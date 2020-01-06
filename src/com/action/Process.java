package com.action;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class Process {
	final static Logger logger = Logger.getLogger(Process.class);
	public com.activeMQ.ActiveMQCall activemqcall = null;

	
	public  String CREATE_DM_CM(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.PROCESS.CREATE_DM_CM";
	   		//"SRNumber":""+SRNumber+"",
			String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"regTerms\":\""+regTerms+"\"}";
	   		activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		//correlationId=activemqcall.GetProducer(queueName,SourceId,correlationId,jsonString);
	   		correlationId=activemqcall.GetProducer(queueName,P_REQUEST_NUMBER,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		String res = "";
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[regTerms.length];
	   		
	   		for(int j=0;j<regTerms.length;j++) {
	   			
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(regTerms[j].getPARAM_ID());
	   		objX41.setATTRIBUTE1(regTerms[j].getATTRIBUTE1());
	   		objX41.setATTRIBUTE2(regTerms[j].getATTRIBUTE2());
	   		objX41.setATTRIBUTE3(regTerms[j].getATTRIBUTE3());
	   		objX41.setATTRIBUTE4(regTerms[j].getATTRIBUTE4());
	   		objX41.setATTRIBUTE5(regTerms[j].getATTRIBUTE5());
	   		arr[j] = objX41;
	   		logger.info("Request :: PROCESS :: CREATE_CM_DM :: P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + " :: PARAM_ID :: "+regTerms[j].getPARAM_ID() + " :: ATTRIBUTE1 :: "+regTerms[j].getATTRIBUTE1()+ " :: ATTRIBUTE2 :: "+regTerms[j].getATTRIBUTE2()+ " :: ATTRIBUTE3 :: "+regTerms[j].getATTRIBUTE3()+ " :: ATTRIBUTE4 :: "+regTerms[j].getATTRIBUTE4()+ " :: ATTRIBUTE5 :: "+regTerms[j].getATTRIBUTE5());
	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	   		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		result.put("status", param.getX_RETURN_STATUS());
	   		result.put("message", param.getX_RETURN_MESSAGE());
	   		JSONArray mainArr = new JSONArray();
	   		JSONObject subJson = null;
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			subJson = new JSONObject();
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
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
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
						subJson.put("ATTRIBUTE3", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
					}else {
						subJson.put("ATTRIBUTE3", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4() != null) {
						subJson.put("ATTRIBUTE4", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
					}else {
						subJson.put("ATTRIBUTE4", JSONObject.NULL);	
					}
					
					
					mainArr.put(subJson);	
	   		}
	   		result.put("data", mainArr);
	   		logger.info("Response :: PROCESS :: CREATE_CM_DM :: P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + " :: Response :: "+mainArr);
	   		res = result.toString();
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   		/*Thread t1 = new Thread(new Runnable() {
	   			public void run() {
	   				String response = activemqcall.GetConsumer(queueName);
	   				System.out.println("3 4:: "+response);
	   			}
	   		});
	   		t1.start();*/
	   		//return param.getX_RETURN_STATUS();

	   		}catch (Exception e) {
	   			//return e.getMessage();
	   			try {
	   				result.put("status", "E");
	   		   		result.put("message", e.getMessage());
	   			}catch (Exception ex) {
					// TODO: handle exception
				}
	   			res = result.toString();
	   		}
	   		return res;
				
		}

	public  String updateMortgage(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.PROCESS.UPDATEMORTGAGE";
	   		//"SRNumber":""+SRNumber+"",
			String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"regTerms\":\""+regTerms+"\"}";
	   		activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		//correlationId=activemqcall.GetProducer(queueName,SourceId,correlationId,jsonString);
	   		correlationId=activemqcall.GetProducer(queueName,P_REQUEST_NUMBER,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		String res = "";
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[regTerms.length];
	   		
	   		for(int j=0;j<regTerms.length;j++) {
	   			
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(regTerms[j].getPARAM_ID());
	   		objX41.setATTRIBUTE1(regTerms[j].getATTRIBUTE1());
	   		objX41.setATTRIBUTE2(regTerms[j].getATTRIBUTE2());
	   		objX41.setATTRIBUTE3(regTerms[j].getATTRIBUTE3());
	   		objX41.setATTRIBUTE4(regTerms[j].getATTRIBUTE4());
	   		objX41.setATTRIBUTE5(regTerms[j].getATTRIBUTE5());
	   		objX41.setATTRIBUTE6(regTerms[j].getATTRIBUTE6());
	   		objX41.setATTRIBUTE7(regTerms[j].getATTRIBUTE7());
	   		objX41.setATTRIBUTE8(regTerms[j].getATTRIBUTE8());
	   		objX41.setATTRIBUTE9(regTerms[j].getATTRIBUTE9());
	   		objX41.setATTRIBUTE10(regTerms[j].getATTRIBUTE10());
	   		objX41.setATTRIBUTE11(regTerms[j].getATTRIBUTE11());
	   		objX41.setATTRIBUTE12(regTerms[j].getATTRIBUTE12());
	   		objX41.setATTRIBUTE13(regTerms[j].getATTRIBUTE13());
	   		objX41.setATTRIBUTE14(regTerms[j].getATTRIBUTE14());
	   		objX41.setATTRIBUTE15(regTerms[j].getATTRIBUTE15());
	   		objX41.setATTRIBUTE16(regTerms[j].getATTRIBUTE16());
	   		objX41.setATTRIBUTE17(regTerms[j].getATTRIBUTE17());
	   		objX41.setATTRIBUTE18(regTerms[j].getATTRIBUTE18());
	   		objX41.setATTRIBUTE19(regTerms[j].getATTRIBUTE19());
	   		objX41.setATTRIBUTE20(regTerms[j].getATTRIBUTE20());
	   		arr[j] = objX41;
	   		logger.info("Request :: PROCESS :: updateMortgage :: P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + " :: PARAM_ID :: "+regTerms[j].getPARAM_ID() + " :: ATTRIBUTE1 :: "+regTerms[j].getATTRIBUTE1()+ " :: ATTRIBUTE2 :: "+regTerms[j].getATTRIBUTE2()+ " :: ATTRIBUTE3 :: "+regTerms[j].getATTRIBUTE3()+ " :: ATTRIBUTE4 :: "+regTerms[j].getATTRIBUTE4()+ " :: ATTRIBUTE5 :: "+regTerms[j].getATTRIBUTE5()+ " :: ATTRIBUTE6 :: "+regTerms[j].getATTRIBUTE6()+ " :: ATTRIBUTE7 :: "+regTerms[j].getATTRIBUTE7()+ " :: ATTRIBUTE8 :: "+regTerms[j].getATTRIBUTE8()+ " :: ATTRIBUTE9 :: "+regTerms[j].getATTRIBUTE9()+ " :: ATTRIBUTE10 :: "+regTerms[j].getATTRIBUTE10()+ " :: ATTRIBUTE11 :: "+regTerms[j].getATTRIBUTE11()+ " :: ATTRIBUTE12 :: "+regTerms[j].getATTRIBUTE12()+ " :: ATTRIBUTE13 :: "+regTerms[j].getATTRIBUTE13()+ " :: ATTRIBUTE14 :: "+regTerms[j].getATTRIBUTE14()+ " :: ATTRIBUTE15 :: "+regTerms[j].getATTRIBUTE15()+ " :: ATTRIBUTE16 :: "+regTerms[j].getATTRIBUTE16()+ " :: ATTRIBUTE17 :: "+regTerms[j].getATTRIBUTE17()+ " :: ATTRIBUTE18 :: "+regTerms[j].getATTRIBUTE18()+ " :: ATTRIBUTE19 :: "+regTerms[j].getATTRIBUTE19()+ " :: ATTRIBUTE20 :: "+regTerms[j].getATTRIBUTE20());
	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	   		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		result.put("status", param.getX_RETURN_STATUS());
	   		result.put("message", param.getX_RETURN_MESSAGE());
	   		JSONArray mainArr = new JSONArray();
	   		JSONObject subJson = null;
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			subJson = new JSONObject();
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
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
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
						subJson.put("ATTRIBUTE3", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
					}else {
						subJson.put("ATTRIBUTE3", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4() != null) {
						subJson.put("ATTRIBUTE4", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
					}else {
						subJson.put("ATTRIBUTE4", JSONObject.NULL);	
					}
					
					
					mainArr.put(subJson);	
	   		}
	   		result.put("data", mainArr);
	   		logger.info("Response :: PROCESS :: updateMortgage :: P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + " :: Response :: "+mainArr);
	   		res = result.toString();
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   		/*Thread t1 = new Thread(new Runnable() {
	   			public void run() {
	   				String response = activemqcall.GetConsumer(queueName);
	   				System.out.println("3 4:: "+response);
	   			}
	   		});
	   		t1.start();*/
	   		//return param.getX_RETURN_STATUS();

	   		}catch (Exception e) {
	   			//return e.getMessage();
	   			try {
	   				result.put("status", "E");
	   		   		result.put("message", e.getMessage());
	   			}catch (Exception ex) {
					// TODO: handle exception
				}
	   			res = result.toString();
	   		}
	   		return res;
				
		}
	

}
