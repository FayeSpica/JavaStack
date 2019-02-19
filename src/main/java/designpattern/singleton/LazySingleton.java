package designpattern.singleton;

/**
 * 单例模式
 * 懒汉式实现
 * */
public class LazySingleton {
    private static LazySingleton instance;

    public static synchronized LazySingleton getInstance(){
        if(instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }

    private LazySingleton(){

    }
}
