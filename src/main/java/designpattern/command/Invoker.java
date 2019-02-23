package designpattern.command;

/**
 * 命令调用者，发起者
 * */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的方法
    public void call(){
        command.execute();
    }
}
