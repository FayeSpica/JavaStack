package designpattern.mediator;

/**
 * 市场部门
 * */
public class Market implements Department{

    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("finance",this);
    }

    @Override
    public void selfAction() {
        System.out.println("市场");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作");

    }
}
