package designpattern.decorator;

public class TestDecorator {
    public static void main(String[] args){
        Car car = new Car();
        car.move();

        System.out.println("增加新的功能，飞行----------");
        FlySuperCar flySuperCar = new FlySuperCar(car);
        flySuperCar.move();


        System.out.println("----------");
        WaterFlySuperCar waterFlySuperCar = new WaterFlySuperCar(car);
        waterFlySuperCar.move();


        System.out.println("----------");
        AICar aiCar = new AICar(waterFlySuperCar);
        aiCar.move();
    }
}
