package designpattern.command;

public class TestCommand {
    public static void main(String[] args){
        Command command = new ConcreteCommand(new Receiver());

        Invoker invoker = new Invoker(command);

        invoker.call();
    }
}
