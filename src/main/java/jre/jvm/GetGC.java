package jre.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author liaowm5
 * @version 1.0
 * @description TODO
 * @date 2019-02-26 13:41
 **/
public class GetGC {
    public static void main(String[] args){
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcm : list){
            System.out.println(gcm.getName());
        }
    }
}
