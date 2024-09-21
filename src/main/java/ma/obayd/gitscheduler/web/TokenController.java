package ma.obayd.gitscheduler.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ma.obayd.gitscheduler.dto.TokenRequestDto;
import ma.obayd.gitscheduler.entities.Token;
import ma.obayd.gitscheduler.services.TokenService;


@RestController
@RequestMapping("/tokens")
public class TokenController {
    

    private final TokenService tokenService ;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService ;
    }


    @PostMapping
    public Token createToken (@RequestBody TokenRequestDto tokenRequestDto) {
        return tokenService.createToken(tokenRequestDto) ;
    }

}
