package com.action;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;
import com.sfdc.BouncedChequeSFDC;

public class BouncedCheque {


	final static Logger logger = Logger.getLogger(BouncedCheque.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	
	public String BouncedChequeProcess(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM)
	{//BOUNCREDCHEQUE
		// retrive
					String res = "";
					final String queueName = "IPMS.BOUNCREDCHEQUE.BOUNCEDCHEQUEPROCESSUAT" + 
							"";
					// "SRNumber":""+SRNumber+"",
					String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NUMBER + "\",\"P_REQUEST_NAME\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\"}";
						activemqcall = new ActiveMQCall();
					 String correlationId = activemqcall.createRandomString();
					//String correlationId = P_REQUEST_NUMBER;

					System.out.println("1 :: " + correlationId);
					//id not given *************
					correlationId = activemqcall.GetProducer(queueName, "", correlationId, jsonString);
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
						//objX4.setPARAM_ID("");

						body.setP_REQUEST_MESSAGE(objX4);
						com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
								.RETRIEVE(header, body);

						//System.out.println(param.getX_RETURN_MESSAGE());
						//System.out.println(param.getX_RETURN_STATUS());
						//System.out.println(param.getX_RESPONSE_MESSAGE());
						APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
						//System.out.println(objAPPSXXDC_PROCESS_SEX1794747X2X56.length);
						//BouncedChequeSFDC objBouncedChequeSFDC = new BouncedChequeSFDC();
						logger.info("BouncedChequeProcess X_RETURN_MESSAGE :: "+param.getX_RETURN_MESSAGE());
						logger.info("BouncedChequeProcess X_RETURN_STATUS :: "+param.getX_RETURN_STATUS());
						logger.info("BouncedChequeProcess Bounced Cheque List Total :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56.length);
						for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
							//System.out.println("ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
						//	objAPPSXXDC_PROCESS_SEX1794747X2X56[i].
							logger.info("BouncedChequeProcess ATTRIBUTE1 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
							logger.info("BouncedChequeProcess ATTRIBUTE2 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
							logger.info("BouncedChequeProcess ATTRIBUTE3 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
							logger.info("BouncedChequeProcess ATTRIBUTE4 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
							logger.info("BouncedChequeProcess ATTRIBUTE5 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
							logger.info("BouncedChequeProcess ATTRIBUTE6 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
							logger.info("BouncedChequeProcess ATTRIBUTE7 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
							logger.info("BouncedChequeProcess ATTRIBUTE8 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
							String CaseId = BouncedChequeSFDC.bouncedChequeCase(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2(), objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6(), objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3(), 
									objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7(), objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4(), objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8(), 
									objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(), objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
							logger.info("BouncedChequeProcess CaseId :: "+CaseId);
							this.BouncedChequeUnit("123", "XXDC_GET_BC_UNITS", "SFDC", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(), CaseId);
							String CaseNumber = BouncedChequeSFDC.getCaseNumber(CaseId);
							logger.info("BouncedChequeProcess CaseNumber :: "+CaseNumber);
							System.out.println("CaseNumber :: "+CaseNumber);
							if(CaseNumber != null) {
								this.updateBouncedChequeLine("2-123", "UPDATE_BOUNCE_CHQ_WITH_SR", "SFDC", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(), CaseNumber);
							}
						}
						BouncedChequeSFDC.closeConnection();
						String response = activemqcall.GetConsumer(queueName);
						System.out.println("3 4:: " + response);
						/*
						 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
						 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
						 * }); t1.start();
						 */
						return param.getX_RETURN_STATUS();

					} catch (Exception e) {
						logger.info("BouncedChequeProcess Exception :: " + e.getMessage());
						return e.getMessage();

					}

		
	}
	
	public String BouncedChequeUnit(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String ReceiptId,String CaseId)
	{//BOUNCREDCHEQUE
		// retrive
		
					String res = "";
					final String queueName = "IPMS.BOUNCREDCHEQUE.BOUNCEDCHEQUEUNITUAT";
					// "SRNumber":""+SRNumber+"",
					String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"ReceiptId\":\""+ReceiptId+"\",\"CaseId\":\""+CaseId+"\"}";
						activemqcall = new ActiveMQCall();
					 String correlationId = activemqcall.createRandomString();
					//String correlationId = P_REQUEST_NUMBER;

					System.out.println("1 :: " + correlationId);
					//id not given *************
					correlationId = activemqcall.GetProducer(queueName, "", correlationId, jsonString);
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
						objX4.setPARAM_ID(ReceiptId);

						body.setP_REQUEST_MESSAGE(objX4);
						com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
								.RETRIEVE(header, body);

						System.out.println(param.getX_RETURN_MESSAGE());
						System.out.println(param.getX_RETURN_STATUS());
						System.out.println(param.getX_RESPONSE_MESSAGE());
						logger.info("BouncedChequeUnit X_RETURN_MESSAGE :: "+param.getX_RETURN_MESSAGE());
						logger.info("BouncedChequeUnit X_RETURN_STATUS :: "+param.getX_RETURN_STATUS());
						APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
						logger.info("BouncedChequeUnit BouncedCheque Unit Total :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56.length);
						//BouncedChequeSFDC objBouncedChequeSFDC = new BouncedChequeSFDC();
						for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
							//System.out.println("ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
							logger.info("BouncedChequeUnit Attribute1 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
							BouncedChequeSFDC.bookingUnit(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1(), CaseId);
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
						 logger.info("BouncedChequeUnit Exception :: " + e.getMessage());
						return e.getMessage();

					}

		
	}
	
	public String BouncedChequeReason(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String PARAM_ID)
	{

	// process
			final String queueName = "IPMS.BOUNCREDCHEQUE.BOUNCEDCHEQUEREASONUAT";
			// "SRNumber":""+SRNumber+"",
			
			String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\"" +PARAM_ID + "\"}";
			activemqcall = new ActiveMQCall();
		    String correlationId = activemqcall.createRandomString();
			//String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: " + correlationId);
			correlationId = activemqcall.GetProducer(queueName, PARAM_ID, correlationId, jsonString);
			System.out.println("2 :: " + correlationId);
			String attr1 = "";
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
				objX41.setPARAM_ID(PARAM_ID);
				
				APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] { objX41 };
				body.setP_REQUEST_MESSAGE(arr);
				OutputParameters param = port.PROCESS(header, body);
				// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
				// OutputParameters param = port.PROCESS(header, body);
				//
				System.out.println("1::" + param.getX_RETURN_MESSAGE());
				System.out.println("2::" + param.getX_RETURN_STATUS());
				System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
				APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
				for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
					System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
					attr1 = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();
				}
				String response = activemqcall.GetConsumer(queueName);
				System.out.println("3 4:: " + response);
				/*
				 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
				 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
				 * }); t1.start();
				 */
				return attr1;

			} catch (Exception e) {
				return e.getMessage();

			}

	
	}
	
	public String updateBouncedChequeLine(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String ChequeId,String CaseNumber)
	{
		String res="updateBouncedChequeLine";
		//process
		// BouncedCheque/updateBouncedChequeLine?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&ChequeId=&CaseNumber=
		
		final String queueName = "IPMS.BOUNCREDCHEQUE.UPDATEBOUNCEDCHEQUELINEUAT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"ChequeId\":\""+ChequeId+"\",\"CaseNumber\":\""+CaseNumber+"\"}";
		activemqcall = new ActiveMQCall();
		 String correlationId = activemqcall.createRandomString();
		//String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, ChequeId, correlationId, jsonString);
		System.out.println("2 :: " + correlationId);
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
			objX41.setPARAM_ID(ChequeId);
			objX41.setATTRIBUTE1(CaseNumber);
			APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] { objX41 };
			body.setP_REQUEST_MESSAGE(arr);
			OutputParameters param = port.PROCESS(header, body);
			// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
			// OutputParameters param = port.PROCESS(header, body);
			//
			System.out.println("1::" + param.getX_RETURN_MESSAGE());
			System.out.println("2::" + param.getX_RETURN_STATUS());
			System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
			logger.info("updateBouncedChequeLine X_RETURN_MESSAGE :: "+param.getX_RETURN_MESSAGE());
			logger.info("updateBouncedChequeLine X_RETURN_STATUS :: "+param.getX_RETURN_STATUS());
			
			APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			logger.info("updateBouncedChequeLine Bounced Cheque List Total :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57.length);
			for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				logger.info("updateBouncedChequeLine ParamId :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				logger.info("updateBouncedChequeLine PROC_MESSAGE :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
				logger.info("updateBouncedChequeLine PROC_STATUS :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
//				logger.info("updateBouncedChequeLine ParamId :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
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
			logger.info("updateBouncedChequeLine Exception :: "+e.getMessage());
			return e.getMessage();

		}

				
			
	}
	
	
}
