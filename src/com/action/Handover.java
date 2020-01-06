package com.action;

import java.util.Date;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;
import com.sfdc.GeneratePCCSFDC;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;



public class Handover {
	final static Logger logger = Logger.getLogger(Handover.class);
	public com.activeMQ.ActiveMQCall activemqcall = null;
	MongoDB objMongoDB = null;
	
	

	public  String LetterofDischarge(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.HANDOVER.LETTEROFDISCHARGEUAT";
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
	   		arr[j] = objX41;
	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
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
					

					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\"}";
					
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				
					
					mainArr.put(subJson);	
	   		}
	   		result.put("data", mainArr);
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

	
	
	
	public String getBuildingRERAPercentage (String P_REQUEST_NUMBER, String P_REQUEST_NAME, String P_SOURCE_SYSTEM,
			String BuildingId)

	{
		// PROCESS
		// url
		// CRM_SR_NEW/services/getBuildingRERAPercentage?P_REQUEST_NUMBER=&P_REQUEST_NAME=BUILDING_COMP_PERCENTAGE&P_SOURCE_SYSTEM=SFDC&BuildingId=

		final String queueName = "IPMS.HANDOVER.GETBUILDINGRERAPERCENTAGEUAT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\"" + P_SOURCE_SYSTEM
				+ "\",\"BuildingId\":\"" + BuildingId + "\"}";
		activemqcall = new ActiveMQCall();
		// String correlationId = activemqcall.createRandomString();
		String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, BuildingId, correlationId, jsonString);
		System.out.println("2 :: " + correlationId);
		String strAttr1 = "";
		JSONObject objJSONObject = new JSONObject();
		// TextMessage textMessage = new
		try {
			XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
			XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

			SOAHeader header = new SOAHeader();

			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(BuildingId);
			
			APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] { objX41 };
			body.setP_REQUEST_MESSAGE(arr);
			objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
			OutputParameters param = port.PROCESS(header, body);
			// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
			// OutputParameters param = port.PROCESS(header, body);
			//
			System.out.println("1::" + param.getX_RETURN_MESSAGE());
//			System.out.println("2::" + param.getX_RETURN_STATUS());
//			System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
			
			objJSONObject.put("Status", param.getX_RETURN_STATUS());
			objJSONObject.put("Message", param.getX_RETURN_MESSAGE());
	 		logger.info("getBuildingRERAPercentage status response :: "+param.getX_RETURN_STATUS());
	 		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			
			
//			APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			// for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
			// System.out.println("param id response :: " +
			// objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
			// System.out.println("param id response :: " +
			// objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
			// System.out.println("param id response :: " +
			// objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
			// System.out.println("param id response :: " +
			// objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
			// }

			for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
				// logger.info("GenCustomerStatement param id response ::
				// "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				// System.out.println("param id response ::
				// "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				strAttr1 = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();
				// objJSONObject.put("PARAM_ID",
				// objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				// if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
				// objJSONObject.put("PROC_STATUS",
				// objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				// }else {
				// objJSONObject.put("PROC_STATUS", JSONObject.NULL);
				// }

