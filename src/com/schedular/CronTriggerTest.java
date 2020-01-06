package com.schedular;



import java.util.ResourceBundle;

import org.apache.camel.core.osgi.utils.BundleContextUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * This class is used for executing multiple 
 * quartz job using CronTrigger(Quartz 2.1.5).
 * @author javawithease
 */
public class CronTriggerTest {
	public  void Main( ){
    	try{
    		//Set job details.
    		JobDetail job1 = JobBuilder.newJob(Job1.class)
    				.withIdentity("job1", "group1").build();
    		
    		JobDetail job2 = JobBuilder.newJob(Job2.class)
    				.withIdentity("job2", "group1").build();
    		
    		JobDetail job3 = JobBuilder.newJob(Job3.class)
    				.withIdentity("job3", "group1").build();
        	
        	//Set the scheduler timings.
    		Trigger trigger1 = TriggerBuilder.newTrigger()
    			.withIdentity("cronTrigger1", "group1")
    			.withSchedule(CronScheduleBuilder
    				.cronSchedule("0/10 * * * * ?")).build();
    		
    		Trigger trigger2 = TriggerBuilder.newTrigger()
    			.withIdentity("cronTrigger2", "group1")
    			.withSchedule(CronScheduleBuilder
    				.cronSchedule("0/10 * * * * ?")).build();
    		
    		Trigger trigger3 = TriggerBuilder.newTrigger()
    			.withIdentity("cronTrigger3", "group1")
    			.withSchedule(CronScheduleBuilder
    				.cronSchedule("0/10 * * * * ?")).build();
        	
        	//Execute the job.
    		Scheduler scheduler = 
    				new StdSchedulerFactory().getScheduler();
        	scheduler.start();
        	scheduler.scheduleJob(job1, trigger1);
        	scheduler.scheduleJob(job2, trigger2);
        	scheduler.scheduleJob(job3, trigger3);
    	}catch(Exception e){
    		e.printStackTrace();
    	}    	
	}
	
	static ResourceBundle bundle = ResourceBundle.getBundle("serverConfig"); 
	public static void callCronJob(){
		try{
			//bundle = ResourceBundle.getBundle("serverConfig");
    		//Set job details.
    		JobDetail job1 = JobBuilder.newJob(Job1.class)
    				.withIdentity("job1", "group1").build();
    		
    		JobDetail job2 = JobBuilder.newJob(Job2.class)
    				.withIdentity("job2", "group1").build();
    		
    		JobDetail job3 = JobBuilder.newJob(Job3.class)
    				.withIdentity("job3", "group1").build();
    		
    		JobDetail job4 = JobBuilder.newJob(Job4.class)
    				.withIdentity("job4", "group1").build();
    		
    		JobDetail job5 = JobBuilder.newJob(Job5.class)
    				.withIdentity("job5", "group1").build();
    		
    		JobDetail job6 = JobBuilder.newJob(Job6.class)
    				.withIdentity("job6", "group1").build();
    		
    		JobDetail job7 = JobBuilder.newJob(Job7.class)
    				.withIdentity("job7", "group1").build();
        	
    		//Set the scheduler timings.
    		Trigger trigger1 = TriggerBuilder.newTrigger()
    			.withIdentity("cronTrigger1", "group1")
    			.withSchedule(CronScheduleBuilder
    				.cronSchedule(bundle.getString("collectionscallinglistmonth"))).build();
    		
    		Trigger trigger2 = TriggerBuilder.newTrigger()
    			.withIdentity("cronTrigger2", "group1")
    			.withSchedule(CronScheduleBuilder
    				.cronSchedule(bundle.getString("collectionscallinglisthour"))).build();
    		
    		Trigger trigger3 = TriggerBuilder.newTrigger()
    			.withIdentity("cronTrigger3", "group1")
    			.withSchedule(CronScheduleBuilder
    				.cronSchedule(bundle.getString("dpcallinglistweek"))).build();
    		
    		Trigger trigger4 = TriggerBuilder.newTrigger()
        			.withIdentity("cronTrigger4", "group1")
        			.withSchedule(CronScheduleBuilder
        				.cronSchedule(bundle.getString("recoverycallinglistmonth"))).build();
        	
    		Trigger trigger5 = TriggerBuilder.newTrigger()
        			.withIdentity("cronTrigger5", "group1")
        			.withSchedule(CronScheduleBuilder
        				.cronSchedule(bundle.getString("bouncechequelist"))).build();
        	
    		Trigger trigger6 = TriggerBuilder.newTrigger()
        			.withIdentity("cronTrigger6", "group1")
        			.withSchedule(CronScheduleBuilder
        				.cronSchedule(bundle.getString("bouncechequereason"))).build();
        	
    		Trigger trigger7 = TriggerBuilder.newTrigger()
        			.withIdentity("cronTrigger7", "group1")
        			.withSchedule(CronScheduleBuilder
        				.cronSchedule(bundle.getString("spacallinglistmonth"))).build();
        	
    		
        	//Execute the job.
    		Scheduler scheduler = 
    				new StdSchedulerFactory().getScheduler();
        	scheduler.start();
        	scheduler.scheduleJob(job1, trigger1);
        	scheduler.scheduleJob(job2, trigger2);
        	scheduler.scheduleJob(job3, trigger3);
        	scheduler.scheduleJob(job4, trigger4);
        	scheduler.scheduleJob(job5, trigger5);
        	scheduler.scheduleJob(job6, trigger6);
        	scheduler.scheduleJob(job7, trigger7);
    	}catch(Exception e){
    		e.printStackTrace();
    	}    	

	}
}
