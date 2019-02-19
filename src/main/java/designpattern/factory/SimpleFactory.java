package designpattern.factory;

import designpattern.factory.bean.Audi;
import designpattern.factory.bean.Benz;
import designpattern.factory.bean.Car;

public class SimpleFactory {
    public static Car createCar(String type){
        if("Audi".equals(type)){
            return new Audi();
        }else if("Benz".equals(type)){
            return new Benz();
        }else{
            return null;
        }
    }

    public static Car createAudi(){
        return new Audi();
    }

    public static Car createBenz(){
        return new Benz();
    }
}
