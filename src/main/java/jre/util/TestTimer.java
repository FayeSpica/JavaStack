package jre.util;

import java.util.*;

/**
 * 任务调度
 * */
public class TestTimer {
    public static void main(String[] args){
        Timer timer = new Timer();

        //timer.schedule(new MyTask(),1000);
        //timer.schedule(new MyTask(),new Date(5000),1000);
        Calendar cal = new GregorianCalendar(2019,2,14,8,38,0);
        timer.schedule(new MyTask(),cal.getTime(),1000);
    }
}

class MyTask extends TimerTask{
    public void run() {
        System.out.println("ddd");
    }
}
