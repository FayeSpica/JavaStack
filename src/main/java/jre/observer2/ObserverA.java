package jre.observer2;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        this.myState = ((ConcreteSubject) o).getState();
        System.out.println(this.toString()+" ["+this.myState+"]");
    }
}
