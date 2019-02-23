package designpattern.strategy;

public class NewCustomerHugeBatchStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打九折");
        return standardPrice*0.9;
    }
}
