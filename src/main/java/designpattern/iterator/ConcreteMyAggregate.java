package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 * */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void removeObject(Object obj){
        this.list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    // 获得迭代器
    public MyIterator iterator(){
        return new ConcreteIterator();
    }

    //使用内部类定义迭代器，可以直接使用外部类的属性
    private class ConcreteIterator implements MyIterator{
        private int cursor; //定义游标用于记录遍历时的位置

        @Override
        public void first() {
            cursor=0;
        }

        @Override
        public void next() {
            cursor++;
        }

        @Override
        public boolean hasNext() {
            return cursor<list.size();
        }

        @Override
        public boolean isFirst() {
            return cursor==0;
        }

        @Override
        public boolean isLast() {
            return list.size()>0&&cursor==list.size()-1;
        }

        @Override
        public Object getCurrentObj() {
            return list.size()==0?null:list.get(cursor);
        }
    }
}
