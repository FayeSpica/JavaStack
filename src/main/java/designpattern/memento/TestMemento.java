package designpattern.memento;

public class TestMemento {
    public static void main(String[] args){
        CareTaker taker = new CareTaker();

        Emp emp = new Emp("liaowm5",18,900);
        System.out.println("第一次创建对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());

        taker.setEmpMemento(emp.memento());

        emp.setSalary(10000);
        System.out.println("修改对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());

        emp.recovery(taker.getEmpMemento());
        System.out.println("恢复对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());
    }
}
