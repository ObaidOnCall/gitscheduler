package ma.obayd.gitscheduler.services;


import java.util.Map;


import org.quartz.JobDetail;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.dto.JobDetailResponse;
import ma.obayd.gitscheduler.dto.Response;
import ma.obayd.gitscheduler.mappers.EmailJobDetailMapper;

@Service
public class SimpleJobService {


    private final EmailJobDetailMapper emailJobDetailMapper ;
    
    @Autowired
    public SimpleJobService (EmailJobDetailMapper emailJobDetailMapper) {
        this.emailJobDetailMapper = emailJobDetailMapper;
    }

    public Response addSimpleJob(EmailRequest emailRequest){
        
        String jobkey = "jobDetail" ;
        String triggerkey = "trigger" ;
        
        Map<String , Object> mapJobAndTrigger = emailJobDetailMapper.emailRequestToJobDetailAndTrigger(emailRequest) ;
        
        return JobDetailResponse.builder()
                                .description("secccefjj")
                                .build() ;
    }
}
