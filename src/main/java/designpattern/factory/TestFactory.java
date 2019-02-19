package designpattern.factory;

import designpattern.factory.bean.Audi;
import designpattern.factory.bean.Benz;
import designpattern.factory.bean.Car;

public class TestFactory {
    public static void main(String[] args){
        testNoFactory();
        testSimpleFactory();
    }

    // 无工厂模式
    public static void testNoFactory(){
        Car c1 = new Audi();
        Car c2 = new Benz();
        c1.run();
        c2.run();
    }

    // 简单工厂模式
    public static void testSimpleFactory(){
        Car c1 = SimpleFactory.createCar("Audi");
        Car c2 = SimpleFactory.createCar("Benz");
        c1.run();
        c2.run();
    }

    // 工厂方法模式
    public static void testFactoryMethod(){

    }
}


