package ma.obayd.gitscheduler.lifecycle;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.logging.Logger;


@Component
public class MyServiceLifecycle{

    Logger logger = Logger.getLogger(getClass().getName());
    private boolean isRunning = false;

    private final Scheduler scheduler ;

    @Autowired
    public MyServiceLifecycle(Scheduler scheduler) {
        this.scheduler = scheduler ;
    }

    @PostConstruct
    public void start() {
        try {
            scheduler.start();
            logger.info("starts Quartz✅");

            isRunning = true ;
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.info("Quartz faild to starts with mesage :" + e.getMessage());

            isRunning = false ;

        }
    }

    @PreDestroy
    public void stop() {
        try {
            scheduler.shutdown();
            logger.warning("Quartz is going to shutdown ✅");
            isRunning = false ;
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.warning("Quartz faild to shutdown ❎ message"+e.getMessage());
            isRunning = true ;

        }
    }

    public boolean isRunning() {
        return isRunning ;
    }

}
