package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 任务
 * */
public class HelloJob implements Job {
    public static void main(String[] args){

    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("start");
        System.out.println("Hello World! - " + new Date());
        System.out.println("");
    }
}
