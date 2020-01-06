package com.action;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
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

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class PenaltyWaiver {
	final static Logger logger = Logger.getLogger(PenaltyWaiver.class);
	public com.activeMQ.ActiveMQCall activemqcall = null;
	public com.activeMQ.ActiveMQCall connection = null;
	MongoDB objMongoDB =null;
	public String PenaltyWaiverDetails(String RegistrationId, String ProcessName, String SubProcessName,
		 String ProjectCity,String NotApplicableCity, String Project, String BuildingCode, String BedroomType,
		 String UnitType, String PermittedUse, String Units, String ReadyOffPlan, String ApplicableNationality,
		 String CustomerClassification,String AgreementStatus,
		String CumulativePenaltyWaiverUnit,String CumulativePenaltyWaiverPercent,String PenaltyAmount,
		String extrastring1,String extrastring2,String extrastring3,String extrastring4,
		float extrafloat1,float extrafloat2,float extrafloat3,float extrafloat4
		)
	{
		String res = "PenaltyWaiverDetails";

// http://localhost:8080/CRM_SR_NEW/services/PenaltyWaiverRule/PenaltyWaiverDetails?RegistrationId=&ProcessName=&SubProcessName=&ProjectCity=&NotApplicableCity=&Project=&BuildingCode=&BedroomType=&UnitType=&PermittedUse=&Units=&ReadyOffPlan=&ApplicableNationality=&CustomerClassification=
		try {
		/*String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
				+ "\",\"SubProcessName\":\"" + SubProcessName + "\","
				+ "\"ProjectCity\":\"" + ProjectCity + "\",\"NotApplicableCity\":\"" + NotApplicableCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"BedroomType\":\"" + BedroomType + "\",\"UnitType\":\"" + UnitType
				+ "\",\"PermittedUse\":\"" + PermittedUse + "\",\"Units\":\"" + Units + "\"," + "\"ReadyOffPlan\":\""
				+ ReadyOffPlan + "\",\"ApplicableNationality\":\"" + ApplicableNationality
				+ "\",\"CustomerClassification\":\"" + CustomerClassification + "\"}";
		*/
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
				+ "\",\"SubProcessName\":\"" + SubProcessName + "\","
				+ "\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"BedroomType\":\"" + BedroomType + "\",\"UnitType\":\"" + UnitType
				+ "\",\"PermittedUse\":\"" + PermittedUse + "\",\"Units\":\"" + Units + "\"," + "\"ReadyOffPlan\":\""
				+ ReadyOffPlan + "\",\"ApplicableNationality\":\"" + ApplicableNationality
				+ "\",\"CustomerClassification\":\"" + CustomerClassification + "\""
				+",\"AgreementStatus\":\"" + AgreementStatus + "\""
				   +",\"CumulativePenaltyWaiverUnit\":\"" + CumulativePenaltyWaiverUnit + "\""
				   +",\"CumulativePenaltyWaiverPercent\":\"" + CumulativePenaltyWaiverPercent + "\""
				   +",\"PenaltyAmount\":\"" + PenaltyAmount + "\""
				   +",\"extrastring1\":\"" + extrastring1 + "\""
				   +",\"extrastring2\":\"" + extrastring2 + "\""
				   +",\"extrastring3\":\"" + extrastring3 + "\""
				   +",\"extrastring4\":\"" + extrastring4 + "\""
				   +",\"extrafloat1\":\"" + extrafloat1 + "\""
				   +",\"extrafloat2\":\"" + extrafloat2 + "\""
				   +",\"extrafloat3\":\"" + extrafloat3 + "\""
				   +",\"extrafloat4\":\"" + extrafloat4 + "\""
						+ "}";
		System.out.println(jsonString);
		
		activemqcall = new ActiveMQCall();
		// \"\":\"\"++\"\"
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("PENALTYWAIVERRULE.RULE.PENALTYWAIVERDETAILSUAT"); // **************queue name***************
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

		/* MessageListener listener = new MessageListener() {

			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				String messageText = null;
				try {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						messageText = textMessage.getText();
						System.out.println("messageText = " + messageText);
						System.out.println("listener");

					}
				} catch (JMSException e) {
					// Handle the exception appropriately
				}
			}

		};

		responseConsumer.setMessageListener(listener);   */

		TextMessage message = session.createTextMessage();
		message.setText(jsonString);
		// Set the reply to field to the temp queue you created above, this is the queue
		// the server
		// will respond to
		message.setJMSReplyTo(tempDest);

		String correlationId = activemqcall.createRandomString();
		// String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: " + correlationId);
		message.setJMSCorrelationID(correlationId);

		// Tell the producer to send the message
		System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);

		// ((Object) producer).send(message);
		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
		producer.send(message);
		
		TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
		System.out.println("message :: "+objTextMsg.getText());
		//System.out.println("success");
		while(true) {
			if(objTextMsg.getText() != null) {
				System.out.println("message if :: "+objTextMsg);
				res = objTextMsg.getText();
				
				String requestString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
						+ "\",\"SubProcessName\":\"" + SubProcessName + "\","
						+ "\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
						+ BuildingCode + "\",\"BedroomType\":\"" + BedroomType + "\",\"UnitType\":\"" + UnitType
						+ "\",\"PermittedUse\":\"" + PermittedUse + "\",\"Units\":\"" + Units + "\"," + "\"ReadyOffPlan\":\""
						+ ReadyOffPlan + "\",\"ApplicableNationality\":\"" + ApplicableNationality
						+ "\",\"CustomerClassification\":\"" + CustomerClassification + "\""
						+",\"AgreementStatus\":\"" + AgreementStatus + "\""
						   +",\"CumulativePenaltyWaiverUnit\":\"" + CumulativePenaltyWaiverUnit + "\""
						   +",\"CumulativePenaltyWaiverPercent\":\"" + CumulativePenaltyWaiverPercent + "\""
						   +",\"PenaltyAmount\":\"" + PenaltyAmount + "\""
						   +",\"extrastring1\":\"" + extrastring1 + "\""
						   +",\"extrastring2\":\"" + extrastring2 + "\""
						   +",\"extrastring3\":\"" + extrastring3 + "\""
						   +",\"extrastring4\":\"" + extrastring4 + "\""
						   +",\"extrafloat1\":\"" + extrafloat1 + "\""
						   +",\"extrafloat2\":\"" + extrafloat2 + "\""
						   +",\"extrafloat3\":\"" + extrafloat3 + "\""
						   +",\"extrafloat4\":\"" + extrafloat4 + "\""
								+ "}";
								objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, "s");
				
				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		


		System.out.println("success");
		}
		catch(Exception e)
		{
			System.out.println("error ::"+e.getMessage());
		}
		return res;

	}

	public String TotalPenaltyWaiver(String P_REQUEST_NUMBER, String P_REQUEST_NAME, String P_SOURCE_SYSTEM,
			String RegistrationId)

	{

		// PROCESS
		// url
		// getTokenRefunds?P_REQUEST_NUMBER=&P_REQUEST_NAME=TOTAL_PENALTY_WAIVER&P_SOURCE_SYSTEM=SFDC&RegistrationId=

		final String queueName = "IPMS.COCD.TOTALPENALTYWAIVERUAT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\"" + P_SOURCE_SYSTEM
				+ "\",\"RegistrationId\":\"" + RegistrationId + "\"}";
		logger.info("TotalPenaltyWaiver Called :: "+jsonString);
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
			System.out.println("1::" + param.getX_RETURN_MESSAGE());
			//System.out.println("2::" + param.getX_RETURN_STATUS());
			//System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
			objJSONObject.put("Status", param.getX_RETURN_STATUS());
			objJSONObject.put("Message", param.getX_RETURN_MESSAGE());
			logger.info("TotalPenaltyWaiver :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "Status :: "+ param.getX_RETURN_STATUS() + "Return Message :: "+param.getX_RETURN_MESSAGE()+"Response Message :: "+param.getX_RESPONSE_MESSAGE());
			APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				logger.info("TotalPenaltyWaiver :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "i :: "+ i + "Param ID :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID() +"Attribute 1 :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
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
					objJSONObject.put("Penalty_Waive_Amount", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					}else {
						objJSONObject.put("Penalty_Waive_Amount", JSONObject.NULL);	
					}
					
					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+RegistrationId+"\"}";
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), "s");
					
			}
			String response = activemqcall.GetConsumer(queueName);
			System.out.println("correlationId consumer:: " + response);
			/*
			 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
			 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
			 * }); t1.start();
			 */
		//	return param.getX_RETURN_STATUS();

		} catch (Exception e) {
			//return e.getMessage();
			try {
				objJSONObject.put("Status", "E");
				objJSONObject.put("Message", e.getMessage());
				}catch (Exception ex) {
					// TODO: handle exception
				}
		}
		return objJSONObject.toString();

	}

	public String GeneratePenaltyStatment( String P_REQUEST_NUMBER, String P_REQUEST_NAME, String P_SOURCE_SYSTEM,String PARAM_ID, String STAGE_ID,String Batch_Name) {
		final String queueName = "IPMS.COCD.GeneratePenaltyStatmentUAT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\"" + P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\"" + P_SOURCE_SYSTEM
				+ "\",\"PARAM_ID\":\"" + PARAM_ID + "\"}";
		logger.info("TotalPenaltyWaiver Called :: "+jsonString);
		activemqcall = new ActiveMQCall();
		// String correlationId = activemqcall.createRandomString();
		String correlationId = P_REQUEST_NUMBER;
		System.out.println("correlationId 1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, PARAM_ID, correlationId, jsonString);
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
			objX41.setPARAM_ID(PARAM_ID);
			objX41.setATTRIBUTE1(STAGE_ID);
	 		objX41.setATTRIBUTE2(Batch_Name);
	 		//objX41.setATTRIBUTE3(RegistrationId);
			APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] { objX41 };
			body.setP_REQUEST_MESSAGE(arr);
			objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		
	   		
			OutputParameters param = port.PROCESS(header, body);
			// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
			// OutputParameters param = port.PROCESS(header, body);
			//
			System.out.println("1::" + param.getX_RETURN_MESSAGE());
			//System.out.println("2::" + param.getX_RETURN_STATUS());
			//System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
			objJSONObject.put("Status", param.getX_RETURN_STATUS());
			objJSONObject.put("Message", param.getX_RETURN_MESSAGE());
			logger.info("generatePenaltyStatment :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "Status :: "+ param.getX_RETURN_STATUS() + "Return Message :: "+param.getX_RETURN_MESSAGE()+"Response Message :: "+param.getX_RESPONSE_MESSAGE());
			APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				logger.info("generatePenaltyStatment :: "+"P_REQUEST_NUMBER :: "+P_REQUEST_NUMBER + "i :: "+ i + "Param ID :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID() +"Attribute 1 :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
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
					objJSONObject.put("URL", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					}else {
						objJSONObject.put("URL", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() !=null) {
						objJSONObject.put("REQUEST_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
						}else {
							objJSONObject.put("REQUEST_ID", JSONObject.NULL);	
						}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() !=null) {
						objJSONObject.put("STAGE_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
						}else {
							objJSONObject.put("STAGE_ID", JSONObject.NULL);	
						}
					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+PARAM_ID+"\",\"STAGE_ID\":\""+STAGE_ID+"\",\"Batch_Name\":\""+Batch_Name+"\"}";
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					
					
					
			}
			String response = activemqcall.GetConsumer(queueName);
			System.out.println("correlationId consumer:: " + response);
			/*
			 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
			 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
			 * }); t1.start();
			 */
		//	return param.getX_RETURN_STATUS();

		} catch (Exception e) {
			//return e.getMessage();
			try {
				objJSONObject.put("Status", "E");
				objJSONObject.put("Message", e.getMessage());
				}catch (Exception ex) {
					// TODO: handle exception
				}
		}
		return objJSONObject.toString();

        }
	
	 public  String UpdatePenaltyWaived(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
			//process
				/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
				 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
				 */
			//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
			//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
				final String queueName = "IPMS.UpdatePenaltyWaivedUAT";
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
		   		JSONObject objJSONObject = null;
		   		JSONArray arrR = new JSONArray();
		   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		   			objJSONObject = new JSONObject();
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
						if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
							objJSONObject.put("Transaction_Number", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
							}else {
								objJSONObject.put("Transaction_Number", JSONObject.NULL);	
							}
						arrR.put(objJSONObject);
						
						
						String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\"}";
						objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", objJSONObject.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());

		   		}
		   		result.put("data", arrR);
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
