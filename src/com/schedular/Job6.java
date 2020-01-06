package com.schedular;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.action.BouncedCheque;
import com.action.CallingList;
import com.sfdc.BouncedChequeSFDC;

public class Job6 implements Job{
	final static Logger logger = Logger.getLogger(Job6.class);
	
	
	public void execute(JobExecutionContext context) 
			throws JobExecutionException {	 
		System.out.println("Job6 is running.");
		logger.info("Job6 is running.");
		BouncedChequeSFDC.getCaseForNoReason();
	}
}
