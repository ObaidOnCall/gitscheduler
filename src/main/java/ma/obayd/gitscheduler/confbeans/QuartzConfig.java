package ma.obayd.gitscheduler.confbeans;

import org.quartz.Scheduler;
import org.quartz.spi.JobFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


@Configuration
public class QuartzConfig {

    // @Bean
    // public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) {
    //     SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
    //     return schedulerFactoryBean;
    // }

    @Bean
    public Scheduler scheduler() throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        Resource resource = new FileSystemResource("src/main/resources/quartz.properties");
        schedulerFactoryBean.setConfigLocation(resource);
        schedulerFactoryBean.afterPropertiesSet();
        return schedulerFactoryBean.getScheduler();
    }
}
