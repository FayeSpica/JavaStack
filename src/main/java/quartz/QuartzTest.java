package quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * quartz框架
 * */
public class QuartzTest {
    public void run() throws Exception{
        //1、创建Scheduler工厂
        SchedulerFactory sf = new StdSchedulerFactory();
        //2、从工厂中获取调度器
        Scheduler sched = sf.getScheduler();

        JobDetail job;


    }
}
