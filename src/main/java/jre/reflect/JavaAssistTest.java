package jre.reflect;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 测试javassist的API
 * */
public class JavaAssistTest {
    public static void main(String[] args)throws MalformedURLException {
        //Float a = 1.0;
        Float b = new Float(1.0);
        URL u=new URL("http://w.1.com");
        System.out.println(u);
        Long l = 42l;
        Integer i = 42;
        System.out.println(l.equals(42L));
        System.out.println(i.equals(l));
    }
}
