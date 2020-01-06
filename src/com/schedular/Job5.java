package com.schedular;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.action.BouncedCheque;
import com.action.CallingList;

public class Job5 implements Job{
	final static Logger logger = Logger.getLogger(Job5.class);
	BouncedCheque objBouncedCheque = new BouncedCheque();
	
	public void execute(JobExecutionContext context) 
			throws JobExecutionException {	 
		System.out.println("Job5 is running.");
		logger.info("Job5 is running.");
		objBouncedCheque.BouncedChequeProcess("2-122", "GET_BOUNCED_CHQ_LIST", "SFDC");
	}
}
