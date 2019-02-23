package designpattern.bridge;


public interface Brand {
    void sale();
}

class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class DELL implements Brand{
    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}
