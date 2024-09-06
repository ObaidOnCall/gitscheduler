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

import ma.obayd.gitscheduler.confbeans.QuartzConfig;
import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.jobs.EmailJob;

import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;



@Component
public class EmailJobDetailMapper {


    public Map<String , Object> emailRequestToJobDetailAndTrigger(EmailRequest emailRequest) {

        // String genName = UUID.randomUUID().toString() ;
        JobDataMap  jobDataMap = new JobDataMap() ;
        jobDataMap.put("message" , emailRequest.getMessage()) ;

        // JobDetail jobDetail = JobBuilder.newJob(EmailJob.class)
        // .withIdentity(genName, "email")
        // .storeDurably()
        // .build();

        // /**
        //  * @build the trigger
        //  */
         
        // Trigger trigger = TriggerBuilder.newTrigger()
        //         .withIdentity(genName, "emailTriggers")
        //         .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(emailRequest.getHour(), emailRequest.getMinute()))
        //         .forJob(jobDetail.getKey())
        //         .build();
        JobDetailFactoryBean jobDetail = QuartzConfig.createJobDetail(EmailJob.class , jobDataMap);
        CronTriggerFactoryBean trigger = QuartzConfig.createCronTrigger((JobDetail) jobDetail ,"0 15 10 * * ?") ;
        /**
         * @ build the map to return it 
         */

        Map<String , Object> map = new HashMap<>() ;
        map.put("jobDetail", jobDetail) ;
        map.put("trigger",trigger) ;

        return map ;
    }

}
