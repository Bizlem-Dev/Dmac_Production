package com.sfdc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.action.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.Error;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Booking_Unit__c;
import com.sforce.soap.enterprise.sobject.Case;
import com.sforce.soap.enterprise.sobject.SR_Attachments__c;

public class GeneratePCCSFDC {
	static EnterpriseConnection connection = null;

	public static String setPCCUrl(String url,String RegId,String procStatus,String procMessage,String caseId){
    	System.out.println("start");
    	String caseNumber="";
    	System.out.println("GeneratePCCSFDC setPCCUrl param id response :: "+RegId);
    	System.out.println("GeneratePCCSFDC setPCCUrl PROC_STATUS response :: "+procStatus);
    	System.out.println("GeneratePCCSFDC setPCCUrl PROC_Message response :: "+procMessage);
    	System.out.println("GeneratePCCSFDC setPCCUrl URL response :: "+url);
    	System.out.println("GeneratePCCSFDC setPCCUrl CASE response :: "+caseId);
    	try {
    		// EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection GeneratePCCSFDC setPCCUrl :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       		System.out.println("connection GeneratePCCSFDC setPCCUrl After :: "+connection);
    		}
    	/*	System.out.println("connection GeneratePCCSFDC setPCCUrl Query Beforw :: SELECT Id FROM Booking_Unit__c WHERE Registration_ID__c = '"+RegId+"'");
    	     QueryResult queryResults = connection.query("SELECT Id FROM Booking_Unit__c WHERE Registration_ID__c = '"+RegId+"'");
    	     System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults 1 length :: "+queryResults.getSize() + " Query :: SELECT Id FROM Booking_Unit__c WHERE Registration_ID__c = '"+RegId+"'");
            if (queryResults.getSize() > 0) {
              for (int i=0;i<queryResults.getSize();i++){
            	  Booking_Unit__c buc = (Booking_Unit__c)queryResults.getRecords()[i];
            	  System.out.println("connection GeneratePCCSFDC setPCCUrl Booking_Unit__c :: "+buc.getId()); 
            	 // QueryResult queryResultsCase = connection.query("SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' And Status != 'Rejected') AND RecordType.DeveloperName = 'Early_Handover'");
            	  System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults Query :: SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' AND Status != 'Rejected' AND Status != 'Cancelled') AND RecordType.DeveloperName = 'Early_Handover'");
            	  QueryResult queryResultsCase = connection.query("SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' AND Status != 'Rejected' AND Status != 'Cancelled') AND RecordType.DeveloperName = 'Early_Handover'");
            	  System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults 2 length :: "+queryResultsCase.getSize() + " Query :: SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' AND Status != 'Rejected' AND Status != 'Cancelled') AND RecordType.DeveloperName = 'Early_Handover'");
            	  if (queryResultsCase.getSize() > 0) {
            	  for (int queryResultsCasei=0;queryResultsCasei<queryResultsCase.getSize();queryResultsCasei++){
                	  Case c = (Case)queryResultsCase.getRecords()[queryResultsCasei];
                	  System.out.println("connection GeneratePCCSFDC setPCCUrl Case :: "+c.getId());
          */      	 
                	  
                	  QueryResult queryResultsAttachment = connection.query("SELECT Attachment_URL__c,Case__c,Id FROM SR_Attachments__c WHERE Case__c = '"+caseId+"' AND Name LIKE '%PCC%'");
                	  System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults 3 length :: "+queryResultsAttachment.getSize() + " Query :: SELECT Attachment_URL__c,Case__c,Id FROM SR_Attachments__c WHERE Case__c = '"+caseId+"' AND Name LIKE '%PCC%'");
                	  if (queryResultsAttachment.getSize() > 0) {
                	  for (int queryResultsAttachmenti=0;queryResultsAttachmenti<queryResultsAttachment.getSize();queryResultsAttachmenti++){
                		  SR_Attachments__c objSR_Attachments__c = (SR_Attachments__c)queryResultsAttachment.getRecords()[queryResultsAttachmenti];
                		  SR_Attachments__c[] records = new SR_Attachments__c[1];
                	              SR_Attachments__c l = new SR_Attachments__c();
                	        	   l.setId(objSR_Attachments__c.getId());
                	        	   if(procStatus.equals("E")) {
                	        		   System.out.println("connection GeneratePCCSFDC setPCCUrl length() :: "+procMessage.length());
                	        		   System.out.println("connection GeneratePCCSFDC setPCCUrl :: "+procMessage);
                	        	   l.setError_Message__c(procMessage);
                	        	   }else {
                	        		   l.setAttachment_URL__c(url);
                    	        	}
                	             records[0] = l;
                	     
                	           // create the records in Salesforce.com
                	           SaveResult[] saveResults = connection.update(records);
                	     
                	             if (saveResults[0].isSuccess()) {
                	            	System.out.println("GeneratePCCSFDC setPCCUrl Successfully created record - CaseId: " + saveResults[0].getSuccess());
                	             } else {
                	               Error[] errors = saveResults[0].getErrors();
                	               for (int j=0; j< errors.length; j++) { 
                	            	   System.out.println("GeneratePCCSFDC setPCCUrl ERROR creating record: " + errors[0].getMessage()); 
                	            	   } 
                	   			} 
                	   			
                	  }
                	  }
            	
            	  
            	  
            	/*  }
            	  }
               System.out.println("GeneratePCCSFDC setPCCUrl == "+caseNumber);
              }
            }
            */
            
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println("error  ::  " +e.getMessage());
		}
    	return caseNumber;
    }	

