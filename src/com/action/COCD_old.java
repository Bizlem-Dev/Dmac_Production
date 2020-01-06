package com.action;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.ResourceBundle;

import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
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
  
public class COCD_old {
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
		final String queueName = "IPMS.COCD.GETCOCDDETAILS";
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
		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 =param.getX_RESPONSE_MESSAGE();
		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
			//objAPPSXXDC_PROCESS_SEX1794747X1X57[i].
		}
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
		final String queueName = "IPMS.COCD.GENERATECOCD";
   		//"SRNumber":""+SRNumber+"",
   		String jsonString = "{\"partyId\":\""+partyID+"\",\"SRNumber\":\""+SRNumber+"\"}";
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
   		body.setP_REQUEST_NAME("TEST1");
   		body.setP_SOURCE_SYSTEM("SFDC");
   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
   		objX41.setPARAM_ID(partyID);
   		objX41.setATTRIBUTE1(SRNumber);
   		
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
   		body.setP_REQUEST_MESSAGE(arr);
   		OutputParameters param = port.PROCESS(header, body);
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
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
	
	public String uploadCOCD(String partyID,String SRNumber, String url)
	{
		logger.info("uploadCOCD :: partyID :: "+partyID);
		logger.info("uploadCOCD :: SRNumber :: "+SRNumber);
		logger.info("uploadCOCD :: url :: "+url);
		final String queueName = "IPMS.COCD.UPLOADCOCD";
   		//"SRNumber":""+SRNumber+"",
   		String jsonString = "{\"partyId\":\""+partyID+"\",\"SRNumber\":\""+SRNumber+"\",\"url\":\""+url+"\"}";
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
   		body.setP_REQUEST_NAME("TEST1");
   		body.setP_SOURCE_SYSTEM("SFDC");
   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
   		objX41.setPARAM_ID(partyID);
   		objX41.setATTRIBUTE1(SRNumber);
   		objX41.setATTRIBUTE2(url);
   		
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
   		body.setP_REQUEST_MESSAGE(arr);
   		OutputParameters param = port.PROCESS(header, body);
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
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
	
	public String getCOCDInvoice(String partyID,String regID,String invoiceType,String amountDescription,String invoiceNumber,String receiptNumber )
	{
		logger.info("getCOCDInvoice :: partyID :: "+partyID);
		logger.info("getCOCDInvoice :: regID :: "+regID);
		logger.info("getCOCDInvoice :: invoiceType :: "+invoiceType);
		final String queueName = "IPMS.COCD.getCOCDINVOICE";
   		//"SRNumber":""+SRNumber+"",
   		String jsonString = "{\"partyId\":\""+partyID+"\",\"regID\":\""+regID+"\",\"invoiceType\":\""+invoiceType+"\"}";
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
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME("TEST1");
   		body.setP_SOURCE_SYSTEM("SFDC");
   		
   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
		objX4.setPARAM_ID(regID);
		objX4.setATTRIBUTE1(partyID);
   		objX4.setATTRIBUTE2(invoiceType);
   		
		body.setP_REQUEST_MESSAGE(objX4);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
		
		System.out.println(param.getX_RETURN_MESSAGE());
		System.out.println(param.getX_RETURN_STATUS());
		System.out.println(param.getX_RESPONSE_MESSAGE());
   		
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
	
	
	
	public String OQOODFeeDetails(String Party_ID, String RegistrationID)
	{//retrive
		logger.info("OQOODFeeDetails :: Party_ID :: "+Party_ID);
		logger.info("OQOODFeeDetails :: RegistrationID :: "+RegistrationID);
		final String queueName = "IPMS.COCD.OQOODFEEDETAILS";
   		//"SRNumber":""+SRNumber+"",
   		String jsonString = "{\"Party_ID\":\""+Party_ID+"\",\"RegistrationID\":\""+RegistrationID+"\"}";
   		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,Party_ID,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME("TEST1");
   		body.setP_SOURCE_SYSTEM("SFDC");
   		
   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
		objX4.setPARAM_ID(Party_ID);
		objX4.setATTRIBUTE1(RegistrationID);
   		
		body.setP_REQUEST_MESSAGE(objX4);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
		
		System.out.println(param.getX_RETURN_MESSAGE());
		System.out.println(param.getX_RETURN_STATUS());
		System.out.println(param.getX_RESPONSE_MESSAGE());
   		
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
	
	
	public String  IPMSNewPartyDetails(String PartyID,String Country, String CountryArabic, String AddressLine1, String AddressLine2,String AddressLine3, String AddressLine4, String AddressLine1Arabic,String AddressLine2Arabic,
			String AddressLine3Arabic,String AddressLine4Arabic,String City,String CityArabic,String State,String StateArabic,String PostalCode,String PostalCodeArabic,
			String Email,String MobileNumberCountryCode,String MobileNumber,String HomeNumberCountryCode,String HomeNumber,String WorkNumberCountryCode,String WorkNumber,
			String PassportNumber,Date PassportIssueDate,String PassportIssuePlace,String PassportIssuePlaceArabic,String Nationality,String NationalityArabic,
			String Title,String TitleArabic,String FirstName,String FirstNameArabic,String MiddleName,String MiddleNameArabic,String LastName,String LastNameArabic,
			String NameofAttorney,String PurposeofPOA,String DateofIssue, String Issuedby)
	{
	logger.info("IPMSNewPartyDetails :: PartyID :: "+PartyID);
	logger.info("IPMSNewPartyDetails :: Country :: "+Country);
	logger.info("IPMSNewPartyDetails :: CountryArabic :: "+CountryArabic);
	logger.info("IPMSNewPartyDetails :: AddressLine1 :: "+AddressLine1);
	logger.info("IPMSNewPartyDetails :: AddressLine2 :: "+AddressLine2);
	logger.info("IPMSNewPartyDetails :: AddressLine3 :: "+AddressLine3);
	logger.info("IPMSNewPartyDetails :: AddressLine4 :: "+AddressLine4);
	logger.info("IPMSNewPartyDetails :: AddressLine1Arabic :: "+AddressLine1Arabic);
	logger.info("IPMSNewPartyDetails :: AddressLine2Arabic :: "+AddressLine2Arabic);
	logger.info("IPMSNewPartyDetails :: AddressLine3Arabic :: "+AddressLine3Arabic);
	logger.info("IPMSNewPartyDetails :: AddressLine4Arabic :: "+AddressLine4Arabic);
	logger.info("IPMSNewPartyDetails :: City :: "+City);
	logger.info("IPMSNewPartyDetails :: CityArabic :: "+CityArabic);
	logger.info("IPMSNewPartyDetails :: State :: "+State);	
	logger.info("IPMSNewPartyDetails :: StateArabic :: "+StateArabic);
	logger.info("IPMSNewPartyDetails :: PostalCode :: "+PostalCode);
	
	

	final String queueName = "IPMS.COCD.GETCOCDDETAILS";
	//"SRNumber":""+SRNumber+"",
	String jsonString = "{\"partyId\":\""+PartyID+"\",\"Country\":"+Country+"\",\"CountryArabic\":\""+CountryArabic+"\",}";
	activemqcall=new ActiveMQCall();
	String correlationId = activemqcall.createRandomString();
	System.out.println("1 :: "+correlationId);	
	correlationId=activemqcall.GetProducer(queueName,PartyID,correlationId,jsonString);
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
	objX41.setPARAM_ID(PartyID);
	objX41.setATTRIBUTE1(Country);
	objX41.setATTRIBUTE2(CountryArabic);
	objX41.setATTRIBUTE3(AddressLine1);
	objX41.setATTRIBUTE4(AddressLine2);
	objX41.setATTRIBUTE5(AddressLine3);
	objX41.setATTRIBUTE6(AddressLine4);
	objX41.setATTRIBUTE7(AddressLine1Arabic);
	objX41.setATTRIBUTE8(AddressLine2Arabic);
	objX41.setATTRIBUTE9(AddressLine3Arabic);
	objX41.setATTRIBUTE10(AddressLine4Arabic);
	objX41.setATTRIBUTE11(City);
	objX41.setATTRIBUTE12(CityArabic);
	objX41.setATTRIBUTE13(State);
	objX41.setATTRIBUTE14(StateArabic);
	objX41.setATTRIBUTE15(PostalCode);
	objX41.setATTRIBUTE16(PostalCodeArabic);
	objX41.setATTRIBUTE17(Email);
	objX41.setATTRIBUTE18(MobileNumberCountryCode);
	objX41.setATTRIBUTE19(MobileNumber);
	objX41.setATTRIBUTE20(HomeNumberCountryCode);
	objX41.setATTRIBUTE21(HomeNumber);
	objX41.setATTRIBUTE22(WorkNumber);
	objX41.setATTRIBUTE23(WorkNumberCountryCode);
	objX41.setATTRIBUTE24(PassportNumber);
	objX41.setATTRIBUTE25(PassportIssueDate.toString());
	objX41.setATTRIBUTE26(PassportIssuePlace);
	objX41.setATTRIBUTE27(PassportIssuePlaceArabic);
	objX41.setATTRIBUTE28(Nationality);
	objX41.setATTRIBUTE29(Title);
	objX41.setATTRIBUTE30(TitleArabic);
	objX41.setATTRIBUTE31(FirstName);
	objX41.setATTRIBUTE32(FirstNameArabic);
	objX41.setATTRIBUTE33(MiddleName);
	objX41.setATTRIBUTE34(MiddleNameArabic);
	objX41.setATTRIBUTE35(LastName);
	objX41.setATTRIBUTE36(LastNameArabic);
	objX41.setATTRIBUTE37(NameofAttorney);
	objX41.setATTRIBUTE38(PurposeofPOA);
	objX41.setATTRIBUTE39(DateofIssue);
	//objX41.setATTRIBUTE40(Issuedby);
	objX41.setATTRIBUTE41(Issuedby);

	
	
	APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	body.setP_REQUEST_MESSAGE(arr);
	OutputParameters param = port.PROCESS(header, body);
//	body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	OutputParameters param = port.PROCESS(header, body);
//	
	System.out.println("1::"+param.getX_RETURN_MESSAGE());
	System.out.println("2::"+param.getX_RETURN_STATUS());
	System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 =param.getX_RESPONSE_MESSAGE();
	for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		//objAPPSXXDC_PROCESS_SEX1794747X1X57[i].
	}
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
	
		return "IPMSNewPartyDetails";
	}
	
	public String UnitDetails(String RegID)
	{//retrive
		logger.info("UnitDetails :: RegID :: "+RegID);
		final String queueName = "IPMS.COCD.UNITDETAILS";
   		//"SRNumber":""+SRNumber+"",
   		String jsonString = "{\"RegID\":\""+RegID+"\"}";
   		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,RegID,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME("TEST1");
   		body.setP_SOURCE_SYSTEM("SFDC");
   		
   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
		objX4.setPARAM_ID(RegID);
   		
		body.setP_REQUEST_MESSAGE(objX4);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
		
		System.out.println(param.getX_RETURN_MESSAGE());
		System.out.println(param.getX_RETURN_STATUS());
		System.out.println(param.getX_RESPONSE_MESSAGE());
   		
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
	
	public String DownloadSOA(String PartyID, String RegID)
	
	{//retrive
		logger.info("UnitDetails :: RegID :: "+RegID);
		final String queueName = "IPMS.COCD.DOWNLOADSOA";
   		//"SRNumber":""+SRNumber+"",
   		String jsonString = "{\"PartyID\":\""+PartyID+"\",\"RegID\":\""+RegID+"\"}";
   		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,PartyID,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME("TEST1");
   		body.setP_SOURCE_SYSTEM("SFDC");
   		
   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
		objX4.setPARAM_ID(PartyID);
		objX4.setATTRIBUTE1(RegID);
		body.setP_REQUEST_MESSAGE(objX4);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
		
		System.out.println(param.getX_RETURN_MESSAGE());
		System.out.println(param.getX_RETURN_STATUS());
		System.out.println(param.getX_RESPONSE_MESSAGE());
   		
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
		        	  final String queueName = "IPMS.COCD.FILEUPLOADDS";
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
				   		objX41.setATTRIBUTE2(l1.getParentId());
			   		
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
		        
		           System.out.print("**************************************");
		           final String queueName = "IPMS.COCD.IMPSTASKCREATION";
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
		   		objX41.setPARAM_ID(l1.getId());
		   		objX41.setATTRIBUTE1(l1.getActivityDate().toString());
		   		objX41.setATTRIBUTE2(l1.getSubject());
		   		
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

		       }
			 }catch(Exception e) {
				 e.printStackTrace();
				 System.out.print(e.getMessage());
				 return e.getMessage();
			 }
return res;
		 }

}


	
	

