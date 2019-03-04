package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaowm5
 * @version 1.0
 * @description VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @date 2019-03-01 14:30
 **/
public class HeapOOM {
    static class OOMObject{}
    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
