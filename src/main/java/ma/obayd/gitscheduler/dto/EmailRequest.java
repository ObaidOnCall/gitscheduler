package ma.obayd.gitscheduler.dto;



import java.io.Serializable;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Setter @Getter
public class EmailRequest implements Request , Serializable{

    private String message ;
    // private Timestamp sendDate ;
    private int dayOfMonth ;
    private int dayOfWeek ;
    private int hour ;
    private int minute ;

}
