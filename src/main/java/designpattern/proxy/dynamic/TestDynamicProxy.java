package designpattern.proxy.dynamic;

import designpattern.proxy.RealStar;
import designpattern.proxy.Star;

import java.lang.reflect.Proxy;

/**
 * 测试JDK自带动态代理
 *
 * */
public class TestDynamicProxy {
    public static void main(String[] args){
        Star realStar = new RealStar();

        StarHandler handler = new StarHandler(realStar);

        Star proxy = (Star) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{Star.class},handler);

        proxy.bookTicket();
        proxy.sing();
    }
}
