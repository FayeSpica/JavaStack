package leetcode;

import java.util.LinkedList;

public class _146_LRU {
    LinkedList<Map> list;
    int capacity;

    public _146_LRU(int capacity) {
        this.list=new LinkedList<Map>();
        this.capacity=capacity;
    }

    public int get(int key) {
        Map res = null;
        for (Map map:list
        ) {
            if(map.key==key){
                res = map;
                break;
            }
        }
        if(res!=null){
            list.remove(res);
            list.addFirst(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Map res = null;
        for (Map map:list
        ) {
            if(map.key==key){
                res = map;
                res.value=value;
                break;
            }
        }
        if(res!=null){
            list.addFirst(res);
            if(list.size()>capacity) {
                list.remove(res);
            }
        }
        else{
            list.addFirst(new Map(key,value));
            if(list.size()>capacity){
                list.removeLast();
            }
        }
    }

    // 2 1 1 2
    public static void main(String[] args){
        _146_LRU _146_lru = new _146_LRU(2);

        _146_lru.put(1,1);
        _146_lru.put(2,2);
        System.out.println(_146_lru.get(1));
        _146_lru.put(3,3);
        _146_lru.get(2);
        System.out.println(_146_lru.get(2));
        _146_lru.put(4,4);
        _146_lru.get(1);
        System.out.println(_146_lru.get(1));
        _146_lru.get(3);
        System.out.println(_146_lru.get(3));
        _146_lru.get(4);
        System.out.println(_146_lru.get(4));



    }
}

class Map{
    int key;
    int value;

    public Map(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Map){
            Map map=(Map)obj;
            return map.key==this.key;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return key;
    }
}
