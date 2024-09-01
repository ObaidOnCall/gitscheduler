package ma.obayd.gitscheduler.dto;

import java.util.Date;

import org.quartz.JobKey;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Setter @Getter @Builder
public class JobDetailResponse implements Response{

    private String description ;
    private Date nextFirTime ;
    private boolean isCreated ;
    private int code ;
    private JobKey jobKey ;

}
