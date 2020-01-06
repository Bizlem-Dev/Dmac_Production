package com.action;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;
import com.sfdc.CallingListSFDC;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class CallingList {

	final static Logger logger = Logger.getLogger(CallingList.class);
	//CallingListSFDC objCallingListSFDC = new CallingListSFDC(); 
	public String getNUpdateCollectionCallingListMonthly() {
		
			ActiveMQCall activemqcall = null;
		//retrive
			//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
			        String res = "";
					final String queueName = "IPMS.GETCOLLECTIONCALLINGLISTUAT";
					// "SRNumber":""+SRNumber+"",
				    activemqcall = new ActiveMQCall();
					 String correlationId = activemqcall.createRandomString();
					//String correlationId = P_REQUEST_NUMBER;

					//System.out.println("1 :: " + correlationId);
					correlationId = activemqcall.GetProducer(queueName, "", correlationId, "");
					try {
						
						XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
						XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

						SOAHeader header = new SOAHeader();

						com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
						body.setP_REQUEST_NUMBER(correlationId);
						body.setP_REQUEST_NAME("GET_COLLECTION_LIST");
						body.setP_SOURCE_SYSTEM("SFDC");

						APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
						body.setP_REQUEST_MESSAGE(objX4);
						com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
								.RETRIEVE(header, body);

						System.out.println(param.getX_RETURN_MESSAGE());
						System.out.println(param.getX_RETURN_STATUS());
						System.out.println(param.getX_RESPONSE_MESSAGE());
						APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
						JSONArray arr = new JSONArray();
						String blank = "";
						for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
							//for (int i = 0; i < 5; i++) {
							System.out.println("inside for");
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
							logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
						// call sfdc to update
//							objCallingListSFDC.UpdateCollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5(),
//									objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11(),
//									objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17(),
//									objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()
//									);
							CallingListSFDC.UpdateCollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i]);
					   }
						String response = activemqcall.GetConsumer(queueName);
						System.out.println("3 4:: " + response);
						/*
						 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
						 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
						 * }); t1.start();
						 */
					//	System.out.print("res   "+arr.toString());
					//	return arr.toString();

					} catch (Exception e) {
						//return e.getMessage();
						return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

					}
					
					return "true";

		
	}

	
	public String getNUpdateDPCollectionCallingListMonthly() {
		
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		        String res = "";
				final String queueName = "IPMS.GETDPCOLLECTIONCALLINGLISTUAT";
				// "SRNumber":""+SRNumber+"",
			    activemqcall = new ActiveMQCall();
				 String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				correlationId = activemqcall.GetProducer(queueName, "", correlationId, "");
				try {
					
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_DP_COLLECTION_LIST");
					body.setP_SOURCE_SYSTEM("SFDC");

					APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
					body.setP_REQUEST_MESSAGE(objX4);
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
					JSONArray arr = new JSONArray();
					String blank = "";
					for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
					//	for (int i = 0; i < 5; i++) {
						System.out.println("inside for");
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
					// call sfdc to update
//						objCallingListSFDC.UpdateCollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5(),
//								objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11(),
//								objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17(),
//								objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()
//								);
						CallingListSFDC.UpdateDPCollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i]);
				   }
					String response = activemqcall.GetConsumer(queueName);
					System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
				//	System.out.print("res   "+arr.toString());
				//	return arr.toString();

				} catch (Exception e) {
					//return e.getMessage();
					return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

				}
				
				return "true";

	
}

	
	public String getNUpdateRecoveryCollectionCallingListMonthly() {
		
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		        String res = "";
				final String queueName = "IPMS.GETRECOVERYLISTUAT";
				// "SRNumber":""+SRNumber+"",
			    activemqcall = new ActiveMQCall();
				 String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				correlationId = activemqcall.GetProducer(queueName, "", correlationId, "");
				try {
					
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_RECOVERY_LIST");
					body.setP_SOURCE_SYSTEM("SFDC");

					APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
					body.setP_REQUEST_MESSAGE(objX4);
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
					JSONArray arr = new JSONArray();
					String blank = "";
					for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
					//for (int i = 0; i < 5; i++) {
						System.out.println("inside for");
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
						logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
					// call sfdc to update
//						objCallingListSFDC.UpdateCollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5(),
//								objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11(),
//								objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17(),
//								objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22(),objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()
//								);
						CallingListSFDC.UpdateRecoveryCollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i]);
				   }
					String response = activemqcall.GetConsumer(queueName);
					System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
				//	System.out.print("res   "+arr.toString());
				//	return arr.toString();

				} catch (Exception e) {
					//return e.getMessage();
					return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

				}
				
				return "true";

	
}

	
	
	public String getNUpdateCollectionCallingListHourlySF() {
		
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		        String res = "";
				final String queueName = "IPMS.GETCOLLECTIONCALLINGLISTHOURLYSFUAT";
				// "SRNumber":""+SRNumber+"",
			    activemqcall = new ActiveMQCall();
				 String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				correlationId = activemqcall.GetProducer(queueName, "", correlationId, "");
				try {
					
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_COLLECTION_LIST");
					body.setP_SOURCE_SYSTEM("SFDC");

					APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
					body.setP_REQUEST_MESSAGE(objX4);
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
					JSONArray arr = new JSONArray();
					String blank = "";
					for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
						System.out.println("inside for");
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
						logger.info("CallingList getNUpdateCollectionCallingListHourlySF :: URN :: "+correlationId + " ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
					// call sfdc to update
						 
				   }
				//	String response = activemqcall.GetConsumer(queueName);
				//	System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
					System.out.print("res   "+arr.toString());
					return arr.toString();

				} catch (Exception e) {
					//return e.getMessage();
					return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

				}
				
				

	
}
	
