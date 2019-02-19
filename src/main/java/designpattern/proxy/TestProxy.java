package designpattern.proxy;

public class TestProxy {
    public static void main(String[] args){
        Star realStar = new RealStar();
        Star proxyStar = new ProxyStar(realStar);

        proxyStar.confer();
        proxyStar.signContract();
        proxyStar.bookTicket();
        proxyStar.sing();
        proxyStar.getMoney();
    }
}
