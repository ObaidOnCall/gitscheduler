package ma.obayd.gitscheduler.utils;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.quartz.impl.StdSchedulerFactory;

@Configuration
public class UtilsConf {

    @Bean("propertiesLoader1")
    public PropertiesLoader propertiesLoader() {
        return PropertiesLoader.builder().build() ;
    }

    @Bean
    public Scheduler getScheduler(@Qualifier("propertiesLoader1") PropertiesLoader propertiesLoader){
        Scheduler scheduler = null;
        try {
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory(propertiesLoader.loadProperties("src/main/resources/quartz.properties")) ;
            scheduler = stdSchedulerFactory.getScheduler() ;
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        return scheduler ;
    }

    @Bean
    public QuartzUtils quartzUtils() {
        return new QuartzUtils() ;
    }
 }
