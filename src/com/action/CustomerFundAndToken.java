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
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class CustomerFundAndToken {
	
	final static Logger logger = Logger.getLogger(CustomerFundAndToken.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;
	 public String CustomerPaymentMade(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String RegistrationId) {
	    	// url         CustomerFundAndToken/CustomerPaymentMade?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_CUSTOMER_PAYMENT_MADE&P_SOURCE_SYSTEM=&RegistrationId=
	    	
	    		// retrive
	    			String res = "";
	    			final String queueName = "IPMS.CUSTOMERFUNDANDTOKEN.CUSTOMERPAYMENTMADEUAT";
	    			// "SRNumber":""+SRNumber+"",
	    			String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationId\":\""+RegistrationId+"\"}";
	    				activemqcall = new ActiveMQCall();
	    			// String correlationId = activemqcall.createRandomString();
	    			String correlationId = P_REQUEST_NUMBER;

	    			System.out.println("1 :: " + correlationId);
	    			correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
	    			System.out.println("2 :: " + correlationId);
	    			// TextMessage textMessage = new
	    			try {
	    				XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	    				XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

	    				SOAHeader header = new SOAHeader();

	    				com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
	    				body.setP_REQUEST_NUMBER(correlationId);
	    				body.setP_REQUEST_NAME(P_REQUEST_NAME);
	    				body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);

	    				APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
	    				objX4.setPARAM_ID(RegistrationId);

	    				body.setP_REQUEST_MESSAGE(objX4);
	    				
	    				objMongoDB = new MongoDB();
	    		   		Date reqDate = new Date();
	    				com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
	    						.RETRIEVE(header, body);

	    				System.out.println(param.getX_RETURN_MESSAGE());
	    				System.out.println(param.getX_RETURN_STATUS());
	    				System.out.println(param.getX_RESPONSE_MESSAGE());
	    				APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
	    				JSONObject subJson = null;
	    				for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
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
	    					subJson=new JSONObject();
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
	    						}if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6() != null) {
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
	    					
	    					String requestString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+RegistrationId+"\"}";
	    					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), param.getX_RETURN_STATUS());

	    				
	    				
	    				}
	    				String response = activemqcall.GetConsumer(queueName);
	    				System.out.println("3 4:: " + response);
	    				/*
	    				 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
	    				 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
	    				 * }); t1.start();
	    				 */
	    				return param.getX_RETURN_STATUS();

	    			} catch (Exception e) {
	    				return e.getMessage();

	    			}
	 	
	    }
	    
	    
	    public String getExcessAmount(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String RegistrationId) {
			//PROCESS
		    	// url        CustomerFundAndToken/getExcessAmount?P_REQUEST_NUMBER=&P_REQUEST_NAME=LETTER_OF_DISCHARGE&P_SOURCE_SYSTEM=&RegistrationId=
		    			//http://localhost:8080/CRM_SR_NEW/services/CustomerFundAndToken/getExcessAmount?P_REQUEST_NUMBER=22&P_REQUEST_NAME=GET_EXCESS_AMOUNT&P_SOURCE_SYSTEM=SFDC&RegistrationId=92604		
		    			final String queueName = "IPMS.CUSTOMERFUNDANDTOKEN.EXCESSAMOUNTUAT";
		    			// "SRNumber":""+SRNumber+"",
		    			String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationId\":\""+RegistrationId+"\"}";
		    			logger.info("getExcessAmount Called :: "+jsonString);
		    			activemqcall = new ActiveMQCall();
		    			// String correlationId = activemqcall.createRandomString();
		    			String correlationId = P_REQUEST_NUMBER;
		    			System.out.println("correlationId 1 :: " + correlationId);
		    			correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
		    			System.out.println("correlationId 2 :: " + correlationId);
		    			// TextMessage textMessage = new
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
		    				objX41.setPARAM_ID(RegistrationId);
		    				
		    				APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] { objX41 };
		    				body.setP_REQUEST_MESSAGE(arr);
		    				
		    				objMongoDB = new MongoDB();
		    		   		Date reqDate = new Date();
		    		   		
		    				OutputParameters param = port.PROCESS(header, body);
		    				// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
		    				// OutputParameters param = port.PROCESS(header, body);
		    				//
		    				//System.out.println("1::" + param.getX_RETURN_MESSAGE());
		    				System.out.println("Status ::" + param.getX_RETURN_STATUS());
		    				//System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
		    				objJSONObject.put("Status", param.getX_RETURN_STATUS());
		    				objJSONObject.put("Message", param.getX_RETURN_MESSAGE());
		    				logger.info("getExcessAmount :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "Status :: "+ param.getX_RETURN_STATUS() + "Return Message :: "+param.getX_RETURN_MESSAGE()+"Response Message :: "+param.getX_RESPONSE_MESSAGE());
		    				APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		    				for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
		    					System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
		    					System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		    					logger.info("getExcessAmount :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "i :: "+ i + "Param ID :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID() +"Attribute 1 :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
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
		    						objJSONObject.put("Excess_Amount", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		    						}else {
		    							objJSONObject.put("Excess_Amount", JSONObject.NULL);	
		    						}
		    						
		    						String requestString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+RegistrationId+"\"}";
			    					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), param.getX_RETURN_STATUS());

			    					
		    				}
		    				
		    				String response = activemqcall.GetConsumer(queueName);
		    				System.out.println("correlationId 3:: " + response);
		    				/*
		    				 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
		    				 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
		    				 * }); t1.start();
		    				 */
		    				

		    			} catch (Exception e) {
		    				//return e.getMessage();
		    				try {
		    				objJSONObject.put("Status", "E");
		    				objJSONObject.put("Message", e.getMessage());
		    				}catch (Exception ex) {
								// TODO: handle exception
							}
		    				//return objJSONObject.toString();

		    			}
		    			return objJSONObject.toString();

		 }
		
	    
	    public String getTokenRefunds(String P_REQUEST_NUMBER, String P_REQUEST_NAME, String P_SOURCE_SYSTEM,
				String RegistrationId){

			// PROCESS
			// url
			// getTokenRefunds?P_REQUEST_NUMBER=&P_REQUEST_NAME=TOKEN_REF_AMOUNTS&P_SOURCE_SYSTEM=SFDC&RegistrationId=
//http://localhost:8080/CRM_SR_NEW/services/CustomerFundAndToken/getTokenRefunds?P_REQUEST_NUMBER=22&P_REQUEST_NAME=TOKEN_REF_AMOUNTS&P_SOURCE_SYSTEM=SFDC&RegistrationId=92604
			final String queueName = "IPMS.COCD.GETTOKENREFUNDUAT";
			// "SRNumber":""+SRNumber+"",
			String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\"" + P_SOURCE_SYSTEM
					+ "\",\"RegistrationId\":\"" + RegistrationId + "\"}";
			logger.info("getTokenRefunds Called :: "+jsonString);
			activemqcall = new ActiveMQCall();
			// String correlationId = activemqcall.createRandomString();
			String correlationId = P_REQUEST_NUMBER;
			System.out.println("correlationId 1 :: " + correlationId);
			correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
			System.out.println("correlationId 2 :: " + correlationId);
			// TextMessage textMessage = new
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
				objX41.setPARAM_ID(RegistrationId);

				APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] { objX41 };
				body.setP_REQUEST_MESSAGE(arr);
				
				objMongoDB = new MongoDB();
		   		Date reqDate = new Date();
				OutputParameters param = port.PROCESS(header, body);
				// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
				// OutputParameters param = port.PROCESS(header, body);
				//
			//	System.out.println("1::" + param.getX_RETURN_MESSAGE());
				System.out.println("2::" + param.getX_RETURN_STATUS());
			//	System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
				objJSONObject.put("Status", param.getX_RETURN_STATUS());
				objJSONObject.put("Message", param.getX_RETURN_MESSAGE());
				logger.info("getTokenRefunds :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "Status :: "+ param.getX_RETURN_STATUS() + "Return Message :: "+param.getX_RETURN_MESSAGE()+"Response Message :: "+param.getX_RESPONSE_MESSAGE());
				String paramId = null;
				APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
				for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
					System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					
					logger.info("getTokenRefunds :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "i :: "+ i + "Param ID :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID() +"Attribute 1 :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					
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
					objJSONObject.put("Amount_Paid", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					}else {
						objJSONObject.put("Amount_Paid", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
					objJSONObject.put("Amount_COCA", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
					}else {
						objJSONObject.put("Amount_COCA", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
						objJSONObject.put("Excess_Amount", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
						}else {
							objJSONObject.put("Excess_Amount", JSONObject.NULL);	
						}
					
					
					String requestString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+RegistrationId+"\"}";
					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), param.getX_RETURN_STATUS());

				}
				String response = activemqcall.GetConsumer(queueName);
				System.out.println("correlationId 3:: " + response);
				/*
				 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
				 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
				 * }); t1.start();
				 */
//				return param.getX_RETURN_STATUS();

			} catch (Exception e) {
	//			return e.getMessage();
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
