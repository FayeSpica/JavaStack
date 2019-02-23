package designpattern.strategy;

/**
 * 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化。
 * 如果使用Spring的依赖注入，还可以通过配置文件，动态的注入不同的策略对象，动态的切换不同的算法。
 * */
public class Context {
    private Strategy strategy; //当前采用的算法对象

    //可以通过构造器注入
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printPrice(double price){
        System.out.println("报价["+strategy.getPrice(price)+"]");
    }
}
