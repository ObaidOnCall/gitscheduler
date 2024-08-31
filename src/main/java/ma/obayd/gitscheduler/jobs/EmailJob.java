package ma.obayd.gitscheduler.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.logging.Logger;


public class EmailJob implements Job{

    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("email sent ✅");
    }

}
