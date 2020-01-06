package com.action;

import org.apache.log4j.Logger;

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
import javax.xml.ws.Service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.axis2.json.gson.factory.JsonObject;

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
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.customer_creation.*;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONException;
import gvjava.org.json.JSONObject;

public class Assignment {
	//ASSIGNMENT
	final static Logger logger = Logger.getLogger(Assignment.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	
	public  String getPDCDetails(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String Registrationid) {
		//process
				/*http://localhost:8080/CRM_SR_NEW/services/Assignment/getPDCAvaliable?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=GET_PDC_YN&P_SOURCE_SYSTEM=SFDC&Registrationid=12345
				 */
		String res="";
				final String queueName = "IPMS.ASSIGNMENT.GETPDCDETAILSUAT";
		   		//"SRNumber":""+SRNumber+"",
				String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
		   		activemqcall=new ActiveMQCall();
		   		//String correlationId = activemqcall.createRandomString();
		   		String correlationId = P_REQUEST_NUMBER;
		   		System.out.println("1 :: "+correlationId);	
		   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
		   		System.out.println("2 :: "+correlationId);
		   	//TextMessage textMessage = new 
		   		JSONObject mainJson = new JSONObject();
		   		try {
		   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
		   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
		   		
		   		SOAHeader header = new SOAHeader();
		   		
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = 
		   				new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
		   		body.setP_REQUEST_NUMBER(correlationId);
		   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
		   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
		   		APPSXXDC_PROCESS_SERX1794747X2X4 objX41 = new APPSXXDC_PROCESS_SERX1794747X2X4();
		   		objX41.setPARAM_ID(Registrationid);
		   			
		   		body.setP_REQUEST_MESSAGE(objX41);
		   		objMongoDB = new MongoDB();
		   		Date reqDate = new Date();
		   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
//		   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//		   		OutputParameters param = port.PROCESS(header, body);
//		   		
		   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
		   		System.out.println("2::"+param.getX_RETURN_STATUS());
		   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		   		mainJson.put("status", param.getX_RETURN_STATUS());
		   		mainJson.put("message", param.getX_RETURN_MESSAGE());
		   		APPSXXDC_PROCESS_SEX1794747X2X56[] resR = param.getX_RESPONSE_MESSAGE();
		   		JSONObject results = null;
		   		JSONArray arr = new JSONArray();
		   		for(int i=0;i<resR.length;i++) {
		   			results = new JSONObject();
		   		if(resR[i].getATTRIBUTE1() != null) {
		   		results.put("ATTRIBUTE1", resR[i].getATTRIBUTE1());
		   		}else {
		   			results.put("ATTRIBUTE1", JSONObject.NULL);	
		   		}
		   		
		   		if(resR[i].getATTRIBUTE2() != null) {
			   		results.put("ATTRIBUTE2", resR[i].getATTRIBUTE2());
			   		}else {
			   			results.put("ATTRIBUTE2", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE3() != null) {
			   		results.put("ATTRIBUTE3", resR[i].getATTRIBUTE3());
			   		}else {
			   			results.put("ATTRIBUTE3", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE4() != null) {
			   		results.put("ATTRIBUTE4", resR[i].getATTRIBUTE4());
			   		}else {
			   			results.put("ATTRIBUTE4", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE5() != null) {
			   		results.put("ATTRIBUTE5", resR[i].getATTRIBUTE5());
			   		}else {
			   			results.put("ATTRIBUTE5", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE6() != null) {
			   		results.put("ATTRIBUTE6", resR[i].getATTRIBUTE6());
			   		}else {
			   			results.put("ATTRIBUTE6", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE7() != null) {
			   		results.put("ATTRIBUTE7", resR[i].getATTRIBUTE7());
			   		}else {
			   			results.put("ATTRIBUTE7", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getATTRIBUTE8() != null) {
			   		results.put("ATTRIBUTE8", resR[i].getATTRIBUTE8());
			   		}else {
			   			results.put("ATTRIBUTE8", JSONObject.NULL);	
			   		}
		   		arr.put(results);
		   		
		   		String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";

	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", results.toString(), param.getX_RETURN_MESSAGE());
				
		   		
		   		}
		   		mainJson.put("data", arr);
		   		
		   		String response = activemqcall.GetConsumer(queueName);
		   		System.out.println("3 4:: "+response);
		   		/*Thread t1 = new Thread(new Runnable() {
		   			public void run() {
		   				String response = activemqcall.GetConsumer(queueName);
		   				System.out.println("3 4:: "+response);
		   			}
		   		});
		   		t1.start();*/
    	   		System.out.println("res  ::"+res);

		   		
		   		}catch (Exception e) {
		   			try {
		   				mainJson.put("status","E");
		   				mainJson.put("message",e.getMessage());
		   			}catch (Exception ex) {
						// TODO: handle exception
					}
		   			
		   		}
		   		return mainJson.toString();


			}

	
	
	
	public String getPendingDues(String regid,String caseno) {
		JSONObject res1= new JSONObject();
		String Amount1, Amount2,Amount3, Amount4 = "";
		String res ="";
		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
   		XXDC_PROCESS_SERVICE_WS_PortType port = null;
   		
		try {
		/*Amount1 = getDueandOverDue("123456", "GET_DUES_OVERDUES", "SFDC", regid, caseno);
		res.put("Dues and Overdues", Amount1);
		Thread.sleep(6000);
		Amount3=getFacilityDue("12345", "FACILITY_DUE_YN", "SFDC", regid, caseno);
		res.put("Facility Dues", Amount3);
		Thread.sleep(6000);
		Amount2 = getPenaltyValue("123456", "GET_PENALTY", "SFDC", regid, caseno);
		res.put("Penalties", Amount2);
		Thread.sleep(6000);
		Amount4=getQuarterlyDue("12345", "QUARTERLY_DUE_YN", "SFDC", regid, caseno);
		res.put("Quarterly Dues", Amount4);*/
			
			activemqcall=new ActiveMQCall();
			String[] array = {"GET_DUES_OVERDUES","FACILITY_DUE_YN","GET_PENALTY"};
	   		//String[] arrayJ = {"Dues and Overdues","Facility Dues","Penalties","Quarterly Dues"};
	   		//String[] arrayJ = {"Dues and Overdues towards unit","FM dues and overdues","Penalties towards unit","FM dues for the quarter"};
	   		String[] arrayJ = {"Balance as per SOA","FM Balance as per SOA","Penalties accrued but not posted to SOA"};
	   		//String[] queue = {"IPMS.ASSIGNMENT.CHECKDUEOVERDUEUAT","IPMS.ASSIGNMENT.GETFACILITYDUEUAT","IPMS.ASSIGNMENT.GETPENALTYVALUEUAT","IPMS.ASSIGNMENT.GETQUARTERLYDUEUAT"};
	   		String[] queue = {"IPMS.ASSIGNMENT.CHECKDUEOVERDUEUAT","IPMS.ASSIGNMENT.GETFACILITYDUEUAT","IPMS.ASSIGNMENT.GETPENALTYVALUEUAT"};
	   		port = service.getXXDC_PROCESS_SERVICE_WS_Port();
		   		SOAHeader header = new SOAHeader();
		   		
		   		InputParameters body = new InputParameters();
		   		body.setP_SOURCE_SYSTEM("SFDC");
		   		APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
		   		objX41.setPARAM_ID(regid);
		   		objX41.setATTRIBUTE1(caseno);
		   		for(int e = 0;e<array.length;e++) {
		   			String correlationId = activemqcall.createRandomString();
			   		System.out.println("inside for : "+e);
			   		String jsonString ="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"P_REQUEST_NAME\":\""+array[e]+"\",\"P_SOURCE_SYSTEM\":\"SFDC\",\"Registrationid\":\""+regid+"\",\"caseno\":\""+caseno+"\"}";

			   		correlationId=activemqcall.GetProducer(queue[e],regid,correlationId,jsonString);
			   		System.out.println("2 :: "+correlationId);

		   		body.setP_REQUEST_NAME(array[e]);
		   		body.setP_REQUEST_NUMBER(correlationId);
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
		   		if(param.getX_RETURN_STATUS().equals("S")) {
		   			APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			   		
		   			for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		   			System.out.println("param id response :: "+array[e]  +objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
		   			System.out.println("Attribute1 response :: "+array[e] +objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		   			System.out.println("Attribute2 response :: "+array[e] +objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
		   			if(e == 1 || e == 3) {
		   				res = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2();
		   			}else {
		   				res = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();	   				
		   			}
	if(res == null) {
		res = "0";
	}
	res1.put(arrayJ[e], res);
	if(e == array.length - 1) {
		res1.put("status", param.getX_RETURN_STATUS());	
	}
	//res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\"}";
	//obj.put("Invoices which are due in 30 days", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		   		}
		   		}else if(param.getX_RETURN_STATUS().equals("E")) {
		   			res1.put("status", param.getX_RETURN_STATUS());
		   			res1.put("message",param.getX_RETURN_MESSAGE());
		   			break;
		   		}
		   		
		   		
		   		String requestString ="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"P_REQUEST_NAME\":\""+array[e]+"\",\"P_SOURCE_SYSTEM\":\"SFDC\",\"Registrationid\":\""+regid+"\",\"caseno\":\""+caseno+"\"}";

	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res.toString(), param.getX_RETURN_STATUS());

		   		String response = activemqcall.GetConsumer(queue[e]);
		   		System.out.println("3 4:: "+response);
		   		
		   		//port.wait(3000);
		   		
		   		}
		   		System.out.println("res :: "+res1.toString());
		   		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
			res1.put("status", "E");
   			res1.put("message",e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}
			//return res1.toString();
		}finally {
			port = null;
			service = null;
		}
	return res1.toString();	
	}
	
	
	public  String getDueandOverDue(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String Registrationid, String caseno) 
	{
	//process
	/*http://localhost:8080/CRM_SR_NEW/services/Assignment/getDueandOverDue?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=GET_DUES_OVERDUES&P_SOURCE_SYSTEM=SFDC&Registrationid=12345
	 */
		String res=null;
		JSONObject obj =new JSONObject();
			final String queueName = "IPMS.ASSIGNMENT.CHECKDUEOVERDUEUAT";
	   		//"SRNumber":""+SRNumber+"",
	   		activemqcall=new ActiveMQCall();
	   		String correlationId = activemqcall.createRandomString();
	   		//String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";

	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
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
	   		objX41.setPARAM_ID(Registrationid);
	   		objX41.setATTRIBUTE1(caseno);
	   		
	   		
	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	   		body.setP_REQUEST_MESSAGE(arr);
	   		
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			System.out.println("Attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
	   			System.out.println("Attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
res = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();
if(res == null) {
	res = "0";
}

String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";

objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

//res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\"}";
//obj.put("Invoices which are due in 30 days", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
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
	   		System.out.println("res  "+res);

	   		return res;
	   		

	   		}catch (Exception e) {
	   			return e.getMessage();
	   			
	   		}
}

	
	public  String getPenaltyValue(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String Registrationid, String caseno) {
		/*http://localhost:8080/CRM_SR_NEW/services/Assignment/getPenaltyValue?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=GET_PENALTY&P_SOURCE_SYSTEM=SFDC&Registrationid=12345 
		 */
		//process
		String res=null;
			final String queueName = "IPMS.ASSIGNMENT.GETPENALTYVALUEUAT";
	   		//"SRNumber":""+SRNumber+"",
	   		activemqcall=new ActiveMQCall();
	   		String correlationId = activemqcall.createRandomString();
	   		//String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";

	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
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
	   		objX41.setPARAM_ID(Registrationid);
	   		objX41.setATTRIBUTE1(caseno);
	   			
	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	   		body.setP_REQUEST_MESSAGE(arr);
	   		objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
	   		OutputParameters param = port.PROCESS(header, body);
//	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	   		OutputParameters param = port.PROCESS(header, body);
//	   		
	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
	   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
	   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
	   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
	
	   		//	res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\"}";
                res=objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1();
                if(res == null) {
                	res = "0";
                }
                
                String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";
       			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
	   		System.out.println("res  "+res);
	   		return res;

	   		}catch (Exception e) {
	   			e.printStackTrace();
	   			return e.getMessage();
	   			
	   		}

		}
		
	
	public  String getPDCAvaliable(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String Registrationid) {
		//process
				/*http://localhost:8080/CRM_SR_NEW/services/Assignment/getPDCAvaliable?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=GET_PDC_YN&P_SOURCE_SYSTEM=SFDC&Registrationid=12345
				 */
		String res="";
				final String queueName = "IPMS.ASSIGNMENT.GETPDCAVALIABLEUAT";
		   		//"SRNumber":""+SRNumber+"",
				String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
		   		activemqcall=new ActiveMQCall();
		   		//String correlationId = activemqcall.createRandomString();
		   		String correlationId = P_REQUEST_NUMBER;
		   		System.out.println("1 :: "+correlationId);	
		   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
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
		   		objX41.setPARAM_ID(Registrationid);
		   			
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
		   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
		   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
    	   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
    	   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
    	   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
		
    	   			res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Availability\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\"}";
    	   			String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
           			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
    	   		System.out.println("res  ::"+res);

		   		return res;

		   		}catch (Exception e) {
		   			e.printStackTrace();
		   			return e.getMessage();
		   			
		   		}

			}

	public  String getFacilityDue(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String Registrationid, String caseno) {
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
		   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
		   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
		   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
		   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
		   			
		   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
    	   		//	res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Availability\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\"}";
res=objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2();
if(res == null) {
	res = "0";
}

String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";

objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
    	   		System.out.println("res  ::"+res);

		   		return res;

		   		}catch (Exception e) {
		   			e.printStackTrace();
		   			return e.getMessage();
		   			
		   		}
	}

	public  String getQuarterlyDue(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String Registrationid, String caseno) {
		/*http://localhost:8080/CRM_SR_NEW/services/Assignment/getQuarterlyDue?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=QUARTERLY_DUE_YN&P_SOURCE_SYSTEM=SFDC&Registrationid=12345
		 */
		//process
		String res=null;
				final String queueName = "IPMS.ASSIGNMENT.GETQUARTERLYDUEUAT";
		   		//"SRNumber":""+SRNumber+"",
		   		activemqcall=new ActiveMQCall();
		   		String correlationId = activemqcall.createRandomString();
		   		//String correlationId = P_REQUEST_NUMBER;
		   		System.out.println("1 :: "+correlationId);	
				String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";

		   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
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
		   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
		   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
		   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
		   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
    	   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
    	   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
    	   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
    	   		//	res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Availability\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\"}";
                res=objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2();
                if(res == null) {
                	res = "0";
                }
                
            	String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"caseno\":\""+caseno+"\"}";
            	objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
    	   		System.out.println("res  ::"+res);

		   		return res;

		   		}catch (Exception e) {
		   			e.printStackTrace();
		   			return e.getMessage();
		   			
		   		}

		
	}
	


   public  String PDCOutstanding(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String Registrationid) {
			
			/*http://localhost:8080/CRM_SR_NEW/services/Assignment/PDCOutstanding?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=PDC_INV_OUTSTANDING_YN&P_SOURCE_SYSTEM=SFDC&Registrationid=12345
			 */
			//process
	   String res="";
					final String queueName = "IPMS.ASSIGNMENT.PDCOUTSTANDINGUAT";
					String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
			   		activemqcall=new ActiveMQCall();
			   		//String correlationId = activemqcall.createRandomString();
			   		String correlationId = P_REQUEST_NUMBER;
			   		System.out.println("1 :: "+correlationId);	
			   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
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
			   		objX41.setPARAM_ID(Registrationid);
			   			
			   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
			   		body.setP_REQUEST_MESSAGE(arr);
			   		
			   		objMongoDB = new MongoDB();
			   		Date reqDate = new Date();
			   		
			   		OutputParameters param = port.PROCESS(header, body);
//			   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//			   		OutputParameters param = port.PROCESS(header, body);
//			   		
			   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
			   		System.out.println("2::"+param.getX_RETURN_STATUS());
			   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
			   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
			   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
			   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
			   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
			   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
			   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
	    	   			res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Availability\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\"}";
	    	   			
						String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\"}";
	                	objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
	    	   		System.out.println("res  ::"+res);

			   		return res;

			   		}catch (Exception e) {
			   			e.printStackTrace();
			   			return e.getMessage();
			   			
			   		}		
			}
			
   public String  UpdateRegistrationStatus(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String Registrationid, String NewRegistrationstatus) {
	    	/*http://localhost:8080/CRM_SR_NEW/services/Assignment/UpdateRegistrationStatus?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=UPDATE_REG_STATUS&P_SOURCE_SYSTEM=SFDC&Registrationid=12345&NewRegistrationstatus=
	    	 */
	    	//process
	   String res="";
	    			final String queueName = "IPMS.ASSIGNMENT.UPDATEREGISTRATIONSTATUSUAT";
	    			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"NewRegistrationstatus\":\""+NewRegistrationstatus+"\"}";
	    	   		activemqcall=new ActiveMQCall();
	    	   		//String correlationId = activemqcall.createRandomString();
	    	   		String correlationId = P_REQUEST_NUMBER;
	    	   		System.out.println("1 :: "+correlationId);	
	    	   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
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
	    	   		objX41.setPARAM_ID(Registrationid);
	    	   		objX41.setATTRIBUTE1(NewRegistrationstatus);
	    	   			
	    	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	    	   		body.setP_REQUEST_MESSAGE(arr);
	    	   		objMongoDB = new MongoDB();
	    	   		Date reqDate = new Date();
	    	   		OutputParameters param = port.PROCESS(header, body);
//	    	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	    	   		OutputParameters param = port.PROCESS(header, body);
//	    	   		
	    	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	    	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	    	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	    	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	    	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	    	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	    	   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
	    	   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
	    	   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
	    	   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
	    	   			//res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"Registrationid\":\""+Registrationid+"\", \"Availability\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"Amount\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\"}";
	    	   			res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"PARAM_ID\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID()+"\", \"RegistrationId\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\",\"Attribute2\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2()+"\", \"PROC_STATUS\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS()+"\", \"PROC_MESSAGE\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE()+"\"}";
	    	   			String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+Registrationid+"\",\"NewRegistrationstatus\":\""+NewRegistrationstatus+"\"}";
	                	objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
	    	   		System.out.println("res  ::"+res);

	    	   		return res;

	    	   		}catch (Exception e) {
	    	   			e.printStackTrace();
	    	   			return e.getMessage();
	    	   			
	    	   		}

	    }

   public String  CreateAssignment(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,String PARAM_ID, String Statusflag) {
	    	/*http://localhost:8080/CRM_SR_NEW/services/Assignment/CreateAssignment?P_REQUEST_NUMBER=46535&P_REQUEST_NAME=CREATE_ASSIGNMENT&P_SOURCE_SYSTEM=SFDC&Registrationid=12345&Statusflag=
	    	 */
	    	//process
	   String res="";
	    			final String queueName = "IPMS.ASSIGNMENT.CREATEASSIGNMENTUAT";
	    			String jsonString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+PARAM_ID+"\",\"Statusflag\":\""+Statusflag+"\"}";
	    	   		activemqcall=new ActiveMQCall();
	    	   		//String correlationId = activemqcall.createRandomString();
	    	   		String correlationId = P_REQUEST_NUMBER;
	    	   		System.out.println("1 :: "+correlationId);	
	    	   		correlationId=activemqcall.GetProducer(queueName,PARAM_ID,correlationId,jsonString);
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
	    	   		objX41.setPARAM_ID(PARAM_ID);
	    	   		objX41.setATTRIBUTE1(Statusflag);
	    	   			
	    	   		APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
	    	   		body.setP_REQUEST_MESSAGE(arr);
	    	   		
	    	   		objMongoDB = new MongoDB();
	    	   		Date reqDate = new Date();
	    	   		
	    	   		OutputParameters param = port.PROCESS(header, body);
//	    	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
//	    	   		OutputParameters param = port.PROCESS(header, body);
//	    	   		
	    	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
	    	   		System.out.println("2::"+param.getX_RETURN_STATUS());
	    	   		System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
	    	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	    	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	    	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
	    	   			System.out.println("attribute1 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
	    	   			System.out.println("attribute2 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
	    	   			System.out.println("attribute3 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
	    	   			System.out.println("attribute4 response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
	    	   			//res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"PARAM_ID\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID()+"\", \"RegistrationId\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"PROC_STATUS\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS()+"\", \"PROC_MESSAGE\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE()+"\"}";
	    	   			res="{\"Status\":\""+param.getX_RETURN_STATUS()+"\",\"PARAM_ID\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID()+"\", \"RegistrationId\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1()+"\", \"PROC_STATUS\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS()+"\", \"PROC_MESSAGE\":\""+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE()+"\"}";

		    			String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"Registrationid\":\""+PARAM_ID+"\",\"Statusflag\":\""+Statusflag+"\"}";
	    	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, param.getX_RETURN_STATUS());

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
	    	   		System.out.println("res  ::"+res);
	    	   		return res;

	    	   		}catch (Exception e) {
	    	   			e.printStackTrace();
	    	   			return e.getMessage();
	    	   			
	    	   		}

	    	   		
	    	   		

	    }


   public String AssignmentFee(String RegistrationId, String SourceofRequest, String ProcessName, String SubProcesName,
			String ProjectCity, String Project, String BuildingCode, String PermittedUse, String BedroomType,
			String ApplicableUnits, String UnitType, String CustomerType, String AggrementStatus,
			String UnderAssignment, String ReadyOffPlan, String ApplicableNationality, String POA,
			String NOCIssuanceInLast15days)  {
	   String res = "AssignmentFee";
	   ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
	   try {
		// http://localhost:8080/CRM_SR_NEW/services/Assignment/AssignmentFee?RegistrationId=12&SourceofRequest=&ProcessName=&SubProcesName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ApplicableUnits=&UnitType=&CustomerType=&AggrementStatus=&UnderAssignment=&ReadyOffPlan=&ApplicableNationality=&POA=&NOCIssuanceInLast15days=
		
		// final String queueName = "Assignment.AssignmentFee";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
				+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
				+ "\",\"ApplicableUnits\":\"" + ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\","
				+ "\"CustomerType\":\"" + CustomerType + "\",\"AggrementStatus\":\"" + AggrementStatus
				+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"," + "\"ReadyOffPlan\":\"" + ReadyOffPlan
				+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POA\":\"" + POA
				+ "\",\"NOCIssuanceInLast15days\":\"" + NOCIssuanceInLast15days + "\"}";
		activemqcall = new ActiveMQCall();
		// \"\":\"\"++\"\"
		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("ASSIGNMENT.ASSIGNMENTFEEUAT");
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

		/*MessageListener listener = new MessageListener() {

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

		responseConsumer.setMessageListener(listener);*/

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
		System.out.println("success");

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
				String requestString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
						+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
						+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
						+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
						+ "\",\"ApplicableUnits\":\"" + ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\","
						+ "\"CustomerType\":\"" + CustomerType + "\",\"AggrementStatus\":\"" + AggrementStatus
						+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"," + "\"ReadyOffPlan\":\"" + ReadyOffPlan
						+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POA\":\"" + POA
						+ "\",\"NOCIssuanceInLast15days\":\"" + NOCIssuanceInLast15days + "\"}";
				
	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");

				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		System.out.println("success");

		// String correlationId = activemqcall.createRandomString();
		//// String correlationId = P_REQUEST_NUMBER;
		// System.out.println("1 :: " + correlationId);
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);
		//
		//
		// System.out.println("2 :: " + correlationId);
		// System.out.println(jsonString);
}catch (Exception e) {
	// TODO: handle exception
	return e.getMessage();
}finally {try {
	connection.close();
} catch (JMSException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
		return res;

	}

	public String AssignmentDocument(String RegistrationId, String SourceofRequest, String ProcessName,
			String SubProcesName, String ProjectCity, String Project, String BuildingCode, String PermittedUse,
			String BedroomType, String ApplicableUnits, String UnitType, String CustomerType, String AggrementStatus,
			String UnderAssignment, String ReadyOffPlan, String ApplicableNationality, String POAAssigner,
			String POAAssignor, String NOCIssuanceInLast15days)  {
		// http://localhost:8080/CRM_SR_NEW/services/Assignment/AssignmentDocument?RegistrationId=88&SourceofRequest=&ProcessName=&SubProcesName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ApplicableUnits=&UnitType=&CustomerType=&AggrementStatus=&UnderAssignment=&ReadyOffPlan=&ApplicableNationality=&POAAssigner=&POAAssignor=&NOCIssuanceInLast15days=
		String res = "AssignmentDocument";
		ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
		try {
		
		// final String queueName = "ASSIGNMENT.ASSIGNMENTDOCUMENT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
				+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
				+ "\",\"ApplicableUnits\":\"" + ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\","
				+ "\"CustomerType\":\"" + CustomerType + "\",\"AggrementStatus\":\"" + AggrementStatus
				+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"," + "\"ReadyOffPlan\":\"" + ReadyOffPlan
				+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POAAssigner\":\"" + POAAssignor
				+ "\",\"POAAssignor\":\"" + POAAssigner + "\",\"NOCIssuanceInLast15days\":\"" + NOCIssuanceInLast15days
				+ "\"}";
		activemqcall = new ActiveMQCall();

		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("ASSIGNMENT.ASSIGNMENTDOCUMENTUAT");
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

		/*MessageListener listener = new MessageListener() {

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
					System.out.println(e);
				}
			}

		};

		responseConsumer.setMessageListener(listener);*/

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
		System.out.println("success");

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
				String requestString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
						+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
						+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
						+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
						+ "\",\"ApplicableUnits\":\"" + ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\","
						+ "\"CustomerType\":\"" + CustomerType + "\",\"AggrementStatus\":\"" + AggrementStatus
						+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"," + "\"ReadyOffPlan\":\"" + ReadyOffPlan
						+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POAAssigner\":\"" + POAAssignor
						+ "\",\"POAAssignor\":\"" + POAAssigner + "\",\"NOCIssuanceInLast15days\":\"" + NOCIssuanceInLast15days
						+ "\"}";
	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");

				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		System.out.println("success");

		// \"\":\"\"++\"\"
		// String correlationId = activemqcall.createRandomString();
		// String correlationId = P_REQUEST_NUMBER;
		// System.out.println("1 :: " + correlationId);
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);
		// System.out.println("2 :: " + correlationId);
		// System.out.println(jsonString);
}catch (Exception e) {
	// TODO: handle exception
	return e.getMessage();
}finally {try {
	connection.close();
} catch (JMSException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
		return res;

	}

	public String AssignmentApproval(String RegistrationId, String SourceofRequest, String ProcessName,
			String SubProcesName, String ProjectCity, String Project, String BuildingCode, String PermittedUse,
			String BedroomType, String ApplicableUnits, String UnitType, String CustomerType, String AggrementStatus,
			String UnderTermination, String UnderAssignment, String ReadyOffPlan, String ApplicableNationality,
			String POA)  {
		// http://localhost:8080/CRM_SR_NEW/services/Assignment/AssignmentApproval?RegistrationId=88&SourceofRequest=&ProcessName=&SubProcesName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ApplicableUnits=&UnitType=&CustomerType=&AggrementStatus=&UnderTermination=&UnderAssignment=&ReadyOffPlan=&ApplicableNationality=&POA=
		String res = "AssignmentApproval";
		ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
		try {
		
		// final String queueName = "ASSIGNMENT.ASSIGNMENTAPPROVAL";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
				+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
				+ "\",\"ApplicableUnits\":\"" + ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\","
				+ "\"CustomerType\":\"" + CustomerType + "\",\"AggrementStatus\":\"" + AggrementStatus
				+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"," + "\"ReadyOffPlan\":\"" + ReadyOffPlan
				+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POA\":\"" + POA + "\"}";
		activemqcall = new ActiveMQCall();
		// \"\":\"\"++\"\"

		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("ASSIGNMENT.ASSIGNMENTAPPROVALUAT");
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

		/*MessageListener listener = new MessageListener() {

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

		responseConsumer.setMessageListener(listener);*/

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
		System.out.println("success");

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
				String requestString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"SourceofRequest\":\"" + SourceofRequest
						+ "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcesName\":\"" + SubProcesName
						+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
						+ BuildingCode + "\",\"PermittedUse\":\"" + PermittedUse + "\",\"BedroomType\":\"" + BedroomType
						+ "\",\"ApplicableUnits\":\"" + ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\","
						+ "\"CustomerType\":\"" + CustomerType + "\",\"AggrementStatus\":\"" + AggrementStatus
						+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"," + "\"ReadyOffPlan\":\"" + ReadyOffPlan
						+ "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"POA\":\"" + POA + "\"}";
	   			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");

				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		System.out.println("success");

		// String correlationId = activemqcall.createRandomString();
		//// String correlationId = P_REQUEST_NUMBER;
		// System.out.println("1 :: " + correlationId);
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);
		// System.out.println("2 :: " + correlationId);
		// System.out.println(jsonString);
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}finally {try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		return res;

	}

	
	
	
	public String customerCreation(APPSXXDC_SFDC_REGISTX1809884X1X1 CUST_RECORDS,
			APPSXXDC_SFDC_REGISX1809884X1X23 CUST_ADDRESS,
			APPSXXDC_SFDC_REGISX1809884X1X42 CUST_CONTACT,
			APPSXXDC_SFDC_REGISX1809884X1X77 CUST_AR_DATA,
			APPSXXDC_SFDC_REGIX1809884X1X106 CUST_AR_ADDRESS) {
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.ASSIGNMENT.CREATECUSTOMERUAT";
		String jsonString ="{\"CUST_RECORDS\":\""+CUST_RECORDS+"\",\"CUST_ADDRESS\":\""+CUST_ADDRESS+"\",\"CUST_CONTACT\":\""+CUST_CONTACT+"\",\"CUST_AR_DATA\":\""+CUST_AR_DATA+"\",\"CUST_AR_ADDRESS\":\""+CUST_AR_ADDRESS+"\"}";
   		activemqcall=new ActiveMQCall();
   		String correlationId = activemqcall.createRandomString();
   		String Registrationid = correlationId;
   	//	String correlationId = P_REQUEST_NUMBER;
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,Registrationid,correlationId,jsonString);
   		System.out.println("2 :: "+correlationId);
		try {
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_ServiceLocator service = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_ServiceLocator();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_PortType port = service.getXXDC_SFDC_REGISTRATION_WS_Port();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.SOAHeader();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.customer_creation.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.customer_creation.InputParameters();
			 APPSXXDC_SFDC_REGISTX1809884X1X1 p_CUST_RECORDS = new APPSXXDC_SFDC_REGISTX1809884X1X1();
			 APPSXXDC_SFDC_REGISX1809884X1X23 p_CUST_ADDRESS = new APPSXXDC_SFDC_REGISX1809884X1X23();
			 APPSXXDC_SFDC_REGISX1809884X1X42 p_CUST_CONTACT = new APPSXXDC_SFDC_REGISX1809884X1X42();
			 APPSXXDC_SFDC_REGISX1809884X1X77 p_CUST_AR_DATA = new APPSXXDC_SFDC_REGISX1809884X1X77(); 
			 p_CUST_RECORDS.setPARTY_TYPE(CUST_RECORDS.getPARTY_TYPE());
			 p_CUST_RECORDS.setPARTY_ID(CUST_RECORDS.getPARTY_ID());
			 p_CUST_RECORDS.setEXT_CUST_NUMBER(CUST_RECORDS.getEXT_CUST_NUMBER());
			 p_CUST_RECORDS.setPARTY_TITLE(CUST_RECORDS.getPARTY_TITLE());
			 p_CUST_RECORDS.setPARTY_FIRST_NAME(CUST_RECORDS.getPARTY_FIRST_NAME());
			 p_CUST_RECORDS.setPARTY_MIDDLE_NAME(CUST_RECORDS.getPARTY_MIDDLE_NAME());
			 p_CUST_RECORDS.setPARTY_LAST_NAME(CUST_RECORDS.getPARTY_LAST_NAME());
			 p_CUST_RECORDS.setORGANIZATION_NAME(CUST_RECORDS.getORGANIZATION_NAME());
			 p_CUST_RECORDS.setWHY_DUBAI(CUST_RECORDS.getWHY_DUBAI());
			 p_CUST_RECORDS.setWHY_DAMAC(CUST_RECORDS.getWHY_DAMAC());
			 p_CUST_RECORDS.setINTRODUCED_BY(CUST_RECORDS.getINTRODUCED_BY());
			 p_CUST_RECORDS.setATTRIBUTE1(CUST_RECORDS.getATTRIBUTE1());
			 p_CUST_RECORDS.setATTRIBUTE2(CUST_RECORDS.getATTRIBUTE2());
			 p_CUST_RECORDS.setATTRIBUTE3(CUST_RECORDS.getATTRIBUTE3());
			 p_CUST_RECORDS.setATTRIBUTE4(CUST_RECORDS.getATTRIBUTE4());
			 p_CUST_RECORDS.setATTRIBUTE5(CUST_RECORDS.getATTRIBUTE5());
			 p_CUST_RECORDS.setATTRIBUTE6(CUST_RECORDS.getATTRIBUTE6());
			 p_CUST_RECORDS.setATTRIBUTE7(CUST_RECORDS.getATTRIBUTE7());
			 p_CUST_RECORDS.setATTRIBUTE8(CUST_RECORDS.getATTRIBUTE8());
			 p_CUST_RECORDS.setATTRIBUTE9(CUST_RECORDS.getATTRIBUTE9());
			 p_CUST_RECORDS.setATTRIBUTE10(CUST_RECORDS.getATTRIBUTE10());
			 p_CUST_ADDRESS.setADDRESS1(CUST_ADDRESS.getADDRESS1());
			 p_CUST_ADDRESS.setADDRESS2(CUST_ADDRESS.getADDRESS2());
			 p_CUST_ADDRESS.setADDRESS3(CUST_ADDRESS.getADDRESS3());
			 p_CUST_ADDRESS.setADDRESS4(CUST_ADDRESS.getADDRESS4());
			 p_CUST_ADDRESS.setCITY(CUST_ADDRESS.getCITY());
			 p_CUST_ADDRESS.setPOSTAL_CODE(CUST_ADDRESS.getPOSTAL_CODE());
			 p_CUST_ADDRESS.setSTATE(CUST_ADDRESS.getSTATE());
			 p_CUST_ADDRESS.setCOUNTRY(CUST_ADDRESS.getCOUNTRY());
			 p_CUST_ADDRESS.setATTRIBUTE1(CUST_ADDRESS.getATTRIBUTE1());
			 p_CUST_ADDRESS.setATTRIBUTE2(CUST_ADDRESS.getATTRIBUTE2());
			 p_CUST_ADDRESS.setATTRIBUTE3(CUST_ADDRESS.getATTRIBUTE3());
			 p_CUST_ADDRESS.setATTRIBUTE4(CUST_ADDRESS.getATTRIBUTE4());
			 p_CUST_ADDRESS.setATTRIBUTE5(CUST_ADDRESS.getATTRIBUTE5());
			 p_CUST_ADDRESS.setATTRIBUTE6(CUST_ADDRESS.getATTRIBUTE6());
			 p_CUST_ADDRESS.setATTRIBUTE7(CUST_ADDRESS.getATTRIBUTE7());
			 p_CUST_ADDRESS.setATTRIBUTE8(CUST_ADDRESS.getATTRIBUTE8());
			 p_CUST_ADDRESS.setATTRIBUTE9(CUST_ADDRESS.getATTRIBUTE9());
			 p_CUST_ADDRESS.setATTRIBUTE10(CUST_ADDRESS.getATTRIBUTE10());
			 p_CUST_CONTACT.setPRIMARY_FLAG(CUST_CONTACT.getPRIMARY_FLAG());
			 p_CUST_CONTACT.setHOME_COUNTRY_CODE(CUST_CONTACT.getHOME_COUNTRY_CODE());
			 p_CUST_CONTACT.setHOME_AREA_CODE(CUST_CONTACT.getHOME_AREA_CODE());
			 p_CUST_CONTACT.setHOME_NUMBER(CUST_CONTACT.getHOME_NUMBER());
			 p_CUST_CONTACT.setWORK_COUNTRY_CODE(CUST_CONTACT.getWORK_COUNTRY_CODE());
			 p_CUST_CONTACT.setWORK_AREA_CODE(CUST_CONTACT.getWORK_AREA_CODE());
			 p_CUST_CONTACT.setWORK_NUMBER(CUST_CONTACT.getWORK_NUMBER());
			 p_CUST_CONTACT.setMOBILE_COUNTRY_CODE(CUST_CONTACT.getMOBILE_COUNTRY_CODE());
			 p_CUST_CONTACT.setMOBILE_AREA_CODE(CUST_CONTACT.getMOBILE_AREA_CODE());
			 p_CUST_CONTACT.setMOBILE_NUMBER(CUST_CONTACT.getMOBILE_NUMBER());
			 p_CUST_CONTACT.setFAX_COUNTRY_CODE(CUST_CONTACT.getFAX_COUNTRY_CODE());
			 p_CUST_CONTACT.setFAX_AREA_CODE(CUST_CONTACT.getFAX_AREA_CODE());
			 p_CUST_CONTACT.setFAX_NUMBER(CUST_CONTACT.getFAX_NUMBER());
			 p_CUST_CONTACT.setEMAIL_ADDRESS(CUST_CONTACT.getEMAIL_ADDRESS());
			 p_CUST_CONTACT.setURL(CUST_CONTACT.getURL());
			 p_CUST_CONTACT.setNATIONALITY(CUST_CONTACT.getNATIONALITY());
			 p_CUST_CONTACT.setPASSPORT_NUMBER(CUST_CONTACT.getPASSPORT_NUMBER());
			 p_CUST_CONTACT.setPASSPORT_ISSUE_DATE(CUST_CONTACT.getPASSPORT_ISSUE_DATE());
			 p_CUST_CONTACT.setPASSPROT_ISSUE_PLACE(CUST_CONTACT.getPASSPROT_ISSUE_PLACE());
			 p_CUST_CONTACT.setPASSPORT_EXP_DATE(CUST_CONTACT.getPASSPORT_EXP_DATE());
			 p_CUST_CONTACT.setPASSPROT_COUNTRY(CUST_CONTACT.getPASSPROT_COUNTRY());
			 p_CUST_CONTACT.setGENDER(CUST_CONTACT.getGENDER());
			 p_CUST_CONTACT.setBIRTH_PLACE(CUST_CONTACT.getBIRTH_PLACE());
			 p_CUST_CONTACT.setBIRTH_DATE(CUST_CONTACT.getBIRTH_DATE());
			 p_CUST_CONTACT.setEID_NUMBER(CUST_CONTACT.getEID_NUMBER());
			 p_CUST_CONTACT.setEID_EXP_DATE(CUST_CONTACT.getEID_EXP_DATE());
			 p_CUST_CONTACT.setCR_NUMBER(CUST_CONTACT.getCR_NUMBER());
			 p_CUST_CONTACT.setCR_REG_PLACE(CUST_CONTACT.getCR_REG_PLACE());
			 p_CUST_CONTACT.setCR_REG_DATE(CUST_CONTACT.getCR_REG_DATE());
			 p_CUST_CONTACT.setATTRIBUTE1(CUST_CONTACT.getATTRIBUTE1());
			 p_CUST_CONTACT.setATTRIBUTE2(CUST_CONTACT.getATTRIBUTE2());
			 p_CUST_CONTACT.setATTRIBUTE3(CUST_CONTACT.getATTRIBUTE3());
			 p_CUST_CONTACT.setATTRIBUTE4(CUST_CONTACT.getATTRIBUTE4());
			 p_CUST_CONTACT.setATTRIBUTE5(CUST_CONTACT.getATTRIBUTE5());
			 
			 p_CUST_AR_DATA.setTITLE_NUM_AR(CUST_AR_DATA.getTITLE_NUM_AR());
			 p_CUST_AR_DATA.setFIRST_NAME_AR(CUST_AR_DATA.getFIRST_NAME_AR());
			 p_CUST_AR_DATA.setMIDDLE_NAME_AR(CUST_AR_DATA.getMIDDLE_NAME_AR());
			 p_CUST_AR_DATA.setLAST_NAME_AR(CUST_AR_DATA.getLAST_NAME_AR());
			 p_CUST_AR_DATA.setNATIONALITY_AR(CUST_AR_DATA.getNATIONALITY_AR());
			 p_CUST_AR_DATA.setPASSPORT_NUMBER_AR(CUST_AR_DATA.getPASSPORT_NUMBER_AR());
			 p_CUST_AR_DATA.setCR_NUMBER_AR(CUST_AR_DATA.getCR_NUMBER_AR());
			 p_CUST_AR_DATA.setCR_REG_DATE_AR(CUST_AR_DATA.getCR_REG_DATE_AR());
			 p_CUST_AR_DATA.setCR_REG_PLACE_AR(CUST_AR_DATA.getCR_REG_PLACE_AR());
			 p_CUST_AR_DATA.setEMAIL_ADDRESS_AR(CUST_AR_DATA.getEMAIL_ADDRESS_AR());
			 p_CUST_AR_DATA.setPASSPORT_ISSUE_DATE_AR(CUST_AR_DATA.getPASSPORT_ISSUE_DATE_AR());
			 p_CUST_AR_DATA.setPASSPORT_ISSUE_PLACE_AR(CUST_AR_DATA.getPASSPORT_ISSUE_PLACE_AR());
			 p_CUST_AR_DATA.setMOBILE_COUNTRY_CODE_AR(CUST_AR_DATA.getMOBILE_COUNTRY_CODE_AR());
			 p_CUST_AR_DATA.setMOBILE_AREA_CODE_AR(CUST_AR_DATA.getMOBILE_AREA_CODE_AR());
			 p_CUST_AR_DATA.setMOBILE_NUMBER_AR(CUST_AR_DATA.getMOBILE_NUMBER_AR());
			 p_CUST_AR_DATA.setPHONE_COUNTRY_CODE_AR(CUST_AR_DATA.getPHONE_COUNTRY_CODE_AR());
			 p_CUST_AR_DATA.setPHONE_AREA_CODE_AR(CUST_AR_DATA.getPHONE_AREA_CODE_AR());
			 p_CUST_AR_DATA.setPHONE_NUMBER_AR(CUST_AR_DATA.getPHONE_NUMBER_AR());
			 p_CUST_AR_DATA.setPHONE_EXTENTION_AR(CUST_AR_DATA.getPHONE_EXTENTION_AR());
			 p_CUST_AR_DATA.setFAX_COUNTRY_CODE_AR(CUST_AR_DATA.getFAX_COUNTRY_CODE_AR());
			 p_CUST_AR_DATA.setFAX_AREA_CODE_AR(CUST_AR_DATA.getFAX_AREA_CODE_AR());
			 p_CUST_AR_DATA.setFAX_NUMBER_AR(CUST_AR_DATA.getFAX_NUMBER_AR());
			 p_CUST_AR_DATA.setFAX_EXTENSION_AR(CUST_AR_DATA.getFAX_EXTENSION_AR());
			 p_CUST_AR_DATA.setATTRIBUTE1(CUST_AR_DATA.getATTRIBUTE1());
			 p_CUST_AR_DATA.setATTRIBUTE2(CUST_AR_DATA.getATTRIBUTE2());
			 p_CUST_AR_DATA.setATTRIBUTE3(CUST_AR_DATA.getATTRIBUTE3());
			 p_CUST_AR_DATA.setATTRIBUTE4(CUST_AR_DATA.getATTRIBUTE4());
			 p_CUST_AR_DATA.setATTRIBUTE5(CUST_AR_DATA.getATTRIBUTE5());
			 
			 APPSXXDC_SFDC_REGIX1809884X1X106 p_CUST_AR_ADDRESS = new APPSXXDC_SFDC_REGIX1809884X1X106();
			 p_CUST_AR_ADDRESS.setADDRESS1_AR(CUST_AR_ADDRESS.getADDRESS1_AR());
			 p_CUST_AR_ADDRESS.setADDRESS2_AR(CUST_AR_ADDRESS.getADDRESS2_AR());
			 p_CUST_AR_ADDRESS.setADDRESS3_AR(CUST_AR_ADDRESS.getADDRESS3_AR());
			 p_CUST_AR_ADDRESS.setADDRESS4_AR(CUST_AR_ADDRESS.getADDRESS4_AR());
			 p_CUST_AR_ADDRESS.setCITY_AR(CUST_AR_ADDRESS.getCITY_AR());
			 p_CUST_AR_ADDRESS.setCOUNTRY_AR(CUST_AR_ADDRESS.getCOUNTRY_AR());
			 p_CUST_AR_ADDRESS.setPOSTAL_CODE_AR(CUST_AR_ADDRESS.getPOSTAL_CODE_AR());
			 p_CUST_AR_ADDRESS.setATTRIBUTE1(CUST_AR_ADDRESS.getATTRIBUTE1());
			 p_CUST_AR_ADDRESS.setATTRIBUTE2(CUST_AR_ADDRESS.getATTRIBUTE2());
			 p_CUST_AR_ADDRESS.setATTRIBUTE3(CUST_AR_ADDRESS.getATTRIBUTE3());
			 p_CUST_AR_ADDRESS.setATTRIBUTE4(CUST_AR_ADDRESS.getATTRIBUTE4());
			 p_CUST_AR_ADDRESS.setATTRIBUTE5(CUST_AR_ADDRESS.getATTRIBUTE5());

			 
			 
			body.setP_CUST_RECORDS(p_CUST_RECORDS);
			body.setP_CUST_ADDRESS(p_CUST_ADDRESS);
			body.setP_CUST_CONTACT(p_CUST_CONTACT);
			body.setP_CUST_AR_DATA(p_CUST_AR_DATA);
			body.setP_CUST_AR_ADDRESS(p_CUST_AR_ADDRESS);
			
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.customer_creation.OutputParameters regout = port.CUSTOMER_CREATION(header, body);
			//regout.getX_CUST_ACCOUNT_ID();
			if(regout.getX_CUST_ACCOUNT_ID() != null){
			result.put("X_CUST_ACCOUNT_ID", regout.getX_CUST_ACCOUNT_ID());
			}else {
				result.put("X_CUST_ACCOUNT_ID", JSONObject.NULL);
			}
			if(regout.getX_PARTY_ID() != null){
				result.put("X_PARTY_ID", regout.getX_PARTY_ID());
			}else {
					result.put("X_PARTY_ID", JSONObject.NULL);
			}
			if(regout.getX_REQUEST_STATUS() != null){
				result.put("STATUS", regout.getX_REQUEST_STATUS());
			}else {
					result.put("STATUS", JSONObject.NULL);
			}
			if(regout.getX_ERROR_MESSAGE() != null){
				result.put("MESSAGE", regout.getX_ERROR_MESSAGE());
			}else {
					result.put("MESSAGE", JSONObject.NULL);
			}
			String response = activemqcall.GetConsumer(queueName);
	   		System.out.println("3 4:: "+response);
			
		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("STATUS", "E");
			result.put("MESSAGE", e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		return result.toString();
	}
	
	
	
	
	
	
	
	
//	public  String SPA(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[]  regTerms) {
//		//process
//			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
//			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
//			 */
//		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
//		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
//			final String queueName = "IPMS.SPAUAT";
//	   		//"SRNumber":""+SRNumber+"",
//			String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"regTerms\":\""+regTerms+"\"}";
//	   		activemqcall=new ActiveMQCall();
//	   		//String correlationId = activemqcall.createRandomString();
//	   		String correlationId = P_REQUEST_NUMBER;
//	   		System.out.println("1 :: "+correlationId);	
//	   		//correlationId=activemqcall.GetProducer(queueName,SourceId,correlationId,jsonString);
//	   		correlationId=activemqcall.GetProducer(queueName,P_REQUEST_NUMBER,correlationId,jsonString);
//	   		System.out.println("2 :: "+correlationId);
//	   	//TextMessage textMessage = new 
//	   		JSONObject result = new JSONObject();
//	   		String res = "";
//	   		try {
//	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
//	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
//	   		
//	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader();
//	   		
//	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
//	   		body.setP_REQUEST_NUMBER(correlationId);
//	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
//	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
//	   		
//	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[regTerms.length];
//	   		
//	   		for(int j=0;j<regTerms.length;j++) {
//	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5();
//	   		objX41.setPARAM_ID(regTerms[j].getPARAM_ID());
//	   		objX41.setATTRIBUTE1(regTerms[j].getATTRIBUTE1());
//	   		objX41.setATTRIBUTE2(regTerms[j].getATTRIBUTE2());
//	   		
//	   		arr[j] = objX41;
//	   		}
//	   		body.setP_REQUEST_MESSAGE(arr);
//	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters param = port.PROCESS(header, body);
////	   		body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
////	   		OutputParameters param = port.PROCESS(header, body);
////	   		
//	   		System.out.println("1::"+param.getX_RETURN_MESSAGE());
//	   		System.out.println("2::"+param.getX_RETURN_STATUS());
//	   		//System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
//	   		result.put("status", param.getX_RETURN_STATUS());
//	   		result.put("message", param.getX_RETURN_MESSAGE());
//	   		JSONArray mainArr = new JSONArray();
//	   		JSONObject subJson = null;
//	   		APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
//	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
//	   			subJson = new JSONObject();
//	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
//	   			logger.info("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
//	   			logger.info("PROC_STATUS response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
//	   			logger.info("PROC_Message response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
//	   			subJson.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
//	   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
//	   				subJson.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
//					}else {
//						subJson.put("PROC_STATUS", JSONObject.NULL);	
//					}
//					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
//						subJson.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
//					}else {
//						subJson.put("PROC_MESSAGE", JSONObject.NULL);	
//					}
//					
//					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
//						subJson.put("ATTRIBUTE1", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
//					}else {
//						subJson.put("ATTRIBUTE1", JSONObject.NULL);	
//					}
//					
//					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2() != null) {
//						subJson.put("ATTRIBUTE2", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE2());
//					}else {
//						subJson.put("ATTRIBUTE2", JSONObject.NULL);	
//					}
//					
//					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3() != null) {
//						subJson.put("ATTRIBUTE3", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE3());
//					}else {
//						subJson.put("ATTRIBUTE3", JSONObject.NULL);	
//					}
//					
//					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4() != null) {
//						subJson.put("ATTRIBUTE4", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE4());
//					}else {
//						subJson.put("ATTRIBUTE4", JSONObject.NULL);	
//					}
//					
//					
//					mainArr.put(subJson);	
//	   		}
//	   		result.put("data", mainArr);
//	   		res = result.toString();
//	   		String response = activemqcall.GetConsumer(queueName);
//	   		System.out.println("3 4:: "+response);
//	   		/*Thread t1 = new Thread(new Runnable() {
//	   			public void run() {
//	   				String response = activemqcall.GetConsumer(queueName);
//	   				System.out.println("3 4:: "+response);
//	   			}
//	   		});
//	   		t1.start();*/
//	   		//return param.getX_RETURN_STATUS();
//
//	   		}catch (Exception e) {
//	   			//return e.getMessage();
//	   			try {
//	   				result.put("status", "E");
//	   		   		result.put("message", e.getMessage());
//	   			}catch (Exception ex) {
//					// TODO: handle exception
//				}
//	   			res = result.toString();
//	   		}
//	   		return res;
//				
//		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public String fetchDocumentsListFromRuleEngine(String Registration_ID__c, String CaseNumber, String Booking_Unit__c, String Party_ID__c)
//
//	{
//	//output is Name (String)  isRequired (String)
//		
//		
//		final String queueName = "IPMS.COCD.FETCHDOCUMENTSLISTFROMRULE";
//   		//"SRNumber":""+SRNumber+"",
//   		String jsonString = "{\"Registration_ID__c\":\""+Registration_ID__c+"\",\"CaseNumber\":\""+CaseNumber+"\",\"Booking_Unit__c\":\""+Booking_Unit__c+"\",\"Party_ID__c\":\""+Party_ID__c+"\"}";
//   		activemqcall=new ActiveMQCall();
//   		String correlationId = activemqcall.createRandomString();
//   		System.out.println("1 :: "+correlationId);	
//   		correlationId=activemqcall.GetProducer(queueName,Registration_ID__c,correlationId,jsonString);
//   		System.out.println("2 :: "+correlationId);
//   	//TextMessage textMessage = new 
//   		try {
//   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
//   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
//   		
//   		SOAHeader header = new SOAHeader();
//   		
//   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
//   		body.setP_REQUEST_NUMBER(correlationId);
//   		body.setP_REQUEST_NAME("GET_RULES_ATTRIBUTES");
//   		body.setP_SOURCE_SYSTEM("SFDC");
//   		
//   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
//		objX4.setPARAM_ID(Registration_ID__c);
//		objX4.setATTRIBUTE1(CaseNumber);
//   		objX4.setATTRIBUTE2(Booking_Unit__c);
//   		objX4.setATTRIBUTE3(Party_ID__c);
//
//   		
//		body.setP_REQUEST_MESSAGE(objX4);
//		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
//		
//		System.out.println("return "+param.getX_RETURN_MESSAGE().length());
//    //		System.out.println(param.getX_RETURN_STATUS());
//		System.out.println("response "+param.getX_RESPONSE_MESSAGE());
//   		APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 =param.getX_RESPONSE_MESSAGE();
//   		//objAPPSXXDC_PROCESS_SEX1794747X2X56[0].
//   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X2X56.length;i++) {
//   			System.out.println("Attribute 1: "+i+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
//   		}
//   		String response = activemqcall.GetConsumer(queueName);
//   		System.out.println("3 4:: "+response);
//   		/*Thread t1 = new Thread(new Runnable() {
//   			public void run() {
//   				String response = activemqcall.GetConsumer(queueName);
//   				System.out.println("3 4:: "+response);
//   			}
//   		});
//   		t1.start();*/
//   		return param.getX_RETURN_STATUS();
//   		}catch(Exception e) {
//   			return e.getMessage();
//   		}
//		//return "fetchDocumentsListFromRuleEngine";	
//	}
//
//	
//	public String fetchPaymentsListFromIPMS(String Registration_ID__c, String CaseNumber, String Booking_Unit__c, String Party_ID__c)
//	
//	{
//
//		//output is list of pending payments
//		final String queueName = "IPMS.COCD.FETCHPAYMENTSLISTFROMRULE";
//   		//"SRNumber":""+SRNumber+"",
//   		String jsonString = "{\"Registration_ID__c\":\""+Registration_ID__c+"\",\"CaseNumber\":\""+CaseNumber+"\",\"Booking_Unit__c\":\"\"+Booking_Unit__c+\"\",\"Party_ID__c\":\""+Party_ID__c+"\"}";
//   		activemqcall=new ActiveMQCall();
//   		String correlationId = activemqcall.createRandomString();
//   		System.out.println("1 :: "+correlationId);	
//   		correlationId=activemqcall.GetProducer(queueName,Registration_ID__c,correlationId,jsonString);
//   		System.out.println("2 :: "+correlationId);
//   	//TextMessage textMessage = new 
//   		try {
//   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
//   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
//   		
//   		SOAHeader header = new SOAHeader();
//   		
//   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
//   		body.setP_REQUEST_NUMBER(correlationId);
//   		body.setP_REQUEST_NAME("TEST1");
//   		body.setP_SOURCE_SYSTEM("SFDC");
//   		
//   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
//		objX4.setPARAM_ID(Registration_ID__c);
//		objX4.setATTRIBUTE1(CaseNumber);
//   		objX4.setATTRIBUTE2(Booking_Unit__c);
//   		objX4.setATTRIBUTE3(Party_ID__c);
//
//   		
//		body.setP_REQUEST_MESSAGE(objX4);
//		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
//		
//		System.out.println("return "+param.getX_RETURN_MESSAGE().length());
////		System.out.println(param.getX_RETURN_STATUS());
//		System.out.println("response "+param.getX_RESPONSE_MESSAGE());
//   		APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 =param.getX_RESPONSE_MESSAGE();
//   		//objAPPSXXDC_PROCESS_SEX1794747X2X56[0].
//   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X2X56.length;i++) {
//   			System.out.println("Attribute 1: "+i+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
//   		}
//   		String response = activemqcall.GetConsumer(queueName);
//   		System.out.println("3 4:: "+response);
//   		/*Thread t1 = new Thread(new Runnable() {
//   			public void run() {
//   				String response = activemqcall.GetConsumer(queueName);
//   				System.out.println("3 4:: "+response);
//   			}
//   		});
//   		t1.start();*/
//   		return param.getX_RETURN_STATUS();
//   		}catch(Exception e) {
//   			return e.getMessage();
//   		}
//	//return "fetchPaymentsListFromIPMS";
//		
//	}
//	
//	public String fetchPendingAmount(String Registration_ID__c, String CaseNumber, String Booking_Unit__c, String Party_ID__c)
//	{	
//		//output is Pending_Amount__c
//		//output is list of pending payments
//		final String queueName = "IPMS.COCD.FETCHPENDINGAMOUNT";
//   		//"SRNumber":""+SRNumber+"",
//   		String jsonString = "{\"Registration_ID__c\":\""+Registration_ID__c+"\",\"CaseNumber\":\""+CaseNumber+"\",\"Booking_Unit__c\":\"\"+Booking_Unit__c+\"\",\"Party_ID__c\":\""+Party_ID__c+"\"}";
//   		activemqcall=new ActiveMQCall();
//   		String correlationId = activemqcall.createRandomString();
//   		System.out.println("1 :: "+correlationId);	
//   		correlationId=activemqcall.GetProducer(queueName,Registration_ID__c,correlationId,jsonString);
//   		System.out.println("2 :: "+correlationId);
//   	//TextMessage textMessage = new 
//   		try {
//   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
//   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
//   		
//   		SOAHeader header = new SOAHeader();
//   		
//   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
//   		body.setP_REQUEST_NUMBER(correlationId);
//   		body.setP_REQUEST_NAME("TEST1");
//   		body.setP_SOURCE_SYSTEM("SFDC");
//   		
//   		APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
//		objX4.setPARAM_ID(Registration_ID__c);
//		objX4.setATTRIBUTE1(CaseNumber);
//   		objX4.setATTRIBUTE2(Booking_Unit__c);
//   		objX4.setATTRIBUTE3(Party_ID__c);
//
//   		
//		body.setP_REQUEST_MESSAGE(objX4);
//		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port.RETRIEVE(header, body);
//		
//		System.out.println("return "+param.getX_RETURN_MESSAGE().length());
////		System.out.println(param.getX_RETURN_STATUS());
//		System.out.println("response "+param.getX_RESPONSE_MESSAGE());
//   		APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 =param.getX_RESPONSE_MESSAGE();
//   		//objAPPSXXDC_PROCESS_SEX1794747X2X56[0].
//   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X2X56.length;i++) {
//   			System.out.println("Attribute 1: "+i+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
//   		}
//   		String response = activemqcall.GetConsumer(queueName);
//   		System.out.println("3 4:: "+response);
//   		/*Thread t1 = new Thread(new Runnable() {
//   			public void run() {
//   				String response = activemqcall.GetConsumer(queueName);
//   				System.out.println("3 4:: "+response);
//   			}
//   		});
//   		t1.start();*/
//   		return param.getX_RETURN_STATUS();
//   		}catch(Exception e) {
//   			return e.getMessage();
//   		}
//		//return "fetchPendingAmount";
//		
//	}
//	
//	public String translateToArabic(String Address_Line_1__c, String Address_Line_2__c, String Address_Line_3__c, String Address_Line_4__c, String City__p, 
//	String Country__p, String Nationality__p)
//	{
//		
//		/*output is Address_Line_1_Arabic__pc
//		Address_Line_2_Arabic__pc 	Address_Line_3_Arabic__pc  Address_Line_4_Arabic__pc
//		City_Arabic__pc 	Country_Arabic__pc	Nationality_Arabic__pc */
//		
//		return "translateToArabic";
//			
//	}
//	
//	public String fetchDetailsFromOCR(String PassportDocument )
//	{
//		/*output is  First_Name__c
//		Last_Name__c
//		Passport_Expiry_Date__c
//		Passport_Number__c
//		Nationality__c
//		return "fetchDetailsFromOCR"; */
//		return "fetchDetailsFromOCR";
//	}
//	
//	public String getFileUrl(String File)
//	{
//		//output is File URL from shared repository
//		return "getFileUrl";
//	}
//	
//	public String validateBuyerOTP(String Number)
//	{
//		//output is Buyer_Verified__c (true / false)
//		return "validateBuyerOTP";
//	}

}
