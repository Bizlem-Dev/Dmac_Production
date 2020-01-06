package com.action;

import org.apache.log4j.Logger;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.axiom.blob.Blob;
import org.apache.axis2.databinding.types.soapencoding.Base64Binary;
import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.activeMQ.ActiveMQCall;
import com.bean.COCDRequestMessage;
import com.bean.MongoDB;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;
//import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
//import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters;
import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectorConfig;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

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
  

public class COCD {

	final static Logger logger = Logger.getLogger(COCD.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	
	MongoDB objMongoDB = null;

	
	
    
    public  String generateCOCD(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,
			String IPMSPartyID,String Address1,String Address2,String Address3,String Address4, String city,
			String state,String postalCode,String country,String MobileCountryCode,String MobileAreaCode, String MobileNumber,
			String PhoneCountryCode,String PhoneAreaCode, String PhoneNumber,String FaxCountryCode, String FaxAreaCode,
			String FaxNumber, String EmailAddress, String PassportIssueDate,String PassportNumnber) 
	{//process
    	
		/*generateCOCD?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=COCD_LETTER&P_SOURCE_SYSTEM=SFDC&IPMSPartyID=p-12&Address1=&Address2=&Address3=&Address4=&city=&state=&postalCode=&country=&MobileCountryCode=&MobileAreaCode=&MobileNumber=&PhoneCountryCode=&PhoneAreaCode=&PhoneNumber=&FaxCountryCode=&FaxAreaCode
		=&FaxNumber=&EmailAddress=&PassportIssueDate=&PassportNumnber=
*/
		final String queueName = "IPMS.COCD.GENERATECOCDPRO";
		logger.info("queueName :: "+queueName);

   		//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"IPMSPartyID\":\""+IPMSPartyID+"\",\"Address1\":\""+Address1+"\",\"Address2\":\""+Address2+"\",\"\"Address3\":\""+Address3+"\",\"Address4\":\""+Address4+"\",\"city\":\""+city+"\",\"state\":\""+state+"\",\"postalCode\":\""+postalCode+"\",\"country\":\""+country+"\",\"MobileCountryCode\":\""+MobileCountryCode+"\",\"MobileAreaCode\":\""+MobileAreaCode+"\",\"MobileNumber\":\""+MobileNumber+"\",\"PhoneCountryCode\":\""+PhoneCountryCode+"\",\"PhoneAreaCode\":\""+PhoneAreaCode+"\",\"PhoneNumber\":\""+PhoneNumber+"\",\"FaxCountryCode\":\""+FaxCountryCode+"\",\"FaxAreaCode\":\""+FaxAreaCode+"\",\"FaxNumber\":\""+FaxNumber+"\",\"EmailAddress\":\""+EmailAddress+"\",\"PassportIssueDate\":\""+PassportIssueDate+"\",\"PassportNumnber\":\""+PassportNumnber+"\"}";
		logger.info("jsonString of SFDC param :: "+jsonString);

		
		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = P_REQUEST_NUMBER;
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,IPMSPartyID,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		InputParameters body = new InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
   		objX41.setPARAM_ID(IPMSPartyID);
   		objX41.setATTRIBUTE1(Address1);
   		objX41.setATTRIBUTE2(Address2);
   		objX41.setATTRIBUTE3(Address3);
   		objX41.setATTRIBUTE4(Address4);
   		objX41.setATTRIBUTE5(city);
   		objX41.setATTRIBUTE6(state);
   		objX41.setATTRIBUTE7(postalCode);
   		objX41.setATTRIBUTE8(country);
   		objX41.setATTRIBUTE9(MobileCountryCode);
   		objX41.setATTRIBUTE10(MobileAreaCode);
   		objX41.setATTRIBUTE11(MobileNumber);
   		objX41.setATTRIBUTE12(PhoneCountryCode);
   		objX41.setATTRIBUTE13(PhoneAreaCode);
   		objX41.setATTRIBUTE14(PhoneNumber);
   		objX41.setATTRIBUTE15(FaxCountryCode);
   		objX41.setATTRIBUTE16(FaxAreaCode);
   		objX41.setATTRIBUTE17(FaxNumber);
   		objX41.setATTRIBUTE18(EmailAddress);
   		objX41.setATTRIBUTE19(PassportIssueDate);
   		objX41.setATTRIBUTE20(PassportNumnber);

   		
   		
   		
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
   		body.setP_REQUEST_MESSAGE(arr);
   		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
   		OutputParameters param = port.PROCESS(header, body);
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
//   		
   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
   		System.out.println("2::"+param.getX_RETURN_STATUS());
			logger.info("Status ::"+param.getX_RETURN_STATUS() );

   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
   		String strAttr1 = "";
   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			System.out.println("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
   			System.out.println("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
   			System.out.println("attr 1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
   			System.out.println("attr 2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
   			System.out.println("attr 3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
   			System.out.println("attr 4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
   				strAttr1 = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();	
   			}else {
   				strAttr1 = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() + "~" + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
   			}
   			logger.info("generateCOCD  :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER + " Message :: " + strAttr1);
   			//status = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() + "~" + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
   			logger.info("attr 1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
   			logger.info("attr 2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
   			logger.info("attr 3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
   			logger.info("attr 4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
   			logger.info("strAttr1 ::"+strAttr1 );
	   		JSONObject subJson = null;

   			subJson = new JSONObject();
   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			subJson.put("Message_ID", P_REQUEST_NUMBER);
   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
   				subJson.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				}else {
					subJson.put("PROC_STATUS", JSONObject.NULL);	
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					subJson.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
				}else {
					subJson.put("PROC_MESSAGE", JSONObject.NULL);	
				}
				
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
					subJson.put("ATTRIBUTE1", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
				}else {
					subJson.put("ATTRIBUTE1", JSONObject.NULL);	
				}
				
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
					subJson.put("ATTRIBUTE2", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
				}else {
					subJson.put("ATTRIBUTE2", JSONObject.NULL);	
				}
				
				
				
              String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+IPMSPartyID+"\",\"ATTRIBUTE1\":\""+Address1+"\",\"ATTRIBUTE2\":\""+Address2+"\",\"\"ATTRIBUTE3\":\""+Address3+"\",\"ATTRIBUTE4\":\""+Address4+"\",\"ATTRIBUTE5\":\""+city+"\",\"ATTRIBUTE6\":\""+state+"\",\"ATTRIBUTE7\":\""+postalCode+"\",\"ATTRIBUTE8\":\""+country+"\",\"ATTRIBUTE9\":\""+MobileCountryCode+"\",\"ATTRIBUTE10\":\""+MobileAreaCode+"\",\"ATTRIBUTE11\":\""+MobileNumber+"\",\"ATTRIBUTE12\":\""+PhoneCountryCode+"\",\"ATTRIBUTE13\":\""+PhoneAreaCode+"\",\"ATTRIBUTE14\":\""+PhoneNumber+"\",\"ATTRIBUTE15\":\""+FaxCountryCode+"\",\"ATTRIBUTE16\":\""+FaxAreaCode+"\",\"ATTRIBUTE17\":\""+FaxNumber+"\",\"ATTRIBUTE18\":\""+EmailAddress+"\",\"ATTRIBUTE19\":\""+PassportIssueDate+"\",\"ATTRIBUTE20\":\""+PassportNumnber+"\"}";
   			
   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
			
   		
   		
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
   		if(!(strAttr1==null)) {
   			logger.info("strAttr1 ::"+strAttr1 );
   			return strAttr1;	
   		}else {
   			strAttr1 = "No URL found from IPMS";
   			logger.info("strAttr1 ::"+strAttr1 );
   			return strAttr1;
   		}
   		
   		}catch (Exception e) {
   			e.printStackTrace();
   			return e.getMessage();
   			
   		}

	}

	
	public  String UpdateCOCD(COCDRequestMessage objCOCDRequestMessage)
			{//process
		/*UpdateCOCD?P_REQUEST_NUMBER=r55&P_REQUEST_NAME=COCD&P_SOURCE_SYSTEM=SFDC&partyID=P-66&SRNumber=&P_ADDRESS1=&P_ADDRESS2=&P_ADDRESS3=&P_ADDRESS4=&City=&P_POSTAL_CODE=&P_STATE=&P_COUNTRY=&P_WORK_COUNTRY_CODE=&P_WORK_AREA_CODE=&P_WORK_NUMBER=&P_MOBILE_COUNTRY_CODE=&P_MOBILE_AREA_CODE=&P_MOBILE_NUMBER=&P_FAX_COUNTRY_CODE=&P_FAX_AREA_CODE=&P_FAX_NUMBER=&P_EMAIL_ADDRESS=&P_url=& P_NATIONALITY=&P_PASSPORT_NUMBER=&P_PASSPORT_ISSUE_DATE=&P_PASSPORT_ISSUE_PLACE=&P_CR_REG_PLACE=&P_CR_REG_DATE=&P_ADDRESS1_AR=&P_ADDRESS2_AR=&P_ADDRESS3_AR=&P_ADDRESS4_AR=&P_CITY_AR=&P_COUNTRY_AR=&P_POSTAL_CODE_AR=
		*/
		final String queueName = "IPMS.COCD.UPDATECOCDUAT";
		String jsonString =	"{\"P_REQUEST_NUMBER\":\""+objCOCDRequestMessage.getP_REQUEST_NUMBER()+"\",\"P_REQUEST_NAME\":\""+objCOCDRequestMessage.getP_REQUEST_NAME()+"\",\"P_SOURCE_SYSTEM\":\""+objCOCDRequestMessage.getP_SOURCE_SYSTEM()+"\",\"IPMSPartyID\":\""+objCOCDRequestMessage.getIPMSPartyID()+"\",\"SRNumber\":\""+objCOCDRequestMessage.getSRNumber()+"\",\"P_ADDRESS1\":\""+objCOCDRequestMessage.getP_ADDRESS1()+"\",\"P_ADDRESS2\":\""+objCOCDRequestMessage.getP_ADDRESS2()+"\",\"P_ADDRESS3\":\""+objCOCDRequestMessage.getP_ADDRESS3()+"\",\"P_ADDRESS4\":\""+objCOCDRequestMessage.getP_ADDRESS4()+"\",\"City\":\""+objCOCDRequestMessage.getCity()+"\",\"P_POSTAL_CODE\":\""+objCOCDRequestMessage.getP_POSTAL_CODE()+"\",\"P_STATE\":\""+objCOCDRequestMessage.getP_STATE()+"\",\"P_COUNTRY\":\""+objCOCDRequestMessage.getP_COUNTRY()+"\",\"MobileCountryCode\":\""+objCOCDRequestMessage.getP_MOBILE_COUNTRY_CODE()+"\",\"MobileAreaCode\":\""+objCOCDRequestMessage.getP_MOBILE_AREA_CODE()+"\",\"MobileNumber\":\""+objCOCDRequestMessage.getP_MOBILE_NUMBER()+"\",\"P_WORK_COUNTRY_CODE\":\""+objCOCDRequestMessage.getP_WORK_COUNTRY_CODE()+"\",\"P_WORK_AREA_CODE\":\""+objCOCDRequestMessage.getP_WORK_AREA_CODE()+"\",\"P_WORK_NUMBER\":\""+objCOCDRequestMessage.getP_WORK_NUMBER()+"\",\"P_FAX_COUNTRY_CODE\":\""+objCOCDRequestMessage.getP_FAX_COUNTRY_CODE()+"\",\"P_FAX_AREA_CODE\":\""+objCOCDRequestMessage.getP_FAX_AREA_CODE()+"\",\"P_FAX_NUMBER\":\""+objCOCDRequestMessage.getP_FAX_NUMBER()+"\",\"P_EMAIL_ADDRESS\":\""+objCOCDRequestMessage.getP_EMAIL_ADDRESS()+"\",\"P_url\":\""+objCOCDRequestMessage.getP_url()+"\",\"P_NATIONALITY\":\""+objCOCDRequestMessage.getP_NATIONALITY()+"\",\"P_PASSPORT_NUMBER\":\""+objCOCDRequestMessage.getP_PASSPORT_NUMBER()+"\",\"P_PASSPORT_ISSUE_DATE\":\""+objCOCDRequestMessage.getP_PASSPORT_ISSUE_DATE()+"\",\"P_PASSPORT_ISSUE_PLACE\":\""+objCOCDRequestMessage.getP_PASSPORT_ISSUE_PLACE()+"\",\"P_CR_REG_PLACE\":\""+objCOCDRequestMessage.getP_CR_REG_PLACE()+"\",\"P_CR_REG_DATE\":\""+objCOCDRequestMessage.getP_CR_REG_DATE()+"\",\"P_ADDRESS1_AR\":\""+objCOCDRequestMessage.getP_ADDRESS1_AR()+"\",\"P_ADDRESS2_AR\":\""+objCOCDRequestMessage.getP_ADDRESS2_AR()+"\",\"P_ADDRESS3_AR\":\""+objCOCDRequestMessage.getP_ADDRESS3_AR()+"\",\"P_ADDRESS4_AR\":\""+objCOCDRequestMessage.getP_ADDRESS4_AR()+"\",\"P_CITY_AR\":\""+objCOCDRequestMessage.getP_CITY_AR()+"\",\"P_COUNTRY_AR\":\""+objCOCDRequestMessage.getP_COUNTRY_AR()+"\",\"P_POSTAL_CODE_AR\":\""+objCOCDRequestMessage.getP_POSTAL_CODE_AR()+"\"}";
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = objCOCDRequestMessage.getP_REQUEST_NUMBER();
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,objCOCDRequestMessage.getIPMSPartyID(),correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		InputParameters body = new InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME(objCOCDRequestMessage.getP_REQUEST_NAME());
   		body.setP_SOURCE_SYSTEM(objCOCDRequestMessage.getP_SOURCE_SYSTEM());
   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
   		objX41.setPARAM_ID(objCOCDRequestMessage.getIPMSPartyID());
   		objX41.setATTRIBUTE1(objCOCDRequestMessage.getSRNumber());
   		objX41.setATTRIBUTE2(objCOCDRequestMessage.getP_ADDRESS1());
   		objX41.setATTRIBUTE3(objCOCDRequestMessage.getP_ADDRESS2());
   		objX41.setATTRIBUTE4(objCOCDRequestMessage.getP_ADDRESS3());
   		objX41.setATTRIBUTE5(objCOCDRequestMessage.getP_ADDRESS4());
   		objX41.setATTRIBUTE6(objCOCDRequestMessage.getCity());
   		objX41.setATTRIBUTE7(objCOCDRequestMessage.getP_POSTAL_CODE());
   		objX41.setATTRIBUTE8(objCOCDRequestMessage.getP_STATE());
   		objX41.setATTRIBUTE9(objCOCDRequestMessage.getP_COUNTRY());
   		objX41.setATTRIBUTE10(objCOCDRequestMessage.getP_WORK_COUNTRY_CODE());
   		objX41.setATTRIBUTE11(objCOCDRequestMessage.getP_WORK_AREA_CODE());
   		objX41.setATTRIBUTE12(objCOCDRequestMessage.getP_WORK_NUMBER());
   		objX41.setATTRIBUTE13(objCOCDRequestMessage.getP_MOBILE_COUNTRY_CODE());
   		objX41.setATTRIBUTE14(objCOCDRequestMessage.getP_MOBILE_AREA_CODE());
   		objX41.setATTRIBUTE15(objCOCDRequestMessage.getP_MOBILE_NUMBER());
   		objX41.setATTRIBUTE16(objCOCDRequestMessage.getP_FAX_COUNTRY_CODE());
   		objX41.setATTRIBUTE17(objCOCDRequestMessage.getP_FAX_AREA_CODE());
   		objX41.setATTRIBUTE18(objCOCDRequestMessage.getP_FAX_NUMBER());
   		objX41.setATTRIBUTE19(objCOCDRequestMessage.getP_EMAIL_ADDRESS());
   		objX41.setATTRIBUTE20(objCOCDRequestMessage.getP_url());
   		objX41.setATTRIBUTE21(objCOCDRequestMessage.getP_NATIONALITY());
   		objX41.setATTRIBUTE22(objCOCDRequestMessage.getP_PASSPORT_NUMBER());
   		objX41.setATTRIBUTE23(objCOCDRequestMessage.getP_PASSPORT_ISSUE_DATE());
   		objX41.setATTRIBUTE24(objCOCDRequestMessage.getP_PASSPORT_ISSUE_PLACE());
   		objX41.setATTRIBUTE25(objCOCDRequestMessage.getP_CR_REG_PLACE());
   		objX41.setATTRIBUTE26(objCOCDRequestMessage.getP_CR_REG_DATE());
   		objX41.setATTRIBUTE27(objCOCDRequestMessage.getP_ADDRESS1_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_ADDRESS1_AR :: " + objCOCDRequestMessage.getP_ADDRESS1_AR());
   		objX41.setATTRIBUTE28(objCOCDRequestMessage.getP_ADDRESS2_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_ADDRESS2_AR :: " + objCOCDRequestMessage.getP_ADDRESS2_AR());
   		objX41.setATTRIBUTE29(objCOCDRequestMessage.getP_ADDRESS3_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_ADDRESS3_AR :: " + objCOCDRequestMessage.getP_ADDRESS3_AR());   	
   		objX41.setATTRIBUTE30(objCOCDRequestMessage.getP_ADDRESS4_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_ADDRESS4_AR :: " + objCOCDRequestMessage.getP_ADDRESS4_AR());
   		objX41.setATTRIBUTE31(objCOCDRequestMessage.getP_CITY_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_CITY_AR :: " + objCOCDRequestMessage.getP_CITY_AR());
   		objX41.setATTRIBUTE32(objCOCDRequestMessage.getP_COUNTRY_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_CITY_AR :: " + objCOCDRequestMessage.getP_COUNTRY_AR());
   		objX41.setATTRIBUTE33(objCOCDRequestMessage.getP_POSTAL_CODE_AR());
   		logger.info("Update COCD :: URN :: "+objCOCDRequestMessage.getP_REQUEST_NUMBER() + " Party Id :: " +objCOCDRequestMessage.getIPMSPartyID()+ " P_CITY_AR :: " + objCOCDRequestMessage.getP_POSTAL_CODE_AR());
   	
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
   		body.setP_REQUEST_MESSAGE(arr);
   		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
   		OutputParameters param = port.PROCESS(header, body);
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
//   		
   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
   		System.out.println("2::"+param.getX_RETURN_STATUS());
   		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
   		String status = "";
   		JSONObject subJson = null;
   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			System.out.println("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
   			System.out.println("PROC_MESSAGE response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
//   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS().equals("S")) {
//   				status = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS();
//   			}else {
//   				status = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
//   			}
   			
   			subJson = new JSONObject();
   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			subJson.put("Message_ID", objCOCDRequestMessage.getP_REQUEST_NUMBER());
   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
   				subJson.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				}else {
					subJson.put("PROC_STATUS", JSONObject.NULL);	
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					subJson.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
				}else {
					subJson.put("PROC_MESSAGE", JSONObject.NULL);	
				}
   			
   			
   			status = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() + "~" + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
   			logger.info("updateCOCD  :: P_REQUEST_NUMBER  :: "+correlationId + " Message :: " + status);
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
   		return status;

   		}catch (Exception e) {
   			return e.getMessage();
   			
   		}
		
		
	}
	
		
	public String CreateDebitCreditMemo(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, 
			String RegistrationID, String Amount, String TRANS_TYPEClass, String CALL_TYPE, String UniqueTransactionNumber, String DESCRIPTION)
	{//retrive
		/*CreateDebitCreditMemo?P_REQUEST_NUMBER=r12&P_REQUEST_NAME=CREATE_DM_CM&P_SOURCE_SYSTEM=SFDC&RegistrationID=45&Amount=&TRANS_TYPEClass=&CALL_TYPE=&UniqueTransactionNumber=&DESCRIPTION=
		 
		 */
		
		final String queueName = "IPMS.COCD.CREATEDEBITCREDITMENOUAT";
		String jsonString = "{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationID\":\""+RegistrationID+"\",\"Amount\":\""+Amount+"\",\"TRANS_TYPEClass\":\""+TRANS_TYPEClass+"\",\"CALL_TYPE\":\""+CALL_TYPE+"\",\"UniqueTransactionNumber\":\""+UniqueTransactionNumber+"\",\"DESCRIPTION\":\""+DESCRIPTION+"\"}";
   		
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = P_REQUEST_NUMBER;

   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,RegistrationID,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		//com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
   		
   		//APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
   		APPSXXDC_PROCESS_SERX1794747X1X5 objX4 = new APPSXXDC_PROCESS_SERX1794747X1X5();
   		objX4.setPARAM_ID(RegistrationID);
   		objX4.setATTRIBUTE1(Amount);
   		objX4.setATTRIBUTE2(TRANS_TYPEClass);
   		objX4.setATTRIBUTE3(CALL_TYPE);
   		objX4.setATTRIBUTE4(UniqueTransactionNumber);
   		objX4.setATTRIBUTE5(DESCRIPTION);
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX4};
   		body.setP_REQUEST_MESSAGE(arr);
   		
   		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
		//body.setP_REQUEST_MESSAGE(objX4);
		//com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
		
		System.out.println(param.getX_RETURN_MESSAGE());
		System.out.println(param.getX_RETURN_STATUS());
		System.out.println(param.getX_RESPONSE_MESSAGE());
	String status = "";
	JSONObject subJson = null;
		//APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
			System.out.println("ATTRIBUTE1 Response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
			status = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() + "~" + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
   			logger.info("CreateDebitCreditMemo  :: P_REQUEST_NUMBER  :: "+correlationId + " Message :: " + status);
   			logger.info("CreateDebitCreditMemo  :: P_REQUEST_NUMBER  :: "+correlationId + "ATTRIBUTE1 Response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		
   			subJson = new JSONObject();
   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			subJson.put("Message_ID",P_REQUEST_NUMBER);
   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
   				subJson.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				}else {
					subJson.put("PROC_STATUS", JSONObject.NULL);	
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					subJson.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
				}else {
					subJson.put("PROC_MESSAGE", JSONObject.NULL);	
				}
				
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
					subJson.put("ATTRIBUTE1", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
				}else {
					subJson.put("ATTRIBUTE1", JSONObject.NULL);	
				}
				
		

		 		String requestString = "{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+RegistrationID+"\",\"ATTRIBUTE1\":\""+Amount+"\",\"ATTRIBUTE2\":\""+TRANS_TYPEClass+"\",\"ATTRIBUTE3\":\""+CALL_TYPE+"\",\"ATTRIBUTE4\":\""+UniqueTransactionNumber+"\",\"ATTRIBUTE5\":\""+DESCRIPTION+"\"}";
			
					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					
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
   		return status;

   		}catch (Exception e) {
   			return e.getMessage();
   			
   		}
		

				
	}
	
	
	public String COCDFinancials(String PartyId, String SourceofRequest, String ProcessName,
			String SubProcesName, String ProjectCity, String Project, String BuildingCode, String PermittedUse,
			String BedroomType, String ReadyOffPlan, String CustomerType, String ApplicableNationality, String POA)
			{
		String res = "COCDFinancials";
		JSONArray arr = null;
		ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
		try {
		arr = new JSONArray();
		// PROCESS
		// url
		//  http://localhost:8080/CRM_SR_NEW/services/COCD/COCDFinancials?RegistrationId=33&SourceofRequest=&ProcessName=&SubProcesName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ReadyOffPlan=&CustomerType=&ApplicableNationality=&POA=

//		final String queueName = "COCD.Rules.COCDFinancials";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"RegistrationId\":\"" + PartyId + "\",\"SourceofRequest\":\"" + SourceofRequest
				+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
				+ "\",\"ReadyOffPlan\":\"" + ReadyOffPlan + "\",\"CustomerType\":\"" + CustomerType
				+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POA\":\"" + POA + "\"}";
		 activemqcall = new ActiveMQCall();
System.out.println(jsonString);
		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("COCD.Rules.COCDFinancialsUAT");
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		//System.out.println("msg");
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		//System.out.println("msg1");
		
		
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

		/*MessageListener listener = new MessageListener() {

			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				String messageText = null;
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						messageText = textMessage.getText();
						System.out.println("messageText = " + messageText);
						System.out.println("listener");

					}
				} catch (JMSException e) {
					// Handle the exception appropriately
				}
			}

		};

		responseConsumer.setMessageListener(listener);
*/
		//System.out.println("msg2");
		
		TextMessage message = session.createTextMessage();
		//System.out.println("msg3");
		message.setText(jsonString);
		// Set the reply to field to the temp queue you created above, this is the queue
		// the server
		// will respond to
		//System.out.println("msg4");
		message.setJMSReplyTo(tempDest);
		//System.out.println("msg5");
		String correlationId = activemqcall.createRandomString();
		// String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: " + correlationId);
		message.setJMSCorrelationID(correlationId);
		System.out.println("success");

		// Tell the producer to send the message
		System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);

		// ((Object) producer).send(message);
		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
		producer.send(message);
		TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
		System.out.println("message :: "+objTextMsg.getText());
		//System.out.println("success");
		while(true) {
			if(objTextMsg.getText() != null) {
				System.out.println("message if :: "+objTextMsg);
				res = objTextMsg.getText();
				
				String requestString = "{\"P_REQUEST_NUMBER\":\""+correlationId+"\","
						+ "\"PARAM_ID\":\"" + PartyId + "\",\"ATTRIBUTE1\":\"" + SourceofRequest
						+ "\",\"ATTRIBUTE2\":\"" + ProcessName + "\",\"ATTRIBUTE3\":\"" + SubProcesName
						+ "\",\"ATTRIBUTE4\":\"" + ProjectCity + "\",\"ATTRIBUTE5\":\"" + Project + "\",\"ATTRIBUTE6\":\""
						+ BuildingCode + "\",\"ATTRIBUTE7\":\"" + PermittedUse + "\",\"ATTRIBUTE8\":\"" + BedroomType
						+ "\",\"ATTRIBUTE9\":\"" + ReadyOffPlan + "\",\"ATTRIBUTE10\":\"" + CustomerType
						+ "\",\"ATTRIBUTE11\":\"" + ApplicableNationality + "\",\"ATTRIBUTE12\":\"" + POA + "\"}";
			
				
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");
					
				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		

		// \"\":\"\"++\"\"
		// String correlationId = activemqcall.createRandomString();
		//// String correlationId = P_REQUEST_NUMBER;
		// System.out.println("1 :: " + correlationId);
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);
		// System.out.println("2 :: " + correlationId);
		// System.out.println(jsonString);
		// TextMessage textMessage = new
}catch (Exception e) {
	System.out.println("error ::"+e.getMessage());
	// TODO: handle exception
	return e.getMessage();
}finally {try {
	connection.close();
} catch (JMSException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
		return res;

	}

  public String COCDApprovalsRequired(String RegistrationId, String SourceofRequest, String ProcessName,
			String SubProcesName, String ProjectCity, String Project, String BuildingCode, String PermittedUse,
			String BedroomType, String ReadyOffPlan, String CustomerType, String ApplicableNationality,
			String UnderAssignment, String POA) {
	  String res = "COCDApprovalsRequired";
	  ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
	  try {

		// PROCESS
		// url
		//  http://localhost:8080/CRM_SR_NEW/services/COCD/COCDApprovalsRequired?RegistrationId=&SourceofRequest=&ProcessName=&SubProcesName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ReadyOffPlan=&CustomerType=&ApplicableNationality=&UnderAssignment=&POA=

		
//		final String queueName = "COCD.Rules.COCDApprovalsRequired";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
				+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
				+ "\",\"ReadyOffPlan\":\"" + ReadyOffPlan + "\",\"CustomerType\":\"" + CustomerType
				+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"UnderAssignment\":\""
				+ UnderAssignment + "\",\"POA\":\"" + POA + "\"}";
activemqcall = new ActiveMQCall();
		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("COCD.Rules.COCDApprovalsRequiredUAT");
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		System.out.println("msg");
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);
System.out.println("msg1");
	/*	MessageListener listener = new MessageListener() {

			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				String messageText = null;
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						messageText = textMessage.getText();
						System.out.println("messageText = " + messageText);
						System.out.println("listener");

					}
				} catch (JMSException e) {
					// Handle the exception appropriately
					//return "jms "+e.getMessage();
				}
			}

		};

		responseConsumer.setMessageListener(listener);*/

		TextMessage message = session.createTextMessage();
		message.setText(jsonString);
		// Set the reply to field to the temp queue you created above, this is the queue
		// the server
		// will respond to
		message.setJMSReplyTo(tempDest);

		String correlationId = activemqcall.createRandomString();
		// String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: " + correlationId);
		message.setJMSCorrelationID(correlationId);
		System.out.println("success");

		// Tell the producer to send the message
		System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);

		// ((Object) producer).send(message);
		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
		producer.send(message);
		TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
		System.out.println("message :: "+objTextMsg.getText());
		//System.out.println("success");
		while(true) {
			if(objTextMsg.getText() != null) {
				System.out.println("message if :: "+objTextMsg);
				res = objTextMsg.getText();
				
				String requestString = "{\"P_REQUEST_NUMBER\":\""+correlationId+"\","
						+ "\"PARAM_ID\":\"" + RegistrationId + "\",\"ATTRIBUTE1\":\"" + SourceofRequest
						+ "\",\"ATTRIBUTE2\":\"" + ProcessName + "\",\"ATTRIBUTE3\":\"" + SubProcesName
						+ "\",\"ATTRIBUTE4\":\"" + ProjectCity + "\",\"ATTRIBUTE5\":\"" + Project + "\",\"ATTRIBUTE6\":\""
						+ BuildingCode + "\",\"ATTRIBUTE7\":\"" + PermittedUse + "\",\"ATTRIBUTE8\":\"" + BedroomType
						+ "\",\"ATTRIBUTE9\":\"" + ReadyOffPlan + "\",\"ATTRIBUTE10\":\"" + CustomerType
						+ "\",\"ATTRIBUTE11\":\"" + ApplicableNationality + "\",\"ATTRIBUTE12\":\""
						+ UnderAssignment + "\",\"ATTRIBUTE13\":\"" + POA + "\"}";
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");

				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		System.out.println("success");

		// activemqcall = new ActiveMQCall();
		// \"\":\"\"++\"\"
		// String correlationId = activemqcall.createRandomString();
		//// String correlationId = P_REQUEST_NUMBER;
		// System.out.println("1 :: " + correlationId);
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);
		// System.out.println("2 :: " + correlationId);
		// System.out.println(jsonString);
		//
	  }catch (Exception e) {
		// TODO: handle exception
		  return e.getMessage();
	}finally {try {
		connection.close();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
		return res;
	}

  public String COCDDocumentation(String RegistrationId, String SourceofRequest, String ProcessName,
			String SubProcesName, String ProjectCity, String Project, String BuildingCode, String PermittedUse,
			String BedroomType, String ReadyOffPlan, String CustomerType, String ApplicableNationalityNew,
			String UnderAssignment, String POA)  {
	  String res = "COCDDocumentation";
	  ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
	  try {

		// PROCESS
		// http://localhost:8080/CRM_SR_NEW/services/COCD/COCDDocumentation?RegistrationId=33&SourceofRequest=&ProcessName=&SubProcesName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ReadyOffPlan=&CustomerType=&ApplicableNationalityNew=&UnderAssignment=&POA=
		
//		final String queueName = "COCD.Rule.COCDDocumentation";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
				+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
				+ "\",\"ReadyOffPlan\":\"" + ReadyOffPlan + "\",\"CustomerType\":\"" + CustomerType
				+ "\",\"ApplicableNationalityNew\":\"" + ApplicableNationalityNew + "\",\"UnderAssignment\":\""
				+ UnderAssignment + "\",\"POA\":\"" + POA + "\"}";
activemqcall = new ActiveMQCall();
		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("COCD.Rule.COCDDocumentationUAT");
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

	/*	MessageListener listener = new MessageListener() {

			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				String messageText = null;
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						messageText = textMessage.getText();
						System.out.println("messageText = " + messageText);
						System.out.println("listener");

					}
				} catch (JMSException e) {
					// Handle the exception appropriately
				}
			}

		};

		responseConsumer.setMessageListener(listener);*/

		TextMessage message = session.createTextMessage();
		message.setText(jsonString);
		// Set the reply to field to the temp queue you created above, this is the queue
		// the server
		// will respond to
		message.setJMSReplyTo(tempDest);

		String correlationId = activemqcall.createRandomString();
		// String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: " + correlationId);
		message.setJMSCorrelationID(correlationId);
		System.out.println("success");

		// Tell the producer to send the message
		System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);

		// ((Object) producer).send(message);
		objMongoDB = new MongoDB();
		Date reqDate = new Date();
		producer.send(message);
		TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
		System.out.println("message :: "+objTextMsg.getText());
		//System.out.println("success");
		while(true) {
			if(objTextMsg.getText() != null) {
				System.out.println("message if :: "+objTextMsg);
				res = objTextMsg.getText();
				String requestString = "{\"P_REQUEST_NUMBER\":\""+correlationId+"\","
						+ "\"PARAM_ID\":\"" + RegistrationId + "\",\"ATTRIBUTE1\":\"" + SourceofRequest
						+ "\",\"ATTRIBUTE2\":\"" + ProcessName + "\",\"ATTRIBUTE3\":\"" + SubProcesName
						+ "\",\"ATTRIBUTE4\":\"" + ProjectCity + "\",\"ATTRIBUTE5\":\"" + Project + "\",\"ATTRIBUTE6\":\""
						+ BuildingCode + "\",\"ATTRIBUTE7\":\"" + PermittedUse + "\",\"ATTRIBUTE8\":\"" + BedroomType
						+ "\",\"ATTRIBUTE9\":\"" + ReadyOffPlan + "\",\"ATTRIBUTE10\":\"" + CustomerType
						+ "\",\"ATTRIBUTE11\":\"" + ApplicableNationalityNew + "\",\"ATTRIBUTE12\":\""
						+ UnderAssignment + "\",\"ATTRIBUTE13\":\"" + POA + "\"}";
				
				
				
				
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");

				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}

		System.out.println("success");

		// activemqcall = new ActiveMQCall();
		// // \"\":\"\"++\"\"
		// String correlationId = activemqcall.createRandomString();
		//// String correlationId = P_REQUEST_NUMBER;
		// System.out.println("1 :: " + correlationId);
		// correlationId = activemqcall.GetProducer(queueName,"RegistrationId",
		// correlationId, jsonString);
		// System.out.println("2 :: " + correlationId);
		// System.out.println(jsonString);
		// TextMessage textMessage = new
	  }catch (Exception e) {
		// TODO: handle exception
		  return e.getMessage();
	}finally {try {
		connection.close();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
		return res;

	}

  public  String GenCustomerStatement(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String ParamId, String stageID, String batchname, String RegistrationId,
		  Base64Binary b) {
		//process
		/*GenCustomerStatment?P_REQUEST_NUMBER=r33&P_REQUEST_NAME=DP_SOA&P_SOURCE_SYSTEM=SFDC&SourceSystenId=&stageID=&batchname=&registerationid=42
		 */
	
		final String queueName = "IPMS.COCD.GENERATECUSTOMERSTATEMENTUAT";
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"SourceSystemId\":\""+ParamId+"\",\"stageID\":\""+stageID+"\",\"batchname\":\""+batchname+"\",\"registerationid\":\""+RegistrationId+"\"}";
		//activemqcall=new ActiveMQCall();
		logger.info("GenCustomerStatement full request :: "+jsonString);
 		//String correlationId = activemqcall.createRandomString();
 		String correlationId = P_REQUEST_NUMBER;
 		//System.out.println("1 :: "+correlationId);	
 		//correlationId=activemqcall.GetProducer(queueName,ParamId,correlationId,jsonString);
 		//System.out.println("2 :: "+correlationId);
 	//TextMessage textMessage = new
 		String strAttr1="";
 		JSONObject objJSONObject = new JSONObject();
 		try {
 		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
 		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
 		
 		SOAHeader header = new SOAHeader();
 		
 		InputParameters body = new InputParameters();
 		body.setP_REQUEST_NUMBER(correlationId);
 		body.setP_REQUEST_NAME(P_REQUEST_NAME);
 		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
 		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
 		objX41.setPARAM_ID(ParamId);
 		objX41.setATTRIBUTE1(stageID);
 		objX41.setATTRIBUTE2(batchname);
 		objX41.setATTRIBUTE3(RegistrationId);
 		
 		
 		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
 		body.setP_REQUEST_MESSAGE(arr);
 		objMongoDB = new MongoDB();
		Date reqDate = new Date();
 		OutputParameters param = port.PROCESS(header, body);
// 		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
// 		OutputParameters param = port.PROCESS(header, body);
// 		
 		System.out.println("1::"+param.getX_RETURN_MESSAGE());
 		//System.out.println("2::"+param.getX_RETURN_STATUS());
 		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
 		objJSONObject.put("Status", param.getX_RETURN_STATUS());
		objJSONObject.put("Message", param.getX_RETURN_MESSAGE());
 		logger.info("GenCustomerStatement status response :: "+param.getX_RETURN_STATUS());
 		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
 		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
 			logger.info("GenCustomerStatement param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
 			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
 			strAttr1 = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();
 			objJSONObject.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
 			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
				objJSONObject.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				}else {
					objJSONObject.put("PROC_STATUS", JSONObject.NULL);	
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
				objJSONObject.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
				}else {
					objJSONObject.put("PROC_MESSAGE", JSONObject.NULL);	
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() !=null) {
				objJSONObject.put("URL", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
				}else {
					objJSONObject.put("URL", JSONObject.NULL);	
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() !=null) {
					objJSONObject.put("REQUEST_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
					}else {
						objJSONObject.put("REQUEST_ID", JSONObject.NULL);	
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() !=null) {
					objJSONObject.put("STAGE_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
					}else {
						objJSONObject.put("STAGE_ID", JSONObject.NULL);	
					}
				
	String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+ParamId+"\",\"ATTRIBUTE1\":\""+stageID+"\",\"ATTRIBUTE2\":\""+batchname+"\",\"ATTRIBUTE3\":\""+RegistrationId+"\"}";

	   			
	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				
 		}
 		logger.info("GenCustomerStatement full response :: "+objJSONObject);
 		//String response = activemqcall.GetConsumer(queueName);
 	//	System.out.println("3 4:: "+response);
 		/*Thread t1 = new Thread(new Runnable() {
 			public void run() {
 				String response = activemqcall.GetConsumer(queueName);
 				System.out.println("3 4:: "+response);
 			}
 		});
 		t1.start();*/
// 		if(!(strAttr1==null)) {
//   			logger.info("strAttr1 ::"+strAttr1 );
//   			return strAttr1;	
//   		}else {
//   			strAttr1 = "No URL found from IPMS";
//   			logger.info("strAttr1 ::"+strAttr1 );
//   			return strAttr1;
//   		}
 		
 		//return strAttr1;
 		}catch (Exception e) {
 			//return e.getMessage();
 			try {
				objJSONObject.put("Status", "E");
				objJSONObject.put("Message", e.getMessage());
				}catch (Exception ex) {
					// TODO: handle exception
				}
 			
 		}
 		return objJSONObject.toString();
 		
 	
	}



}
