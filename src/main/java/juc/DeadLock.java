package juc;

/**
 * @author liaowm5
 * @version 1.0
 * @description 死锁
 * @date 2019-02-27 21:28
 **/
public class DeadLock {
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args){
        GetThreadAB threadAB = new GetThreadAB();
        GetThreadBA threadBA = new GetThreadBA();


    }

    static class GetThreadAB extends Thread{
        @Override
        public void run() {
            synchronized (a){
                System.out.println("get a");
                synchronized (b){
                    System.out.println("get b");
                }
            }
        }
    }

    static class GetThreadBA extends Thread{
        @Override
        public void run() {
            synchronized (b){
                System.out.println("get b");
                synchronized (a){
                    System.out.println("get a");
                }
            }
        }
    }
}
