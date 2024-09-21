package ma.obayd.gitscheduler.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import ma.obayd.gitscheduler.dto.TokenRequestDto;
import ma.obayd.gitscheduler.entities.Token;

@Component
public class TokenMapper {
    

    public Token toToken(TokenRequestDto tokenRequestDto){
        Token token= new Token() ;
        BeanUtils.copyProperties(tokenRequestDto, token);
        return token ;
    }
}
