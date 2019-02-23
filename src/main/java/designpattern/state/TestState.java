package designpattern.state;

public class TestState {
    public static void main(String[] args){
        HomeContext ctx = new HomeContext();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
        ctx.setState(new CheckedInState());
    }
}
