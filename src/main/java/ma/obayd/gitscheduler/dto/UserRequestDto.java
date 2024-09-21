package ma.obayd.gitscheduler.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
    
    @NotBlank(message = "must not be null")
    private String username ;
    @NotBlank(message = "must not be null")
    @Email(message = "Email Format Please")
    private String email ;
    
    @NotBlank(message = "must not be null")
    @Size(max =24 ,min = 8 , message = "Size Must Be Between 8 And 24")
    private String passwd ;
}