//	public static String setPCCUrl(String url,String RegId,String procStatus,String procMessage){
//    	System.out.println("start");
//    	String caseNumber="";
//    	System.out.println("GeneratePCCSFDC setPCCUrl param id response :: "+RegId);
//    	System.out.println("GeneratePCCSFDC setPCCUrl PROC_STATUS response :: "+procStatus);
//    	System.out.println("GeneratePCCSFDC setPCCUrl PROC_Message response :: "+procMessage);
//    	System.out.println("GeneratePCCSFDC setPCCUrl URL response :: "+url);
//    	try {
//    		// EnterpriseConnection connection=SFDCConnection.SfdcConnect();
//    		System.out.println("connection GeneratePCCSFDC setPCCUrl :: "+connection);
//    		if(connection == null) {
//       		 connection = SFDCConnection.SfdcConnect();
//       		System.out.println("connection GeneratePCCSFDC setPCCUrl After :: "+connection);
//    		}
//    		System.out.println("connection GeneratePCCSFDC setPCCUrl Query Beforw :: SELECT Id FROM Booking_Unit__c WHERE Registration_ID__c = '"+RegId+"'");
//    	     QueryResult queryResults = connection.query("SELECT Id FROM Booking_Unit__c WHERE Registration_ID__c = '"+RegId+"'");
//    	     System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults 1 length :: "+queryResults.getSize() + " Query :: SELECT Id FROM Booking_Unit__c WHERE Registration_ID__c = '"+RegId+"'");
//            if (queryResults.getSize() > 0) {
//              for (int i=0;i<queryResults.getSize();i++){
//            	  Booking_Unit__c buc = (Booking_Unit__c)queryResults.getRecords()[i];
//            	  System.out.println("connection GeneratePCCSFDC setPCCUrl Booking_Unit__c :: "+buc.getId()); 
//            	 // QueryResult queryResultsCase = connection.query("SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' And Status != 'Rejected') AND RecordType.DeveloperName = 'Early_Handover'");
//            	  System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults Query :: SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' AND Status != 'Rejected' AND Status != 'Cancelled') AND RecordType.DeveloperName = 'Early_Handover'");
//            	  QueryResult queryResultsCase = connection.query("SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' AND Status != 'Rejected' AND Status != 'Cancelled') AND RecordType.DeveloperName = 'Early_Handover'");
//            	  System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults 2 length :: "+queryResultsCase.getSize() + " Query :: SELECT Id FROM Case WHERE Booking_Unit__c = '"+buc.getId()+"' AND (Status != 'Closed' AND Status != 'New' AND Status != 'Rejected' AND Status != 'Cancelled') AND RecordType.DeveloperName = 'Early_Handover'");
//            	  if (queryResultsCase.getSize() > 0) {
//            	  for (int queryResultsCasei=0;queryResultsCasei<queryResultsCase.getSize();queryResultsCasei++){
//                	  Case c = (Case)queryResultsCase.getRecords()[queryResultsCasei];
//                	  System.out.println("connection GeneratePCCSFDC setPCCUrl Case :: "+c.getId());
//                	  QueryResult queryResultsAttachment = connection.query("SELECT Attachment_URL__c,Case__c,Id FROM SR_Attachments__c WHERE Case__c = '"+c.getId()+"' AND Name LIKE '%PCC%'");
//                	  System.out.println("connection GeneratePCCSFDC setPCCUrl queryResults 3 length :: "+queryResultsAttachment.getSize() + " Query :: SELECT Attachment_URL__c,Case__c,Id FROM SR_Attachments__c WHERE Case__c = '"+c.getId()+"' AND Name LIKE '%PCC%'");
//                	  if (queryResultsAttachment.getSize() > 0) {
//                	  for (int queryResultsAttachmenti=0;queryResultsAttachmenti<queryResultsAttachment.getSize();queryResultsAttachmenti++){
//                		  SR_Attachments__c objSR_Attachments__c = (SR_Attachments__c)queryResultsAttachment.getRecords()[queryResultsAttachmenti];
//                		  SR_Attachments__c[] records = new SR_Attachments__c[1];
//                	              SR_Attachments__c l = new SR_Attachments__c();
//                	        	   l.setId(objSR_Attachments__c.getId());
//                	        	   if(procStatus.equals("E")) {
//                	        		   System.out.println("connection GeneratePCCSFDC setPCCUrl length() :: "+procMessage.length());
//                	        		   System.out.println("connection GeneratePCCSFDC setPCCUrl :: "+procMessage);
//                	        	   l.setError_Message__c(procMessage);
//                	        	   }else {
//                	        		   l.setAttachment_URL__c(url);
//                    	        	}
//                	             records[0] = l;
//                	     
//                	           // create the records in Salesforce.com
//                	           SaveResult[] saveResults = connection.update(records);
//                	     
//                	             if (saveResults[0].isSuccess()) {
//                	            	System.out.println("GeneratePCCSFDC setPCCUrl Successfully created record - CaseId: " + saveResults[0].getSuccess());
//                	             } else {
//                	               Error[] errors = saveResults[0].getErrors();
//                	               for (int j=0; j< errors.length; j++) { 
//                	            	   System.out.println("GeneratePCCSFDC setPCCUrl ERROR creating record: " + errors[0].getMessage()); 
//                	            	   } 
//                	   			} 
//                	   			
//                	  }
//                	  }
//            	  }
//            	  }
//               System.out.println("GeneratePCCSFDC setPCCUrl == "+caseNumber);
//              }
//            }
//            
//            
//    	}catch (Exception e) {
//			// TODO: handle exception
//    		System.out.println(e.getMessage());
//		}
//    	return caseNumber;
//    }	
	
		
}
