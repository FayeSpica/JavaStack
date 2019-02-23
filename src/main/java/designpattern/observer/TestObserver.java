package designpattern.observer;

public class TestObserver {
    public static void main(String[] args){
        //目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();

        //创建多个观察者
        Observer observer1 = new ObserverA();
        Observer observer2 = new ObserverA();
        Observer observer3 = new ObserverA();

        concreteSubject.register(observer1);
        concreteSubject.register(observer2);
        concreteSubject.register(observer3);

        concreteSubject.setState(1);
    }
}
