package jre.juc;

/**
 *
 *
 * */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);

    public static void main(String[] args){
        //设置
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        threadLocal.set(1);

        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        @Override
        public void run() {
            threadLocal.set((int)Math.random()*100);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
    }
}
