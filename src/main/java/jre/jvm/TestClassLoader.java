package jre.jvm;

import java.lang.reflect.Method;

/**
 * 测试自定义的classLoader
 * */
public class TestClassLoader {
    public static void main(String[] args) throws Exception{
        FileSysytemClassLoader fileSysytemClassLoader = new FileSysytemClassLoader();
        Class<?> c=fileSysytemClassLoader.loadClass("jre.jvm.StringL");
        System.out.println(c);
        jre.jvm.StringL stringL = (StringL) c.getConstructor().newInstance();
        Method mainMethod=c.getMethod("main",String[].class);
        mainMethod.invoke(c,(Object) args);
        Thread.currentThread().getContextClassLoader();
    }
}
