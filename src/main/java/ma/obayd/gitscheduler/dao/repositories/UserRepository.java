package ma.obayd.gitscheduler.dao.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import ma.obayd.gitscheduler.dao.interfaces.UserInterface;
import ma.obayd.gitscheduler.entities.User;
import ma.obayd.gitscheduler.utils.Hash;
import ma.obayd.gitscheduler.utils.PropertiesLoader;



@Repository
public class UserRepository implements UserInterface{

    private static final int BATCHSIZE = 20 ;

    @PersistenceContext
    private EntityManager em ;

    private final PropertiesLoader propertiesLoader ;


    @Autowired
    public UserRepository (PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader ;
    }
    
    @Override
    public User createUser(User user) {
        em.persist(user);
        return user ;
    }

    

    @Override
    public User updateUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    /**
     * 
     * @param id
     * @return user
     */
    @Override
    public User findUser(Long id) {
        return em.find(User.class, id) ; 
    }


    public User findUserByEmail(String email) {
        return em.createQuery("SELECT u FROM User u WHERE u.email = :email" , User.class)
                      .setParameter("email", email)
                      .getSingleResult() ;
    }
    

    /**
     * @V1.1
     */

    @Override
    public List<User> createUsers(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            
            /**
             * @get the current User and Hash the password
             */
            User user = users.get(i) ;
            user.setPasswd(Hash.hashPassword(user.getPasswd()));
            em.persist(user);
            if (i % BATCHSIZE == 0 && i > 0) {
                em.flush();
                em.clear();
            }
        }
        em.flush();
        em.clear();
        return users;
    }

    @Override
    public Map<Object , Object> removeUsers(List<Long> ids) {
        
        String jpql = "DELETE FROM User u WHERE u.id IN :ids";
        Query query = em.createQuery(jpql);
        query.setParameter("ids", ids);

        // Execute the query
        int count = query.executeUpdate();
        Map<Object,Object> response = new HashMap<>() ;
        response.put("message", "Count Of Users Deleted :" + count) ;
        response.put("ListDeleted", ids) ;
        return response ;
    }

    @Override
    public List<User> listUsers(int page, int limit) {

        return em.createQuery("SELECT u FROM User u" , User.class)
        .setFirstResult((page - 1) * limit)
        .setMaxResults(limit)
        .getResultList();
    }
}
