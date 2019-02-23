package designpattern.singleton;

/**
 * 单例：构造器私有化
 * 双重检测
 * */
public class DoubleCheckedLocking {
    private volatile static DoubleCheckedLocking instance;
    private DoubleCheckedLocking(){

    }

    public static DoubleCheckedLocking getInstance(){

        if(null !=instance){
            return instance;
        }

        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckedLocking();
                //可能存在指令重排，加volatile避免
            }
        }

        return instance;
    }


    public static void main(String[] args){
        Thread thread = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        });
        thread.start();

        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
