package com.action;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;

public class Rule {
	public String getRuleEngineValues(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String RegistrationId)
	{
		ActiveMQCall activemqcall = null;

	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		
				String res = "";
				final String queueName = "IPMS.COCD.getRuleEngineValuesUAT";
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
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
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
						System.out.println("ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
						System.out.println("ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
						System.out.println("ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
						System.out.println("ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
						System.out.println("ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
						System.out.println("ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
						System.out.println("ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
						System.out.println("ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
						System.out.println("ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
						System.out.println("ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
						System.out.println("ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
						System.out.println("ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
						System.out.println("ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
						System.out.println("ATTRIBUTE24 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24());
						System.out.println("ATTRIBUTE25 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25());
						System.out.println("ATTRIBUTE26 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26());
						System.out.println("ATTRIBUTE27 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27());
						System.out.println("ATTRIBUTE28 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28());
						System.out.println("ATTRIBUTE29 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE29());
						System.out.println("ATTRIBUTE30 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30());
						System.out.println("ATTRIBUTE31 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31());
						System.out.println("ATTRIBUTE32 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32());
						System.out.println("ATTRIBUTE33 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33());
						System.out.println("ATTRIBUTE34 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34());

					
					
					
					
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

	

}
