package jre.servlet;

import jre.lang.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class XMLTest {
    public static void main(String[] args) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser parser = factory.newSAXParser();

        WebHandler handler = new WebHandler();
        parser.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("web.xml")
                ,handler);

        WebContext webContext = new WebContext(handler.getEntities(),handler.getMappings());
        System.out.println(webContext);
        String className = webContext.getClz("/reg");
        System.out.println(className);
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet) clz.getConstructor().newInstance();
        System.out.println(servlet);
        //servlet.service();


    }


}

class WebHandler extends DefaultHandler{
    private List<Entity> entities = new ArrayList<>();
    private List<Mapping> mappings = new ArrayList<>();
    private Entity entity;
    private Mapping mapping;
    private String tag;
    private boolean map = false;
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch,start,length).trim();

        if(tag!=null) {
            if(map){
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(contents);
                }
            }else{
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(contents);
                }
            }

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        tag=qName;
        if(tag.equals("servlet")){
            entity = new Entity();
            map=false;
        }else if(tag.equals("servlet-mapping")){
            mapping = new Mapping();
            map=true;
        }

        System.out.println(qName+"-->start");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("servlet")){
            entities.add(entity);
        }else if(qName.equals("servlet-mapping")){
            mappings.add(mapping);
        }
        System.out.println(qName+"-->end");
        tag=null;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}
