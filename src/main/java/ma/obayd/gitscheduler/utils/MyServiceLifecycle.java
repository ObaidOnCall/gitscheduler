package ma.obayd.gitscheduler.utils;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
public class MyServiceLifecycle implements SmartLifecycle{

    Logger logger = Logger.getLogger(getClass().getName());
    private boolean isRunning = false;

    @Override
    public void start() {

        logger.info("Application starts ✅");
        isRunning = true ;
    }

    @Override
    public void stop() {

        logger.warning("Application shutdown ❎");
        isRunning = false ;
    }

    @Override
    public boolean isRunning() {
        return isRunning ;
    }

}
