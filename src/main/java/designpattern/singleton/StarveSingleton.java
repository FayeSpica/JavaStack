package designpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式
 * 饿汉式实现
 * */
public class StarveSingleton implements Serializable {
    private static StarveSingleton instance = new StarveSingleton();

    public static StarveSingleton getInstance(){
        return instance;
    }

    private StarveSingleton(){
        if(instance!=null){
            throw new RuntimeException();
        }
    }


    //反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建对象！
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }
}
