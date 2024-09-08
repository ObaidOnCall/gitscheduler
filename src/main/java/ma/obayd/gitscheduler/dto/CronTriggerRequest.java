package ma.obayd.gitscheduler.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class CronTriggerRequest {
    
    private int dayOfMonth ;
    private int dayOfWeek ;
    private int hour ;
    private int minute ;
    private String cronExpression ;

}
