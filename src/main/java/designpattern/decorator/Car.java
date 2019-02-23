package designpattern.decorator;

public class Car implements ICar{
    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
}

class SuperCar implements ICar{
    protected ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {

    }
}

class FlySuperCar extends SuperCar{

    public FlySuperCar(ICar car) {
        super(car);
    }

    public void fly(){
        System.out.println("Flying");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

class WaterFlySuperCar extends FlySuperCar{
    public WaterFlySuperCar(ICar car) {
        super(car);
    }

    @Override
    public void fly() {
        super.fly();
    }

    @Override
    public void move() {
        super.move();
        dive();
    }

    public void dive(){
        System.out.println("Diving");
    }
}

class AICar extends WaterFlySuperCar{
    public AICar(ICar car) {
        super(car);
    }

    @Override
    public void fly() {
        super.fly();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void dive() {
        super.dive();
    }
}