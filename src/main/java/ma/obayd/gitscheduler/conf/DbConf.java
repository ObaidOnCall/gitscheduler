package ma.obayd.gitscheduler.conf;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.Persistence;
import ma.obayd.gitscheduler.utils.PropertiesLoader;


// import org.hibernate.c3p0.internal.C3P0ConnectionProvider ;
 



/**
 * @ here we are going to config every 
 * @ object that has a realtion with Database
 */
@Configuration
@EnableTransactionManagement
public class DbConf {
    



    /**
     * 
     * @param propertiesLoader
     * @return <--( entityManger singlaton object )-->
     */
    @Bean
    public EntityManagerFactory entityManagerFactory(@Qualifier("propertiesLoader1") PropertiesLoader propertiesLoader) {
        Properties properties = propertiesLoader.loadProperties("src/main/resources/application.properties");
        return Persistence.createEntityManagerFactory("mypersistence", properties);
    }

    // @Bean
    // public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
    //     return entityManagerFactory.createEntityManager();
    // }

    // @Bean
    // public SessionFactory session(EntityManagerFactory emp) {
    //     return emp.unwrap(SessionFactory.class);
    // }


    @Bean
    public PlatformTransactionManager transcationManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager() ;
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        return jpaTransactionManager ;
    }


}
