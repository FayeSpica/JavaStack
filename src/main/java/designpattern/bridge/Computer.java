package designpattern.bridge;

import sun.security.krb5.internal.crypto.Des;

/**
 * 没有使用桥接模式
 * 违反了单一职责原则
 * */

public interface Computer {
    void sale();
}

class Desktop implements Computer{
    @Override
    public void sale() {
        System.out.println("销售台式机！");
    }
}

class Laptop implements Computer{
    @Override
    public void sale() {
        System.out.println("销售笔记本！");
    }
}

class Pad implements Computer{
    @Override
    public void sale() {
        System.out.println("销售平板电脑！");
    }
}

class LenovoDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售lenovo台式机！");
    }
}

class LenovoLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售lenovo笔记本！");
    }
}

class LenovoPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售lenovo平板！");
    }
}

class DELLDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售DELL台式机！");
    }
}

class DELLLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售DELL笔记本！");
    }
}

class DELLPad extends Pad{
    @Override
    public void sale() {
        System.out.println("销售DELL平板！");
    }
}