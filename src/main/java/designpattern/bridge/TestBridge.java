package designpattern.bridge;

public class TestBridge {
    public static void main(String[] args){
        Computer2 computer2 = new Laptop2(new Lenovo());

        computer2.sale();
    }
}
