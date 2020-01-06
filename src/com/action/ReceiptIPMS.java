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
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class ReceiptIPMS {

	final static Logger logger = Logger.getLogger(ReceiptIPMS.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	public  String GenerateReceipt(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.GenerateReceiptUAT";
	   		//"SRNumber":""+SRNumber+"",
			String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"regTerms\":\""+regTerms+"\"}";
	   		activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		//System.out.println("1 :: "+correlationId);	
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
	   		arr[j] = objX41;
	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		Date reqDate = new Date();
	   		objMongoDB = new MongoDB();
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
	   			logger.info("UpdateRecoveryFlag param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			logger.info("UpdateRecoveryFlag PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
	   			logger.info("UpdateRecoveryFlag PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
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
					
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
						subJson.put("ATTRIBUTE3", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
					}else {
						subJson.put("ATTRIBUTE3", JSONObject.NULL);	
					}
					
					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+regTerms[i].getATTRIBUTE3()+"\"}";
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

	public  String GenerateReceipt1(String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String ParamId,String Attr1,String Attr2,String Attr3) {
		final String queueName = "IPMS.GenerateReceipt";
   		
   		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		String jsonString="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"ATTRIBUTE3\":\""+Attr3+"\",\"PARAM_ID\":\""+ParamId+"\"}";
   		correlationId=activemqcall.GetProducer(queueName,correlationId,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
   		String res = "";
   		try {
   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader();
   		
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
   		body.setP_REQUEST_NUMBER(correlationId);
   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
   		
   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
   		objX41.setPARAM_ID(ParamId);
   		objX41.setATTRIBUTE1(Attr1);
   		objX41.setATTRIBUTE2(Attr2);
   		objX41.setATTRIBUTE3(Attr3);
   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
   		body.setP_REQUEST_MESSAGE(arr);
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
   		System.out.println("2::"+param.getX_RETURN_STATUS());
   		logger.info("GenerateReceipt1 X_RETURN_MESSAGE response :: "+param.getX_RETURN_MESSAGE());
   		logger.info("GenerateReceipt1 X_RETURN_STATUS response :: "+param.getX_RETURN_STATUS());
   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
   			logger.info("GenerateReceipt1 param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
   			logger.info("GenerateReceipt1 PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
   			logger.info("GenerateReceipt1 PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
   			logger.info("GenerateReceipt1 ATTRIBUTE1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
   			
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
					res = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();
				}else {
					res = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE();
				}
				
			//	String requestString="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+regTerms[i].getATTRIBUTE3()+"\"}";
		//		objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
				
				//String requestString1="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+regTerms[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+regTerms[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+regTerms[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+regTerms[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+regTerms[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+regTerms[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+regTerms[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+regTerms[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+regTerms[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+regTerms[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+regTerms[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+regTerms[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+regTerms[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+regTerms[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+regTerms[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+regTerms[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+regTerms[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+regTerms[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+regTerms[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+regTerms[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+regTerms[i].getATTRIBUTE23()+"\",\"ATTRIBUTE24\":\""+regTerms[i].getATTRIBUTE24()+"\",\"ATTRIBUTE25\":\""+regTerms[i].getATTRIBUTE25()+"\",\"ATTRIBUTE26\":\""+regTerms[i].getATTRIBUTE26()+"\",\"ATTRIBUTE27\":\""+regTerms[i].getATTRIBUTE27()+"\",\"ATTRIBUTE28\":\""+regTerms[i].getATTRIBUTE28()+"\",\"ATTRIBUTE29\":\""+regTerms[i].getATTRIBUTE29()+"\",\"ATTRIBUTE30\":\""+regTerms[i].getATTRIBUTE30()+"\",\"ATTRIBUTE31\":\""+regTerms[i].getATTRIBUTE31()+"\",\"ATTRIBUTE32\":\""+regTerms[i].getATTRIBUTE32()+"\",\"ATTRIBUTE33\":\""+regTerms[i].getATTRIBUTE33()+"\",\"ATTRIBUTE34\":\""+regTerms[i].getATTRIBUTE34()+"\",\"ATTRIBUTE35\":\""+regTerms[i].getATTRIBUTE35()+"\",\"ATTRIBUTE36\":\""+regTerms[i].getATTRIBUTE36()+"\",\"ATTRIBUTE37\":\""+regTerms[i].getATTRIBUTE37()+"\",\"ATTRIBUTE38\":\""+regTerms[i].getATTRIBUTE38()+"\",\"ATTRIBUTE39\":\""+regTerms[i].getATTRIBUTE39()+"\",\"ATTRIBUTE40\":\""+regTerms[i].getATTRIBUTE40()+"\",\"ATTRIBUTE41\":\""+regTerms[i].getATTRIBUTE41()+"\",\"ATTRIBUTE42\":\""+regTerms[i].getATTRIBUTE42()+"\",\"ATTRIBUTE43\":\""+regTerms[i].getATTRIBUTE43()+"\",\"ATTRIBUTE44\":\""+regTerms[i].getATTRIBUTE44()+"\",\"ATTRIBUTE45\":\""+regTerms[i].getATTRIBUTE45()+"\",\"ATTRIBUTE46\":\""+regTerms[i].getATTRIBUTE46()+"\",\"ATTRIBUTE47\":\""+regTerms[i].getATTRIBUTE47()+"\",\"ATTRIBUTE48\":\""+regTerms[i].getATTRIBUTE48()+"\",\"ATTRIBUTE49\":\""+regTerms[i].getATTRIBUTE49()+"\",\"ATTRIBUTE50\":\""+regTerms[i].getATTRIBUTE50()+"\"}";
				
				
				//mainArr.put(subJson);	
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
   		//return param.getX_RETURN_STATUS();

   		}catch (Exception e) {
   			//return e.getMessage();
   			
   			res = e.getMessage();
   		}
   		return res;
			
	}


public  String GetReceiptDetails(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4  regTerms) {
	ReceiptIPMS objReceiptIPMS = new ReceiptIPMS();
	final String queueName = "IPMS.GetReceiptDetailsUAT";
		String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms.getPARAM_ID()+"\"}";
		activemqcall=new ActiveMQCall();
		//String correlationId = activemqcall.createRandomString();
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
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12() != null) {
				subJson.put("ATTRIBUTE12", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
				}else {
					subJson.put("ATTRIBUTE12", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13() != null) {
				subJson.put("ATTRIBUTE13", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
				}else {
					subJson.put("ATTRIBUTE13", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14() != null) {
				subJson.put("ATTRIBUTE14", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
				}else {
					subJson.put("ATTRIBUTE14", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15() != null) {
				subJson.put("ATTRIBUTE15", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
				}else {
					subJson.put("ATTRIBUTE15", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16() != null) {
				subJson.put("ATTRIBUTE16", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
				}else {
					subJson.put("ATTRIBUTE16", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17() != null) {
				subJson.put("ATTRIBUTE17", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
				}else {
					subJson.put("ATTRIBUTE17", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18() != null) {
				subJson.put("ATTRIBUTE18", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
				}else {
					subJson.put("ATTRIBUTE18", JSONObject.NULL);
				}
			if(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19() != null) {
				subJson.put("ATTRIBUTE19", objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
				}else {
					subJson.put("ATTRIBUTE19", JSONObject.NULL);
				}
			
			/*regTerms1[i].setPARAM_ID("2-1123");
			regTerms1[i].setATTRIBUTE1("");
			regTerms1[i].setATTRIBUTE2("");
			regTerms1[i].setATTRIBUTE3(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
			*/
//			String PARAM_ID  = "2-"+correlationId;
//			String attr1 = "";
//			String attr2 = "";
//			String attr3 = objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1();
//			String ATTRIBUTE20 = objReceiptIPMS.GenerateReceipt1("GENERATE_DP_RECEIPT", "SFDC",PARAM_ID,attr1,attr2,attr3);
//			if(ATTRIBUTE20 != null) {
//			subJson.put("ATTRIBUTE20", ATTRIBUTE20);
//			}else {
//				subJson.put("ATTRIBUTE20", JSONObject.NULL);
//			}
		//	String requestString="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+regTerms[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+regTerms[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+regTerms[i].getATTRIBUTE3()+"\"}";
		//	objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", subJson.toString(), param.getX_RETURN_STATUS());
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

	//return null;	
}

	
}
