package com.action;

import java.util.Date;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class CustomerPayment {
	final static Logger logger = Logger.getLogger(CustomerPayment.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;
	public  String customerPaymentMade(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4  regTerms) {
		final String queueName = "IPMS.CustomerPaymentMadeUAT";
   		String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms.getPARAM_ID()+"\"}";
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		//P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&regTerms=
   		String correlationId = P_REQUEST_NUMBER;
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,P_REQUEST_NUMBER,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   		JSONObject result = new JSONObject();
   		try {
			XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
			XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

			SOAHeader header = new SOAHeader();

			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);

			APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
			objX4.setPARAM_ID(regTerms.getPARAM_ID());

			body.setP_REQUEST_MESSAGE(objX4);
			objMongoDB = new MongoDB();
	   		Date reqDate = new Date();

			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
					.RETRIEVE(header, body);

			System.out.println(param.getX_RETURN_MESSAGE());
			System.out.println(param.getX_RETURN_STATUS());
			System.out.println(param.getX_RESPONSE_MESSAGE());
			result.put("status", param.getX_RETURN_STATUS());
			result.put("message", param.getX_RETURN_MESSAGE());
			JSONArray mainArr = new JSONArray();
	   		JSONObject subJson = null;
	   		APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
	   		//com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] regTerms1 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[objAPPSXXDC_PROCESS_SEX1794747X2X56.length];
			for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
				subJson = new JSONObject();
				System.out.println("ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
				System.out.println("ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
				System.out.println("ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
				System.out.println("ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
				System.out.println("ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
				System.out.println("ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
				System.out.println("ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
				System.out.println("ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
				System.out.println("ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
				System.out.println("ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1() != null) {
				subJson.put("ATTRIBUTE1", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
				}else {
					subJson.put("ATTRIBUTE1", JSONObject.NULL);
				}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2() != null) {
					subJson.put("ATTRIBUTE2", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
					}else {
						subJson.put("ATTRIBUTE2", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3() != null) {
					subJson.put("ATTRIBUTE3", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
					}else {
						subJson.put("ATTRIBUTE3", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4() != null) {
					subJson.put("ATTRIBUTE4", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
					}else {
						subJson.put("ATTRIBUTE4", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5() != null) {
					subJson.put("ATTRIBUTE5", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
					}else {
						subJson.put("ATTRIBUTE5", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6() != null) {
					subJson.put("ATTRIBUTE6", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
					}else {
						subJson.put("ATTRIBUTE6", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7() != null) {
					subJson.put("ATTRIBUTE7", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
					}else {
						subJson.put("ATTRIBUTE7", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8() != null) {
					subJson.put("ATTRIBUTE8", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
					}else {
						subJson.put("ATTRIBUTE8", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9() != null) {
					subJson.put("ATTRIBUTE9", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
					}else {
						subJson.put("ATTRIBUTE9", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10() != null) {
					subJson.put("ATTRIBUTE10", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
					}else {
						subJson.put("ATTRIBUTE10", JSONObject.NULL);
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11() != null) {
				     subJson.put("ATTRIBUTE11", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
				     }else {
				      subJson.put("ATTRIBUTE11", JSONObject.NULL);
				     }
		   		String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms.getPARAM_ID()+"\"}";
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), param.getX_RETURN_STATUS());
			mainArr.put(subJson);
			}
			result.put("data", mainArr);
			String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: " + response);
			/*
			 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
			 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
			 * }); t1.start();
			 */
			return result.toString();

		} catch (Exception e) {
			try {
   				result.put("status", "E");
   		   		result.put("message", e.getMessage());
   			}catch (Exception ex) {
				// TODO: handle exception
			}
			return result.toString();

		}
	
}

}