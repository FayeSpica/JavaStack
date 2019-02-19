package designpattern.factory.bean;

public class Benz implements Car{
    @Override
    public void run() {
        System.out.println("Car=Benz");
    }
}
