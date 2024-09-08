package ma.obayd.gitscheduler.utils;

import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import ma.obayd.gitscheduler.dto.CronTriggerRequest;

public class QuartzUtils {
    

    public JobDetail makeJobDetail(Class<? extends Job> targetJob , String name , String group , JobDataMap jobDataMap) {
        return JobBuilder.newJob(targetJob)
        .withIdentity(name, group)
        .setJobData(jobDataMap)
        .storeDurably()
        .build();
    }

    public JobDetail makeJobDetail(Class<? extends Job> targetJob , String group , JobDataMap jobDataMap) {
        String name = UUID.randomUUID().toString() ;

        return JobBuilder.newJob(targetJob)
        .withIdentity(name, group)
        .setJobData(jobDataMap)
        .storeDurably()
        .build();
    }

    public Trigger makeTrigger (CronTriggerRequest cronTriggerRequest , String name , String group , JobKey jobKey) {

        Trigger trigger ;

        if (cronTriggerRequest.getDayOfMonth() != 0) {
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.monthlyOnDayAndHourAndMinute(cronTriggerRequest.getDayOfMonth(), cronTriggerRequest.getHour(), cronTriggerRequest.getMinute()))
                .forJob(jobKey)
                .build();
        }
        else if (cronTriggerRequest.getDayOfWeek() != 0){
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(cronTriggerRequest.getDayOfWeek(), cronTriggerRequest.getHour(), cronTriggerRequest.getMinute()))
                .forJob(jobKey)
                .build();
        }
        else if (cronTriggerRequest.getHour() != 0 && cronTriggerRequest.getMinute() != 0){
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(cronTriggerRequest.getHour(), cronTriggerRequest.getMinute()))
                .forJob(jobKey)
                .build();
        }

        else {
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronTriggerRequest.getCronExpression()))
                .forJob(jobKey)
                .build();
        }
        return trigger ;
    }

    public Trigger makeTrigger (CronTriggerRequest cronTriggerRequest , String group , JobKey jobKey) {
        
        String name = UUID.randomUUID().toString() ;
        Trigger trigger ;
        if (cronTriggerRequest.getDayOfMonth() != 0) {
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.monthlyOnDayAndHourAndMinute(cronTriggerRequest.getDayOfMonth(), cronTriggerRequest.getHour(), cronTriggerRequest.getMinute()))
                .forJob(jobKey)
                .build();
        }
        else if (cronTriggerRequest.getDayOfWeek() != 0){
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(cronTriggerRequest.getDayOfWeek(), cronTriggerRequest.getHour(), cronTriggerRequest.getMinute()))
                .forJob(jobKey)
                .build();
        }
        else if (cronTriggerRequest.getHour() != 0 && cronTriggerRequest.getMinute() != 0){
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(cronTriggerRequest.getHour(), cronTriggerRequest.getMinute()))
                .forJob(jobKey)
                .build();
        }
        else {
            trigger = TriggerBuilder.newTrigger()
                .withIdentity(name , group)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronTriggerRequest.getCronExpression()))
                .forJob(jobKey)
                .build();
        }
        return trigger ;
    }
}
