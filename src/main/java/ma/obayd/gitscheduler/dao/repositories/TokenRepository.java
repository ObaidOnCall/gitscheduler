package ma.obayd.gitscheduler.dao.repositories;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.obayd.gitscheduler.dao.interfaces.TokenInterface;
import ma.obayd.gitscheduler.entities.Token;


@Repository
public class TokenRepository implements TokenInterface{

    /***
     *@Transaction Scoping: The EntityManager is bound to the scope of a transaction.
     * When a transaction begins, the container automatically provides an EntityManager 
     * that is associated with the current transaction. This EntityManager is used for all 
     * database operations within that transaction.
     * 
     *@Automatic Transaction Management: The container ensures that all changes made within a 
     * transaction are committed or rolled back as needed. When a transaction commits, 
     * the container synchronizes the persistence context with the database. 
     * If the transaction rolls back, all changes made within that transaction are discarded.
     * 
     *@Lifecycle Management: The container takes care of creating and closing the EntityManager. 
     * You don’t need to manually manage its lifecycle. When a transaction is completed, 
     * the container manages the cleanup of the EntityManager.
     */
    @PersistenceContext
    private EntityManager em ;

    
    @Override
    public Token createToken(Token token) {
        em.persist(token);
        return token ;
    }
    
}
