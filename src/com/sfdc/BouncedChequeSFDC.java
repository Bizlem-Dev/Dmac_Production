package com.sfdc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.action.BouncedCheque;
import com.action.SFDCConnection;
import com.activeMQ.ActiveMQCall;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.DeleteResult;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.Error;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Booking_Unit__c;
import com.sforce.soap.enterprise.sobject.Case;
import com.sforce.soap.enterprise.sobject.Lead;
import com.sforce.soap.enterprise.sobject.RecordType;
import com.sforce.soap.enterprise.sobject.SR_Booking_Unit__c;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.ConnectionException;


public class BouncedChequeSFDC {

//	static EnterpriseConnection connection;
	/*static final String USERNAME = "akhil@akhilpvtltd.com";
	static final String PASSWORD = "bizlem12!@isAmHOJNL0aMe9qsi2p8l3gn4";*/
	
	static final String USERNAME = "sfdc.mq@damacgroup.com.devpro";
	static final String PASSWORD = "sfdcmq1234hu6JZ3DyV9csul6cVPYdoTO";
	//static final String PASSWORD = "sfdcmq123";
    public BouncedChequeSFDC() {
//    	System.out.println("connecction :: "+connection);
//    	if(connection == null) {
//   		 connection = SFDCConnection.SfdcConnect();
//   	 }
    }
    public static void main(String[] args) {
//    	BouncedCheque objBouncedCheque = new BouncedCheque();
//    	objBouncedCheque.BouncedChequeProcess("2-122", "GET_BOUNCED_CHQ_LIST", "SFDC");
    	BouncedChequeSFDC.getCaseForNoReason();
    	//new BouncedChequeSFDC().login();
//    	new BouncedChequeSFDC().getCaseForNoReason();
//    	BouncedChequeSFDC.getCaseNumber("5007E000006813L");
//    	BouncedCheque objBouncedCheque = new BouncedCheque();
//    	BouncedChequeSFDC.getCaseNumber("5007E000006813L");
//    	BouncedChequeSFDC obj = new BouncedChequeSFDC();
//    	obj.getCaseNumber("vs");
    }
    public void login(){
    	String sfdcUserName = USERNAME;
		String sfdcPassword = PASSWORD;
		
		ConnectorConfig config = new ConnectorConfig();
		config.setUsername(sfdcUserName);
		config.setPassword(sfdcPassword);
		//config.setAuthEndpoint("https://login.salesforce.com/services/Soap/c/40.0");
		config.setAuthEndpoint("https://test.salesforce.com/services/Soap/c/40.0");
try{
		connection = Connector.newConnection(config);
	        System.out.println("Auth EndPoint: "+config.getAuthEndpoint());
		System.out.println("Service EndPoint: "+config.getServiceEndpoint());
		System.out.println("Username: "+config.getUsername());
		System.out.println("SessionId: "+config.getSessionId());
		
              // run the different examples
	//	printparams();
            // queryLeads();                   // Query Leads from Salesforce
             //createLeads();                  // Create Leads in Salesforce
            // updateLeads();                  // Update Leads in Salesforce
           //  deleteLeads();                  // Delete Leads in Salesforce
		bouncedChequeCase("2345322","","2017-10-25","7846","","","","");
		bookingUnit("765", "5007E000005Zw51QAC");
		//a2F7E0000003kuDUAQ
        } catch (ConnectionException e1) {
            e1.printStackTrace();
        }  
  
//        try {
//             connection.logout();
//              System.out.println("Logged out.");
//       } catch (ConnectionException ce) {
//                  ce.printStackTrace();
//       }
    }     
    
	final static Logger logger = Logger.getLogger(BouncedChequeSFDC.class); 
    
