package jre.lang;

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

        PersonHandler handler = new PersonHandler();
        parser.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("p.xml")
                ,handler);

        List<Person> persons = handler.getPersons();
        for(Person person:persons){
            System.out.println(person);
        }
    }


}

class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag;
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch,start,length).trim();


        if(tag!=null) {
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                person.setAge(Integer.parseInt(contents));
            }
        }

        if(contents.length()>0) {
            System.out.println("内容为->" + contents);
        }else{
            System.out.println("->null");
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        persons = new ArrayList<Person>();

        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("endDocument");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if(qName.equals("person")){
            person = new Person();
        }

        System.out.println(qName+"-->start");
        tag=qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("person")){
            persons.add(person);
        }
        System.out.println(qName+"-->end");
        tag=null;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
