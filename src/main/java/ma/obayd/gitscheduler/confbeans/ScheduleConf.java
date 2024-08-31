package ma.obayd.gitscheduler.confbeans;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configurable
public class ScheduleConf {

    @Bean
    @Primary
    public Scheduler firstScheduler() throws SchedulerException{

        return StdSchedulerFactory.getDefaultScheduler();
    }
}
