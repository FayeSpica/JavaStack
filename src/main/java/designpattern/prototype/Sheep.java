package designpattern.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable, Serializable {
    private String sname;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //直接调用Object Clone方法

        //深拷贝
        Sheep sheep = (Sheep) obj;
        sheep.birthday = (Date) this.birthday.clone();

        return obj;
    }

    public Sheep() {
    }

    public Sheep(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "sname='" + sname + '\'' +
                ", birthday=" + birthday +
                '}';
    }


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
