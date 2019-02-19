package jre.lang;

public class ReflectTest {
    public static void main(String[] args) throws Exception{
        Class clz = Class.forName("jre.lang.Iphone");
        jre.lang.Iphone iphone = (jre.lang.Iphone)clz.getConstructor().newInstance();
        
    }
}

class Iphone{
    public Iphone(){

    }
}
