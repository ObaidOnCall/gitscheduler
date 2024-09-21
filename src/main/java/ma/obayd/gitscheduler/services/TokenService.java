package ma.obayd.gitscheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.obayd.gitscheduler.dao.repositories.TokenRepository;
import ma.obayd.gitscheduler.dto.TokenRequestDto;
import ma.obayd.gitscheduler.entities.Token;
import ma.obayd.gitscheduler.mappers.TokenMapper;

@Service
@Transactional
public class TokenService {
    
    private final TokenRepository tokenRepository ;
    private final TokenMapper tokenMapper ;


    @Autowired
    public TokenService (TokenRepository tokenRepository , TokenMapper tokenMapper) {
        this.tokenRepository = tokenRepository ;
        this.tokenMapper = tokenMapper ;
    }


    public Token createToken (TokenRequestDto tokenRequestDto) {
        
        return tokenRepository.createToken(tokenMapper.toToken(tokenRequestDto)) ;
    }

}
