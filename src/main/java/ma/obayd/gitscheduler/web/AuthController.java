package ma.obayd.gitscheduler.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.obayd.gitscheduler.dto.LoginRequestDto;
import ma.obayd.gitscheduler.entities.Token;
import ma.obayd.gitscheduler.entities.User;
import ma.obayd.gitscheduler.exceptions.UserNotFoundException;
import ma.obayd.gitscheduler.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UserService userService ;


    @Autowired
    public AuthController(UserService userService){
        this.userService = userService ;
    }


    @PostMapping("/login")
    public Token login (@RequestBody LoginRequestDto loginRequestDto) throws UserNotFoundException {        

        return userService.login(loginRequestDto) ;
    }
}
