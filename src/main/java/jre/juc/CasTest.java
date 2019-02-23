package jre.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {
    private static AtomicInteger stock = new AtomicInteger(5);
    public static void main(String[] args){
        for (int i=0;i<5;i++){
            new Thread(()->{
                Integer left = stock.decrementAndGet();
                if(left<1){
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"get");
                System.out.println(left+"left");
            }).start();
        }
    }
}
