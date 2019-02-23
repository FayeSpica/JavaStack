package designpattern.mediator;

/**
 * 财务部门
 * */
public class Finance implements Department{

    private Mediator mediator;

    public Finance(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("finance",this);
    }

    @Override
    public void selfAction() {
        System.out.println("财务");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作");

    }
}
