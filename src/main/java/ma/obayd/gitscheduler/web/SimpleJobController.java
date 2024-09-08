package ma.obayd.gitscheduler.web;


import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import ma.obayd.gitscheduler.dto.EmailRequest;
import ma.obayd.gitscheduler.dto.JobDetailResponseDto;
import ma.obayd.gitscheduler.dto.Response;
import ma.obayd.gitscheduler.services.SimpleJobService;


@RestController
public class SimpleJobController {

    private final SimpleJobService simpleJobService ;

    @Autowired
    public SimpleJobController(SimpleJobService simpleJobService ){
        this.simpleJobService = simpleJobService ;
    }

    @PostMapping("/add-simplejob")
    public Response addSimpleJob(@RequestBody EmailRequest emailRequest , @RequestParam(value = "fields" , required = false) List<String> fields) throws SchedulerException {
        
        /**
         * @call addsimpleJob from  SimpleJobService
         */
        // JobDetailResponseDto jobDetailResponse = (JobDetailResponseDto)  ;
        return  simpleJobService.addSimpleJob(emailRequest);

    }

    @DeleteMapping("/delete-simplejob")
    public Response deleteSimpleJob (@RequestParam(value = "group" , required = true) String group , @RequestParam(value = "name" , required = true) String name) throws SchedulerException {
        return simpleJobService.deleteSimpleJob(name ,group) ;
    }

}
