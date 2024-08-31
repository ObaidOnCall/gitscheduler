package ma.obayd.gitscheduler.web;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.jobs.EmailJob;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.DateBuilder.* ;

@RestController
public class SimpleController {

    
    private final Scheduler scheduler ;
    
    @Autowired
    public SimpleController (Scheduler scheduler) {
        this.scheduler = scheduler ;
    }

    @PostMapping("/add-simplejob")
    public Object addSimpleJob(@RequestBody EmailRequest emailRequest) throws SchedulerException {
        
        String genName = UUID.randomUUID().toString() ;
        JobDataMap  jobDataMap = new JobDataMap() ;
        jobDataMap.put("message" , emailRequest.getMessage()) ;
        JobDetail jobDetail = JobBuilder.newJob(EmailJob.class)
        .withIdentity(genName, "email")
        .storeDurably()
        .build();
        /**
         *@ make respose for the created job
         *@ becasue the Type JobDtail not serlizebale by default
         */
        Map<String, Object> response = new HashMap<>();
        response.put("jobName", jobDetail.getKey().getName());
        response.put("jobGroup", jobDetail.getKey().getGroup());

        SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(new Date()) // some Date
                .forJob(genName, "email") // identify job with name, group strings
                .build();

        scheduler.scheduleJob(jobDetail , trigger ) ;
        return response ;
    }

}
