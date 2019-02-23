package designpattern.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 经理作为中介
 * */
public class Manager implements Mediator{

    private Map<String,Department> map = new HashMap<>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname,department);
    }

    @Override
    public void command(String dname) {
        map.get(dname).outAction();
    }
}