    static EnterpriseConnection connection = null;
    public static String bouncedChequeCase(String PartyId, String Cheque_Number__c, String Cheque_Date,String Cheque_Amount, String Bank_Name,String BankAccountName,String Receipt_Id__c,String BounceReason){
    	String res="";
    	String AccountId="";
    	String RecordTypeId="";
    	String CaseId="";
    	 //System.out.println("print printparams ...");
    	    
         try {
        	 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
        	// System.out.println("connection bouncedChequeCase :: "+connection);
        	 if(connection == null) {
        		 connection = SFDCConnection.SfdcConnect();
        	 }
        	 logger.info("bouncedChequeCase connection :: "+connection);
           //QueryResult queryResults = connection.query("SELECT Country__c, Country_Arabic__c, Address_2__c, Address_Arabic_2__c, Address_3__c, Address_Arabic_3__c, Address_4__c, Address_Arabic_4__c, City__c, City_Arabic__c, State__c, State_Arabic__c, Postal_Code__c, Postal_Code_Arabic__c, Contact_Email__c, Mobile_Country_Code__c, Contact_Mobile__c, Home_Phone__c, Home_Phone_Country_Code__c, Work_Phone__c, Work_Phone_Country_Code__c,New_CR__c, Passport_Issue_Date__c, Passport_Issue_Place__c, Passport_Issue_Place_Arabic__c, Changed_Nationality__c, Changed_Nationality_Arabic__c, Title__c, Title_Arabic__c, Customer_First_Name__c, Customer_Middle_Name__c, Customer_Last_Name__c from Case ");
           QueryResult queryResults1 = connection.query("SELECT Id from Account Where Party_ID__c='"+PartyId+"'");
           logger.info("bouncedChequeCase queryResults1 :: "+"SELECT Id from Account Where Party_ID__c='"+PartyId+"'");
           if (queryResults1.getSize() > 0) {
             for (int i=0;i<queryResults1.getSize();i++){
            	 Account l = (Account)queryResults1.getRecords()[i];
            	 AccountId=l.getId();
            // System.out.println("AccountId== "+AccountId);
             logger.info("bouncedChequeCase AccountId :: "+AccountId);
             }
           }else{        
        	   //System.out.println("AccountId no record== ");
        	   logger.info("bouncedChequeCase AccountId no record==");
           }
           
           //QueryResult queryResults = connection.query("SELECT Country__c, Country_Arabic__c, Address_2__c, Address_Arabic_2__c, Address_3__c, Address_Arabic_3__c, Address_4__c, Address_Arabic_4__c, City__c, City_Arabic__c, State__c, State_Arabic__c, Postal_Code__c, Postal_Code_Arabic__c, Contact_Email__c, Mobile_Country_Code__c, Contact_Mobile__c, Home_Phone__c, Home_Phone_Country_Code__c, Work_Phone__c, Work_Phone_Country_Code__c,New_CR__c, Passport_Issue_Date__c, Passport_Issue_Place__c, Passport_Issue_Place_Arabic__c, Changed_Nationality__c, Changed_Nationality_Arabic__c, Title__c, Title_Arabic__c, Customer_First_Name__c, Customer_Middle_Name__c, Customer_Last_Name__c from Case ");
           QueryResult queryResults2 = connection.query("SELECT Id from RecordType Where DeveloperName='Bounced_Cheque_SR'");
           logger.info("bouncedChequeCase queryResults2 :: "+"SELECT Id from RecordType Where DeveloperName='Bounced_Cheque_SR'");
           if (queryResults2.getSize() > 0) {
             for (int i=0;i<queryResults2.getSize();i++){
            	 RecordType l = (RecordType)queryResults2.getRecords()[i];
            	 RecordTypeId=l.getId();
             System.out.println("RecordTypeId== "+RecordTypeId);
             logger.info("bouncedChequeCase RecordTypeId :: "+RecordTypeId);
             }
           }else{        
        	   System.out.println("RecordTypeId no record== ");
        	   logger.info("bouncedChequeCase RecordTypeId no record==");
           }   
     
         } catch (Exception e) {
           e.printStackTrace();
           logger.info("bouncedChequeCase Exception 1 :: "+e.getMessage());
         }    
    	
         
         System.out.println("Creating  case...");
         Case[] records = new Case[1];
     
         try {
//        	 Calendar cal = Calendar.getInstance();
//        	 SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
//        	 cal.setTime(sdf.parse(Cheque_Date));// all done
        	 Calendar cal = Calendar.getInstance();
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
 			
 			    Date varDate=dateFormat.parse(Cheque_Date);
 			    dateFormat=new SimpleDateFormat("yyyy-MM-dd");
 			    System.out.println("Date :"+dateFormat.format(varDate));
 			    cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
           // create 5 test leads
           for (int i=0;i<1;i++) {
        	   Case l = new Case();
        	   l.setSR_Type__c("Bounced Cheque SR");
        	   l.setCheque_Number__c(Cheque_Number__c);
        	   l.setBounced_Cheque_Date_of_Expiry__c(cal);
        	   l.setCheque_Amount__c(Double.valueOf(Cheque_Amount)); 	  
        	   l.setCheque_Bank_Name__c(Bank_Name);
        	   l.setRecordTypeId(RecordTypeId);
        	   l.setAccountId(AccountId);
        	   l.setReceipt_Id__c(Receipt_Id__c);
  
             records[i] = l;
           }
     
           // create the records in Salesforce.com
           SaveResult[] saveResults = connection.create(records);
     
           // check the returned results for any errors
           for (int i=0; i< saveResults.length; i++) {
             if (saveResults[i].isSuccess()) {
            	 CaseId=saveResults[i].getId();
               System.out.println(i+". Successfully created record - CaseId: " + CaseId);
               logger.info("bouncedChequeCase :: "+i+". Successfully created record - CaseId: " + CaseId);
             } else {
               Error[] errors = saveResults[i].getErrors();
               for (int j=0; j< errors.length; j++) { 
            	   System.out.println("ERROR creating record: " + errors[j].getMessage()); 
            	   logger.info("bouncedChequeCase :: "+"ERROR creating record: " + errors[j].getMessage());
            	   } 
   			} 
   			} 
   			} catch (Exception e) {
   				e.printStackTrace();
   				logger.info("bouncedChequeCase Exception 2 :: "+e.getMessage());
   				}  
         
         
    	return CaseId;
    }
    
    
    
    
    public static String bookingUnit(String RegId, String CaseId){
    	String res="";
    	String BookingUnitId="";
    	String SR_Booking_Unit__c="";
    	try {
    		 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection bookingUnit :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
    		System.out.println("bookingUnit RegId Response :: " + RegId);
    		logger.info("bookingUnit RegId Response :: " + RegId);
    	     QueryResult queryResults = connection.query("SELECT Id from Booking_Unit__c Where Registration_ID__c='"+RegId+"'");
    	     logger.info("bookingUnit queryResults :: " + "SELECT Id from Booking_Unit__c Where Registration_ID__c='"+RegId+"'");
            if (queryResults.getSize() > 0) {
              for (int i=0;i<queryResults.getSize();i++){
            	  Booking_Unit__c l = (Booking_Unit__c)queryResults.getRecords()[i];
            	  BookingUnitId=l.getId();
               System.out.println("BookingUnitId == "+BookingUnitId);
               SR_Booking_Unit__c[] records = new SR_Booking_Unit__c[1];
               
               for (int j=0;j<1;j++) {
             	  SR_Booking_Unit__c sr=new SR_Booking_Unit__c();
                  sr.setBooking_Unit__c(BookingUnitId);
                   sr.setCase__c(CaseId);
              
                 records[j] = sr;
               }
         
               // create the records in Salesforce.com
               SaveResult[] saveResults = connection.create(records);
         
               // check the returned results for any errors
               for (int k=0; k< saveResults.length; k++) {
                 if (saveResults[k].isSuccess()) {
                 	SR_Booking_Unit__c=saveResults[k].getId();
                   System.out.println(k+". Successfully updated record - SR_Booking_Unit__c: " + SR_Booking_Unit__c);
                   logger.info("bookingUnit saveResults :: " + k+". Successfully updated record - SR_Booking_Unit__c: " + SR_Booking_Unit__c);
                 } else {
                   Error[] errors = saveResults[k].getErrors();
                   for (int e=0; e< errors.length; e++) { 
                	   System.out.println("ERROR creating record: " + errors[e].getMessage());
                	   logger.info("bookingUnit saveResults :: " + "ERROR creating record: " + errors[e].getMessage());
                	   } 
                 }
               }
              }
            }
              
            
          } catch (Exception e) {
            e.printStackTrace();
            logger.info("bookingUnit Exception :: " + e.getMessage());
          }    
    	return SR_Booking_Unit__c;
    }
    static BouncedCheque objBouncedCheque = new BouncedCheque();
    static ActiveMQCall activemqcall = new ActiveMQCall();
    public static String getCaseForNoReason(){
    	try {
    		 //EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	     }
    	     QueryResult queryResults = connection.query("SELECT Id,Receipt_Id__c from Case Where Bounced_Reason__c=null And Receipt_Id__c != null");
            if (queryResults.getSize() > 0) {
              for (int i=0;i<queryResults.getSize();i++){
            	  Case c = (Case)queryResults.getRecords()[i];
            	  //BookingUnitId=l.getId();
               System.out.println("Case Id__c == "+c.getId());
               System.out.println("Case Receipt_Id__c == "+c.getReceipt_Id__c());
               activemqcall = new ActiveMQCall();
   		       String P_REQUEST_NUMBER = activemqcall.createRandomString();
               String reason = objBouncedCheque.BouncedChequeReason(P_REQUEST_NUMBER, "GET_BOUNCE_CHQ_REASON", "SFDC", c.getReceipt_Id__c());
              if(reason != "") {
            	  System.out.println("Case Id__c == "+c.getId() +"reason :: "+reason);
               Case[] records = new Case[1];
               for (int j=0;j<1;j++) {
            	   Case l = new Case();
            	   l.setBounced_Reason__c(reason);
            	   l.setId(c.getId());
                 records[j] = l;
               }
         
               // create the records in Salesforce.com
               SaveResult[] saveResults = connection.update(records);
         
               // check the returned results for any errors
               for (int k=0; k< saveResults.length; k++) {
                 if (saveResults[k].isSuccess()) {
                	 //CaseId=saveResults[i].getId();
                   System.out.println(k+". Successfully created record - CaseId: " + saveResults[k].getId());
                 } else {
                   Error[] errors = saveResults[k].getErrors();
                   for (int j=0; j< errors.length; j++) { 
                	   System.out.println("ERROR creating record: " + errors[j].getMessage()); 
                	   } 
       			} 
       			}
              } 
               
              }
            }
              
                  } catch (Exception e) {
            e.printStackTrace();
          }    
    	//return SR_Booking_Unit__c;
    	return null;
    }
    
    public static String getCaseNumber(String CaseId){
    	System.out.println("start");
    	String caseNumber="";
    	try {
    		// EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    		System.out.println("connection getCaseNumber :: "+connection);
    		if(connection == null) {
       		 connection = SFDCConnection.SfdcConnect();
       	 }
    	     QueryResult queryResults = connection.query("SELECT CaseNumber from Case Where Id='"+CaseId+"'");
            if (queryResults.getSize() > 0) {
              for (int i=0;i<queryResults.getSize();i++){
            	  Case c = (Case)queryResults.getRecords()[i];
            	  caseNumber=c.getCaseNumber();
               System.out.println("CaseNumber == "+caseNumber);
              }
            }
            
            
    	}catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e.getMessage());
		}
    	return caseNumber;
    }
    
    public static void closeConnection() {
    	if(connection != null) {
   		 connection = null;
   	 }
    }

}
