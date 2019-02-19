package designpattern.singleton;

/**
 * 单例模式
 * 静态内部类实现
 * */
public class StaticSingleton {
    private static class SingletonInstance{
        private static final StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonInstance.instance;
    }

    private StaticSingleton(){

    }
}
