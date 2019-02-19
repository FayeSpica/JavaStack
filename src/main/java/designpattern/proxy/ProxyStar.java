package designpattern.proxy;

public class ProxyStar implements Star{

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer");
        star.confer();
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract");
        star.signContract();
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket");
        star.bookTicket();
    }

    @Override
    public void sing() {
        //System.out.println("ProxyStar.sing");
        star.sing();
    }

    @Override
    public void getMoney() {
        System.out.println("ProxyStar.getMoney");
        star.getMoney();
    }
}
