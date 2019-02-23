package jre.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫取链接
 * */
public class WebSpiderTest {

    public static String getHtml(String urlStr){
        StringBuilder sb = new StringBuilder();
        try{
            URL url = new URL(urlStr);

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),"GBK"));

            String temp = "";
            while ((temp=reader.readLine())!=null){
                //System.out.println(temp);
                sb.append(temp);
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return sb.toString();
        }
    }

    public static void main(String[] args){
        String html=getHtml("https://www.163.com");

        //Pattern p = Pattern.compile("<a[\\s\\S]+?]</a>");  //取到超链接的整个内容

        Pattern p = Pattern.compile("href=\"([\\w\\s./:]+?)\"");  //取到超链接的地址

        Matcher m = p.matcher(html);

        while (m.find()){
            System.out.println(m.group());
            System.out.println(m.group(1));
        }
    }
}
