package com.schedular;


import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.action.CallingList;

/**
 * This class defines a quartz job.
 * @author javawithease
 */
public class Job2 implements Job{
	final static Logger logger = Logger.getLogger(Job2.class);
	CallingList objCallingList = new CallingList();
	public void execute(JobExecutionContext context) 
			throws JobExecutionException {	 
		System.out.println("Job2 is running.");
		logger.info("Hourly Job2 is running.");
		objCallingList.getNUpdateCollectionCallingListMonthly();
	}
}
