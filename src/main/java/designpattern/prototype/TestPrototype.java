package designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 测试原型模式
 * */
public class TestPrototype {
    public int x;
    public TestPrototype(){
        test();
    }

    public void t(){
        test();
    }
    public static void test(){

    }

    public static void seralize() throws Exception{
        //使用序列化和反序列化实现深复制
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        Sheep sheep = new Sheep("B",new Date());


        oos.writeObject(sheep);

        byte[] bytes=bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        ObjectInputStream ois = new ObjectInputStream(bis);

        Sheep sheep2 = (Sheep) ois.readObject();
        sheep.setBirthday(new Date(1));
        System.out.println(sheep);
        System.out.println(sheep2);
    }

    private static void testMethod(){
        System.out.println("testMethod");
    }
    public static void main(String[] args) throws Exception{
        Sheep sheep = new Sheep("A",new Date());
        System.out.println(sheep);
        System.out.println(System.identityHashCode(sheep));
        System.out.println(sheep.clone());
        System.out.println(System.identityHashCode(sheep.clone()));//深浅拷贝

        String s="12343243";
        char[] c = s.toCharArray();
        System.out.println(String.valueOf(c));
        int[] nums=null;
        Integer i01=59;
        int i02=59;
        Integer i03=Integer.valueOf(59);
        Integer i04=new Integer(59);

        System.out.println(i01==i02);
        System.out.println(i01==i03);
        System.out.println(i03==i04);
        System.out.println(i02==i04);

        ((TestPrototype)null).testMethod();

        seralize();

    }
}
