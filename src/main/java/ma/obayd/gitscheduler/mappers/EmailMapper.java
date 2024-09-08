package ma.obayd.gitscheduler.mappers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.jobs.EmailJob;



@Component
public class EmailMapper {


    public JobDataMap toJobDataMap(EmailRequest emailRequest) {

        JobDataMap  jobDataMap = new JobDataMap() ;
        jobDataMap.put("message" , emailRequest.getMessage()) ;

        return jobDataMap ;
    }

}