public String getCollectionCallingListIPMS(String P_REQUEST_NUMBER,String RegId,String option1,String option2,String option3,String option4,String option5,String option6,String option7) {
		
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		        String res = "";
				final String queueName = "IPMS.GETCOLLECTIONCALLINGLISTHOURLYUAT";
				// "SRNumber":""+SRNumber+"",
			    activemqcall = new ActiveMQCall();
				 //String correlationId = activemqcall.createRandomString();
				String correlationId = P_REQUEST_NUMBER;
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				correlationId = activemqcall.GetProducer(queueName, "", correlationId, "");
				try {
					
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_COLLECTION_LIST");
					body.setP_SOURCE_SYSTEM("SFDC");

					APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
					objX4.setPARAM_ID(RegId);
					body.setP_REQUEST_MESSAGE(objX4);
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
					JSONArray arr = new JSONArray();
					String blank = "";
					System.out.println("Length :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56.length);
					arr.put(objAPPSXXDC_PROCESS_SEX1794747X2X56.length);
					if(objAPPSXXDC_PROCESS_SEX1794747X2X56.length == 0) {
						res="{\"ATTRIBUTE2\":\"0\",\"ATTRIBUTE5\":\"0\",\"ATTRIBUTE6\":\"0\",\"ATTRIBUTE13\":\"0\",\"ATTRIBUTE14\":\"0\",\"ATTRIBUTE15\":\"0\",\"ATTRIBUTE16\":\"0\",\"ATTRIBUTE17\":\"0\",\"ATTRIBUTE18\":\"0\",\"ATTRIBUTE19\":\"0\",\"ATTRIBUTE20\":\"0\",\"ATTRIBUTE21\":\"0\",\"ATTRIBUTE22\":\"0\",\"ATTRIBUTE23\":\"0\"}";
					}
					for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
						System.out.println("inside for");
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
						logger.info("CallingList getNUpdateCollectionCallingListHourly :: URN :: "+correlationId + " ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
						//res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\"}";
						//if(RegId.equals(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11())) {
						  res="{\"ATTRIBUTE2\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2()+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\"}";
						//}
						//arr.put(res);
				   }
				//	String response = activemqcall.GetConsumer(queueName);
				//	System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
					//System.out.print("res   :: "+arr.toString());
					return res;

				} catch (Exception e) {
					//return e.getMessage();
					return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

				}
				
				

	
}

public String getNUpdateSPACallingListMonthly() {
	
	ActiveMQCall activemqcall = null;
//retrive
	//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
	        String res = "";
			final String queueName = "IPMS.GETSPACALLINGLISTUAT";
			// "SRNumber":""+SRNumber+"",
		    activemqcall = new ActiveMQCall();
			 String correlationId = activemqcall.createRandomString();
			//String correlationId = P_REQUEST_NUMBER;

			//System.out.println("1 :: " + correlationId);
			correlationId = activemqcall.GetProducer(queueName, "", correlationId, "");
			try {
				
				XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
				XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

				SOAHeader header = new SOAHeader();

				com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
				body.setP_REQUEST_NUMBER(correlationId);
				body.setP_REQUEST_NAME("GET_SPA_CALLING_LIST");
				body.setP_SOURCE_SYSTEM("SFDC");

				APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
				body.setP_REQUEST_MESSAGE(objX4);
				com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
						.RETRIEVE(header, body);

				System.out.println(param.getX_RETURN_MESSAGE());
				System.out.println(param.getX_RETURN_STATUS());
				System.out.println(param.getX_RESPONSE_MESSAGE());
				APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
				JSONArray arr = new JSONArray();
				String blank = "";
				for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
					//for (int i = 0; i < 5; i++) {
					System.out.println("inside for");
					logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
					logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
					logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
					logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
					logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
					logger.info("CallingList getNUpdateCollectionCallingListMonthly :: URN :: "+correlationId + " ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
					
				// call sfdc to update
					CallingListSFDC.UpdateSPACollectionCallingListMonthly(objAPPSXXDC_PROCESS_SEX1794747X2X56[i]);
			   }
				String response = activemqcall.GetConsumer(queueName);
				System.out.println("3 4:: " + response);
				/*
				 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
				 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
				 * }); t1.start();
				 */
			//	System.out.print("res   "+arr.toString());
			//	return arr.toString();

			} catch (Exception e) {
				//return e.getMessage();
				return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

			}
			
			return "true";


}


	
}
