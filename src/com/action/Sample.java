package com.action;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters;

public class Sample {

	public static void main(String[] args) {
		try {
			
			
		// TODO Auto-generated method stub
			
			/*XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
			XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
			
			SOAHeader header = new SOAHeader();
			
			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER("1-1211111");
			body.setP_REQUEST_NAME("GET_CUSTOMER_PAYMENT_MADE");
			body.setP_SOURCE_SYSTEM("SFDC");
			APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
			objX4.setPARAM_ID("69326");
			
			body.setP_REQUEST_MESSAGE(objX4);
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
			
			System.out.println(param.getX_RETURN_MESSAGE());
			System.out.println(param.getX_RETURN_STATUS());
			System.out.println(param.getX_RESPONSE_MESSAGE());
			
			*/
			Sample objSample = new Sample();
			objSample.getRuleEngineValues("10745","123456344535");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
	
	public String getRuleEngineValues(String RegistrationId, String correlationId)
	{
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		System.out.println("in method");
				String res = "";
				final String queueName = "IPMS.Rules";
				// "SRNumber":""+SRNumber+"",
				//String jsonString = "{\"RegistrationId\":\""+RegistrationId+"\"}";
				//	activemqcall = new ActiveMQCall();
				// String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				//correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
				//System.out.println("2 :: " + correlationId);
				// TextMessage textMessage = new
				try {
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_RULE_ATTRIBUTES");
					body.setP_SOURCE_SYSTEM("SFDC");

					APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
					objX4.setPARAM_ID(RegistrationId);

					body.setP_REQUEST_MESSAGE(objX4);
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
					System.out.println("length  "+objAPPSXXDC_PROCESS_SEX1794747X2X56.length);
					for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
						System.out.println("inside for");
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
						 res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\",\"ATTRIBUTE24\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24()+"\",\"ATTRIBUTE25\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25()+"\",\"ATTRIBUTE26\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26()+"\",\"ATTRIBUTE27\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27()+"\",\"ATTRIBUTE28\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28()+"\",\"ATTRIBUTE29\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE29()+"\",\"ATTRIBUTE30\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30()+"\",\"ATTRIBUTE31\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31()+"\",\"ATTRIBUTE32\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32()+"\",\"ATTRIBUTE33\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33()+"\",\"ATTRIBUTE34\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34()+"\",\"ATTRIBUTE35\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE35()+"\",\"ATTRIBUTE36\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE36()+"\",\"ATTRIBUTE37\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE37()+"\",\"ATTRIBUTE38\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE38()+"\",\"ATTRIBUTE39\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE39()+"\",\"ATTRIBUTE40\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE40()+"\"}";

					System.out.print("res   "+res);
					
									}
				//	String response = activemqcall.GetConsumer(queueName);
				//	System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
					return res;

				} catch (Exception e) {
					return e.getMessage();

				}
	}

}
