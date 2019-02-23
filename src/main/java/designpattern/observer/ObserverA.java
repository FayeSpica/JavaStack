package designpattern.observer;

public class ObserverA implements Observer{

    private int myState; //myState需要跟目标对象保持一致

    @Override
    public void update(Subject subject) {
        this.myState = ((ConcreteSubject) subject).getState();
        System.out.println(this.toString()+"myState=["+this.myState+"]");
    }
}
