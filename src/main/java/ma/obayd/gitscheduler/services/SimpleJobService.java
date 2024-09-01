package ma.obayd.gitscheduler.services;


import java.util.Map;


import org.quartz.JobDetail;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.dto.JobDetailResponse;
import ma.obayd.gitscheduler.dto.Response;
import ma.obayd.gitscheduler.mappers.EmailJobDetailMapper;

@Service
public class SimpleJobService {


    private final Scheduler scheduler ;
    private final EmailJobDetailMapper emailJobDetailMapper ;
    
    @Autowired
    public SimpleJobService (Scheduler scheduler , EmailJobDetailMapper emailJobDetailMapper) {
        this.scheduler = scheduler ;
        this.emailJobDetailMapper = emailJobDetailMapper;
    }

    public Response addSimpleJob(EmailRequest emailRequest) throws SchedulerException {
        
        String jobkey = "jobDetail" ;
        String triggerkey = "trigger" ;
        
        Map<String , Object> mapJobAndTrigger = emailJobDetailMapper.emailRequestToJobDetailAndTrigger(emailRequest) ;
        
        scheduler.scheduleJob((JobDetail) mapJobAndTrigger.get(jobkey),(Trigger) mapJobAndTrigger.get(triggerkey));

        return JobDetailResponse.builder()
                                .description(((JobDetail) mapJobAndTrigger.get(jobkey)).getDescription())
                                .jobKey(((JobDetail) mapJobAndTrigger.get(jobkey)).getKey())
                                .nextFirTime(((Trigger) mapJobAndTrigger.get(triggerkey)).getNextFireTime())
                                .build() ;
    }
}
