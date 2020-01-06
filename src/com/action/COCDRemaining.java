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

public class COCDRemaining {
	final static Logger logger = Logger.getLogger(COCDRemaining.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	
	public String getCurrentPaymentPlanDetail(String P_REQUEST_NUMBER, String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String REGISTERATION_ID) {
		
		//getCurrentPaymentPlanDetail?P_REQUEST_NUMBER=r22&P_REQUEST_NAME=GET_REG_PAYMENT_TERMS&P_SOURCE_SYSTEM=SFDC&REGISTERATION_ID=41
		
		String res="";
		final String queueName = "IPMS.COCD.GETCURRENTPAYMENTPLANDETAIL";
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"REGISTERATION_ID\":\""+REGISTERATION_ID+"\"}";
   		
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = P_REQUEST_NUMBER;

   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,REGISTERATION_ID,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   	//TextMessage textMessage = new 
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		SOAHeader header = new SOAHeader();
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
   		
   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
   		objX4.setPARAM_ID(REGISTERATION_ID);
   		
   		
		body.setP_REQUEST_MESSAGE(objX4);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
		
		System.out.println(param.getX_RETURN_MESSAGE());
		System.out.println(param.getX_RETURN_STATUS());
		System.out.println(param.getX_RESPONSE_MESSAGE());
		APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X2X56.length;i++) {
			System.out.println("ATTRIBUTE1 Response :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
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
   		return param.getX_RETURN_STATUS();

   		}catch (Exception e) {
   			return e.getMessage();
   			
   		}
		
	}
	public  String GenCustomerStatement(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String SourceSystenId, String stageID, String batchname, String registerationid) {
		//process
		/*GenCustomerStatment?P_REQUEST_NUMBER=r33&P_REQUEST_NAME=DP_SOA&P_SOURCE_SYSTEM=SFDC&SourceSystenId=&stageID=&batchname=&registerationid=42
		 */
		final String queueName = "IPMS.COCD.GENERATECUSTOMERSTATEMENT";
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"SourceSystemId\":\""+SourceSystenId+"\",\"stageID\":\""+stageID+"\",\"batchname\":\""+batchname+"\",\"registerationid\":\""+registerationid+"\"}";
		
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = P_REQUEST_NUMBER;
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,SourceSystenId,correlationId,jsonString);
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
   		objX41.setPARAM_ID(SourceSystenId);
   		objX41.setATTRIBUTE1(stageID);
   		objX41.setATTRIBUTE2(batchname);
   		objX41.setATTRIBUTE3(registerationid);
   		
   		
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
   		body.setP_REQUEST_MESSAGE(arr);
   		OutputParameters param = port.PROCESS(header, body);
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
//   		
   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
   		System.out.println("2::"+param.getX_RETURN_STATUS());
   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
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
   		return param.getX_RETURN_STATUS();

   		}catch (Exception e) {
   			return e.getMessage();
   			
   		}
		
	}

	
	
		     
    public String  SRDataToIPMS(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String SRNumber,String SRDataType,String SRName,String SRStatus
			,String SRCreator,String IPMSPartyId,String RegistrationId,String SRCreationDate,String SFDCTaskId,String TaskDueDate,String ValuesDependingOnSRType,String TaskCloseDate,String TaskCloseBy,String ApprovalStatus,String TaskComment,String SRNote)
	{
		// url    SRDataToIPMS?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&SRNumber=&SRDataType=&SRName=&SRStatus=&SRCreator=&IPMSPartyId=&RegistrationId=&SRCreationDate=&SFDCTaskId=&TaskDueDate=&ValuesDependingOnSRType=&TaskCloseDate=&TaskCloseBy=&ApprovalStatus=&TaskComment=&SRNote=
//process
		String res="SRDataToIPMS";
		final String queueName = "IPMS.COCD.SRDATATOIPMS";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+ P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"SRNumber\":\""+SRNumber+"\",\"SRDataType\":\""+SRDataType+"\",\"SRName\":\""+SRName+"\",\"SRStatus\":\""+SRStatus+"\",\"SRCreator\":\""+SRCreator+"\",\"IPMSPartyId\":\""+IPMSPartyId+"\",\"RegistrationId\":\""+RegistrationId+"\",\"SRCreationDate\":\""+SRCreationDate+"\",\"SFDCTaskId\":\""+SFDCTaskId+"\",\"TaskDueDate\":\""+TaskDueDate+"\",\"ValuesDependingOnSRType\":\""+ValuesDependingOnSRType+"\",\"TaskCloseDate\":\""+TaskCloseDate+"\",\"TaskCloseBy\":\""+TaskCloseBy+"\",\"ApprovalStatus\":\""+ApprovalStatus+"\",\"TaskComment\":\""+TaskComment+"\",\"SRNote\":\""+SRNote+"\"}";
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

			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(SRNumber);
		
			objX41.setATTRIBUTE1(SRDataType);
			//String SRName,String SRStatus
			//,String SRCreator,String IPMSPartyId,String RegistrationId,String SRCreationDate,String SFDCTaskId,String TaskDueDate,String ValuesDependingOnSRType,String TaskCloseDate,String TaskCloseBy,String ApprovalStatus,String TaskComment,String SRNote)
			
			objX41.setATTRIBUTE2(SRName);
			objX41.setATTRIBUTE3(SRStatus);
			objX41.setATTRIBUTE4(SRCreator);
			objX41.setATTRIBUTE5(IPMSPartyId);
			objX41.setATTRIBUTE6(RegistrationId);
			objX41.setATTRIBUTE7(SRCreationDate);
			objX41.setATTRIBUTE8(SFDCTaskId);
			objX41.setATTRIBUTE9(TaskDueDate);
			
			objX41.setATTRIBUTE10(ValuesDependingOnSRType);   //10.....39
			objX41.setATTRIBUTE46(TaskCloseBy);
			objX41.setATTRIBUTE47(ApprovalStatus);
			objX41.setATTRIBUTE48(ApprovalStatus);
			objX41.setATTRIBUTE49(TaskComment);
			objX41.setATTRIBUTE50(SRNote);
			
			
			

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
	
	
	
	
	public String generatePCC(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String RegistrationId,String StageId,String BatchName)
	
	{
		//PROCESS
// url         generatePCC?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&RegistrationId=&stageId=&BatchName=
		
		
		
		final String queueName = "IPMS.COCD.GENETAREPCC";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationId\":\""+RegistrationId+"\",\"StageId\":\""+StageId+"\",\"BatchName\":\""+BatchName+"\"}";
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

			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(RegistrationId);
			objX41.setATTRIBUTE1(StageId);
			objX41.setATTRIBUTE2(BatchName);
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
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());


			
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
	

    public String getPDCDetails(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String RegistrationId)
    {
	
	// url         generatePCC?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&RegistrationId=
	
		// retrive
			String res = "";
			final String queueName = "IPMS.COCD.GETPDCDETAILS";
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

    public String LetterofDischarge(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String RegistrationId, String StageId, String BatchName) {
    	//PROCESS
    	// url         LetterofDischarge?P_REQUEST_NUMBER=&P_REQUEST_NAME=LETTER_OF_DISCHARGE&P_SOURCE_SYSTEM=&RegistrationId=&stageId=&BatchName=
    					
    			final String queueName = "IPMS.COCD.LETTEROFDISCHARGE";
    			// "SRNumber":""+SRNumber+"",
    			String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"RegistrationId\":\""+RegistrationId+"\",\"StageId\":\""+StageId+"\",\"BatchName\":\""+BatchName+"\"}";
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

    				InputParameters body = new InputParameters();
    				body.setP_REQUEST_NUMBER(correlationId);
    				body.setP_REQUEST_NAME(P_REQUEST_NAME);
    				body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
    				APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
    				objX41.setPARAM_ID(RegistrationId);
    				objX41.setATTRIBUTE1(StageId);
    				objX41.setATTRIBUTE2(BatchName);
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

    public String TotalPenaltyWaiver(String P_REQUEST_NUMBER, String P_REQUEST_NAME, String P_SOURCE_SYSTEM,
			String RegistrationId)

	{

		// PROCESS
		// url
		// getTokenRefunds?P_REQUEST_NUMBER=&P_REQUEST_NAME=TOTAL_PENALTY_WAIVER&P_SOURCE_SYSTEM=SFDC&RegistrationId=

		final String queueName = "IPMS.COCD.TOTALPENALTYWAIVER";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\"" + P_SOURCE_SYSTEM
				+ "\",\"RegistrationId\":\"" + RegistrationId + "\"}";
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

			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(RegistrationId);

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

	public String getTokenRefunds(String P_REQUEST_NUMBER, String P_REQUEST_NAME, String P_SOURCE_SYSTEM,
			String RegistrationId)

	{

		// PROCESS
		// url
		// getTokenRefunds?P_REQUEST_NUMBER=&P_REQUEST_NAME=TOKEN_REF_AMOUNTS&P_SOURCE_SYSTEM=SFDC&RegistrationId=

		final String queueName = "IPMS.COCD.GETTOKENREFUND";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\"" + P_SOURCE_SYSTEM
				+ "\",\"RegistrationId\":\"" + RegistrationId + "\"}";
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

			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(RegistrationId);

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
