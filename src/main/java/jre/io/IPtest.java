package jre.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class IPtest {

    public static void main(String[] args) throws Exception {

        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());



        addr = InetAddress.getByName("www.baidu.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        final StringBuilder sb = new StringBuilder();
        sb.append(1);

        URL url = new URL("https://www.bilibili.com/video/av33198858?p=237");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getPath());


        System.out.println(url.getQuery());
        System.out.println(url.getRef());


        //InputStream is = url.openStream();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3704.3 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String msg=null;
        while (null!=(msg=br.readLine())){
            System.out.println(msg);
        }
        br.close();


    }
}
