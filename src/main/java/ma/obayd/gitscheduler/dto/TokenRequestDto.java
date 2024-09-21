package ma.obayd.gitscheduler.dto;

import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ma.obayd.gitscheduler.enums.TokenType;


@Getter @Setter
public class TokenRequestDto {
    
    @NotNull(message = "type of token not null ")
    private TokenType type ;
    

    @NotBlank
    @Min(value = 86400, message = "TTL must be at least 1 day (86,400 seconds)")
    @Max(value = 31536000, message = "TTL must not exceed 1 year (31,536,000 seconds)")
    private Date expireAt ;

    @Nullable
    private String acl ;


}
