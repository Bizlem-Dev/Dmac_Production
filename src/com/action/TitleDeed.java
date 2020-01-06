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

public class TitleDeed {
	
	final static Logger logger = Logger.getLogger(TitleDeed.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	public  String GetPenaltyOnServiceChrg(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.TitleDeed.GETPENALTYONSERVICECHRGUAT";
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
					
					String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+regTerms[i].getPARAM_ID()+"\"}";
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

}
