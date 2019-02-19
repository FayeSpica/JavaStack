package designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单例模式的效率
 *
 * */
public class TestSpeed {

    public static void main(String[] args) throws Exception{

        long start = System.currentTimeMillis();

        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++) {
            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    Object o = EnumSingleton.getInstance();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();  //main线程阻塞，直到计数器变为0，才回继续往下执行！

        long end = System.currentTimeMillis();

        System.out.println("总耗时："+(end-start)+"ms");
    }

}
