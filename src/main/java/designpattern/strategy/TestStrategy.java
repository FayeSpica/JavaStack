package designpattern.strategy;

/**
 * 实现起来比较容易，符合一般开发人员的思路
 * 假如类型特别多，算法比较复杂时，整个条件语句的代码就变得很长，难以维护。
 * 如果有新增类型，就需要频繁的修改此处代码
 * 不符合开闭原则：对修改关闭，对扩展开放
 *
 * */
public class TestStrategy {

    public static void main(String[] args){
        Context context = new Context(new NewCustomerMiniBatchStrategy());
        context.printPrice(10000);

        context.setStrategy(new NewCustomerHugeBatchStrategy());
        context.printPrice(10000);

        context.setStrategy(new OldCustomerMiniBatchStrategy());
        context.printPrice(10000);

        context.setStrategy(new OldCustomerHugeBatchStrategy());
        context.printPrice(10000);

    }

    public double getPrice(String type,double price){
        double discount=1;
        if(type.equals("普通客户小批量")){
            System.out.println("不打折，原价");
        }else if(type.equals("普通客户大批量")){
            System.out.println("打九折");
            discount*=0.9;
        }else if(type.equals("老客户小批量")){
            System.out.println("打八五折");
            discount*=0.85;
        }else if(type.equals("老客户大批量")){
            System.out.println("打八折");
            discount*=0.8;
        }
        return price*discount;
    }
}
