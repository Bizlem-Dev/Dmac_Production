package com.schedular;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.action.CallingList;

public class Job4 implements Job{
	final static Logger logger = Logger.getLogger(Job4.class);
	CallingList objCallingList = new CallingList();
	public void execute(JobExecutionContext context) 
			throws JobExecutionException {	 
		System.out.println("Job4 is running.");
		logger.info("Job4 is running.");
		objCallingList.getNUpdateRecoveryCollectionCallingListMonthly();
	}
}
