package com.action;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.activeMQ.CallService;


public class Snagrweb {
	final static Logger logger = Logger.getLogger(Snagrweb.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	ResourceBundle bundle = null;
	CallService call=null;
	
	public String activityLogs(String LocID,String ProjectName) {
		final String queueName = "SNAGRWEB.ACTIVITYLOGS.UAT";
		 String url="";
		 String res="";
		try {
		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,LocID,correlationId,"");
		

		
			try{
				 bundle = ResourceBundle.getBundle("serverConfig");
				 url=bundle.getString("snagrurl") + ProjectName +  bundle.getString("activitylogurl");
				 System.out.println("url  "+url);
				
				 call = new CallService();
					String[] checkparamKey = {"LocID"};
			        String[] checkparamValue = {LocID};
			         res = call.callGetService(url, checkparamKey, checkparamValue);
				 
				}catch(Exception e){
					return e.getMessage();
				}
   		
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
		}catch(Exception e) {
			return e.getMessage();
		}
		return res;
	}
	
	public String defects(String LocationID,String ProjectName) {
		final String queueName = "SNAGRWEB.DEFECTS.UAT";
		 String url="";
		 String res="";
		try {
		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,LocationID,correlationId,"");
		

		
			try{
				 bundle = ResourceBundle.getBundle("serverConfig");
				 url=bundle.getString("snagrurl") + ProjectName +  bundle.getString("defects");
				 System.out.println("url  "+url);
				
				 call = new CallService();
					String[] checkparamKey = {"LocationID"};
			        String[] checkparamValue = {LocationID};
			         res = call.callGetService(url, checkparamKey, checkparamValue);
				 
				}catch(Exception e){
					return e.getMessage();
				}
   		
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
		}catch(Exception e) {
			return e.getMessage();
		}
		return res;
	}
	
	
	
	public String drillDown(String DrawingID,String ProjectName) {
		final String queueName = "SNAGRWEB.DRILLDOWN.UAT";
		 String url="";
		 String res="";
		try {
		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,DrawingID,correlationId,"");
		

		
			try{
				 bundle = ResourceBundle.getBundle("serverConfig");
				 url=bundle.getString("snagrurl") + ProjectName +  bundle.getString("DrillDown");
				 System.out.println("url  "+url);
				
				 call = new CallService();
					String[] checkparamKey = {"DrawingID"};
			        String[] checkparamValue = {DrawingID};
			         res = call.callGetService(url, checkparamKey, checkparamValue);
				 
				}catch(Exception e){
					return e.getMessage();
				}
   		
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
		}catch(Exception e) {
			return e.getMessage();
		}
		return res;
	}
	
	
	public String Inspections(String LocID,String ProjectName) {
		final String queueName = "SNAGRWEB.INSPECTIONS.UAT";
		 String url="";
		 String res="";
		try {
		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,LocID,correlationId,"");
		

		
			try{
				 bundle = ResourceBundle.getBundle("serverConfig");
				 url=bundle.getString("snagrurl") + ProjectName +  bundle.getString("Inspections");
				 System.out.println("url  "+url);
				
				 call = new CallService();
					String[] checkparamKey = {"LocID"};
			        String[] checkparamValue = {LocID};
			         res = call.callGetService(url, checkparamKey, checkparamValue);
				 
				}catch(Exception e){
					return e.getMessage();
				}
   		
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
		}catch(Exception e) {
			return e.getMessage();
		}
		return res;
	}

	public String Location(String LocationIDs,String ProjectName) {
		final String queueName = "SNAGRWEB.LOCATION.UAT";
		 String url="";
		 String res="";
		try {
		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,LocationIDs,correlationId,"");
		

		
			try{
				 bundle = ResourceBundle.getBundle("serverConfig");
				 url=bundle.getString("snagrurl") + ProjectName +bundle.getString("Location");
				 System.out.println("url  "+url);
				
				 call = new CallService();
					String[] checkparamKey = {"LocationIDs"};
			        String[] checkparamValue = {LocationIDs};
			         res = call.callGetService(url, checkparamKey, checkparamValue);
				 
				}catch(Exception e){
					return e.getMessage();
				}
   		
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
		}catch(Exception e) {
			return e.getMessage();
		}
		return res;
	}
	
	public String LocationExtRef(String ExtRef,String ProjectName) {
		final String queueName = "SNAGRWEB.LocationExtRef.UAT";
		 String url="";
		 String res="";
		try {
		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,ExtRef,correlationId,"");
		

		
			try{
				 bundle = ResourceBundle.getBundle("serverConfig");
				 url=bundle.getString("snagrurl") + ProjectName +bundle.getString("Location");
				 System.out.println("url  "+url);
				
				 call = new CallService();
					String[] checkparamKey = {"ExtRef"};
			        String[] checkparamValue = {ExtRef};
			         res = call.callGetService(url, checkparamKey, checkparamValue);
				 
				}catch(Exception e){
					return e.getMessage();
				}
   		
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
		}catch(Exception e) {
			return e.getMessage();
		}
		return res;
	}
	

}
