package ma.obayd.gitscheduler.dto;



import java.io.Serializable;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Setter @Getter
public class EmailRequest implements Request {

    private String message ;
    private CronTriggerRequest cron ;

    @Deprecated
    private int dayOfMonth ;
    @Deprecated
    private int dayOfWeek ;
    @Deprecated
    private int hour ;
    @Deprecated
    private int minute ;

}
