package com.sfdc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.action.CallingList;
import com.action.SFDCConnection;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Calling_List__c;
import com.sforce.soap.enterprise.sobject.Group;
import com.sforce.soap.enterprise.sobject.RecordType;

public class CallingListSFDC {
	static EnterpriseConnection connection = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallingList objCallingList = new CallingList();
//		objCallingList.getNUpdateCollectionCallingListMonthly();
//		objCallingList.getNUpdateDPCollectionCallingListMonthly();
		objCallingList.getNUpdateRecoveryCollectionCallingListMonthly();
//		CallingListSFDC objCallingListSFDC = new CallingListSFDC();
//		objCallingListSFDC.Test();
//		
		//objCallingListSFDC.TestRegId();
		//String res = objCallingList.getCollectionCallingListIPMS("1234", "86466","", "", "", "", "", "", "");
		//System.out.println("res main :: "+res);
//		CallingListSFDC objCallingListSFDC = new CallingListSFDC();
		//objCallingListSFDC.UpdateCollectionCallingListMonthly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56);
	}
	
	
	public String Test() {
		System.out.println("inside");
		//System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2());
		try {
			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			 //////////////////////////////////////////////////////////////////////
		//	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
			//String query = "select Id , Name , Type from Group where Name = 'Collection Queue' and Type = 'Queue' ";
			String query = "select Id , Name , Type from Group where Name = 'Recovery Queue' and Type = 'Queue' ";
//			String query = "SELECT Id from RecordType where DeveloperName='Recovery_Calling_List'"; 
			QueryResult queryResults1 = connection.query(query);
	         //  System.out.println(queryResults1);
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	// RecordType RecType = (RecordType)queryResults1.getRecords()[i];
	            	 Group RecType = (Group)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+RecType.getId());
	             }
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	public String TestRegId() {
		System.out.println("inside");
		//System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2());
		try {
			Calendar c= Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			String s = "86466";
			String queryS = s + "-" + month + "-" + year;
			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			 //////////////////////////////////////////////////////////////////////
		//	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
			 QueryResult queryResults1 = connection.query("SELECT Id from Calling_List__c where MQ_Unique_Id__c='"+queryS+"'");
	           System.out.println(queryResults1);
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	 Calling_List__c objCalling_List__c = (Calling_List__c)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+objCalling_List__c.getId());
	             com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
            	 callingList.setId(objCalling_List__c.getId());
            	 callingList.setAmount_Received__c(100.23);
            	 
            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
    			 if(!results1[0].getSuccess()){
    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
    			 }
	             }
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	
//	public String UpdateCollectionCallingListMonthly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56) {
//				System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11());
//				try {
//					EnterpriseConnection connection=SFDCConnection.SfdcConnect();
//					 //////////////////////////////////////////////////////////////////////
//					Calendar cRegId = Calendar.getInstance();
//					 QueryResult queryResults1 = connection.query("SELECT Id from RecordType where DeveloperName='Collections_Calling_List'");
//			           
//			           if (queryResults1.getSize() > 0) {
//			             for (int i=0;i<queryResults1.getSize();i++){
//			            	 
//			            	 RecordType RecType = (RecordType)queryResults1.getRecords()[i];
//			            	// AccountId=l.getId();
//			            	 System.out.println(RecType.getId());
//			            	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
//			            	 callingList.setRecordTypeId(RecType.getId());
//			            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
//			            	 callingList.setCustomer_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3()));
//			            	 callingList.setDeposit_Received__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
//			            	 callingList.setDM_Due_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
//			            	 callingList.setInv_Due__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
//			            	 Calendar cal = Calendar.getInstance();
//			            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//			     			
//			     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7());
//			     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//			     			    System.out.println("Date :"+dateFormat.format(varDate));
//			     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
//			            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
//			            	 callingList.setRegistration_Date__c(cal);
//			            	 SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
//			            	 Date varDate1=dateFormat1.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8());
//			     			    dateFormat1=new SimpleDateFormat("yyyy-MM-dd");
//			     			    System.out.println("Date :"+dateFormat1.format(varDate1));
//			            	  cal.setTime(dateFormat1.parse(dateFormat1.format(varDate1)));
//			            	  
//			            	 callingList.setStatus_Update_Date__c(cal);
//			            	 callingList.setGeneral_Phone__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9()));
//			            	 callingList.setOld_Status_Desc__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
//			            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
//			            	 callingList.setSales_Executive__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
//			            	 callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13()));
//			            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14()));
//			            	 callingList.setAmount_Pending__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15()));
//			            	 callingList.setConstruction_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
//			            	 callingList.setDUE_0_30_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
//			            	 callingList.setDUE_30_60_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
//			            	 callingList.setDUE_60_90_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
//			            	 callingList.setDUE_90_180_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
//			            	 callingList.setDUE_180_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
//			            	 callingList.setDUE_MORE_THAN_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
//			            	 callingList.setNOT_DUE__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
//			            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
//			            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
//			    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
//			    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
//			    			 if(!results1[0].getSuccess()){
//			    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
//			    			 }
//			             //System.out.println("AccountId== "+RecType.getId());
//			             }
//			           }else{        
//			        	   System.out.println("AccountId no record== ");
//			           }
//				}catch (Exception e) {
//					// TODO: handle exception
//					System.out.println("Error :: "+e.getMessage());
//				}
//				return null;
//		
//			}

	
	public static String UpdateCollectionCallingListMonthly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56) {
		System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11());
		try {
			 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection bookingUnit :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
			 //////////////////////////////////////////////////////////////////////
			Calendar cRegId = Calendar.getInstance();
			int year = cRegId.get(Calendar.YEAR);
			int month = cRegId.get(Calendar.MONTH) + 1;
			//String s = "86466";
			String queryS = objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11() + "-" + month + "-" + year;
			QueryResult updateCallist = connection.query("SELECT Id from Calling_List__c where MQ_Unique_Id__c='"+queryS+"'");
	           if (updateCallist.getSize() > 0) {
	             for (int i=0;i<updateCallist.getSize();i++){
	            	 Calling_List__c objCalling_List__c = (Calling_List__c)updateCallist.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+objCalling_List__c.getId());
	             com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
            	 callingList.setId(objCalling_List__c.getId());
            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
            	 callingList.setDM_Due_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
            	 callingList.setInv_Due__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
            	 //callingList.setIn
            	 callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13()));
            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14()));
            	 callingList.setAmount_Pending__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15()));
            	 callingList.setConstruction_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
            	 callingList.setDUE_0_30_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
            	 callingList.setDUE_30_60_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
            	 callingList.setDUE_60_90_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
            	 callingList.setDUE_90_180_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
            	 callingList.setDUE_180_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
            	 callingList.setDUE_MORE_THAN_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
            	 callingList.setNOT_DUE__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
            	// callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
    			 if(!results1[0].getSuccess()){
    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
    			 }
	             }
	           }else {
			 QueryResult queryResults1 = connection.query("SELECT Id from RecordType where DeveloperName='Collections_Calling_List'");
	           
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	 
	            	 RecordType RecType = (RecordType)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	            	 System.out.println(RecType.getId());
	            	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
	            	 callingList.setRecordTypeId(RecType.getId());
	            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
	            	 callingList.setCustomer_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3()));
	            	 callingList.setDeposit_Received__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
	            	 callingList.setDM_Due_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
	            	 callingList.setInv_Due__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
	            	 Calendar cal = Calendar.getInstance();
	            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	     			
	     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7());
	     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat.format(varDate));
	     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
	            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
	            	 callingList.setRegistration_Date__c(cal);
	            	 SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
	            	 Date varDate1=dateFormat1.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8());
	     			    dateFormat1=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat1.format(varDate1));
	            	  cal.setTime(dateFormat1.parse(dateFormat1.format(varDate1)));
	            	  
	            	 callingList.setStatus_Update_Date__c(cal);
	            	 callingList.setGeneral_Phone__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9()));
	            	 callingList.setOld_Status_Desc__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
	            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
	            	 callingList.setSales_Executive__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
	            	 callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13()));
	            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14()));
	            	 callingList.setAmount_Pending__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15()));
	            	 callingList.setConstruction_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
	            	 callingList.setDUE_0_30_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
	            	 callingList.setDUE_30_60_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
	            	 callingList.setDUE_60_90_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
	            	 callingList.setDUE_90_180_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
	            	 callingList.setDUE_180_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
	            	 callingList.setDUE_MORE_THAN_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
	            	 callingList.setNOT_DUE__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
	            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
	            	 String query = "select Id , Name , Type from Group where Name = 'Collection Queue' and Type = 'Queue' ";
 	     			 QueryResult queryResultsQueue = connection.query(query);
	     	           System.out.println("size :: "+queryResultsQueue.getSize());
	     	           if (queryResultsQueue.getSize() > 0) {
	     	             for (int que=0;que<queryResultsQueue.getSize();que++){
	     	            	 Group grpQue = (Group)queryResultsQueue.getRecords()[que];
	     	            	// AccountId=l.getId();
	     	             System.out.println("RecordTypeId == "+grpQue.getId());
	     	             callingList.setOwnerId(grpQue.getId());
	     	             }
	     	           }else{        
	     	        	   System.out.println("Queue not found == ");
	     	           }
	            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
	    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
	    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
	    			 if(!results1[0].getSuccess()){
	    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
	    			 }
	             //System.out.println("AccountId== "+RecType.getId());
	             
	             }
	           
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :: "+e.getMessage());
		}finally {
			
		}
		return null;

	}

	
	public static String UpdateDPCollectionCallingListMonthly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56) {
		System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11());
		try {
			 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection bookingUnit :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
			 //////////////////////////////////////////////////////////////////////
			Calendar cRegId = Calendar.getInstance();
			int year = cRegId.get(Calendar.YEAR);
			int month = cRegId.get(Calendar.MONTH) + 1;
			//String s = "86466";
			String queryS = objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21() + "-" + month + "-" + year;
			QueryResult updateCallist = connection.query("SELECT Id from Calling_List__c where MQ_Unique_Id__c='"+queryS+"'");
	           if (updateCallist.getSize() > 0) {
	             for (int i=0;i<updateCallist.getSize();i++){
	            	 Calling_List__c objCalling_List__c = (Calling_List__c)updateCallist.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+objCalling_List__c.getId());
	             com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
            	 callingList.setId(objCalling_List__c.getId());
             	 callingList.setAmount_Applied__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
            	 callingList.setAmount_Credited__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3()));
            	 callingList.setAmount_Due_Original__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
            	 callingList.setAmount_Due_Remaining__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
            	 callingList.setBalance_Dp__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));
            	 callingList.setCustomer_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8()));
            	 callingList.setCustomer_Trx_Id__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9()));
            	 callingList.setDays__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
            	 callingList.setDp_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
            	 callingList.setPercent_Value__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
            	 Calendar cal = Calendar.getInstance();
            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
     			
     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13());
     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
     			    System.out.println("Date :"+dateFormat.format(varDate));
     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
            	 callingList.setRegistration_Date__c(cal);
            	 SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
            	 Date varDate1=dateFormat1.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14());
     			    dateFormat1=new SimpleDateFormat("yyyy-MM-dd");
     			    System.out.println("Date :"+dateFormat1.format(varDate1));
            	  cal.setTime(dateFormat1.parse(dateFormat1.format(varDate1)));
            	  
            	 callingList.setStatus_Update_Date__c(cal);
            	 SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");
            	 Date varDate2=dateFormat2.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15());
     			    dateFormat2=new SimpleDateFormat("yyyy-MM-dd");
     			    System.out.println("Date :"+dateFormat2.format(varDate2));
            	  cal.setTime(dateFormat2.parse(dateFormat2.format(varDate2)));
            	  
            	 callingList.setTrx_Date__c(cal);
            	 callingList.setDeposit_Received__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
            	 callingList.setGeneral_Phone__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
            	 callingList.setInterface_Line_Attribute3__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
            	 callingList.setInvoice_Type__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
            	 callingList.setOld_Status_Desc__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
            	 callingList.setSales_Executive__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
            	 callingList.setStatus__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
            	 callingList.setVisible_In_Cust_Stmt__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE24()));
            	 //callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
    			 if(!results1[0].getSuccess()){
    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
    			 }
	             }
	           }else {
			 QueryResult queryResults1 = connection.query("SELECT Id from RecordType where DeveloperName='DP_Calling_List'");
	           
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	 
	            	 RecordType RecType = (RecordType)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	            	 System.out.println(RecType.getId());
	            	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
	            	 callingList.setRecordTypeId(RecType.getId());
	            	 callingList.setAmount_Applied__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
	            	 callingList.setAmount_Credited__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3()));
	            	 callingList.setAmount_Due_Original__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
	            	 callingList.setAmount_Due_Remaining__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
	            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
	            	 callingList.setBalance_Dp__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));
	            	 callingList.setCustomer_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8()));
	            	 callingList.setCustomer_Trx_Id__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9()));
	            	 callingList.setDays__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
	            	 callingList.setDp_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
	            	 callingList.setPercent_Value__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
	            	 Calendar cal = Calendar.getInstance();
	            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	     			
	     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13());
	     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat.format(varDate));
	     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
	            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
	            	 callingList.setRegistration_Date__c(cal);
	            	 SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
	            	 Date varDate1=dateFormat1.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14());
	     			    dateFormat1=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat1.format(varDate1));
	            	  cal.setTime(dateFormat1.parse(dateFormat1.format(varDate1)));
	            	  
	            	 callingList.setStatus_Update_Date__c(cal);
	            	 SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");
	            	 Date varDate2=dateFormat2.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15());
	     			    dateFormat2=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat2.format(varDate2));
	            	  cal.setTime(dateFormat2.parse(dateFormat2.format(varDate2)));
	            	  
	            	 callingList.setTrx_Date__c(cal);
	            	 callingList.setDeposit_Received__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
	            	 callingList.setGeneral_Phone__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
	            	 callingList.setInterface_Line_Attribute3__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
	            	 callingList.setInvoice_Type__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
	            	 callingList.setOld_Status_Desc__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
	            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
	            	 callingList.setSales_Executive__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
	            	 callingList.setStatus__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
	            	 callingList.setVisible_In_Cust_Stmt__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE24()));
	            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
	            	 String query = "select Id , Name , Type from Group where Name = 'Collection Queue' and Type = 'Queue' ";
 	     			 QueryResult queryResultsQueue = connection.query(query);
	     	           System.out.println("size :: "+queryResultsQueue.getSize());
	     	           if (queryResultsQueue.getSize() > 0) {
	     	             for (int que=0;que<queryResultsQueue.getSize();que++){
	     	            	 Group grpQue = (Group)queryResultsQueue.getRecords()[que];
	     	            	// AccountId=l.getId();
	     	             System.out.println("RecordTypeId == "+grpQue.getId());
	     	             callingList.setOwnerId(grpQue.getId());
	     	             }
	     	           }else{        
	     	        	   System.out.println("Queue not found == ");
	     	           }
	            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
	    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
	    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
	    			 if(!results1[0].getSuccess()){
	    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
	    			 }
	             //System.out.println("AccountId== "+RecType.getId());
	             
	             }
	           
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :: "+e.getMessage());
		}
		return null;

	}
	
	
	public static String UpdateRecoveryCollectionCallingListMonthly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56) {
		System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11());
		try {
			 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection bookingUnit :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
			 //////////////////////////////////////////////////////////////////////
			Calendar cRegId = Calendar.getInstance();
			int year = cRegId.get(Calendar.YEAR);
			int month = cRegId.get(Calendar.MONTH) + 1;
			//String s = "86466";
			String queryS = objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2() + "-" + month + "-" + year;
			QueryResult updateCallist = connection.query("SELECT Id from Calling_List__c where MQ_Unique_Id__c='"+queryS+"'");
	           if (updateCallist.getSize() > 0) {
	             for (int i=0;i<updateCallist.getSize();i++){
	            	 Calling_List__c objCalling_List__c = (Calling_List__c)updateCallist.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+objCalling_List__c.getId());
	             com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
            	 callingList.setId(objCalling_List__c.getId());
            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
            	 callingList.setDLD_Reg_Status__c(Boolean.parseBoolean(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8())));
            	 callingList.setRecovery__c(Boolean.parseBoolean(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9())));
            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
            	 callingList.setPSF__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
            	 callingList.setParty_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
            	 Calendar cal = Calendar.getInstance();
            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
     			
     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7());
     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
     			    System.out.println("Date :"+dateFormat.format(varDate));
     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
            	 callingList.setArf_Date__c(cal);
            	
            	// callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
    			 if(!results1[0].getSuccess()){
    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
    			 }
	             }
	           }else {
			 QueryResult queryResults1 = connection.query("SELECT Id from RecordType where DeveloperName='Recovery_Calling_List'");
	           
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	 
	            	 RecordType RecType = (RecordType)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	            	 System.out.println(RecType.getId());
	            	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
	            	 callingList.setRecordTypeId(RecType.getId());
	            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
	            	 callingList.setDLD_Reg_Status__c(Boolean.parseBoolean(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8())));
	            	 callingList.setRecovery__c(Boolean.parseBoolean(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9())));
	            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
	            	 callingList.setPSF__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
	            	 callingList.setParty_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
	            	 Calendar cal = Calendar.getInstance();
	            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	     			
	     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7());
	     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat.format(varDate));
	     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
	            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
	            	 callingList.setArf_Date__c(cal);
	            	
	            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
	            	 
	            	 String query = "select Id , Name , Type from Group where Name = 'Recovery Queue' and Type = 'Queue'";
 	     			 QueryResult queryResultsQueue = connection.query(query);
	     	           System.out.println("size :: "+queryResultsQueue.getSize());
	     	           if (queryResultsQueue.getSize() > 0) {
	     	             for (int que=0;que<queryResultsQueue.getSize();que++){
	     	            	 Group grpQue = (Group)queryResultsQueue.getRecords()[que];
	     	            	// AccountId=l.getId();
	     	             System.out.println("RecordTypeId == "+grpQue.getId());
	     	             callingList.setOwnerId(grpQue.getId());
	     	             }
	     	           }else{        
	     	        	   System.out.println("Queue not found == ");
	     	           }
	            	 
	            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
	    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
	    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
	    			 if(!results1[0].getSuccess()){
	    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
	    			 }
	             //System.out.println("AccountId== "+RecType.getId());
	             
	             }
	           
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :: "+e.getMessage());
		}
		return null;

	}

	
	public static String UpdateCollectionCallingListHourly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56) {
		System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11());
		try {
			 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection bookingUnit :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
			 //////////////////////////////////////////////////////////////////////
			Calendar cRegId = Calendar.getInstance();
			int year = cRegId.get(Calendar.YEAR);
			int month = cRegId.get(Calendar.MONTH) + 1;
			//String s = "86466";
			String queryS = objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11() + "-" + month + "-" + year;
			QueryResult updateCallist = connection.query("SELECT Id from Calling_List__c where MQ_Unique_Id__c='"+queryS+"'");
	           if (updateCallist.getSize() > 0) {
	             for (int i=0;i<updateCallist.getSize();i++){
	            	 Calling_List__c objCalling_List__c = (Calling_List__c)updateCallist.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+objCalling_List__c.getId());
	             com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
            	 callingList.setId(objCalling_List__c.getId());
            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
            	 callingList.setDM_Due_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
            	 callingList.setInv_Due__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
            	 callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13()));
            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14()));
            	 callingList.setAmount_Pending__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15()));
            	 callingList.setConstruction_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
            	 callingList.setDUE_0_30_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
            	 callingList.setDUE_30_60_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
            	 callingList.setDUE_60_90_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
            	 callingList.setDUE_90_180_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
            	 callingList.setDUE_180_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
            	 callingList.setDUE_MORE_THAN_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
            	 callingList.setNOT_DUE__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
    			 if(!results1[0].getSuccess()){
    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
    			 }
	             }
	           }else {
			 QueryResult queryResults1 = connection.query("SELECT Id from RecordType where DeveloperName='Collections_Calling_List'");
	           
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	 
	            	 RecordType RecType = (RecordType)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	            	 System.out.println(RecType.getId());
	            	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
	            	 callingList.setRecordTypeId(RecType.getId());
	            	 callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
	            	 callingList.setCustomer_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3()));
	            	 callingList.setDeposit_Received__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
	            	 callingList.setDM_Due_Amount__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
	            	 callingList.setInv_Due__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6()));
	            	 Calendar cal = Calendar.getInstance();
	            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	     			
	     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7());
	     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat.format(varDate));
	     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
	            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
	            	 callingList.setRegistration_Date__c(cal);
	            	 SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
	            	 Date varDate1=dateFormat1.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE8());
	     			    dateFormat1=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat1.format(varDate1));
	            	  cal.setTime(dateFormat1.parse(dateFormat1.format(varDate1)));
	            	  
	            	 callingList.setStatus_Update_Date__c(cal);
	            	 callingList.setGeneral_Phone__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE9()));
	            	 callingList.setOld_Status_Desc__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE10()));
	            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()));
	            	 callingList.setSales_Executive__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE12()));
	            	 callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE13()));
	            	 callingList.setAmount_Paid__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE14()));
	            	 callingList.setAmount_Pending__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE15()));
	            	 callingList.setConstruction_Status__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE16()));
	            	 callingList.setDUE_0_30_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE17()));
	            	 callingList.setDUE_30_60_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE18()));
	            	 callingList.setDUE_60_90_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE19()));
	            	 callingList.setDUE_90_180_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE20()));
	            	 callingList.setDUE_180_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE21()));
	            	 callingList.setDUE_MORE_THAN_360_DAYS__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE22()));
	            	 callingList.setNOT_DUE__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE23()));
	            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
	            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
	    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
	    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
	    			 if(!results1[0].getSuccess()){
	    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
	    			 }
	             //System.out.println("AccountId== "+RecType.getId());
	             
	             }
	           
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :: "+e.getMessage());
		}
		return null;

	}
	
	private static double parseDoubleCus(String s){
	    if(s == null || s.isEmpty()) 
	        return 0.0;
	    else
	        return Double.parseDouble(s);
	}
	
	private static String parseStringCheckNull(String s){
	    if(s == null) {
	        return "";
	    }
		return s;
	    
	}

	public static String UpdateSPACollectionCallingListMonthly(APPSXXDC_PROCESS_SEX1794747X2X56 objAPPSXXDC_PROCESS_SEX1794747X2X56) {
		System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11());
		try {
			 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection UpdateSPACollectionCallingListMonthly :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
			 //////////////////////////////////////////////////////////////////////
			Calendar cRegId = Calendar.getInstance();
			int year = cRegId.get(Calendar.YEAR);
			int month = cRegId.get(Calendar.MONTH) + 1;
			//String s = "86466";
			String queryS = objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2() + "-" + month + "-" + year;
			QueryResult updateCallist = connection.query("SELECT Id from Calling_List__c where MQ_Unique_Id__c='"+queryS+"'");
	           if (updateCallist.getSize() > 0) {
	             for (int i=0;i<updateCallist.getSize();i++){
	            	 Calling_List__c objCalling_List__c = (Calling_List__c)updateCallist.getRecords()[i];
	            	// AccountId=l.getId();
	             System.out.println("RecordTypeId == "+objCalling_List__c.getId());
	             com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
            	 callingList.setId(objCalling_List__c.getId());
            	 
            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
            	 Calendar cal = Calendar.getInstance();
            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
     			
     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3());
     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
     			    System.out.println("Date :"+dateFormat.format(varDate));
     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
            	 callingList.setRegistration_Date__c(cal);
            	callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
            	callingList.setAmount_Due_Original__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
            	callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6())));
            	
            	// callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE11()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
    			 if(!results1[0].getSuccess()){
    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
    			 }
	             }
	           }else {
			 QueryResult queryResults1 = connection.query("SELECT Id from RecordType where DeveloperName='SPA_Calling'");
	           
	           if (queryResults1.getSize() > 0) {
	             for (int i=0;i<queryResults1.getSize();i++){
	            	 
	            	 RecordType RecType = (RecordType)queryResults1.getRecords()[i];
	            	// AccountId=l.getId();
	            	 System.out.println(RecType.getId());
	            	 com.sforce.soap.enterprise.sobject.Calling_List__c callingList = new com.sforce.soap.enterprise.sobject.Calling_List__c();
	            	 callingList.setRecordTypeId(RecType.getId());
	            	 callingList.setRegistration_ID__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()));
	            	 Calendar cal = Calendar.getInstance();
	            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	     			
	     			    Date varDate=dateFormat.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE3());
	     			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	     			    System.out.println("Date :"+dateFormat.format(varDate));
	     			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
	            	// cal.setTime(sdf.parse(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE7()));// all done
	            	 callingList.setRegistration_Date__c(cal);
	            	callingList.setAmount_Received__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE4()));
	            	callingList.setAmount_Due_Original__c(CallingListSFDC.parseDoubleCus(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE5()));
	            	callingList.setUnit_Status__c(CallingListSFDC.parseStringCheckNull(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE6())));
	            	 callingList.setMQ_Unique_Id__c(CallingListSFDC.parseStringCheckNull(objAPPSXXDC_PROCESS_SEX1794747X2X56.getATTRIBUTE2()) + "-" + (cRegId.get(Calendar.MONTH)+1) + "-" + cRegId.get(Calendar.YEAR));
	            	 
	            	 String query = "select Id , Name , Type from Group where Name = 'Contact Center Queue' and Type = 'Queue'";
 	     			 QueryResult queryResultsQueue = connection.query(query);
	     	           System.out.println("size :: "+queryResultsQueue.getSize());
	     	           if (queryResultsQueue.getSize() > 0) {
	     	             for (int que=0;que<queryResultsQueue.getSize();que++){
	     	            	 Group grpQue = (Group)queryResultsQueue.getRecords()[que];
	     	            	// AccountId=l.getId();
	     	             System.out.println("RecordTypeId == "+grpQue.getId());
	     	             callingList.setOwnerId(grpQue.getId());
	     	             }
	     	           }else{        
	     	        	   System.out.println("Queue not found == ");
	     	           }
	            	 
	            	 com.sforce.soap.enterprise.SaveResult[] results1 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { callingList });
	    			 System.out.println("Result  :::::: " + results1[0].getSuccess());
	    			 //logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
	    			 if(!results1[0].getSuccess()){
	    				 System.out.print("Result  ::::::  " + results1[0].getErrors()[0].getMessage());
	    			 }
	             //System.out.println("AccountId== "+RecType.getId());
	             
	             }
	           
	           }else{        
	        	   System.out.println("AccountId no record== ");
	           }
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :: "+e.getMessage());
		}
		return null;

	}
	
	
	
}
