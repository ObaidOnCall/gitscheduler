package ma.obayd.gitscheduler.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.Setter;

import java.util.logging.Logger;

@Setter
public class EmailJob implements Job{

    private String message ;
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap() ;
        
        logger.info(message + ":email sent ✅");
    }

}
