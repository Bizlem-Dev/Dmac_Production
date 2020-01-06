package com.action;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;
//import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
//import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectorConfig;
import com.sforce.soap.enterprise.DeleteResult;
import com.sforce.soap.enterprise.Error;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Attachment;
import com.sforce.soap.enterprise.sobject.Booking_Unit__c;
import com.sforce.soap.enterprise.sobject.Case;
import com.sforce.soap.enterprise.sobject.Lead;
import com.sforce.soap.enterprise.sobject.SR_Attachments__c;
import com.sforce.soap.enterprise.sobject.Task;
import com.sforce.ws.ConnectionException;
  
public class COCD_old_old {
	final static Logger logger = Logger.getLogger(COCD_old.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		COCD_old a=new COCD_old();
     //String abc=a.FileUploadDDS("a257E000000ReInQAK");
		String abc=a.IPMSTaskCreation("00T7E000008UBbqUAG");
		System.out.print("abc"   +abc);

	}
	
	public String getCOCDDetails(String partyID,String SRNumber,String AddressLine1,String AddressLine2,String AddressLine3, String city,String state,
			String postalCode,String country,String CRNumber, String PassportIssueDate, String LandlineNo,String MoileNo,
			String Fax, String Email ) {
		logger.info("getCOCDDetails :: partyID :: "+partyID);
		logger.info("getCOCDDetails :: SRNumber :: "+SRNumber);
		logger.info("getCOCDDetails :: AddressLine1 :: "+AddressLine1);
		logger.info("getCOCDDetails :: AddressLine2 :: "+AddressLine2);
		logger.info("getCOCDDetails :: AddressLine3 :: "+AddressLine3);
		logger.info("getCOCDDetails :: city :: "+city);
		logger.info("getCOCDDetails :: state :: "+state);
		logger.info("getCOCDDetails :: postalCode :: "+postalCode);
		logger.info("getCOCDDetails :: country :: "+country);
		logger.info("getCOCDDetails :: CRNumber :: "+CRNumber);
		logger.info("getCOCDDetails :: PassportIssueDate :: "+PassportIssueDate);
		logger.info("getCOCDDetails :: LandlineNo :: "+LandlineNo);
		logger.info("getCOCDDetails :: MoileNo :: "+MoileNo);
		logger.info("getCOCDDetails :: Fax :: "+Fax);	
		logger.info("getCOCDDetails :: Email :: "+Email);
		final String queueName = "IPMS.COCD.GENERATE";
		//"SRNumber":""+SRNumber+"",
		String jsonString = "{\"partyId\":\""+partyID+"\",\"SRNumber\":"+SRNumber+"\",\"AddressLine1\":\""+AddressLine1+"\",}";
		activemqcall=new ActiveMQCall();
		String correlationId = activemqcall.createRandomString();
		System.out.println("1 :: "+correlationId);	
		correlationId=activemqcall.GetProducer(queueName,partyID,correlationId,jsonString);
		System.out.println("2 :: "+correlationId);
	//TextMessage textMessage = new 
		try {
		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
		
		SOAHeader header = new SOAHeader();
		
		InputParameters body = new InputParameters();
		body.setP_REQUEST_NUMBER(correlationId);
		body.setP_REQUEST_NAME("COCD_LETTER");
		body.setP_SOURCE_SYSTEM("SFDC");
		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
		objX41.setPARAM_ID(partyID);
		objX41.setATTRIBUTE1(AddressLine1);
		objX41.setATTRIBUTE2(AddressLine2);
		objX41.setATTRIBUTE3(AddressLine3);
		objX41.setATTRIBUTE4(city);
		objX41.setATTRIBUTE5(state);
		objX41.setATTRIBUTE6(postalCode);
		objX41.setATTRIBUTE7(country);
		objX41.setATTRIBUTE8(CRNumber);
		objX41.setATTRIBUTE9(PassportIssueDate);
		objX41.setATTRIBUTE10(LandlineNo);
		objX41.setATTRIBUTE11(MoileNo);
		objX41.setATTRIBUTE12(Fax);
		objX41.setATTRIBUTE13(Email);
		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
		body.setP_REQUEST_MESSAGE(arr);
		OutputParameters param = port.PROCESS(header, body);
//		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		OutputParameters param = port.PROCESS(header, body);
//		
		System.out.println("1::"+param.getX_RETURN_MESSAGE());
		System.out.println("2::"+param.getX_RETURN_STATUS());
		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		String response = activemqcall.GetConsumer(queueName);
		System.out.println("3 4:: "+response);
		/*Thread t1 = new Thread(new Runnable() {
			public void run() {
				String response = activemqcall.GetConsumer(queueName);
				System.out.println("3 4:: "+response);
			}
		});
		t1.start();*/
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "getCOCDDetails";
	}
	
	public String generateCOCD(String partyID,String SRNumber)
	{
		logger.info("generateCOCD :: partyID :: "+partyID);
		logger.info("generateCOCD :: SRNumber :: "+SRNumber);
		
		
		return "generateCOCD";
	}
	
	public String uploadCOCD(String partyID,String SRNumber, String url)
	{
		logger.info("uploadCOCD :: partyID :: "+partyID);
		logger.info("uploadCOCD :: SRNumber :: "+SRNumber);
		logger.info("uploadCOCD :: url :: "+url);
		
		
		return "uploadCOCD";
	}
	
	public String getCOCDInvoice(String partyID,String regID,String invoiceType,String amountDescription,String invoiceNumber,String receiptNumber )
	{
		logger.info("getCOCDInvoice :: partyID :: "+partyID);
		logger.info("getCOCDInvoice :: regID :: "+regID);
		logger.info("getCOCDInvoice :: invoiceType :: "+invoiceType);
		
		
	return "getCOCDInvoice";
	}

	
	
	public String CodIpmsCallout( ){ 
		   String res="CodIpmsCallout";
		try{
			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
	        System.out.println("print CodIpmsCallout ...");
	        //QueryResult queryResults = connection.query("SELECT Country__c, Country_Arabic__c, Address_2__c, Address_Arabic_2__c, Address_3__c, Address_Arabic_3__c, Address_4__c, Address_Arabic_4__c, City__c, City_Arabic__c, State__c, State_Arabic__c, Postal_Code__c, Postal_Code_Arabic__c, Contact_Email__c, Mobile_Country_Code__c, Contact_Mobile__c, Home_Phone__c, Home_Phone_Country_Code__c, Work_Phone__c, Work_Phone_Country_Code__c,New_CR__c, Passport_Issue_Date__c, Passport_Issue_Place__c, Passport_Issue_Place_Arabic__c, Changed_Nationality__c, Changed_Nationality_Arabic__c, Title__c, Title_Arabic__c, Customer_First_Name__c, Customer_Middle_Name__c, Customer_Last_Name__c from Case ");
	          QueryResult queryResults = connection.query("SELECT CaseNumber, Country__c, Country_Arabic__c, Address_2__c, Address_Arabic_2__c, Address_3__c, Address_Arabic_3__c, Address_4__c, Address_Arabic_4__c, City__c, City_Arabic__c, State__c, State_Arabic__c, Postal_Code__c, Postal_Code_Arabic__c, Contact_Email__c, Mobile_Country_Code__c, Contact_Mobile__c, Home_Phone__c, Home_Phone_Country_Code__c, Work_Phone__c,Work_Phone_Country_Code__c,New_CR__c,Passport_Issue_Date__c,Changed_Nationality__c from Case ");
	          if (queryResults.getSize() > 0) {
	            for (int i=0;i<queryResults.getSize();i++){
	              Case l = (Case)queryResults.getRecords()[i];
	              System.out.println(l.getCountry__c()+"  "+l.getCaseNumber());
	            }
	          }
				
			 
			}catch(Exception e){
				return e.getMessage();
			}
				return res;
			
	}
		
		 public String UnitFlexCallout( ){ 
			 String res="UnitFlexCallout";
			 try{
					EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			        System.out.println("print UnitFlexCallout ...");
			        //QueryResult queryResults = connection.query("SELECT Country__c, Country_Arabic__c, Address_2__c, Address_Arabic_2__c, Address_3__c, Address_Arabic_3__c, Address_4__c, Address_Arabic_4__c, City__c, City_Arabic__c, State__c, State_Arabic__c, Postal_Code__c, Postal_Code_Arabic__c, Contact_Email__c, Mobile_Country_Code__c, Contact_Mobile__c, Home_Phone__c, Home_Phone_Country_Code__c, Work_Phone__c, Work_Phone_Country_Code__c,New_CR__c, Passport_Issue_Date__c, Passport_Issue_Place__c, Passport_Issue_Place_Arabic__c, Changed_Nationality__c, Changed_Nationality_Arabic__c, Title__c, Title_Arabic__c, Customer_First_Name__c, Customer_Middle_Name__c, Customer_Last_Name__c from Case ");
			          QueryResult queryResults = connection.query("SELECT Registration_ID__c from Booking_Unit__c ");
			          if (queryResults.getSize() > 0) {
			            for (int i=0;i<queryResults.getSize();i++){
			            	Booking_Unit__c l = (Booking_Unit__c)queryResults.getRecords()[i];
			              System.out.println(l.getRegistration_ID__c());
			            }
			          }
			 
			 return res;
		 }catch(Exception e){
			 e.printStackTrace();
				return e.getMessage();
			}
		   
	
		 }
	
		 public String DownloadFormCallout( ){ 
String res="DownloadFormCallout";

try{
	EnterpriseConnection connection=SFDCConnection.SfdcConnect();
    System.out.println("print DocumentUploadCallout ...");
    QueryResult queryResults2 = connection.query("SELECT Party_ID__c from Account ");
    if (queryResults2.getSize() > 0) {
      for (int i=0;i<queryResults2.getSize();i++){
     	 Account l2 = (Account)queryResults2.getRecords()[i];
        System.out.println(l2.getParty_ID__c());

      }
        System.out.print("**************************************");

    }


return res;
}catch(Exception e){
	e.printStackTrace();
return e.getMessage();
}

		 }
		 
		 public String DocumentUploadCallout( ){ 
			 String res="DocumentUploadCallout";

			 try{
			 	EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			     System.out.println("print DocumentUploadCallout ...");
			     QueryResult queryResults1 = connection.query("SELECT Body from Attachment ");
			       if (queryResults1.getSize() > 0) {
			         for (int i=0;i<queryResults1.getSize();i++){
			        	// Attachment l1 = (Attachment)queryResults1.getRecords()[i];
			           //System.out.println(l1.getBody().toString());
			         }
			           System.out.print("**************************************");

			       }
			       QueryResult queryResults2 = connection.query("SELECT Party_ID__c from Account ");
			       if (queryResults2.getSize() > 0) {
			         for (int i=0;i<queryResults2.getSize();i++){
			        	 Account l2 = (Account)queryResults2.getRecords()[i];
			           System.out.println(l2.getParty_ID__c());

			         }
			           System.out.print("**************************************");

			       }
			       QueryResult queryResults3 = connection.query("SELECT CaseNumber from Case ");
			       if (queryResults3.getSize() > 0) {
			         for (int i=0;i<queryResults3.getSize();i++){
			        	 Case l3 = (Case)queryResults3.getRecords()[i];
			           System.out.println(l3.getCaseNumber());

			         }
			           System.out.print("**************************************");

			       }
			       QueryResult queryResults4 = connection.query("SELECT Id from SR_Attachments__c ");
			       if (queryResults4.getSize() > 0) {
			         for (int i=0;i<queryResults4.getSize();i++){
			        	 SR_Attachments__c l4 = (SR_Attachments__c)queryResults4.getRecords()[i];
			           System.out.println(l4.getId());
			         }
			           System.out.print("**************************************");

			       }
			       
			       
			       

			 return res;
			 }catch(Exception e){
			
			 e.printStackTrace();
			 return e.getMessage();
			 }

			  }
		 
		 public String FileUploadDDS(String CaseId_Id) {
			 String res="";
			 int count=0;
			 try {
			 EnterpriseConnection connection=SFDCConnection.SfdcConnect();
		     System.out.println("print DocumentUploadCallout ...");
		     QueryResult queryResults1 = connection.query("SELECT Body,ParentId,Id, Name from Attachment where ParentId='"+CaseId_Id+"'");
		       if (queryResults1.getSize() > 0) {
		    	   System.out.print("size  "+queryResults1.getSize()+"***");
		         for (int i=0;i<queryResults1.getSize();i++){
		        	 
		 		        
		        	Attachment l1= (Attachment)queryResults1.getRecords()[i];
		        	 System.out.println("count"+ count +"**");
		           System.out.println(l1.getBody()+" "+l1.getParentId()+" "+l1.getName()+l1.getId());
		        	 count++;
		        	  final String queueName = "IPMS.COCD.FileUploadDDS";
				   		//"SRNumber":""+SRNumber+"",
				   		String jsonString = "{\"partyId\":\""+CaseId_Id+"\"}";
				   		activemqcall=new ActiveMQCall();
				   		String correlationId = activemqcall.createRandomString();
				   		System.out.println("1 :: "+correlationId);	
				   		correlationId=activemqcall.GetProducer(queueName,CaseId_Id,correlationId,jsonString);
				   		System.out.println("2 :: "+correlationId);
				   	//TextMessage textMessage = new 
				   		try {
				   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
				   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
				   		
				   		SOAHeader header = new SOAHeader();
				   		
				   		InputParameters body = new InputParameters();
				   		body.setP_REQUEST_NUMBER(correlationId);
				   		body.setP_REQUEST_NAME("TEST1");
				   		body.setP_SOURCE_SYSTEM("SFDC");
				   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
				   		objX41.setPARAM_ID(l1.getId());
				   		byte[] encoded = Base64.encodeBase64(l1.getBody());
				   		String file = new String(encoded, "US-ASCII");
				   		objX41.setATTRIBUTE1(file);
				   		objX41.setATTRIBUTE2(l1.getName());
				   		
				   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
				   		body.setP_REQUEST_MESSAGE(arr);
				   		OutputParameters param = port.PROCESS(header, body);
//				   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//				   		OutputParameters param = port.PROCESS(header, body);
//				   		
				   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
				   		System.out.println("2::"+param.getX_RETURN_STATUS());
				   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
				   		String response = activemqcall.GetConsumer(queueName);
				   		System.out.println("3 4:: "+response);
				   		/*Thread t1 = new Thread(new Runnable() {
				   			public void run() {
				   				String response = activemqcall.GetConsumer(queueName);
				   				System.out.println("3 4:: "+response);
				   			}
				   		});
				   		t1.start();*/
				   		return param.getX_RETURN_STATUS();

				   		}catch (Exception e) {
				   			return e.getMessage();
				   			
				   		}
		         }
		           System.out.print("**************************************");
		         

		       }
			 }catch(Exception e) {
				 e.printStackTrace();
				 System.out.println(e.getMessage());
				 return e.getMessage();
			 }
return res;
		 }
		 
		 public String IPMSTaskCreation(String  SFDCTaskId_Id) {
			 String res="IPMSTaskCreation";
			 int count=0;
			 String ActivityDate="";
			 String Subject="";
			 try {
			 EnterpriseConnection connection=SFDCConnection.SfdcConnect();
		     System.out.println("print DocumentUploadCallout ...");
		     QueryResult queryResults1 = connection.query("SELECT ActivityDate, Subject, Id from Task where Id='"+SFDCTaskId_Id+"' ");
//		     where OwnerId='"+SFDCTaskId+"'
		       if (queryResults1.getSize() > 0) {
		    	   System.out.println("size "+queryResults1.getSize());
		         for (int i=0;i<queryResults1.getSize();i++){
		        	 Task l1= (Task)queryResults1.getRecords()[i];
		          System.out.println(l1.getActivityDate()+" "+l1.getSubject()+"  "+l1.getId());
		          ActivityDate=l1.getActivityDate().toString();
		          Subject=l1.getSubject();
		        	 System.out.println("count "+count);
		        	 count++;
		        	 res = l1.getSubject();
		         }
		           System.out.print("**************************************");
		           final String queueName = "IPMS.COCD.TASKCREATION";
		   		//"SRNumber":""+SRNumber+"",
		   		String jsonString = "{\"partyId\":\""+SFDCTaskId_Id+"\"}";
		   		activemqcall=new ActiveMQCall();
		   		String correlationId = activemqcall.createRandomString();
		   		System.out.println("1 :: "+correlationId);	
		   		correlationId=activemqcall.GetProducer(queueName,SFDCTaskId_Id,correlationId,jsonString);
		   		System.out.println("2 :: "+correlationId);
		   	//TextMessage textMessage = new 
		   		try {
		   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
		   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
		   		
		   		SOAHeader header = new SOAHeader();
		   		
		   		InputParameters body = new InputParameters();
		   		body.setP_REQUEST_NUMBER(correlationId);
		   		body.setP_REQUEST_NAME("TEST1");
		   		body.setP_SOURCE_SYSTEM("SFDC");
		   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
		   		objX41.setPARAM_ID(SFDCTaskId_Id);
		   		objX41.setATTRIBUTE1(ActivityDate);
		   		objX41.setATTRIBUTE2(Subject);
		   		
		   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
		   		body.setP_REQUEST_MESSAGE(arr);
		   		OutputParameters param = port.PROCESS(header, body);
//		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		   		OutputParameters param = port.PROCESS(header, body);
//		   		
		   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
		   		System.out.println("2::"+param.getX_RETURN_STATUS());
		   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		   		String response = activemqcall.GetConsumer(queueName);
		   		System.out.println("3 4:: "+response);
		   		/*Thread t1 = new Thread(new Runnable() {
		   			public void run() {
		   				String response = activemqcall.GetConsumer(queueName);
		   				System.out.println("3 4:: "+response);
		   			}
		   		});
		   		t1.start();*/
		   		return ActivityDate+"  "+Subject+" "+param.getX_RETURN_STATUS();

		   		}catch (Exception e) {
		   			return e.getMessage();
		   			
		   		}

		       }
			 }catch(Exception e) {
				 e.printStackTrace();
				 System.out.print(e.getMessage());
				 return e.getMessage();
			 }
return res;
		 }

}


	
	

