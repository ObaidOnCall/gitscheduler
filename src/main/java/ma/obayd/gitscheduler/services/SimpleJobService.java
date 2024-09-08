package ma.obayd.gitscheduler.services;


import jakarta.transaction.Transactional;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.dto.JobDetailResponseDto;
import ma.obayd.gitscheduler.dto.Response;
import ma.obayd.gitscheduler.jobs.EmailJob;
import ma.obayd.gitscheduler.mappers.EmailMapper;
import ma.obayd.gitscheduler.utils.QuartzUtils;

@Service
public class SimpleJobService {


    private final EmailMapper emailJobDetailMapper ;
    private final Scheduler scheduler ;
    private final QuartzUtils quartzUtils ;
    
    @Autowired
    public SimpleJobService (EmailMapper emailJobDetailMapper , Scheduler scheduler , QuartzUtils quartzUtils) {
        this.emailJobDetailMapper = emailJobDetailMapper;
        this.scheduler = scheduler ;
        this.quartzUtils = quartzUtils ;
    }

    public Response addSimpleJob(EmailRequest emailRequest){

        
        JobDataMap jobDataMap = emailJobDetailMapper.toJobDataMap(emailRequest) ;
        JobDetail jobDetail = quartzUtils.makeJobDetail(EmailJob.class ,"email" , jobDataMap) ;
        Trigger trigger = quartzUtils.makeTrigger(emailRequest.getCron(), "email", jobDetail.getKey()) ;
        
        try {
            scheduler.scheduleJob(jobDetail , trigger) ;
        } catch (SchedulerException e) {
            /**
             * @return an error object from JobDetailResponse with code 7
             * @that means there is an issue with you request .
             */
            e.printStackTrace();
            return JobDetailResponseDto.builder()
                                    .errCode(7)
                                    .errMessage(e.getMessage())
                                    .build() ;
        }
        return JobDetailResponseDto.builder()
                                .jobKey(jobDetail.getKey())
                                .nextFirTime(trigger.getNextFireTime())
                                .description("secccefjj")
                                .build() ;
    }

    @Transactional
    public Response deleteSimpleJob(String name , String group) throws SchedulerException{
        JobKey jobKey = new JobKey(name , group) ;
        scheduler.deleteJob(jobKey) ;
        return JobDetailResponseDto.builder()
                                    .jobKey(jobKey)
                                    .description("this Job Deleted")
                                    .build();

    }
}
