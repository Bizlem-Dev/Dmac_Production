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

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class PlotHandover {
	final static Logger logger = Logger.getLogger(COCD.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB	objMongoDB=null;
    public  String commencementCondition(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,
			String Registrationid ) 
	{//process
    	
		/*commencementCondition?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=GET_CONDITIONS_FOR_COMMENCMENT&P_SOURCE_SYSTEM=SFDC&Registrationid=8765
		
*/
		final String queueName = "IPMS.PLOTHANDOVER.COMMENCEMENTCONDITIONUAT";
		logger.info("queueName :: "+queueName);

   		//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
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
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
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
   			logger.info("attr 1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
   			logger.info("attr 2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
   			logger.info("attr 3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
   			logger.info("attr 4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
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
					result.put("AMOUNT", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					}else {
						result.put("AMOUNT", JSONObject.NULL);	
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
					result.put("AMOUNT_PDC", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
					}else {
						result.put("AMOUNT_PDC", JSONObject.NULL);	
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
					result.put("CHEQUE_NUMBERS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
					}else {
						result.put("CHEQUE_NUMBERS", JSONObject.NULL);	
					}
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4() != null) {
					result.put("BANK_NAME", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
					}else {
						result.put("BANK_NAME", JSONObject.NULL);	
					}
				

				String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+Registrationid+"\"}";
				
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
    
    public  String invoiceAmountAreavariation(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,
			String Registrationid ) 
	{//process
    	
		/*invoiceamountOnareavariation?P_REQUEST_NUMBER=r11&P_REQUEST_NAME=GET_INVOICE_AMOUNT_ON_AREA_VARIATION&P_SOURCE_SYSTEM=SFDC&Registrationid=8765
		
*/
		final String queueName = "IPMS.PLOTHANDOVER.INVOICEAMOUNTONAREAVARIATIONUAT";
		logger.info("queueName :: "+queueName);

   		//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
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
//   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//   		OutputParameters param = port.PROCESS(header, body);
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
   			logger.info("attr 1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
   			logger.info("attr 2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
   			logger.info("attr 3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
   			logger.info("attr 4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
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
					result.put("INVOICE_AMOUNT", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
					}else {
						result.put("INVOICE_AMOUNT", JSONObject.NULL);	
					}
				 String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+Registrationid+"\"}";
					
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
   
    public  String UpdatePlotHandoverDetails(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.UpdatePlotHandoverDetailsUAT";
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
					

					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+regTerms[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+regTerms[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+regTerms[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+regTerms[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+regTerms[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+regTerms[i].getATTRIBUTE8()+"\"}";
						
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					
					
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

    
    public  String GetPlotHandoverDetails(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.GetPlotHandoverDetailsUAT";
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
					

					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\"}";
						
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					
					
					
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
    
    public  String getFacilityDue(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String Registrationid, String caseno,String option1,String option2,String option3,String option4,String option5) {
		/*http://localhost:8080/CRM_SR_NEW/services/Assignment/getFacilityDue?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=FACILITY_DUE_YN&P_SOURCE_SYSTEM=SFDC&Registrationid=12345
		 */
		//process
		String res=null;
				final String queueName = "IPMS.ASSIGNMENT.GETFACILITYDUEUAT";
		   		//"SRNumber":""+SRNumber+"",
		   		activemqcall=new ActiveMQCall();
		   		String correlationId = activemqcall.createRandomString();
		   		//String correlationId = P_REQUEST_NUMBER;
		   		System.out.println("1 :: "+correlationId);
				String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";

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
		   		objX41.setATTRIBUTE1(caseno);
		   			
		   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
		   		body.setP_REQUEST_MESSAGE(arr);

		   		objMongoDB = new MongoDB();
		   		Date reqDate = new Date();
		   		OutputParameters param = port.PROCESS(header, body);
//		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		   		OutputParameters param = port.PROCESS(header, body);
//		   		
		   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
		   		System.out.println("2::"+param.getX_RETURN_STATUS());
		   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		   		JSONArray mainArr = new JSONArray();
		   		JSONObject subJson = null;
		   		result.put("message", param.getX_RETURN_MESSAGE());
		   		result.put("status", param.getX_RETURN_STATUS());
		   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		   			subJson = new JSONObject();
		   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
//		   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
//		   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
//		   			
		   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
    	   		//	res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Availability\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\"}";
//		   			res=objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2();
//		   			if(res == null) {
//		   				res = "0";
//		   			}
		   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
		   			subJson.put("Message_ID", P_REQUEST_NUMBER);
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
						

						String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";
						
						objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
						
		   			mainArr.put(subJson);
		   		}
		   		result.put("data", mainArr);
		   		String response = activemqcall.GetConsumer(queueName);
		   		System.out.println("3 4:: "+response);
		   		/*Thread t1 = new Thread(new Runnable() {
		   			public void run() {
		   				String response = activemqcall.GetConsumer(queueName);
		   				System.out.println("3 4:: "+response);
		   			}
		   		});
		   		t1.start();*/
    	   		System.out.println("res  ::"+result);

		   		return result.toString();

		   		}catch (Exception e) {
		   			e.printStackTrace();
		   			return e.getMessage();
		   			
		   		}
	}

    }
