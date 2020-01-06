package com.schedular;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.action.BouncedCheque;
import com.action.CallingList;
import com.sfdc.BouncedChequeSFDC;

public class Job7 implements Job{
	final static Logger logger = Logger.getLogger(Job7.class);
	
	
	CallingList objCallingList = new CallingList();
	public void execute(JobExecutionContext context) 
			throws JobExecutionException {	 
		System.out.println("Job7 is running.");
		logger.info("Monthly Job7 is running.");
		objCallingList.getNUpdateSPACallingListMonthly();
	}
}
