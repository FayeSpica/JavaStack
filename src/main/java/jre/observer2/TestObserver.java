package jre.observer2;

public class TestObserver {
    public static void main(String[] args){
        //创建目标对象Observable
        ConcreteSubject subject = new ConcreteSubject();

        ObserverA observer1 = new ObserverA();
        ObserverA observer2 = new ObserverA();
        ObserverA observer3 = new ObserverA();

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);

        subject.setState(12);
    }
}
