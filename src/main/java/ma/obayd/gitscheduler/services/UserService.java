package ma.obayd.gitscheduler.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.NoResultException;
import ma.obayd.gitscheduler.dao.repositories.TokenRepository;
import ma.obayd.gitscheduler.dao.repositories.UserRepository;
import ma.obayd.gitscheduler.dto.LoginRequestDto;
import ma.obayd.gitscheduler.dto.UserRequestDto;
import ma.obayd.gitscheduler.dto.UserResponseDto;
import ma.obayd.gitscheduler.entities.Token;
import ma.obayd.gitscheduler.entities.User;
import ma.obayd.gitscheduler.enums.TokenType;
import ma.obayd.gitscheduler.exceptions.UserNotFoundException;
import ma.obayd.gitscheduler.mappers.UserMapper;


@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository ;
    private final TokenRepository tokenRepository ;
    private final UserMapper userMapper ;


    @Autowired
    public UserService (UserRepository userRepository , TokenRepository tokenRepository ,UserMapper userMapper){
        this.userRepository = userRepository ;
        this.userMapper = userMapper ;
        this.tokenRepository =  tokenRepository ;
    }

    public UserResponseDto save(UserRequestDto userRequest) {

        User user = userMapper.toUser(userRequest) ;
        user.setPasswd("gogo");
        user = userRepository.createUser(user) ;
        return userMapper.fromUser(user) ;

    }

    public Map<Object , Object> delete(List<Long> ids) {
        return userRepository.removeUsers(ids) ;
    }



    /**
     * @see save
     * @param userRequests
     * @return List<UserResponse>
     */
    public List<UserResponseDto> save(List<UserRequestDto> userRequests) {

        List<User> users = userMapper.toUser(userRequests) ;
        users = userRepository.createUsers(users) ;
        return userMapper.fromUser(users) ;

    }

    /**
     * 
     * @param page
     * @param limit
     * @return List<UserResponse> userResponses
     */
    public List<UserResponseDto> listUsers(int page, int limit){
        return userMapper.fromUser(userRepository.listUsers(page, limit)) ;
    }

    /**
     * 
     * @param id
     * @return
     */
    public UserResponseDto findUser(Long id) {
        return userMapper.fromUser(userRepository.findUser(id)) ; 
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email) ;
    }

    public Token login(LoginRequestDto loginRequestDto) throws UserNotFoundException {
        User user ;
        try {
            user = userRepository.findUserByEmail(loginRequestDto.getEmail()) ;

            /***
             * 
             * @check the Password
             */
            

        } catch (NoResultException e) {
            throw new UserNotFoundException("there is no user with this email :" + loginRequestDto.getEmail()) ;
        }

        // Get the current date
        LocalDate now = LocalDate.now();
            
        // Add 3 months to the current date
        LocalDate threeMonthsLater = now.plusMonths(3);
        
        // Convert LocalDate to Date
        Date expireAt = Date.from(threeMonthsLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Token token = Token.builder()
                           .user(user) 
                           .type(TokenType.MASTER)
                           .expireAt(expireAt)
                           .build();

        return tokenRepository.createToken(token) ;
        
    }
}