				if (objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					objJSONObject.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
				} else {
					objJSONObject.put("PROC_MESSAGE", JSONObject.NULL);
				}
				if (objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
					objJSONObject.put("URL", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
				} else {
					objJSONObject.put("URL", JSONObject.NULL);
				}
				if (objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
					objJSONObject.put("REQUEST_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
				} else {
					objJSONObject.put("REQUEST_ID", JSONObject.NULL);
				}
				if (objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
					objJSONObject.put("BUILDING_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
				} else {
					objJSONObject.put("BUILDING_ID", JSONObject.NULL);
				}
				

		 		String requestString = "{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+BuildingId+"\"}";
		   			
		   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					
			}

			String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: " + response);
			/*
			 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
			 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
			 * }); t1.start();
			 */
			

		} catch (Exception e) {
			try {
				objJSONObject.put("Status", "E");
				objJSONObject.put("Message", e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}

		}
		return objJSONObject.toString();

	}

	
	public  String GenerateKeyReleaseForm(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.HANDOVER.GENERATEKEYRELEASEFORMUAT";
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
	   		arr[j] = objX41;
	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
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
					
					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\"}";
		   			
		   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					
					mainArr.put(subJson);	
	   		}
	   		result.put("data", mainArr);
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

//	 public  String generatePCC(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
//			//process
//				/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
//				 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
//				 */
//			//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
//			//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
//				final String queueName = "IPMS.HANDOVER.GENETAREPCCUAT";
//		   		//"SRNumber":""+SRNumber+"",
//				String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"regTerms\":\""+regTerms+"\"}";
//		   		activemqcall=new ActiveMQCall();
//		   		//String correlationId = activemqcall.createRandomString();
//		   		String correlationId = P_REQUEST_NUMBER;
//		   		System.out.println("1 :: "+correlationId);	
//		   		//correlationId=activemqcall.GetProducer(queueName,SourceId,correlationId,jsonString);
//		   		correlationId=activemqcall.GetProducer(queueName,P_REQUEST_NUMBER,correlationId,jsonString);
//		   		System.out.println("2 :: "+correlationId);
//		   	//TextMessage textMessage = new 
//		   		JSONObject result = new JSONObject();
//		   		String res = "";
//		   		try {
//		   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
//		   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
//		   		
//		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader();
//		   		
//		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
//		   		body.setP_REQUEST_NUMBER(correlationId);
//		   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
//		   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
//		   		
//		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[regTerms.length];
//		   		
//		   		for(int j=0;j<regTerms.length;j++) {
//		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5();
//		   		objX41.setPARAM_ID(regTerms[j].getPARAM_ID());
//		   		objX41.setATTRIBUTE1(regTerms[j].getATTRIBUTE1());
//		   		objX41.setATTRIBUTE2(regTerms[j].getATTRIBUTE2());
//		   		arr[j] = objX41;
//		   		}
//		   		body.setP_REQUEST_MESSAGE(arr);
//		   		objMongoDB = new MongoDB();
//		   		Date reqDate = new Date();
//		   		
//		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
////		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
////		   		OutputParameters param = port.PROCESS(header, body);
////		   		
//		   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
//		   		System.out.println("2::"+param.getX_RETURN_STATUS());
//		   		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
//		   		result.put("status", param.getX_RETURN_STATUS());
//		   		result.put("message", param.getX_RETURN_MESSAGE());
//		   		JSONArray mainArr = new JSONArray();
//		   		JSONObject subJson = null;
//		   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
//		   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
//		   			subJson = new JSONObject();
//		   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
//		   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
//		   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
//		   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
//		   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
//		   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
//		   				subJson.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
//						}else {
//							subJson.put("PROC_STATUS", JSONObject.NULL);	
//						}
//						if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
//							subJson.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
//						}else {
//							subJson.put("PROC_MESSAGE", JSONObject.NULL);	
//						}
//						if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
//							subJson.put("ATTRIBUTE1", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
//						}else {
//							subJson.put("ATTRIBUTE1", JSONObject.NULL);	
//						}
//						if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
//							subJson.put("ATTRIBUTE2", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
//						}else {
//							subJson.put("ATTRIBUTE2", JSONObject.NULL);	
//						}
//						if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
//							subJson.put("ATTRIBUTE3", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
//						}else {
//							subJson.put("ATTRIBUTE3", JSONObject.NULL);	
//						}
//						String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\"}";
//			   			
//			   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
//					
//						
//						mainArr.put(subJson);	
//		   		}
//		   		result.put("data", mainArr);
//		   		res = result.toString();
//		   		String response = activemqcall.GetConsumer(queueName);
//		   		System.out.println("3 4:: "+response);
//		   		/*Thread t1 = new Thread(new Runnable() {
//		   			public void run() {
//		   				String response = activemqcall.GetConsumer(queueName);
//		   				System.out.println("3 4:: "+response);
//		   			}
//		   		});
//		   		t1.start();*/
//		   		//return param.getX_RETURN_STATUS();
//
//		   		}catch (Exception e) {
//		   			//return e.getMessage();
//		   			try {
//		   				result.put("status", "E");
//		   		   		result.put("message", e.getMessage());
//		   			}catch (Exception ex) {
//						// TODO: handle exception
//					}
//		   			res = result.toString();
//		   		}
//		   		return res;
//					
//			}
	
	public  String generatePCC(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.HANDOVER.GENETAREPCC";
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
	   		logger.info("Handover generatePCC Case Id Request :: "+regTerms[j].getATTRIBUTE3());
	   		arr[j] = objX41;
	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		new Thread(new Runnable(){
	   			public void run() {
	   				try {
	   					
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("Handover generatePCC param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("Handover generatePCC PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("Handover generatePCC PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			logger.info("Handover generatePCC URL response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
	   			logger.info("Handover generatePCC Case Id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
	   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
	   				GeneratePCCSFDC.setPCCUrl(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID(),objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS(),objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE(),objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
	   			}		
	   		}
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   				}catch (Exception e) {
						// TODO: handle exception
	   					logger.info("Handover generatePCC Exception response :: "+e.getMessage());
					}
	   			}
	   		}).start();
	   		
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
	   		return "Message Received and URL will be updated in few minutes";
				
		}

	
	public  String GetHandoverDetails(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,  String Registrationid) {
		//process
				
				 /* GetHandoverDetails?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=GET_HANDOVER_DETAILS&P_SOURCE_SYSTEM=SFDC&&Registrationid=12345
				 */
		String res="";
				final String queueName = "IPMS.ASSIGNMENT.GETHANDOVERDETAILSUAT";
		   		//"SRNumber":""+SRNumber+"",
				String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
		   		activemqcall=new ActiveMQCall();
		   		//String correlationId = activemqcall.createRandomString();
		   		String correlationId = P_REQUEST_NUMBER;
		   		System.out.println("1 :: "+correlationId);	
		   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
		   		System.out.println("2 :: "+correlationId);
		   	//TextMessage textMessage = new 
		   		JSONObject mainJson = new JSONObject();
		   		try {
		   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
		   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
		   		
		   		SOAHeader header = new SOAHeader();
		   		
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = 
		   				new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
		   		body.setP_REQUEST_NUMBER(correlationId);
		   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
		   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
		   		APPSXXDC_PROCESS_SERX1794747X2X4 objX41 = new APPSXXDC_PROCESS_SERX1794747X2X4();
		   		objX41.setPARAM_ID(Registrationid);
		   			
		   		body.setP_REQUEST_MESSAGE(objX41);

		   		Date reqDate = new Date();
		   		objMongoDB = new MongoDB();
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
//		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		   		OutputParameters param = port.PROCESS(header, body);
//		   		
		   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
		   		System.out.println("2::"+param.getX_RETURN_STATUS());
		   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		   		mainJson.put("status", param.getX_RETURN_STATUS());
		   		mainJson.put("message", param.getX_RETURN_MESSAGE());
		   		APPSXXDC_PROCESS_SEX1794747X2X56[] resR = param.getX_RESPONSE_MESSAGE();
		   		JSONObject results = null;
		   		JSONArray arr = new JSONArray();
		   		for(int i=0;i<resR.length;i++) {
		   			results = new JSONObject();
		   		if(resR[i].getATTRIBUTE1() != null) {
		   		results.put("ATTRIBUTE1", resR[i].getATTRIBUTE1());
		   		}else {
		   			results.put("ATTRIBUTE1", JSONObject.NULL);	
		   		}
		   		
		   		if(resR[i].getATTRIBUTE2() != null) {
			   		results.put("ATTRIBUTE2", resR[i].getATTRIBUTE2());
			   		}else {
			   			results.put("ATTRIBUTE2", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE3() != null) {
			   		results.put("ATTRIBUTE3", resR[i].getATTRIBUTE3());
			   		}else {
			   			results.put("ATTRIBUTE3", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE4() != null) {
			   		results.put("ATTRIBUTE4", resR[i].getATTRIBUTE4());
			   		}else {
			   			results.put("ATTRIBUTE4", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE5() != null) {
			   		results.put("ATTRIBUTE5", resR[i].getATTRIBUTE5());
			   		}else {
			   			results.put("ATTRIBUTE5", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE6() != null) {
			   		results.put("ATTRIBUTE6", resR[i].getATTRIBUTE6());
			   		}else {
			   			results.put("ATTRIBUTE6", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE7() != null) {
			   		results.put("ATTRIBUTE7", resR[i].getATTRIBUTE7());
			   		}else {
			   			results.put("ATTRIBUTE7", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE8() != null) {
			   		results.put("ATTRIBUTE8", resR[i].getATTRIBUTE8());
			   		}else {
			   			results.put("ATTRIBUTE8", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE9() != null) {
			   		results.put("ATTRIBUTE9", resR[i].getATTRIBUTE9());
			   		}else {
			   			results.put("ATTRIBUTE9", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE10() != null) {
			   		results.put("ATTRIBUTE10", resR[i].getATTRIBUTE10());
			   		}else {
			   			results.put("ATTRIBUTE10", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE11() != null) {
			   		results.put("ATTRIBUTE11", resR[i].getATTRIBUTE11());
			   		}else {
			   			results.put("ATTRIBUTE11", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE12() != null) {
			   		results.put("ATTRIBUTE12", resR[i].getATTRIBUTE12());
			   		}else {
			   			results.put("ATTRIBUTE12", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE13() != null) {
			   		results.put("ATTRIBUTE13", resR[i].getATTRIBUTE13());
			   		}else {
			   			results.put("ATTRIBUTE13", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE14() != null) {
			   		results.put("ATTRIBUTE14", resR[i].getATTRIBUTE14());
			   		}else {
			   			results.put("ATTRIBUTE14", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE15() != null) {
			   		results.put("ATTRIBUTE15", resR[i].getATTRIBUTE15());
			   		}else {
			   			results.put("ATTRIBUTE15", JSONObject.NULL);	
			   		}
		   		if(resR[i].getATTRIBUTE16() != null) {
			   		results.put("ATTRIBUTE16", resR[i].getATTRIBUTE16());
			   		}else {
			   			results.put("ATTRIBUTE16", JSONObject.NULL);	
			   		}
		   		

		   		String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+Registrationid+"\"}";
				objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", results.toString(),param.getX_RETURN_STATUS());
				
		   		arr.put(results);
		   		
		   		}
		   		mainJson.put("data", arr);
		   		String response = activemqcall.GetConsumer(queueName);
		   		System.out.println("3 4:: "+response);
		   		/*Thread t1 = new Thread(new Runnable() {
		   			public void run() {
		   				String response = activemqcall.GetConsumer(queueName);
		   				System.out.println("3 4:: "+response);
		   			}
		   		});
		   		t1.start();*/
    	   		System.out.println("res  ::"+res);

		   		
		   		}catch (Exception e) {
		   			try {
		   				mainJson.put("status","E");
		   				mainJson.put("message",e.getMessage());
		   			}catch (Exception ex) {
						// TODO: handle exception
					}
		   			
		   		}
		   		return mainJson.toString();


			}
	
		
	 public  String UpdatePDCInformation(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, 
			 String Registrationid, String Name,String PDCAmount,String ChequeDate,String ChequeNumber,String PaymentPlan, String Type) 
		{//process
	    	
			/*UpdatePDCInformation?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=GET_HANDOVER_DETAILS&P_SOURCE_SYSTEM=SFDC&Registrationid=8765&Name=&PDCAmount=&ChequeDate=&ChequeNumber=&PaymentPlan=&Type=
			
	*/
			final String queueName = "IPMS.HANDOVER.UPDATEPDCINFORMATIONUAT";
			logger.info("queueName :: "+queueName);

	   		//"SRNumber":""+SRNumber+"",
			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\","+ "\"Registrationid\":\""+Registrationid+"\",\"Name\":\""+Name+"\",\"PDCAmount\":\""+PDCAmount+"\",\"ChequeDate\":\""+ChequeDate+"\",\"ChequeNumber\":\""+ChequeNumber+"\",\"PaymentPlan\":\""+PaymentPlan+"\",\"Type\":\""+Type+"\"}";

			
			//"\"Name\":\""+Name+"\","\"PDCAmount\":\""+PDCAmount+"\","\"ChequeDate\":\""+ChequeDate+"\","\"ChequeNumber\":\""+ChequeNumber+"\","\"PaymentPlan\":\""+PaymentPlan+"\","\"Type\":\""+Type+"\"
			logger.info("jsonString of SFDC param :: "+jsonString);

			
			activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		SOAHeader header = new SOAHeader();
	   		
	   		InputParameters body = new InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(Registrationid);
	   		objX41.setATTRIBUTE1(Name);   //need to set  parameters given in document not attributes
	   		objX41.setATTRIBUTE2(PDCAmount);
	   		objX41.setATTRIBUTE3(ChequeDate);
	   		objX41.setATTRIBUTE4(ChequeNumber);
	   		objX41.setATTRIBUTE5(PaymentPlan);
	   		objX41.setATTRIBUTE6(Type);
	   		
	   		  		
	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	   		body.setP_REQUEST_MESSAGE(arr);
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
				logger.info("Status ::"+param.getX_RETURN_STATUS() );

	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			result.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
					result.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					}else {
						result.put("PROC_STATUS", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					result.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
					}else {
						result.put("PROC_MESSAGE", JSONObject.NULL);	
					}
					String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\","+ "\"Registrationid\":\""+Registrationid+"\",\"Name\":\""+Name+"\",\"PDCAmount\":\""+PDCAmount+"\",\"ChequeDate\":\""+ChequeDate+"\",\"ChequeNumber\":\""+ChequeNumber+"\",\"PaymentPlan\":\""+PaymentPlan+"\",\"Type\":\""+Type+"\"}";
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());

					  			
	   		}
	   		
	   		
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   		
	   		
	   		}catch (Exception e) {
	   			e.printStackTrace();
	   			return e.getMessage();
	   			
	   		}
	   		return result.toString();

		}
	
	
	 public  String GetFinalInvoice(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String Registrationid) {
		 //process
	    	
			/*GetFinalInvoice?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=UPDATE_FINAL_INVOICE&P_SOURCE_SYSTEM=SFDC&Registrationid=8765
			
	*/
			final String queueName = "IPMS.HANDOVER.GETFINALINVOICEUAT";
			logger.info("queueName :: "+queueName);

	   		//"SRNumber":""+SRNumber+"",
			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\" ,\"Registrationid\":\""+Registrationid+"\"}";

			
			logger.info("jsonString of SFDC param :: "+jsonString);

			
			activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		SOAHeader header = new SOAHeader();
	   		
	   		InputParameters body = new InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(Registrationid);
	   		
	   		
	   		  		
	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	   		body.setP_REQUEST_MESSAGE(arr);
	   		
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
				logger.info("Status ::"+param.getX_RETURN_STATUS() );

	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			result.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
					result.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					}else {
						result.put("PROC_STATUS", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					result.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
					}else {
						result.put("PROC_MESSAGE", JSONObject.NULL);	
					}
					
					String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\" ,\"Registrationid\":\""+Registrationid+"\"}";
		   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());

					  			
	   		}
	   		
	   		
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   		
	   		
	   		}catch (Exception e) {
	   			e.printStackTrace();
	   			return e.getMessage();
	   			
	   		}
	   		return result.toString();

	 }
	 
	
	 public  String UpdateBookingUnit(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, 
			 String Registrationid, String HandoverFlag,String PDCAmEarlyHandoverFlagount,String RentalPoolFlag){
		 //process
	    	
			/*UpdatePDCInformation?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=GET_CONDITIONS_FOR_COMMENCMENT&P_SOURCE_SYSTEM=SFDC&Registrationid=8765&HandoverFlag=&PDCAmEarlyHandoverFlagount=&RentalPoolFlag=
			
	*/
			final String queueName = "IPMS.HANDOVER.UPDATEBOOKINGUNITUAT";
			logger.info("queueName :: "+queueName);

	   		//"SRNumber":""+SRNumber+"",
			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\","+ "\"Registrationid\":\""+Registrationid+"\"}";

			
			//"\"Name\":\""+Name+"\","\"PDCAmount\":\""+PDCAmount+"\","\"ChequeDate\":\""+ChequeDate+"\","\"ChequeNumber\":\""+ChequeNumber+"\","\"PaymentPlan\":\""+PaymentPlan+"\","\"Type\":\""+Type+"\"
			logger.info("jsonString of SFDC param :: "+jsonString);

			
			activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		SOAHeader header = new SOAHeader();
	   		
	   		InputParameters body = new InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(Registrationid);
	   		objX41.setATTRIBUTE1(HandoverFlag);   //need to set  parameters given in document not attributes
	   		objX41.setATTRIBUTE2(PDCAmEarlyHandoverFlagount);
	   		objX41.setATTRIBUTE3(RentalPoolFlag);
	   		
	   		
	   		  		
	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	   		body.setP_REQUEST_MESSAGE(arr);
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
				logger.info("Status ::"+param.getX_RETURN_STATUS() );

	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			result.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
					result.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					}else {
						result.put("PROC_STATUS", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					result.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
					}else {
						result.put("PROC_MESSAGE", JSONObject.NULL);	
					}
					

					String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\","+ "\"Registrationid\":\""+Registrationid+"\"}";
		   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());

					  			
	   		}
	   			   		
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   		
	   		
	   		}catch (Exception e) {
	   			e.printStackTrace();
	   			return e.getMessage();
	   			
	   		}
	   		return result.toString();

		}
	
	 public  String EHOCRFRequestGeneration(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, 
			 String Registrationid, String ProjectName,String AptNumber,String CustomerName, String JointBuyerName, String OtherPropertieswithDamac, String SubjectOfRequest){
		 //process
	    	
			/*UpdatePDCInformation?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=GET_CONDITIONS_FOR_COMMENCMENT&P_SOURCE_SYSTEM=SFDC&Registrationid=8765&ProjectName=&AptNumber=&CustomerName=&JointBuyerName=&OtherPropertieswithDamac=&SubjectOfRequest=
			
	*/
			final String queueName = "IPMS.HANDOVER.UPDATEBOOKINGUNITUAT";
			logger.info("queueName :: "+queueName);

	   		//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\","+ "\"Registrationid\":\""+Registrationid+"\",\"ProjectName\":\""+ProjectName+"\",\"AptNumber\":\""+AptNumber+"\",\"CustomerName\":\""+CustomerName+"\",\"JointBuyerName\":\""+JointBuyerName+"\",\"OtherPropertieswithDamac\":\""+OtherPropertieswithDamac+"\",\"SubjectOfRequest\":\""+SubjectOfRequest+"\"}";

			
			//\"ProjectName\":\""+ProjectName+"\",\"AptNumber\":\""+AptNumber+"\",\"CustomerName\":\""+CustomerName+"\",\"JointBuyerName\":\""+JointBuyerName+"\",\"OtherPropertieswithDamac\":\""+OtherPropertieswithDamac+"\",\"SubjectOfRequest\":\""+SubjectOfRequest+"\"
			logger.info("jsonString of SFDC param :: "+jsonString);

			
			activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		SOAHeader header = new SOAHeader();
		
	   		InputParameters body = new InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(Registrationid);
	   		objX41.setATTRIBUTE1(ProjectName);   //need to set  parameters given in document not attributes
	   		objX41.setATTRIBUTE2(AptNumber);
	   		objX41.setATTRIBUTE3(CustomerName);
	   		objX41.setATTRIBUTE4(JointBuyerName);
	   		objX41.setATTRIBUTE5(OtherPropertieswithDamac);
	   		objX41.setATTRIBUTE6(SubjectOfRequest);
	   		
	   		
	   		  		
	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	   		body.setP_REQUEST_MESSAGE(arr);
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
				logger.info("Status ::"+param.getX_RETURN_STATUS() );

	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
	   			result.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
					result.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					}else {
						result.put("PROC_STATUS", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
					result.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
					}else {
						result.put("PROC_MESSAGE", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
						result.put("URL", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
						}else {
							result.put("URL", JSONObject.NULL);	
						}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
						result.put("REQUEST_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
						}else {
							result.put("REQUEST_ID", JSONObject.NULL);	
						}
					String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\","+ "\"Registrationid\":\""+Registrationid+"\",\"ProjectName\":\""+ProjectName+"\",\"AptNumber\":\""+AptNumber+"\",\"CustomerName\":\""+CustomerName+"\",\"JointBuyerName\":\""+JointBuyerName+"\",\"OtherPropertieswithDamac\":\""+OtherPropertieswithDamac+"\",\"SubjectOfRequest\":\""+SubjectOfRequest+"\"}";
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
  			
	   		}
	   			   		
	   		String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
	   		
	   		
	   		}catch (Exception e) {
	   			e.printStackTrace();
	   			return e.getMessage();
	   			
	   		}
	   		return result.toString();

		}
	 

	 public String EarlyHandoverPaymentPlanCreation(String P_REGISTRATION_ID, String P_SR_NUMBER, String P_SR_TYPE,
				com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] regTerms) {

		//http://localhost:8080/CRM_SR_NEW/services/AOPT/PaymentPlanCreation?P_REGISTRATION_ID=10745&P_SR_NUMBER=123&P_SR_TYPE=AMENDMENT_OF_PAYMENT_TERMS&INSTALLMENT=2&DESCRIPTION=afas&PAYMENT_DATE=30-03-2016&EXPECTED_DATE=30-04-2016&MILESTONE_EVENT=casvs&PERCENT_VALUE=32&TRANSFER_AR_INTER_FLAG=Y&PAYMENT_AMOUNT=22	
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.EarlyHandoverPaymentPlanCreationUAT";
		//logger.info("queueName :: "+queueName);

			//"SRNumber":""+SRNumber+"",
		//String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\",\"P_SR_TYPE\":\""+P_SR_TYPE+"\",\"INSTALLMENT\":\""+INSTALLMENT+"\",\"DESCRIPTION\":\""+DESCRIPTION+"\",\"PAYMENT_DATE\":\""+PAYMENT_DATE+"\",\"\"EXPECTED_DATE\":\""+EXPECTED_DATE+"\",\"TRANSFER_AR_INTER_FLAG\":\""+TRANSFER_AR_INTER_FLAG+"\",\"PAYMENT_AMOUNT\":\""+PAYMENT_AMOUNT+"\",\"MILESTONE_EVENT\":\""+MILESTONE_EVENT+"\",\"PERCENT_VALUE\":\""+PERCENT_VALUE+"\"}";
		String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\",\"P_SR_TYPE\":\""+P_SR_TYPE+"\"}";
		logger.info("EarlyHandoverPaymentPlanCreation :: "+jsonString);

		
		activemqcall=new ActiveMQCall();
			String correlationId = activemqcall.createRandomString();
//			String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: "+correlationId);	
			correlationId=activemqcall.GetProducer(queueName,P_REGISTRATION_ID,correlationId,jsonString);
			System.out.println("2 :: "+correlationId);

		try {
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = 
					new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_ServiceLocator();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader();
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters aoptplancreation = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters();
			aoptplancreation.setP_REGISTRATION_ID(P_REGISTRATION_ID);
			aoptplancreation.setP_SR_NUMBER(P_SR_NUMBER);
			aoptplancreation.setP_SR_TYPE(P_SR_TYPE);
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] arr = 
					new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[regTerms.length];
			JSONObject obj=new JSONObject();
			JSONArray jsonarr=new JSONArray();
			JSONObject subobj=null;
			
			for(int i=0;i<regTerms.length;i++) {
				com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5 aoptplancreationfields 
				= new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5();
				aoptplancreationfields.setREGISTRATION_ID(regTerms[i].getREGISTRATION_ID());
				aoptplancreationfields.setTERM_ID(regTerms[i].getTERM_ID());
				aoptplancreationfields.setLINE_ID(regTerms[i].getLINE_ID());
				aoptplancreationfields.setINSTALLMENT(regTerms[i].getINSTALLMENT());
				aoptplancreationfields.setDESCRIPTION(regTerms[i].getDESCRIPTION());
				aoptplancreationfields.setPAYMENT_DATE(regTerms[i].getPAYMENT_DATE());
				aoptplancreationfields.setEXPECTED_DATE(regTerms[i].getEXPECTED_DATE());
				aoptplancreationfields.setMILESTONE_EVENT(regTerms[i].getMILESTONE_EVENT());
				aoptplancreationfields.setPERCENT_VALUE(regTerms[i].getPERCENT_VALUE());
				aoptplancreationfields.setSTATUS(regTerms[i].getSTATUS());
				aoptplancreationfields.setTRANSFER_AR_INTER_FLAG(regTerms[i].getTRANSFER_AR_INTER_FLAG());
				aoptplancreationfields.setPAYMENT_AMOUNT(regTerms[i].getPAYMENT_AMOUNT());
				aoptplancreationfields.setPDC_NUMBER(regTerms[i].getPDC_NUMBER());
				aoptplancreationfields.setPDC_DATE(regTerms[i].getPDC_DATE());
				aoptplancreationfields.setPDC_AMOUNT(regTerms[i].getPDC_AMOUNT());
				arr[i] = aoptplancreationfields;
				//arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] {aoptplancreationfields};
				subobj=new JSONObject();
				subobj.put(P_REGISTRATION_ID, regTerms[i].getREGISTRATION_ID());
				subobj.put("TERM_ID", regTerms[i].getTERM_ID());
				subobj.put("LINE_ID", regTerms[i].getLINE_ID());
				subobj.put("INSTALLMENT", regTerms[i].getINSTALLMENT());
				subobj.put("DESCRIPTION", regTerms[i].getDESCRIPTION());
				subobj.put("PAYMENT_DATE", regTerms[i].getPAYMENT_DATE());
				subobj.put("EXPECTED_DATE", regTerms[i].getEXPECTED_DATE());
				subobj.put("MILESTONE_EVENT", regTerms[i].getMILESTONE_EVENT());
				subobj.put("PERCENT_VALUE", regTerms[i].getPERCENT_VALUE());
				subobj.put("STATUS", regTerms[i].getSTATUS());
				subobj.put("TRANSFER_AR_INTER_FLAG", regTerms[i].getTRANSFER_AR_INTER_FLAG());
				subobj.put("PAYMENT_AMOUNT", regTerms[i].getPAYMENT_AMOUNT());
				subobj.put("PDC_NUMBER", regTerms[i].getPDC_NUMBER());
				subobj.put("PDC_DATE", regTerms[i].getPDC_DATE());
				subobj.put("PDC_AMOUNT", regTerms[i].getPDC_AMOUNT());

				jsonarr.put(subobj);
			}
			
			obj.put("data", jsonarr);
			aoptplancreation.setP_REG_TERMS(arr);
			 
			objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		
			
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters aoptplancreationout = port_aopt.PAYMENT_PLAN_CREATION(header, aoptplancreation);
			System.out.println(aoptplancreationout.getX_RETURN_STATUS());
			logger.info("EarlyHandoverPaymentPlanCreation response status :: "+aoptplancreationout.getX_RETURN_STATUS());
			result.put("status", aoptplancreationout.getX_RETURN_STATUS());
			result.put("message", aoptplancreationout.getX_ERROR_MSG());
			
			

			String requestString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\",\"P_SR_TYPE\":\""+P_SR_TYPE+"\",\"REQUEST_JSON\":\""+obj.toString()+"\"}";
			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), aoptplancreationout.getX_RETURN_STATUS());

			
		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("status", "E");
			result.put("message", e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: "+response);
		return result.toString();	
		}
	 
	 
	 

	
	
	 public  String UPDATE_EARLY_HO_FLAG(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
			//process
				/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
				 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
				 */
			//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
			//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
				final String queueName = "IPMS.UPDATE_EARLY_HO_FLAGUAT";
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
		   		JSONObject obj=new JSONObject();
				JSONArray jsonarr=new JSONArray();
				JSONObject subobj=null;
		   		for(int j=0;j<regTerms.length;j++) {
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5();
		   		objX41.setPARAM_ID(regTerms[j].getPARAM_ID());
		   		objX41.setATTRIBUTE1(regTerms[j].getATTRIBUTE1());
		   		objX41.setATTRIBUTE2(regTerms[j].getATTRIBUTE2());
		   		arr[j] = objX41;
		   		subobj=new JSONObject();
		   		subobj.put("PARAM_ID", regTerms[j].getPARAM_ID());
				subobj.put("ATTRIBUTE1", regTerms[j].getATTRIBUTE1());
				subobj.put("ATTRIBUTE2", regTerms[j].getATTRIBUTE2());
				
				jsonarr.put(subobj);
		   		}
		   		obj.put("data", jsonarr);		   		
		   		body.setP_REQUEST_MESSAGE(arr);
		   		objMongoDB = new MongoDB(); 
		   		Date reqDate = new Date();
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
//		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		   		OutputParameters param = port.PROCESS(header, body);
//		   		
		   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
		   		System.out.println("2::"+param.getX_RETURN_STATUS());
		   		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		   		result.put("status", param.getX_RETURN_STATUS());
		   		result.put("message", param.getX_RETURN_MESSAGE());

				String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"REQUEST_JSON\":\""+obj.toString()+"\"}";
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), param.getX_RETURN_STATUS());

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
	 
	 

	 public  String GET_EARLY_HO_DETAILS(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
			//process
				/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
				 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
				 */
			//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
			//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
				final String queueName = "IPMS.GET_EARLY_HO_DETAILSUAT";
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
		   		arr[j] = objX41;
		   		}
		   		body.setP_REQUEST_MESSAGE(arr);
		   		objMongoDB = new MongoDB();
		   		Date reqDate = new Date();
		   		
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
//		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		   		OutputParameters param = port.PROCESS(header, body);
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
						String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\"}";
						objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
						
						mainArr.put(subJson);	
		   		}
		   		result.put("data", mainArr);
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
