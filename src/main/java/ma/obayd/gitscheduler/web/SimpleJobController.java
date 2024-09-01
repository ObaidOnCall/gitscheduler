package ma.obayd.gitscheduler.web;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.dto.Response;
import ma.obayd.gitscheduler.services.SimpleJobService;


@RestController
public class SimpleJobController {

    private final SimpleJobService simpleJobService ;

    @Autowired
    public SimpleJobController(SimpleJobService simpleJobService){
        this.simpleJobService = simpleJobService ;
    }

    @PostMapping("/add-simplejob")
    public Response addSimpleJob(@RequestBody EmailRequest emailRequest) throws SchedulerException {
        
        /**
         * @call addsimpleJob from  SimpleJobService
         */
        return simpleJobService.addSimpleJob(emailRequest) ;

    }

}
