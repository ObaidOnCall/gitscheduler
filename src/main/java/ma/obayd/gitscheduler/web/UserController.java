package ma.obayd.gitscheduler.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import ma.obayd.gitscheduler.dto.UserRequestDto;
import ma.obayd.gitscheduler.dto.UserResponseDto;
import ma.obayd.gitscheduler.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService ;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService ;
    }


    @GetMapping
    public List<UserResponseDto> listUsers(@RequestParam int page,@RequestParam int limit){
        return userService.listUsers(page, limit) ;
    }
    /**
     * 
     * @param id
     * @return UserResponse
     */
    @GetMapping("/{id}")
    public UserResponseDto findUser(@PathVariable Long id){
        return userService.findUser(id) ;
    }

    @PostMapping
    public List<UserResponseDto> create(@Valid @RequestBody List<UserRequestDto> userRequests) {

        return userService.save(userRequests) ;
    }

    @DeleteMapping("/{ids}")
    public Map<Object , Object> delete(@PathVariable List<Long> ids) {

        return userService.delete(ids) ;
    }

}
