package designpattern.mediator;

public class TestMediator {
    public static void main(String[] args){
        Mediator mediator = new Manager();

        Development development = new Development(mediator);
        Finance finance = new Finance(mediator);
        Market market = new Market(mediator);

        development.selfAction();
        development.outAction();
    }
}
