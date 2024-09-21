package ma.obayd.gitscheduler.dao.interfaces;

import java.util.List;
import java.util.Map;


import ma.obayd.gitscheduler.entities.User;

public interface UserInterface {

    public User createUser(User user) ;
    public User updateUser(User user) ;
    public User findUser(Long id) ;
    public Map<Object, Object> removeUsers(List<Long> ids) ;
    public List<User> createUsers(List<User> user) ;
    public List<User> listUsers(int page , int limit) ;

    public User findUserByEmail(String id) ;


}
