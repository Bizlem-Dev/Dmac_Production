package com.action;

import java.util.Date;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;

import gvjava.org.json.JSONObject;

public class NameAndNationality {
	final static Logger logger = Logger.getLogger(NameAndNationality.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	public  String NameAndNationalityProcess(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String RegistrationId, String Title,String FirstName,
			String MiddleName,String LastName ,String Nationality,String PassportNumber,String PassportIssuePlace,String PassportIssueDate
			,String TitleAR,String FirstNameAR,
			String MiddleNameAR,String LastNameAR ,String NationalityAR) {
	//process
		/*http://localhost:8080/CRM_SR_NEW/services/NameAndNationality/NameAndNationalityProcess?P_REQUEST_NUMBER=8665&P_REQUEST_NAME=NAME_NATIONALITY_CHANGE&P_SOURCE_SYSTEM=&RegistrationId=12345&Title=&FirstName=&MiddleName=&LastName=&Nationality=&PassportNumber=&PassportIssuePlace=&PassportIssueDate=
		 */
		final String queueName = "IPMS.NAMEANDNATIONALITY.NAMEANDNATIONALITYUAT";
   		//"SRNumber":""+SRNumber+"",
		String jsonString =	"{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationId\":\""+RegistrationId+"\",\"Title\":\""+Title+"\",\"FirstName\":\""+FirstName+"\",\"MiddleName\":\""+MiddleName+"\","
				+ "\"LastName \":\""+LastName +"\", \"Nationality\":\""+Nationality+"\",\"PassportNumber\":\""+PassportNumber+"\",\"PassportIssuePlace\":\""+PassportIssuePlace+"\",\"PassportIssueDate\":\""+PassportIssueDate+"\",\"TitleAR\":\""+TitleAR+"\",\"FirstNameAR\":\""+FirstNameAR+"\",\"MiddleNameAR\":\""+MiddleNameAR+"\",\"LastNameAR\":\""+LastNameAR+"\",\"NationalityAR\":\""+NationalityAR+"\"}";
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = P_REQUEST_NUMBER;
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,RegistrationId,correlationId,jsonString);
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
   		objX41.setPARAM_ID(RegistrationId);
   		objX41.setATTRIBUTE1(Title);
   		objX41.setATTRIBUTE2(FirstName);
   		objX41.setATTRIBUTE3(MiddleName);
   		objX41.setATTRIBUTE4(LastName);
   		objX41.setATTRIBUTE5(Nationality);
   		objX41.setATTRIBUTE6(PassportNumber);
   		objX41.setATTRIBUTE7(PassportIssuePlace);
   		objX41.setATTRIBUTE8(PassportIssueDate);
   		objX41.setATTRIBUTE9(TitleAR);
   		objX41.setATTRIBUTE10(FirstNameAR);
   		objX41.setATTRIBUTE11(MiddleNameAR);
   		objX41.setATTRIBUTE12(LastNameAR);
   		objX41.setATTRIBUTE13(NationalityAR);
   		logger.info("Update COCD :: URN :: "+P_REQUEST_NUMBER + " Party Id :: " +RegistrationId+ " TitleAR :: " + TitleAR);
   		logger.info("Update COCD :: URN :: "+P_REQUEST_NUMBER + " Party Id :: " +RegistrationId+ " FirstNameAR :: " + FirstNameAR);
   		logger.info("Update COCD :: URN :: "+P_REQUEST_NUMBER + " Party Id :: " +RegistrationId+ " MiddleNameAR :: " + MiddleNameAR);
   		logger.info("Update COCD :: URN :: "+P_REQUEST_NUMBER + " Party Id :: " +RegistrationId+ " LastNameAR :: " + LastNameAR);
   		logger.info("Update COCD :: URN :: "+P_REQUEST_NUMBER + " Party Id :: " +RegistrationId+ " NationalityAR :: " + NationalityAR);
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
   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
   		String status = "";
   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
   		JSONObject subJson = null;
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
   			status = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() + "~" + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
   			logger.info("NameAndNationalityProcess  :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER + " Message :: " + status);
   		
   			String requestString =	"{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationId\":\""+RegistrationId+"\",\"Title\":\""+Title+"\",\"FirstName\":\""+FirstName+"\",\"MiddleName\":\""+MiddleName+"\","
   					+ "\"LastName \":\""+LastName +"\", \"Nationality\":\""+Nationality+"\",\"PassportNumber\":\""+PassportNumber+"\",\"PassportIssuePlace\":\""+PassportIssuePlace+"\",\"PassportIssueDate\":\""+PassportIssueDate+"\",\"TitleAR\":\""+TitleAR+"\",\"FirstNameAR\":\""+FirstNameAR+"\",\"MiddleNameAR\":\""+MiddleNameAR+"\",\"LastNameAR\":\""+LastNameAR+"\",\"NationalityAR\":\""+NationalityAR+"\"}";
   	   		
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
	
	

}
