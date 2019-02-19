package jre.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;
import java.util.regex.Pattern;

import static jre.servlet.Response.CRLF;

/**
 * HTTP 请求
 * */
public class Request {
    private String requestInfo;
    private String method;
    private String url;

    private Map<String, List<String>> parameterMap;
    public Request(InputStream is){
        parameterMap = new HashMap<String,List<String>>();
        byte[] datas = new byte[1024*1024];
        int len;
        try{
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        parseRequsetInfo();
    }

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }


    private void parseRequsetInfo(){


        System.out.println(requestInfo);
        System.out.println("parse");
        System.out.println();

        Pattern pattern = Pattern.compile(" ");

        String[] str = pattern.split(requestInfo);

        //Arrays.stream(str).forEach(System.out::println);

        //HTTP方法
        this.method = str[0];
        System.out.println("method = "+this.method);

        String urls = str[1];

        //HTTP请求的URL解析
        String[] s=urls.split("\\?");
        this.url = s[0];
        System.out.println("url = "+this.url);


        // URL参数解析
        for(int i=1;i<s.length;i++){
            String[] ss = s[i].split("=");
            if(ss.length<2){
                return;
            }
            String key=ss[0];
            String value=ss[1]==null?null:decode(ss[1]);
            if(!parameterMap.containsKey(key)){
                parameterMap.put(key,new ArrayList<>());
            }
            parameterMap.get(key).add(value);
        }

        System.out.println("parseEnd");
    }

    private String decode(String value){
        return decode(value,"UTF-8");
    }

    private String decode(String value,String charset){
        try {
            return java.net.URLDecoder.decode(value,charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过paramName 获取paramValue
     * */
    public String[] getParameterValues(String key){
        List<String> values = this.parameterMap.get(key);
        if(null==values||values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }

    public String getParameterValue(String key){
        List<String> values = this.parameterMap.get(key);
        return values==null||values.size()==0?null:values.get(0);
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
