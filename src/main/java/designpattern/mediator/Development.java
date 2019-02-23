package designpattern.mediator;

/**
 * 研发部门
 * */
public class Development implements Department{

    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发");
        mediator.command("finance");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作");

    }
}
