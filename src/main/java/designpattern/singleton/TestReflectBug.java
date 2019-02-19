package designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解方式
 * */
public class TestReflectBug {
    public static void main(String[] args) throws Exception{
        StarveSingleton starveSingleton1 = StarveSingleton.getInstance();
        StarveSingleton starveSingleton2 = StarveSingleton.getInstance();

        System.out.println(starveSingleton1);
        System.out.println(starveSingleton2);


        //通过反射的方式直接调用私有构造器
        Class<StarveSingleton> clazz = (Class<StarveSingleton>)Class.forName("designpattern.singleton.StarveSingleton");
        Constructor<StarveSingleton> starveSingletonConstructor = clazz.getDeclaredConstructor();
        starveSingletonConstructor.setAccessible(true);
        //StarveSingleton starveSingleton3 = starveSingletonConstructor.newInstance();


        //通过反序列化的方式构造多个对象
        String file = "/Users/lxx/git/JavaStack/src/main/java/designpattern/singleton/starveSingleton1.txt";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(starveSingleton1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        StarveSingleton starveSingleton4 = (StarveSingleton)ois.readObject();

        System.out.println(starveSingleton1);
        System.out.println(starveSingleton4);
    }
}
