package com.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;
import com.bean.TaskBean;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Case;
import com.sforce.soap.enterprise.sobject.SR_Attachments__c;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class Task {
	final static Logger logger = Logger.getLogger(Task.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	public String  SRDataToIPMS(TaskBean objTaskBean)
	{
		// url    SRDataToIPMS?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&SRNumber=&SRDataType=&SRName=&SRStatus=&SRCreator=&IPMSPartyId=&RegistrationId=&SRCreationDate=&SFDCTaskId=&TaskDueDate=&ValuesDependingOnSRType=&TaskCloseDate=&TaskCloseBy=&ApprovalStatus=&TaskComment=&SRNote=
//process
		//TaskBean objTaskBean = new TaskBean();
		String res="SRDataToIPMS";
		final String queueName = "IPMS.COCD.SRDATATOIPMSPRO";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\""+objTaskBean.getP_REQUEST_NUMBER()+"\",\"P_REQUEST_NAME\":\""+ objTaskBean.getP_REQUEST_NAME() + "\",\"P_SOURCE_SYSTEM\":\""+objTaskBean.getP_SOURCE_SYSTEM()+"\",\"PARAM_ID\":\""+objTaskBean.getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+objTaskBean.getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objTaskBean.getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objTaskBean.getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objTaskBean.getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objTaskBean.getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objTaskBean.getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objTaskBean.getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objTaskBean.getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objTaskBean.getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objTaskBean.getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objTaskBean.getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objTaskBean.getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objTaskBean.getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objTaskBean.getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objTaskBean.getATTRIBUTE15()+"\"}";
		
		activemqcall = new ActiveMQCall();
		// String correlationId = activemqcall.createRandomString();
		String correlationId = objTaskBean.getP_REQUEST_NUMBER();
		System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, objTaskBean.getATTRIBUTE6(), correlationId, jsonString);
		System.out.println("2 :: " + correlationId);
		// TextMessage textMessage = new
		try {
			XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
			XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

			SOAHeader header = new SOAHeader();

			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(objTaskBean.getP_REQUEST_NAME());
			body.setP_SOURCE_SYSTEM(objTaskBean.getP_SOURCE_SYSTEM());
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(objTaskBean.getPARAM_ID());
		
			objX41.setATTRIBUTE1(objTaskBean.getATTRIBUTE1());
			//String SRName,String SRStatus
			//,String SRCreator,String IPMSPartyId,String RegistrationId,String SRCreationDate,String SFDCTaskId,String TaskDueDate,String ValuesDependingOnSRType,String TaskCloseDate,String TaskCloseBy,String ApprovalStatus,String TaskComment,String SRNote)
			
			objX41.setATTRIBUTE2(objTaskBean.getATTRIBUTE2());
			objX41.setATTRIBUTE3(objTaskBean.getATTRIBUTE3());
			objX41.setATTRIBUTE4(objTaskBean.getATTRIBUTE4());
			objX41.setATTRIBUTE5(objTaskBean.getATTRIBUTE5());  // party id
			objX41.setATTRIBUTE6(objTaskBean.getATTRIBUTE6());  // reg id
			objX41.setATTRIBUTE7(objTaskBean.getATTRIBUTE7());
			objX41.setATTRIBUTE8(objTaskBean.getATTRIBUTE8());
			objX41.setATTRIBUTE9(objTaskBean.getATTRIBUTE9());
			
			objX41.setATTRIBUTE10(objTaskBean.getATTRIBUTE10());  
			objX41.setATTRIBUTE11(objTaskBean.getATTRIBUTE11());
			objX41.setATTRIBUTE12(objTaskBean.getATTRIBUTE12());
			objX41.setATTRIBUTE13(objTaskBean.getATTRIBUTE13());
			objX41.setATTRIBUTE14(objTaskBean.getATTRIBUTE14());
			objX41.setATTRIBUTE15(objTaskBean.getATTRIBUTE15());
			objX41.setATTRIBUTE16(objTaskBean.getATTRIBUTE16());
			objX41.setATTRIBUTE17(objTaskBean.getATTRIBUTE17());
			objX41.setATTRIBUTE18(objTaskBean.getATTRIBUTE18());
			objX41.setATTRIBUTE19(objTaskBean.getATTRIBUTE19());
			objX41.setATTRIBUTE20(objTaskBean.getATTRIBUTE20());
			objX41.setATTRIBUTE21(objTaskBean.getATTRIBUTE21());
			objX41.setATTRIBUTE22(objTaskBean.getATTRIBUTE22());
			objX41.setATTRIBUTE23(objTaskBean.getATTRIBUTE23());
			objX41.setATTRIBUTE24(objTaskBean.getATTRIBUTE24());
			objX41.setATTRIBUTE25(objTaskBean.getATTRIBUTE25());
			objX41.setATTRIBUTE26(objTaskBean.getATTRIBUTE26());
			objX41.setATTRIBUTE27(objTaskBean.getATTRIBUTE27());
			objX41.setATTRIBUTE28(objTaskBean.getATTRIBUTE28());
			objX41.setATTRIBUTE29(objTaskBean.getATTRIBUTE29());
			objX41.setATTRIBUTE30(objTaskBean.getATTRIBUTE30());
			
			objX41.setATTRIBUTE31(objTaskBean.getATTRIBUTE31());  
			objX41.setATTRIBUTE32(objTaskBean.getATTRIBUTE32());
			objX41.setATTRIBUTE33(objTaskBean.getATTRIBUTE33());
			objX41.setATTRIBUTE34(objTaskBean.getATTRIBUTE34());
			objX41.setATTRIBUTE35(objTaskBean.getATTRIBUTE35());
			objX41.setATTRIBUTE36(objTaskBean.getATTRIBUTE36());
			objX41.setATTRIBUTE37(objTaskBean.getATTRIBUTE37());
			objX41.setATTRIBUTE38(objTaskBean.getATTRIBUTE38());
			objX41.setATTRIBUTE39(objTaskBean.getATTRIBUTE39());
			//objX41.setATTRIBUTE40(objTaskBean.getATTRIBUTE19());
			objX41.setATTRIBUTE41(objTaskBean.getATTRIBUTE40());
			objX41.setATTRIBUTE42(objTaskBean.getATTRIBUTE41());
			objX41.setATTRIBUTE43(objTaskBean.getATTRIBUTE42());
			objX41.setATTRIBUTE44(objTaskBean.getATTRIBUTE43());
			objX41.setATTRIBUTE45(objTaskBean.getATTRIBUTE44());
			objX41.setATTRIBUTE46(objTaskBean.getATTRIBUTE45());
			objX41.setATTRIBUTE47(objTaskBean.getATTRIBUTE46());
			objX41.setATTRIBUTE48(objTaskBean.getATTRIBUTE47());
			objX41.setATTRIBUTE49(objTaskBean.getATTRIBUTE48());
			objX41.setATTRIBUTE50(objTaskBean.getATTRIBUTE49());
			
			
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

	
	public String  SRDataToIPMSMultiple(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,APPSXXDC_PROCESS_SERX1794747X1X5[] objTaskBean)
	{
		// url    SRDataToIPMS?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&SRNumber=&SRDataType=&SRName=&SRStatus=&SRCreator=&IPMSPartyId=&RegistrationId=&SRCreationDate=&SFDCTaskId=&TaskDueDate=&ValuesDependingOnSRType=&TaskCloseDate=&TaskCloseBy=&ApprovalStatus=&TaskComment=&SRNote=
//process
		//TaskBean objTaskBean = new TaskBean();
		String res="SRDataToIPMS";
		final String queueName = "IPMS.COCD.SRDATATOIPMSMULTIPLEPRO";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+ P_REQUEST_NAME + "\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\"}";
		
		activemqcall = new ActiveMQCall();
		// String correlationId = activemqcall.createRandomString();
		String correlationId = P_REQUEST_NUMBER;
		/*System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, P_REQUEST_NUMBER, correlationId, jsonString);
		System.out.println("2 :: " + correlationId);*/
		// TextMessage textMessage = new
		JSONObject result = new JSONObject();
		try {
			XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
			XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

			SOAHeader header = new SOAHeader();

			InputParameters body = new InputParameters();
			logger.info("SRDataToIPMSMultiple  correlationId messageId  :: "+correlationId);
			body.setP_REQUEST_NUMBER(correlationId);
			body.setP_REQUEST_NAME(P_REQUEST_NAME);
			body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
			APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[objTaskBean.length];
			for(int i=0;i<objTaskBean.length;i++) {
			APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new APPSXXDC_PROCESS_SERX1794747X1X5();
			objX41.setPARAM_ID(objTaskBean[i].getPARAM_ID());
			logger.info("SRDataToIPMSMultiple  PARAM_ID  :: "+objTaskBean[i].getPARAM_ID());
			objX41.setATTRIBUTE1(objTaskBean[i].getATTRIBUTE1());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE1  :: "+objTaskBean[i].getATTRIBUTE1());
			//String SRName,String SRStatus
			//,String SRCreator,String IPMSPartyId,String RegistrationId,String SRCreationDate,String SFDCTaskId,String TaskDueDate,String ValuesDependingOnSRType,String TaskCloseDate,String TaskCloseBy,String ApprovalStatus,String TaskComment,String SRNote)
			
			objX41.setATTRIBUTE2(objTaskBean[i].getATTRIBUTE2());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE2  :: "+objTaskBean[i].getATTRIBUTE2());
			objX41.setATTRIBUTE3(objTaskBean[i].getATTRIBUTE3());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE3  :: "+objTaskBean[i].getATTRIBUTE3());
			objX41.setATTRIBUTE4(objTaskBean[i].getATTRIBUTE4());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE4  :: "+objTaskBean[i].getATTRIBUTE4());
			objX41.setATTRIBUTE5(objTaskBean[i].getATTRIBUTE5());  // party id
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE5  :: "+objTaskBean[i].getATTRIBUTE5());
			objX41.setATTRIBUTE6(objTaskBean[i].getATTRIBUTE6());  // reg id
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE6  :: "+objTaskBean[i].getATTRIBUTE6());
			objX41.setATTRIBUTE7(objTaskBean[i].getATTRIBUTE7());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE7  :: "+objTaskBean[i].getATTRIBUTE7());
			objX41.setATTRIBUTE8(objTaskBean[i].getATTRIBUTE8());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE8  :: "+objTaskBean[i].getATTRIBUTE8());
			objX41.setATTRIBUTE9(objTaskBean[i].getATTRIBUTE9());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE9  :: "+objTaskBean[i].getATTRIBUTE9());
			
			objX41.setATTRIBUTE10(objTaskBean[i].getATTRIBUTE10());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE10  :: "+objTaskBean[i].getATTRIBUTE10());
			objX41.setATTRIBUTE11(objTaskBean[i].getATTRIBUTE11());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE11  :: "+objTaskBean[i].getATTRIBUTE11());
			objX41.setATTRIBUTE12(objTaskBean[i].getATTRIBUTE12());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE12  :: "+objTaskBean[i].getATTRIBUTE12());
			objX41.setATTRIBUTE13(objTaskBean[i].getATTRIBUTE13());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE13  :: "+objTaskBean[i].getATTRIBUTE13());
			objX41.setATTRIBUTE14(objTaskBean[i].getATTRIBUTE14());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE14  :: "+objTaskBean[i].getATTRIBUTE14());
			objX41.setATTRIBUTE15(objTaskBean[i].getATTRIBUTE15());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE15  :: "+objTaskBean[i].getATTRIBUTE15());
			objX41.setATTRIBUTE16(objTaskBean[i].getATTRIBUTE16());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE16  :: "+objTaskBean[i].getATTRIBUTE16());
			objX41.setATTRIBUTE17(objTaskBean[i].getATTRIBUTE17());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE17  :: "+objTaskBean[i].getATTRIBUTE17());
			objX41.setATTRIBUTE18(objTaskBean[i].getATTRIBUTE18());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE18  :: "+objTaskBean[i].getATTRIBUTE18());
			objX41.setATTRIBUTE19(objTaskBean[i].getATTRIBUTE19());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE19  :: "+objTaskBean[i].getATTRIBUTE19());
			objX41.setATTRIBUTE20(objTaskBean[i].getATTRIBUTE20());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE20  :: "+objTaskBean[i].getATTRIBUTE20());
			objX41.setATTRIBUTE21(objTaskBean[i].getATTRIBUTE21());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE21  :: "+objTaskBean[i].getATTRIBUTE21());
			objX41.setATTRIBUTE22(objTaskBean[i].getATTRIBUTE22());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE22  :: "+objTaskBean[i].getATTRIBUTE22());
			objX41.setATTRIBUTE23(objTaskBean[i].getATTRIBUTE23());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE23  :: "+objTaskBean[i].getATTRIBUTE23());
			objX41.setATTRIBUTE24(objTaskBean[i].getATTRIBUTE24());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE24  :: "+objTaskBean[i].getATTRIBUTE24());
			objX41.setATTRIBUTE25(objTaskBean[i].getATTRIBUTE25());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE25  :: "+objTaskBean[i].getATTRIBUTE25());
			objX41.setATTRIBUTE26(objTaskBean[i].getATTRIBUTE26());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE26  :: "+objTaskBean[i].getATTRIBUTE26());
			objX41.setATTRIBUTE27(objTaskBean[i].getATTRIBUTE27());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE27  :: "+objTaskBean[i].getATTRIBUTE27());
			objX41.setATTRIBUTE28(objTaskBean[i].getATTRIBUTE28());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE28  :: "+objTaskBean[i].getATTRIBUTE28());
			objX41.setATTRIBUTE29(objTaskBean[i].getATTRIBUTE29());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE29  :: "+objTaskBean[i].getATTRIBUTE29());
			objX41.setATTRIBUTE30(objTaskBean[i].getATTRIBUTE30());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE30  :: "+objTaskBean[i].getATTRIBUTE30());
			objX41.setATTRIBUTE31(objTaskBean[i].getATTRIBUTE31());  
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE31  :: "+objTaskBean[i].getATTRIBUTE31());
			objX41.setATTRIBUTE32(objTaskBean[i].getATTRIBUTE32());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE32  :: "+objTaskBean[i].getATTRIBUTE32());
			objX41.setATTRIBUTE33(objTaskBean[i].getATTRIBUTE33());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE33  :: "+objTaskBean[i].getATTRIBUTE33());
			objX41.setATTRIBUTE34(objTaskBean[i].getATTRIBUTE34());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE34  :: "+objTaskBean[i].getATTRIBUTE34());
			objX41.setATTRIBUTE35(objTaskBean[i].getATTRIBUTE35());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE35  :: "+objTaskBean[i].getATTRIBUTE35());
			objX41.setATTRIBUTE36(objTaskBean[i].getATTRIBUTE36());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE36  :: "+objTaskBean[i].getATTRIBUTE36());
			objX41.setATTRIBUTE37(objTaskBean[i].getATTRIBUTE37());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE37  :: "+objTaskBean[i].getATTRIBUTE37());
			objX41.setATTRIBUTE38(objTaskBean[i].getATTRIBUTE38());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE38  :: "+objTaskBean[i].getATTRIBUTE38());
			objX41.setATTRIBUTE39(objTaskBean[i].getATTRIBUTE39());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE39  :: "+objTaskBean[i].getATTRIBUTE39());
			//objX41.setATTRIBUTE40(objTaskBean.getATTRIBUTE19());
			objX41.setATTRIBUTE41(objTaskBean[i].getATTRIBUTE41());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE41  :: "+objTaskBean[i].getATTRIBUTE41());
			objX41.setATTRIBUTE42(objTaskBean[i].getATTRIBUTE42());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE42  :: "+objTaskBean[i].getATTRIBUTE42());
			objX41.setATTRIBUTE43(objTaskBean[i].getATTRIBUTE43());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE43  :: "+objTaskBean[i].getATTRIBUTE43());
			objX41.setATTRIBUTE44(objTaskBean[i].getATTRIBUTE44());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE44  :: "+objTaskBean[i].getATTRIBUTE44());
			objX41.setATTRIBUTE45(objTaskBean[i].getATTRIBUTE45());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE45  :: "+objTaskBean[i].getATTRIBUTE45());
			objX41.setATTRIBUTE46(objTaskBean[i].getATTRIBUTE46());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE46  :: "+objTaskBean[i].getATTRIBUTE46());
			objX41.setATTRIBUTE47(objTaskBean[i].getATTRIBUTE47());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE47  :: "+objTaskBean[i].getATTRIBUTE47());
			objX41.setATTRIBUTE48(objTaskBean[i].getATTRIBUTE48());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE48  :: "+objTaskBean[i].getATTRIBUTE48());
			objX41.setATTRIBUTE49(objTaskBean[i].getATTRIBUTE49());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE49  :: "+objTaskBean[i].getATTRIBUTE49());
			objX41.setATTRIBUTE50(objTaskBean[i].getATTRIBUTE50());
			logger.info("SRDataToIPMSMultiple  ATTRIBUTE50  :: "+objTaskBean[i].getATTRIBUTE50());
			arr[i] = objX41;
			}
			
			body.setP_REQUEST_MESSAGE(arr);
			objMongoDB = new MongoDB();
	   		Date reqDate = new Date();
			//System.out.println("body task :: " + body);
			logger.info("Request Number :: "+correlationId+"  srtask :: "+body);
			OutputParameters param = port.PROCESS(header, body);
			// body.setP_REQUEST_MESSAGE(p_REQUEST_MESSAGE);
			// OutputParameters param = port.PROCESS(header, body);
			//
			System.out.println("1::" + param.getX_RETURN_MESSAGE());
			System.out.println("2::" + param.getX_RETURN_STATUS());
			System.out.println("3::" + param.getX_RESPONSE_MESSAGE());
			result.put("status", param.getX_RETURN_STATUS());
			result.put("message", param.getX_RETURN_MESSAGE());
			JSONArray jsonarr = new JSONArray();
			JSONObject jsonobj = null;
			APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
			for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X1X57.length; i++) {
				System.out.println("param id response :: " + objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				jsonobj = new JSONObject();
				jsonobj.put("PARAM_ID", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
				if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS() != null) {
					jsonobj.put("PROC_STATUS", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					}else {
						jsonobj.put("PROC_STATUS", JSONObject.NULL);	
					}
					if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE() != null) {
						jsonobj.put("PROC_MESSAGE", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_MESSAGE());
					}else {
						jsonobj.put("PROC_MESSAGE", JSONObject.NULL);	
					}
	String requestString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"PARAM_ID\":\""+objTaskBean[i].getPARAM_ID()+"\",\"ATTRIBUTE1\":\""+objTaskBean[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objTaskBean[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objTaskBean[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objTaskBean[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objTaskBean[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objTaskBean[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objTaskBean[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objTaskBean[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objTaskBean[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objTaskBean[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objTaskBean[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objTaskBean[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objTaskBean[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objTaskBean[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objTaskBean[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objTaskBean[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objTaskBean[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objTaskBean[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objTaskBean[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objTaskBean[i].getATTRIBUTE20()+"\"}";
					
					objMongoDB.mongoDBInsertFull(P_REQUEST_NUMBER, requestString, "SFDC",reqDate, "IPMS", jsonobj.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());
					jsonarr.put(jsonobj);
			}
			result.put("data", jsonarr);
			logger.info("SRDataToIPMSMultiple  Entire IPMS Response  :: "+result);
			/*String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: " + response);*/
			/*
			 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
			 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
			 * }); t1.start();
			 */
			return result.toString();

		} catch (Exception e) {
			return e.getMessage();

		} 
		
		
	}

	
	
//	public boolean IPMSToSFDC(String Status,String Comments_c,String Task_Id,String Case_Id) {
//		boolean result = false;
//		try {
//			 EnterpriseConnection connection=SFDCConnection.SfdcConnect();
//			 //////////////////////////////////////////////////////////////////////
//			 com.sforce.soap.enterprise.sobject.Task task = new com.sforce.soap.enterprise.sobject.Task();
//			 task.setId(Task_Id);;
//			 task.setStatus(Status);
//			 task.setDescription(Comments_c);
//
//			 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { task });
//			 System.out.println(results1[0].getSuccess()+"::::::");
//			 if(!results1[0].getSuccess()){
//				 System.out.print(results1[0].getErrors()[0].getMessage());
//			 }
//
//			 result = results1[0].getSuccess();
//			 Case objCase = new Case();
//			 objCase.setId(Case_Id);
//			 objCase.setDescription(Comments_c);
//			 objCase.setStatus(Status);
//			 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//			 System.out.println(results2[0].getSuccess()+"::::::");
//			 if(!results2[0].getSuccess()){
//				 System.out.print(results2[0].getErrors()[0].getMessage());
//			 }
//			 result = results2[0].getSuccess();
//			}catch (Exception e) {
//			// TODO: handle exception
//			}
//		return result;
//	}

	
//	public String IPMSToSFDC(String Status,String Comments_c,String Task_Id,String Case_Id,String subject,
//			String optional1,String optional2,String optional3,String optional4,String optional5,String optional6
//			,String optional7,String optional8,String optional9,String optional10,String optional11,String optional12
//			,String optional13,String optional14,String optional15,String optional16,String optional17,String optional18,String optional19
//			,String optional20,String optional21,String optional22,String optional23,String optional24,String optional25) {
//		boolean result = false;
//		try {
//			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
//			 //////////////////////////////////////////////////////////////////////
//			 com.sforce.soap.enterprise.sobject.Task task = new com.sforce.soap.enterprise.sobject.Task();
//		
//			 task.setId(Task_Id);
//			 if(Status.equalsIgnoreCase("Approve")){
//			 task.setStatus("Completed");
//			 if(subject.equalsIgnoreCase("Verify Proof of Payment Details in IPMS")) {
//			 		task.setDocument_Number__c(optional23);
//			 		task.setReceipt_Number__c(optional24);
//			 		task.setCash_Receipt_Id__c(optional25);
//			 	}
//			 }else {
//				 task.setStatus(Status);
//			 }
//			 task.setDescription(Comments_c);
//			 //task.setDocument_URL__c(Document_URL__c);
//			 task.setDocument_URL__c(optional2);
//			 
//			 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { task });
//			 System.out.println(subject +"::::::" + results1[0].getSuccess());
//			 logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
//			 if(!results1[0].getSuccess()){
//				 System.out.print(subject +"::::::" + results1[0].getErrors()[0].getMessage());
//			 }
//
//			 result = results1[0].getSuccess();
//
//				if(subject.equalsIgnoreCase("SELLER POA Verification Pending") && result) {
//					
//				}else if(subject.equalsIgnoreCase("BUYER POA Verification Pending") && result){
//					
//				}else if(subject.equalsIgnoreCase("Scan & Upload Documents in system – Hard copy to CDC") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setDocuments_Uploaded__c(Boolean.parseBoolean(optional1));
//					// objCase.setDocument
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//						 
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Transfer of Account") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setTransfer_Account__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//						 
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Verify the new title deed / customer name with DLD website & update system with new buyer details") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setNew_Buyer_Details_Updated__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Validate new buyer details") && result){
//					
//				}else if(subject.equalsIgnoreCase("Assignment Payment Due") && result){
//					
//				}else if(subject.equalsIgnoreCase("Automated application of funds to the new account") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setAllocate_funds__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("SPA Execution process") && result){
//					
//				}else if(subject.equalsIgnoreCase("Update Buyer SOA") && result){
//					if(Status.equalsIgnoreCase("Approve")){ 
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setBuyer_SOA__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Verify the new Title Deed / customer name with DIFC records & update system with new buyer details") && result){
//					
//				}else if(subject.equalsIgnoreCase("SPA Archival & Audit") && result){
//					if(Status.equalsIgnoreCase("Approve")){ 
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setSPA_Archival_Audit__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+ subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Lease Agreement Execution process") && result){
//					
//				}else if(subject.equalsIgnoreCase("Lease Agreement Archival & Audit") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setSPA_Archival_Audit__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Verify POA Details") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					 Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setIs_POA_Verified__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Verify COCD Fee") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//					 Case objCase = new Case();
//					 objCase.setId(Case_Id);
//					 objCase.setOQOOD_Fee_Verified__c(Boolean.parseBoolean(optional1));
//					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//					 if(!results2[0].getSuccess()){
//						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//					 }
//					 result = results2[0].getSuccess();
//					}
//				}else if(subject.equalsIgnoreCase("Confirm date to replace") && result){
//					if(Status.equalsIgnoreCase("Approve")){
//						 Case objCase = new Case();
//						 objCase.setId(Case_Id);
//						 Calendar cal = Calendar.getInstance();
//		            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//		     			 Date varDate=dateFormat.parse(optional1);
//		     			 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
//		     			 System.out.println("Date :"+dateFormat.format(varDate));
//		     			 cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
//		            	 objCase.setCheque_Availability_Date__c(cal);
//						 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//						 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//						 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//						 if(!results2[0].getSuccess()){
//							 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//						 }
//						 result = results2[0].getSuccess();
//						}
//					}else if(subject.equalsIgnoreCase("Confirm dt for security chq coll") && result){
//						if(Status.equalsIgnoreCase("Approve")){
//							 Case objCase = new Case();
//							 objCase.setId(Case_Id);
//							 Calendar cal = Calendar.getInstance();
//			            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//			     			 Date varDate=dateFormat.parse(optional1);
//			     			 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
//			     			 System.out.println("Date :"+dateFormat.format(varDate));
//			     			 cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
//			            	 objCase.setCheque_Availability_Date__c(cal);
//							 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//							 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//							 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//							 if(!results2[0].getSuccess()){
//								 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//							 }
//							 result = results2[0].getSuccess();
//							}
//						}else if(subject.equalsIgnoreCase("Update commencement date in system") && result){
//							if(Status.equalsIgnoreCase("Approve")){
//								 Case objCase = new Case();
//								 objCase.setId(Case_Id);
//								 Calendar cal = Calendar.getInstance();
//				            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//				     			 Date varDate=dateFormat.parse(optional1);
//				     			 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
//				     			 System.out.println("Date :"+dateFormat.format(varDate));
//				     			 cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
//				            	 objCase.setCommencement_Date__c(cal);
//								 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
//								 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//								 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//								 if(!results2[0].getSuccess()){
//									 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//								 }
//								 result = results2[0].getSuccess();
//								}
//							}else if(subject.equalsIgnoreCase("Upload Title Deed Copy") && result){
//								if(Status.equalsIgnoreCase("Approve")){
//									 SR_Attachments__c objSR_Attachments__c = new SR_Attachments__c();
//									 objSR_Attachments__c.setName("Title Deed Copy");
//									 objSR_Attachments__c.setType__c("Title Deed");
//									 objSR_Attachments__c.setCase__c(Case_Id);
//									 objSR_Attachments__c.setAttachment_URL__c(optional23);
//									 System.out.println("Upload Title Deed Copy :: Attachment_URL__c :: "+optional23);
//									 logger.info("Upload Title Deed Copy :: Attachment_URL__c :: "+optional23);
//									 QueryResult queryResultsCase = connection.query("select Booking_Unit__c From Case where Id = '"+Case_Id+"' ");
//					            	  System.out.println(subject +"::::::" + "queryResults 2 length :: "+queryResultsCase.getSize() + " Query :: select Booking_Unit__c From Case where Id = '"+Case_Id+"'");
//					            	  if (queryResultsCase.getSize() > 0) {
//					            	  for (int queryResultsCasei=0;queryResultsCasei<queryResultsCase.getSize();queryResultsCasei++){
//					                	  Case c = (Case)queryResultsCase.getRecords()[queryResultsCasei];
//					                	  objSR_Attachments__c.setBooking_Unit__c(c.getBooking_Unit__c());
//					            	   }
//					            	  }
//									 com.sforce.soap.enterprise.SaveResult[] results2 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { objSR_Attachments__c });
//									 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
//									 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
//									 if(!results2[0].getSuccess()){
//										 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
//									 }
//									 result = results2[0].getSuccess();
//									}
//								}
//			 
//			}catch (Exception e) {
//			// TODO: handle exception
//				return e.getMessage();
//			}
//		String res = String.valueOf(result);
//		return res;
//	}
	
	public String IPMSToSFDC(String Status,String Comments_c,String Task_Id,String Case_Id,String subject,
			String optional1,String optional2,String optional3,String optional4,String optional5,String optional6
			,String optional7,String optional8,String optional9,String optional10,String optional11,String optional12
			,String optional13,String optional14,String optional15,String optional16,String optional17,String optional18,String optional19
			,String optional20,String optional21,String optional22,String optional23,String optional24,String optional25) {
		boolean result = false;
		try {
			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			 //////////////////////////////////////////////////////////////////////
			 com.sforce.soap.enterprise.sobject.Task task = new com.sforce.soap.enterprise.sobject.Task();
			 task.setId(Task_Id);
			 if(Status.equalsIgnoreCase("Approve")){
			 task.setStatus("Completed");
			 if(subject.equalsIgnoreCase("Verify Proof of Payment Details in IPMS") || subject.equalsIgnoreCase("Verify Proof of Payment Details in IPMS.")) {
				 if(Case_Id.startsWith("500")) {
				 	task.setDocument_Number__c(optional23);
			 		task.setReceipt_Number__c(optional24);
			 		task.setCash_Receipt_Id__c(optional25);
				 }else {
			 		task.setDocument_Number__c(optional25);
			 		task.setReceipt_Number__c(optional24);
			 		task.setCash_Receipt_Id__c(optional23);
				 }
				 
			 	}
			 }else {
				 task.setStatus(Status);
			 }
			 if(subject.equalsIgnoreCase("Verify Proof of Payment Details in IPMS") || subject.equalsIgnoreCase("Verify Proof of Payment Details in IPMS.")) {
				 task.setNotes__c(optional15);
			 }
			 
			 logger.info("IPMSToSFDC  :: Message :: Subject :: "+ subject +" TaskId :: " +Task_Id + " CaseId :: " +Case_Id + " Status :: "+Status);
			 logger.info("IPMSToSFDC  :: Message :: Subject :: "+ subject +" :: optional1 :: " +optional1 + " :: optional2 :: " +optional2 + " :: optional3 :: "+optional3+ " :: optional4 :: "+optional4+ " :: optional5 :: "+optional5+ " :: optional6 :: "+optional6+ " :: optional7 :: "+optional7+ " :: optional8 :: "+optional8+ " :: optional9 :: "+optional9+ " :: optional10 :: "+optional10+ " :: optional11 :: "+optional11+ " :: optional12 :: "+optional12+ " :: optional13 :: "+optional13+ " :: optional14 :: "+optional14+ " :: optional15 :: "+optional15+ " :: optional16 :: "+optional16+ " :: optional17 :: "+optional17+ " :: optional18 :: "+optional18+ " :: optional19 :: "+optional19+ " :: optional20 :: "+optional20+ " :: optional21 :: "+optional21+ " :: optional22 :: "+optional22);
			 logger.info("IPMSToSFDC  :: Message :: Subject :: "+ subject +" :: optional23 :: " +optional23 + " :: optional24 :: " +optional24 + " :: optional25 :: "+optional25);
			 task.setDescription(Comments_c);
			 //task.setDocument_URL__c(Document_URL__c);
			 task.setDocument_URL__c(optional2);
			 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { task });
			 System.out.println(subject +"::::::" + results1[0].getSuccess());
			 logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
			 if(!results1[0].getSuccess()){
				 System.out.print(subject +"::::::" + results1[0].getErrors()[0].getMessage());
				 logger.info("Subject :: "+ subject +" TaskId :: " +Task_Id +"::::::" + results1[0].getErrors()[0].getMessage());
			 }

			 result = results1[0].getSuccess();

				if(subject.equalsIgnoreCase("SELLER POA Verification Pending") && result) {
					
				}else if(subject.equalsIgnoreCase("BUYER POA Verification Pending") && result){
					
				}else if(subject.equalsIgnoreCase("Scan & Upload Documents in system – Hard copy to CDC") && result){
					if(Status.equalsIgnoreCase("Approve")){
					if(Case_Id.startsWith("500")) {	
					 Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setDocuments_Uploaded__c(Boolean.parseBoolean(optional1));
					 //objCase.setNot
					// objCase.setDocument
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
						 
					 }
					 result = results2[0].getSuccess();
					}else {
						result = true;
					}
					}
				}else if(subject.equalsIgnoreCase("Transfer of Account") && result){
					if(Status.equalsIgnoreCase("Approve")){
					if(Case_Id.startsWith("500")) {	
					Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setTransfer_Account__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
						 
					 }
					 result = results2[0].getSuccess();
					}else {
						result = true;
					}
					}
				}else if(subject.equalsIgnoreCase("Verify the new title deed / customer name with DLD website & update system with new buyer details") && result){
					if(Status.equalsIgnoreCase("Approve")){
					if(Case_Id.startsWith("500")) {
					Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setNew_Buyer_Details_Updated__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
						}else {
							result = true;
						}
					}
				}else if(subject.equalsIgnoreCase("Validate new buyer details") && result){
					
				}else if(subject.equalsIgnoreCase("Assignment Payment Due") && result){
					
				}else if(subject.equalsIgnoreCase("Automated application of funds to the new account") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
					Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setAllocate_funds__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
						}else {
							result = true;
						}
					}
				}else if(subject.equalsIgnoreCase("SPA Execution process") && result){
					
				}else if(subject.equalsIgnoreCase("Update Buyer SOA") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
					Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setBuyer_SOA__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
						}else {
							result = true;
						}
					}
				}else if(subject.equalsIgnoreCase("Verify the new Title Deed / customer name with DIFC records & update system with new buyer details") && result){
					
				}else if(subject.equalsIgnoreCase("SPA Archival & Audit") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
					Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setSPA_Archival_Audit__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+ subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
					}else {
						result = true;
					}
					}
				}else if(subject.equalsIgnoreCase("Lease Agreement Execution process") && result){
					
				}else if(subject.equalsIgnoreCase("Lease Agreement Archival & Audit") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
					Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setSPA_Archival_Audit__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
					}else {
						result = true;
					}
					}
				}else if(subject.equalsIgnoreCase("Verify POA Details") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
					 Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setIs_POA_Verified__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
					}else {
						result = true;
					}
					}
				}else if(subject.equalsIgnoreCase("Verify COCD Fee") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
					 Case objCase = new Case();
					 objCase.setId(Case_Id);
					 objCase.setOQOOD_Fee_Verified__c(Boolean.parseBoolean(optional1));
					 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
					 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
					 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
					 if(!results2[0].getSuccess()){
						 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
					 }
					 result = results2[0].getSuccess();
					}else {
						result = true;
					}
					}
				}
				else if(subject.equalsIgnoreCase("Confirm date to replace") && result){
					if(Status.equalsIgnoreCase("Approve")){
						if(Case_Id.startsWith("500")) {
						 Case objCase = new Case();
						 objCase.setId(Case_Id);
						 Calendar cal = Calendar.getInstance();
		            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		     			 Date varDate=dateFormat.parse(optional1);
		     			 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		     			 System.out.println("Date :"+dateFormat.format(varDate));
		     			 cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
		            	 objCase.setCheque_Availability_Date__c(cal);
						 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
						 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
						 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
						 if(!results2[0].getSuccess()){
							 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
						 }
						 result = results2[0].getSuccess();
					}else {
						result = true;
					}
						}
					}else if(subject.equalsIgnoreCase("Confirm dt for security chq coll") && result){
						if(Status.equalsIgnoreCase("Approve")){
							if(Case_Id.startsWith("500")) {
							 Case objCase = new Case();
							 objCase.setId(Case_Id);
							 Calendar cal = Calendar.getInstance();
			            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			     			 Date varDate=dateFormat.parse(optional1);
			     			 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
			     			 System.out.println("Date :"+dateFormat.format(varDate));
			     			 cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
			            	 objCase.setCheque_Availability_Date__c(cal);
							 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
							 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
							 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
							 if(!results2[0].getSuccess()){
								 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
							 }
							 result = results2[0].getSuccess();
						}else {
							result = true;
						}
							}
						}else if(subject.equalsIgnoreCase("Update commencement date in system") && result){
							if(Status.equalsIgnoreCase("Approve")){
								if(Case_Id.startsWith("500")) {
								 Case objCase = new Case();
								 objCase.setId(Case_Id);
								 Calendar cal = Calendar.getInstance();
				            	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				     			 Date varDate=dateFormat.parse(optional1);
				     			 dateFormat=new SimpleDateFormat("dd/MM/yyyy");
				     			 System.out.println("Date :"+dateFormat.format(varDate));
				     			 cal.setTime(dateFormat.parse(dateFormat.format(varDate)));
				            	 objCase.setCommencement_Date__c(cal);
								 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objCase });
								 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
								 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
								 if(!results2[0].getSuccess()){
									 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
								 }
								 result = results2[0].getSuccess();
							}else {
								result = true;
							}
								}
							}else if(subject.equalsIgnoreCase("Upload Title Deed Copy") && result){
								if(Status.equalsIgnoreCase("Approve")){
									if(Case_Id.startsWith("500")) {
									 SR_Attachments__c objSR_Attachments__c = new SR_Attachments__c();
									 objSR_Attachments__c.setName("Title Deed Copy");
									 objSR_Attachments__c.setType__c("Title Deed");
									 objSR_Attachments__c.setCase__c(Case_Id);
									 objSR_Attachments__c.setAttachment_URL__c(optional23);
									 QueryResult queryResultsCase = connection.query("select Booking_Unit__c From Case where Id = '"+Case_Id+"' ");
					            	  System.out.println(subject +"::::::" + "queryResults 2 length :: "+queryResultsCase.getSize() + " Query :: select Booking_Unit__c From Case where Id = '"+Case_Id+"'");
					            	  if (queryResultsCase.getSize() > 0) {
					            	  for (int queryResultsCasei=0;queryResultsCasei<queryResultsCase.getSize();queryResultsCasei++){
					                	  Case c = (Case)queryResultsCase.getRecords()[queryResultsCasei];
					                	  objSR_Attachments__c.setBooking_Unit__c(c.getBooking_Unit__c());
					            	   }
					            	  }
									 com.sforce.soap.enterprise.SaveResult[] results2 = connection.create(new com.sforce.soap.enterprise.sobject.SObject[] { objSR_Attachments__c });
									 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
									 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
									 if(!results2[0].getSuccess()){
										 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
									 }
									 result = results2[0].getSuccess();
								}else {
									result = true;
								}
									}
							}else if(subject.equalsIgnoreCase("Verify in Authority and upload new title deed") && result){
								if(Status.equalsIgnoreCase("Approve")){
									if(Case_Id.startsWith("500")) {
										
									 QueryResult queryResultsSR_Attachment = connection.query("Select Id, Name, Attachment_URL__c, IsValid__c, Case__c from SR_Attachments__c where Name = 'Title Deed Document' and Case__c ='"+Case_Id+"'");
					            	  System.out.println(subject +"::::::" + "queryResults 2 length :: "+queryResultsSR_Attachment.getSize() + " Query :: Select Id, Name, Attachment_URL__c, IsValid__c, Case__c from SR_Attachments__c where Name = 'Title Deed Document' and Case__c ='"+Case_Id+"'");
					            	  SR_Attachments__c objSR_Attachments__c = null;
					            	  if (queryResultsSR_Attachment.getSize() > 0) {
					            	  for (int queryResultsCasei=0;queryResultsCasei<queryResultsSR_Attachment.getSize();queryResultsCasei++){
					            		  //SR_Attachments__c objSR_Attachments__c = new SR_Attachments__c();
					            		  objSR_Attachments__c = (SR_Attachments__c)queryResultsSR_Attachment.getRecords()[queryResultsCasei];
					            		  objSR_Attachments__c.setId(objSR_Attachments__c.getId());
					            		  objSR_Attachments__c.setAttachment_URL__c(optional23);
					            		  objSR_Attachments__c.setIsValid__c(true);
					            	   }
					            	  }
									 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objSR_Attachments__c });
									 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
									 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
									 if(!results2[0].getSuccess()){
										 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
									 }
									 result = results2[0].getSuccess();
								}else {
									result = true;
								}
									}
							}else if(subject.equalsIgnoreCase("Verify transfer and upload proof") && result){
								if(Status.equalsIgnoreCase("Approve")){
									if(Case_Id.startsWith("500")) {
										
									 QueryResult queryResultsSR_Attachment = connection.query("Select Id, Name, Attachment_URL__c, IsValid__c, Case__c from SR_Attachments__c where Name = 'Authority Document' and Case__c ='"+Case_Id+"'");
					            	  System.out.println(subject +"::::::" + "queryResults 2 length :: "+queryResultsSR_Attachment.getSize() + " Query :: Select Id, Name, Attachment_URL__c, IsValid__c, Case__c from SR_Attachments__c where Name = 'Authority Document' and Case__c ='"+Case_Id+"'");
					            	  SR_Attachments__c objSR_Attachments__c = null;
					            	  if (queryResultsSR_Attachment.getSize() > 0) {
					            	  for (int queryResultsCasei=0;queryResultsCasei<queryResultsSR_Attachment.getSize();queryResultsCasei++){
					            		  //SR_Attachments__c objSR_Attachments__c = new SR_Attachments__c();
					            		  objSR_Attachments__c = (SR_Attachments__c)queryResultsSR_Attachment.getRecords()[queryResultsCasei];
					            		  objSR_Attachments__c.setId(objSR_Attachments__c.getId());
					            		  objSR_Attachments__c.setAttachment_URL__c(optional23);
					            		  objSR_Attachments__c.setIsValid__c(true);
					            	   }
					            	  }
									 com.sforce.soap.enterprise.SaveResult[] results2 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { objSR_Attachments__c });
									 System.out.println("IPMSToSFDC Case :: Message "+subject +"::::::" + results2[0].getSuccess());
									 logger.info("IPMSToSFDC Case :: Message "+ subject +" :::::: " + results2[0].getSuccess());
									 if(!results2[0].getSuccess()){
										 System.out.print(subject +"::::::" + results2[0].getErrors()[0].getMessage());
									 }
									 result = results2[0].getSuccess();
								}else {
									result = true;
								}
									}
							}
			 
			}catch (Exception e) {
			// TODO: handle exception
				return e.getMessage();
			}
		String res = String.valueOf(result);
		return res;
	}

	
/*	public String  SRDataToIPMS(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String SRNumber,String SRDataType,String SRName,String SRStatus
			,String SRCreator,String IPMSPartyId,String RegistrationId,String SRCreationDate,String SFDCTaskId,String TaskDueDate,String ValuesDependingOnSRType,String TaskCloseDate,String TaskCloseBy,String ApprovalStatus,String TaskComment,String SRNote)
	{
		// url    SRDataToIPMS?P_REQUEST_NUMBER=&P_REQUEST_NAME=&P_SOURCE_SYSTEM=&SRNumber=&SRDataType=&SRName=&SRStatus=&SRCreator=&IPMSPartyId=&RegistrationId=&SRCreationDate=&SFDCTaskId=&TaskDueDate=&ValuesDependingOnSRType=&TaskCloseDate=&TaskCloseBy=&ApprovalStatus=&TaskComment=&SRNote=
//process
		//TaskBean objTaskBean = new TaskBean();
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
			return param.getX_RETURN_STATUS();

		} catch (Exception e) {
			return e.getMessage();

		} 
		
		
	}*/

	
}
