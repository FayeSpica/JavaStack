package designpattern.singleton;

/**
 * 单例模式
 * 枚举实现(没有延时加载)
 * 可以防止反射和反序列化漏洞！
 * */
public enum EnumSingleton {

    //枚举元素本身就是单例
    INSTANCE;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
