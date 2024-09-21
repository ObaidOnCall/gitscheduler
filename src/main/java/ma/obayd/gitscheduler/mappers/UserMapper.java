package ma.obayd.gitscheduler.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import ma.obayd.gitscheduler.dto.UserRequestDto;
import ma.obayd.gitscheduler.dto.UserResponseDto;
import ma.obayd.gitscheduler.entities.User;

@Component
public class UserMapper {
    

    public User toUser(UserRequestDto userRequest){

        User user = new User() ;
        BeanUtils.copyProperties(userRequest, user);
        return user ;
    }

    public UserResponseDto fromUser(User user) {
        UserResponseDto userResponse = new UserResponseDto() ;

        BeanUtils.copyProperties(user, userResponse);

        return userResponse ;
    }

    public List<User> toUser(List<UserRequestDto> userRequests){

        List <User> users = new ArrayList<>() ;
        for (UserRequestDto userRequest : userRequests) {
            User user = new User() ;
            BeanUtils.copyProperties(userRequest, user);
            users.add(user) ;
            
        }
        
        return users ;
    }

    public List<UserResponseDto> fromUser(List<User> users) {

        List <UserResponseDto> userResponses = new ArrayList<>() ;

        for (User user : users) {
            UserResponseDto userResponse = new UserResponseDto() ;
            BeanUtils.copyProperties(user, userResponse);
            userResponses.add(userResponse);
        }
        return userResponses ;
    } 


}
