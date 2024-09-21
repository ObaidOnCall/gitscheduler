package ma.obayd.gitscheduler.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder 
public class UserResponseDto {
    
    private long id ;
    private String username ;
    private String email ;
    private Date createAt ;
}
