package designpattern.observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subject {
    protected List<Observer> list = new LinkedList<>();

    public void register(Observer observer){
        list.add(observer);
    }

    public void remove(Observer observer){
        list.remove(observer);
    }

    public void notifyAllObservers(){
        list.stream().forEach(observer -> observer.update(this));
    }
}
