package ma.obayd.gitscheduler.dto;



import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Setter @Getter
public class EmailRequest implements Request{

    private String message ;
    private Timestamp sendDate ;

}
