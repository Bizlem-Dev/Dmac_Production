package com.action;

import java.sql.ResultSet;
import java.util.Date;

import org.apache.axis2.databinding.types.soapencoding.Base64Binary;
import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.activeMQ.FtpClientIPMS;
import com.bean.MongoDB;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;


public class AOPTOld {

	 static Logger logger = null; 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	
	public String PaymentPlanCreation(String P_REGISTRATION_ID, String P_SR_NUMBER, String P_SR_TYPE,
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] regTerms) {
		logger = Logger.getLogger(AOPTOld.class);
	//http://localhost:8080/CRM_SR_NEW/services/AOPT/PaymentPlanCreation?P_REGISTRATION_ID=10745&P_SR_NUMBER=123&P_SR_TYPE=AMENDMENT_OF_PAYMENT_TERMS&INSTALLMENT=2&DESCRIPTION=afas&PAYMENT_DATE=30-03-2016&EXPECTED_DATE=30-04-2016&MILESTONE_EVENT=casvs&PERCENT_VALUE=32&TRANSFER_AR_INTER_FLAG=Y&PAYMENT_AMOUNT=22	
	JSONObject result = new JSONObject();
	final String queueName = "IPMS.AOPT.PaymentPlanCreationUAT";
	//logger.info("queueName :: "+queueName);

		//"SRNumber":""+SRNumber+"",
	//String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\",\"P_SR_TYPE\":\""+P_SR_TYPE+"\",\"INSTALLMENT\":\""+INSTALLMENT+"\",\"DESCRIPTION\":\""+DESCRIPTION+"\",\"PAYMENT_DATE\":\""+PAYMENT_DATE+"\",\"\"EXPECTED_DATE\":\""+EXPECTED_DATE+"\",\"TRANSFER_AR_INTER_FLAG\":\""+TRANSFER_AR_INTER_FLAG+"\",\"PAYMENT_AMOUNT\":\""+PAYMENT_AMOUNT+"\",\"MILESTONE_EVENT\":\""+MILESTONE_EVENT+"\",\"PERCENT_VALUE\":\""+PERCENT_VALUE+"\"}";
	String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\",\"P_SR_TYPE\":\""+P_SR_TYPE+"\"}";
	logger.info("AOPTPaymentPlanCreation :: "+jsonString);

	if(activemqcall == null) {
		activemqcall=new ActiveMQCall();
	}
		String correlationId = activemqcall.createRandomString();
//		String correlationId = P_REQUEST_NUMBER;
		System.out.println("1 :: "+correlationId);	
		correlationId=activemqcall.GetProducer(queueName,P_REGISTRATION_ID,correlationId,jsonString);
		System.out.println("2 :: "+correlationId);

	try {
		XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = new XXDC_AOPT_PKG_WS_ServiceLocator();
		XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
		SOAHeader header = new SOAHeader();
   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters aoptplancreation = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters();
		aoptplancreation.setP_REGISTRATION_ID(P_REGISTRATION_ID);
		aoptplancreation.setP_SR_NUMBER(P_SR_NUMBER);
		aoptplancreation.setP_SR_TYPE(P_SR_TYPE);
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] arr = 
				new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[regTerms.length];
		JSONObject obj=new JSONObject();
		JSONArray jsonarr=new JSONArray();
		JSONObject subobj=null;
		
		
		for(int i=0;i<regTerms.length;i++) {
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5 aoptplancreationfields 
			= new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5();
			aoptplancreationfields.setREGISTRATION_ID(regTerms[i].getREGISTRATION_ID());
			aoptplancreationfields.setTERM_ID(regTerms[i].getTERM_ID());
			aoptplancreationfields.setLINE_ID(regTerms[i].getLINE_ID());
			aoptplancreationfields.setINSTALLMENT(regTerms[i].getINSTALLMENT());
			aoptplancreationfields.setDESCRIPTION(regTerms[i].getDESCRIPTION());
			aoptplancreationfields.setPAYMENT_DATE(regTerms[i].getPAYMENT_DATE());
			aoptplancreationfields.setEXPECTED_DATE(regTerms[i].getEXPECTED_DATE());
			aoptplancreationfields.setMILESTONE_EVENT(regTerms[i].getMILESTONE_EVENT());
			aoptplancreationfields.setPERCENT_VALUE(regTerms[i].getPERCENT_VALUE());
			aoptplancreationfields.setSTATUS(regTerms[i].getSTATUS());
			aoptplancreationfields.setTRANSFER_AR_INTER_FLAG(regTerms[i].getTRANSFER_AR_INTER_FLAG());
			aoptplancreationfields.setPAYMENT_AMOUNT(regTerms[i].getPAYMENT_AMOUNT());
			arr[i] = aoptplancreationfields;
			subobj=new JSONObject();
			subobj.put(P_REGISTRATION_ID, regTerms[i].getREGISTRATION_ID());
			subobj.put("TERM_ID", regTerms[i].getTERM_ID());
			subobj.put("LINE_ID", regTerms[i].getLINE_ID());
			subobj.put("INSTALLMENT", regTerms[i].getINSTALLMENT());
			subobj.put("DESCRIPTION", regTerms[i].getDESCRIPTION());
			subobj.put("PAYMENT_DATE", regTerms[i].getPAYMENT_DATE());
			subobj.put("EXPECTED_DATE", regTerms[i].getEXPECTED_DATE());
			subobj.put("MILESTONE_EVENT", regTerms[i].getMILESTONE_EVENT());
			subobj.put("PERCENT_VALUE", regTerms[i].getPERCENT_VALUE());
			subobj.put("STATUS", regTerms[i].getSTATUS());
			subobj.put("TRANSFER_AR_INTER_FLAG", regTerms[i].getTRANSFER_AR_INTER_FLAG());
			subobj.put("PAYMENT_AMOUNT", regTerms[i].getPAYMENT_AMOUNT());
			jsonarr.put(subobj);
			//arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] {aoptplancreationfields};
			
		}
		obj.put("data", jsonarr);
		aoptplancreation.setP_REG_TERMS(arr);
   		objMongoDB = new MongoDB(); 
   		Date reqDate = new Date();
		
		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters aoptplancreationout = port_aopt.PAYMENT_PLAN_CREATION(header, aoptplancreation);
		System.out.println(aoptplancreationout.getX_RETURN_STATUS());
		logger.info("AOPTPaymentPlanCreation response status :: "+aoptplancreationout.getX_RETURN_STATUS());
		result.put("status", aoptplancreationout.getX_RETURN_STATUS());
		result.put("message", aoptplancreationout.getX_ERROR_MSG());
		

		String requestString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\",\"P_SR_TYPE\":\""+P_SR_TYPE+"\",\"REQUEST_JSON\":\""+obj.toString()+"\"}";
			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), aoptplancreationout.getX_RETURN_STATUS());

	}catch (Exception e) {
		// TODO: handle exception
		try {
		result.put("status", "E");
		result.put("message", e.getMessage());
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	String response = activemqcall.GetConsumer(queueName);
		System.out.println("3 4:: "+response);
	return result.toString();	
	}
	
	
	public String PaymentPlanReversal( String P_REGISTRATION_ID, String P_SR_NUMBER) {
		//String res="AOPTPaymentPlanCreation";
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/PaymentPlanReversal?P_REGISTRATION_ID=10745&P_SR_NUMBER=123
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.AOPT.PaymentPlanReversalUAT";
		//logger.info("queueName :: "+queueName);

			//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\"}";
		logger.info("AOPTPaymentPlanReversal :: "+jsonString);

		
		activemqcall=new ActiveMQCall();
			String correlationId = activemqcall.createRandomString();
//			String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: "+correlationId);	
			correlationId=activemqcall.GetProducer(queueName,P_REGISTRATION_ID,correlationId,jsonString);
			System.out.println("2 :: "+correlationId);

		try {
			XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = new XXDC_AOPT_PKG_WS_ServiceLocator();
			XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
			SOAHeader header = new SOAHeader();
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.InputParameters aoptplanreversal = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.InputParameters();
			aoptplanreversal.setP_REGISTRATION_ID(P_REGISTRATION_ID);
			aoptplanreversal.setP_SR_NUMBER(P_SR_NUMBER);
			
			objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();

			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters aoptplanreversalout = port_aopt.PAYMENT_PLAN_REVERSAL(header, aoptplanreversal);
			System.out.println(aoptplanreversalout.getX_RETURN_STATUS());
			logger.info("AOPTPaymentPlanReversal response status :: "+aoptplanreversalout.getX_RETURN_STATUS());
			result.put("status", aoptplanreversalout.getX_RETURN_STATUS());
			result.put("message", aoptplanreversalout.getX_ERROR_MSG());
			
String requestString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\"}";
			
			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), aoptplanreversalout.getX_RETURN_STATUS());

		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("status", "E");
			result.put("message", e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: "+response);
		return result.toString();	
			
		}
	
	public String PaymentPlanReversalCurrent( String P_REGISTRATION_ID, String P_SR_NUMBER) {
		String res="AOPTPaymentPlanReversalCurrent";
		
		return res;	
		}
	
	
	public String PaymentPlanHistory(String P_REGISTRATION_ID, String P_SR_NUMBER) {
	
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.AOPT.PaymentPlanHistoryUAT";
		//logger.info("queueName :: "+queueName);

			//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\"}";
		logger.info("PaymentPlanHistory :: "+jsonString);

		
		activemqcall=new ActiveMQCall();
			String correlationId = activemqcall.createRandomString();
//			String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: "+correlationId);	
			correlationId=activemqcall.GetProducer(queueName,P_REGISTRATION_ID,correlationId,jsonString);
			System.out.println("2 :: "+correlationId);

		try {
			XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = new XXDC_AOPT_PKG_WS_ServiceLocator();
			XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
			SOAHeader header = new SOAHeader();
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.InputParameters aoptplanhistory = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.InputParameters();
			aoptplanhistory.setP_REGISTRATION_ID(P_REGISTRATION_ID);
			aoptplanhistory.setP_SR_NUMBER(P_SR_NUMBER);
			
			objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
	   		
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters aoptplanhistoryout = port_aopt.PRIOR_AOPT_DETAILS(header, aoptplanhistory);
			System.out.println(aoptplanhistoryout.getX_RETURN_STATUS());
			logger.info("PaymentPlanHistory response status :: "+aoptplanhistoryout.getX_RETURN_STATUS());
			for(int i=0;i<aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE().length;i++) {
				result.put("REGISTRATION_ID", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getREGISTRATION_ID());
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getTERM_ID() != null) {
				result.put("TERM_ID", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getTERM_ID());
				}else {
					result.put("TERM_ID", JSONObject.NULL);	
				}
				if( aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getLINE_ID() != null) {
				result.put("LINE_ID", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getLINE_ID());
				}else {
					result.put("LINE_ID", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getINSTALLMENT() != null) {
				result.put("INSTALLMENT", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getINSTALLMENT());
				}else {
					result.put("INSTALLMENT", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getDESCRIPTION() != null) {
				result.put("DESCRIPTION", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getDESCRIPTION());
				}else {
					result.put("DESCRIPTION", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getPAYMENT_DATE() != null) {
				result.put("PAYMENT_DATE", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getPAYMENT_DATE());
				}else {
					result.put("PAYMENT_DATE", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getEXPECTED_DATE() != null) {
				result.put("EXPECTED_DATE", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getEXPECTED_DATE());
				}else {
					result.put("EXPECTED_DATE", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getMILESTONE_EVENT() != null) {
				result.put("MILESTONE_EVENT", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getMILESTONE_EVENT());
				}else {
					result.put("MILESTONE_EVENT", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getPERCENT_VALUE() != null) {
				result.put("PERCENT_VALUE", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getPERCENT_VALUE());
				}else {
					result.put("PERCENT_VALUE", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getSTATUS() != null) {
				result.put("STATUS", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getSTATUS());
				}else {
					result.put("STATUS", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getTRANSFER_AR_INTER_FLAG() != null) {
				result.put("TRANSFER_AR_INTER_FLAG", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getTRANSFER_AR_INTER_FLAG());
				}else {
					result.put("TRANSFER_AR_INTER_FLAG", JSONObject.NULL);	
				}
				if(aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getPAYMENT_AMOUNT() != null) {
				result.put("PAYMENT_AMOUNT", aoptplanhistoryout.getX_PRIOR_REG_TERMS_TABLE()[i].getPAYMENT_AMOUNT());
				}else {
					result.put("PAYMENT_AMOUNT", JSONObject.NULL);	
				}
				
				
			}
			result.put("status", aoptplanhistoryout.getX_RETURN_STATUS());
			result.put("message", aoptplanhistoryout.getX_ERROR_MSG());
			
			 String requestString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\"}";
				
		       objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), aoptplanhistoryout.getX_RETURN_STATUS());

		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("status", "E");
			result.put("message", e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: "+response);
		return result.toString();
		
		}
	
	public String RegistrationDetails( String P_REGISTRATION_ID, String P_SR_NUMBER) {
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.AOPT.RegistrationDetailsUAT";
		//logger.info("queueName :: "+queueName);
//http://localhost:8080/CRM_SR_NEW/services/AOPT/AOPTRegistrationDetails?P_REGISTRATION_ID=10745&P_SR_NUMBER=123
			//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\"}";
		logger.info("AOPTRegistrationDetails :: "+jsonString);

		
		activemqcall=new ActiveMQCall();
			String correlationId = activemqcall.createRandomString();
//			String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: "+correlationId);	
			correlationId=activemqcall.GetProducer(queueName,P_REGISTRATION_ID,correlationId,jsonString);
			System.out.println("2 :: "+correlationId);

		try {
			XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = new XXDC_AOPT_PKG_WS_ServiceLocator();
			XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
			SOAHeader header = new SOAHeader();
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.InputParameters aoptreg = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.InputParameters();
	   		aoptreg.setP_REGISTRATION_ID(P_REGISTRATION_ID);
	   		aoptreg.setP_SR_NUMBER(P_SR_NUMBER);
	   		objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters aoptregout = port_aopt.AOPT_REGISTRATION_DETAILS(header, aoptreg);
			System.out.println(aoptregout.getX_RETURN_STATUS());
			logger.info("AOPTRegistrationDetails response status :: "+aoptregout.getX_RETURN_STATUS());
			if(aoptregout.getX_DISPUTE_VALUE() != null) {
			result.put("X_DISPUTE_VALUE", aoptregout.getX_DISPUTE_VALUE());
			}else {
				result.put("X_DISPUTE_VALUE", JSONObject.NULL);	
			}
			if(aoptregout.getX_PARAM_VALUE() != null) {
			result.put("X_PARAM_VALUE", aoptregout.getX_PARAM_VALUE());
			}else {
				result.put("X_PARAM_VALUE", JSONObject.NULL);
			}
			if(aoptregout.getX_MORTGAGE() != null) {
			result.put("X_MORTGAGE", aoptregout.getX_MORTGAGE());
			}else {
				result.put("X_MORTGAGE", JSONObject.NULL);
			}
			if(aoptregout.getX_HAND_OVER() != null) {
			result.put("X_HAND_OVER", aoptregout.getX_HAND_OVER());
			}else {
				result.put("X_HAND_OVER", JSONObject.NULL);
			}
			if(aoptregout.getX_EARLY_HAND_OVER() != null) {
			result.put("X_EARLY_HAND_OVER", aoptregout.getX_EARLY_HAND_OVER());
			}else {
				result.put("X_EARLY_HAND_OVER", JSONObject.NULL);
			}
			if(aoptregout.getX_OQOOD_FLAG() != null) {
			result.put("X_OQOOD_FLAG", aoptregout.getX_OQOOD_FLAG());
			}else {
				result.put("X_OQOOD_FLAG", JSONObject.NULL);
			}
			if(aoptregout.getX_RERA_PERCENT() != null) {
			result.put("X_RERA_PERCENT", aoptregout.getX_RERA_PERCENT());
			}else {
				result.put("X_RERA_PERCENT", JSONObject.NULL);
			}
			result.put("status", aoptregout.getX_RETURN_STATUS());
			result.put("message", aoptregout.getX_ERROR_MSG());
			
			
String requestString ="{\"P_REGISTRATION_ID\":\""+P_REGISTRATION_ID+"\",\"P_SR_NUMBER\":\""+P_SR_NUMBER+"\"}";
			
			objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC", reqDate, "IPMS", result.toString(), aoptregout.getX_RETURN_STATUS());

		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("status", "E");
			result.put("message", e.getMessage());
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: "+response);
			logger.info("AOPTRegistrationDetails json output :: "+result);
		return result.toString();	
			
        }
	
	public String EarlyHandoverPaymentPlanCreation( String P_REGISTRATION_ID, String P_SR_NUMBER, String P_SR_TYPE,String REGISTRATION_ID, String INSTALLMENT, String DESCRIPTION,String PAYMENT_DATE,String EXPECTED_DATE,String MILESTONE_EVENT,String PERCENT_VALUE,String TRANSFER_AR_INTER_FLAG,String PAYMENT_AMOUNT) {
		String res="EarlyHandoverPaymentPlanCreation";
		
		return res;	
        }
	
	
	
	
	public  String DocumentAttachment(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.AOPT.DOCUMENTATTACHMENTUAT";
			System.out.println("Inside Single Document Attachment");
	   		//"SRNumber":""+SRNumber+"",
			String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"SourceId\":\""+SourceId+"\",\"RegistrationId\":\""+RegistrationId+"\",\"EntityName\":\""+EntityName+"\",\"Category\":\""+Category+"\",\"FileId\":\""+FileId+"\", \"FileName\":\""+FileName+"\",\"FileDescription\":\""+FileDescription+"\",\"SourceFileName\":\""+SourceFileName+"\"}";
	   		activemqcall=new ActiveMQCall();
	   		//String correlationId = activemqcall.createRandomString();
	   		String correlationId = P_REQUEST_NUMBER;
	   		System.out.println("1 :: "+correlationId);	
	   		correlationId=activemqcall.GetProducer(queueName,SourceId,correlationId,jsonString);
	   		System.out.println("2 :: "+correlationId);
	   	//TextMessage textMessage = new 
	   		JSONObject result = new JSONObject();
	   		try {
	   		XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
	   		XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters();
	   		body.setP_REQUEST_NUMBER(correlationId);
	   		body.setP_REQUEST_NAME(P_REQUEST_NAME);
	   		body.setP_SOURCE_SYSTEM(P_SOURCE_SYSTEM);
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5();
	   		objX41.setPARAM_ID(SourceId);
	   		objX41.setATTRIBUTE1(RegistrationId);
	   		objX41.setATTRIBUTE2(EntityName);
	   		objX41.setATTRIBUTE3(Category);
	   		objX41.setATTRIBUTE4(FileId);
	   		objX41.setATTRIBUTE5(FileName);
	   		objX41.setATTRIBUTE6(FileDescription);
	   		objX41.setATTRIBUTE7(SourceFileName);

	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] {objX41};
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
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SEX1794747X1X57[] objAPPSXXDC_PROCESS_SEX1794747X1X57 = param.getX_RESPONSE_MESSAGE();
	   		for(int i=0;i<objAPPSXXDC_PROCESS_SEX1794747X1X57.length;i++) {
	   			System.out.println("param id response :: "+objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPARAM_ID());
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
						result.put("URL", objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1());
						}else {
							result.put("URL", JSONObject.NULL);	
						}
					if(param.getX_RETURN_STATUS().equals("S")) {
			//   			FtpClientIPMS objFtp = new FtpClientIPMS();
			   			if(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1() != null) {
			   			String fileName = objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1().substring(objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1().lastIndexOf('/')+1, objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getATTRIBUTE1().length());
			   			//objFtp.transferFileToIPMS(fileName,b);
			   			//objFtp.transferFileToIPMSFTPS(P_REQUEST_NUMBER,fileName, b);
				   		 new Thread(new Runnable(){

			   			      public void run(){
			//   			    	objFtp.transferFileToIPMSFTPS(P_REQUEST_NUMBER,fileName,b);
			   			    	FtpClientIPMS.IPMSUploadBase64(P_REQUEST_NUMBER,fileName,b);
			   			      }  

			   				 }).start();
			   			}
			   		}
					

					String requestString ="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"SourceId\":\""+SourceId+"\",\"RegistrationId\":\""+RegistrationId+"\",\"EntityName\":\""+EntityName+"\",\"Category\":\""+Category+"\",\"FileId\":\""+FileId+"\", \"FileName\":\""+FileName+"\",\"FileDescription\":\""+FileDescription+"\",\"SourceFileName\":\""+SourceFileName+"\"}";
					
					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), objAPPSXXDC_PROCESS_SEX1794747X1X57[i].getPROC_STATUS());

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
	   			try {
	   				result.put("status", "E");
	   		   		result.put("message", e.getMessage());
	   			}catch (Exception ex) {
					// TODO: handle exception
				}
	   		}
	   		return result.toString();
				
		}

	public  String DocumentAttachmentMultiple(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM, com.bean.DocUploadDTO[] regTerms) {
		//process
			/*http://localhost:8080/CRM_SR_NEW/services/TitleDeed/DocumentAttachment?P_REQUEST_NUMBER=87657&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC
			 * &SourceId=12345&RegistrationId=&EntityName=&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			 */
		//String SourceId, String RegistrationId,String EntityName,String Category,String FileId,String FileName,String FileDescription,String SourceFileName,Base64Binary b		
		//http://localhost:8080/CRM_SR_NEW/services/AOPT/DocumentAttachment?P_REQUEST_NUMBER=10745&P_REQUEST_NAME=ATTACH_DOC_IN_EBS&P_SOURCE_SYSTEM=SFDC&SourceId=44239&RegistrationId=10745&EntityName=fsf&Category=&FileId=&FileName=&FileDescription=&SourceFileName=
			final String queueName = "IPMS.AOPT.DOCUMENTATTACHMENTMULTIPLEUAT";
			System.out.println("Inside Multiple Document Attachment");
	   		//"SRNumber":""+SRNumber+"",
			String jsonString="{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\"}";
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
	   		objX41.setPARAM_ID(regTerms[j].getSourceId());
	   		objX41.setATTRIBUTE1(regTerms[j].getRegistrationId());
	   		objX41.setATTRIBUTE2(regTerms[j].getEntityName());
	   		objX41.setATTRIBUTE3(regTerms[j].getCategory());
	   		objX41.setATTRIBUTE4(regTerms[j].getFileId());
	   		objX41.setATTRIBUTE5(regTerms[j].getFileName());
	   		objX41.setATTRIBUTE6(regTerms[j].getFileDescription());
	   		objX41.setATTRIBUTE7(regTerms[j].getSourceFileName());
	   		arr[j] = objX41;
	   			    	FtpClientIPMS.IPMSUploadBase64(P_REQUEST_NUMBER,regTerms[j].getFileName(),regTerms[j].getFileBinary());

	   		}
	   		body.setP_REQUEST_MESSAGE(arr);
	   		
	   		res = result.toString();
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

	
	
	
	public String getMasterMilestone( String REGISTRATION_ID) {
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.AOPT.MasterMilestoneUAT";
		//logger.info("queueName :: "+queueName);
//http://localhost:8080/CRM_SR_NEW/services/AOPT/AOPTRegistrationDetails?P_REGISTRATION_ID=10745&P_SR_NUMBER=123
			//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REGISTRATION_ID\":\""+REGISTRATION_ID+"\"}";
		logger.info("getMasterMilestone :: "+jsonString);

		
		activemqcall=new ActiveMQCall();
			String correlationId = activemqcall.createRandomString();
//			String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: "+correlationId);	
			correlationId=activemqcall.GetProducer(queueName,REGISTRATION_ID,correlationId,jsonString);
			System.out.println("2 :: "+correlationId);
JSONArray arrJson = new JSONArray();
JSONObject subJson = null;
		try {
			XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = new XXDC_AOPT_PKG_WS_ServiceLocator();
			XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
			SOAHeader header = new SOAHeader();
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.InputParameters aoptmastermilestone = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.InputParameters();
	   		aoptmastermilestone.setP_REGISTRATION_ID(REGISTRATION_ID);
	   		
	   		objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters aoptmastermilestoneout = port_aopt.GET_MASTER_MILESTONE(header, aoptmastermilestone);
			System.out.println(aoptmastermilestoneout.getX_RETURN_STATUS());
			logger.info("getMasterMilestone response status :: "+aoptmastermilestoneout.getX_RETURN_STATUS());
			
			result.put("status", aoptmastermilestoneout.getX_RETURN_STATUS());
			result.put("message", aoptmastermilestoneout.getX_ERROR_MSG());
			for(int i=0;i<aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE().length;i++) {
				subJson = new JSONObject();
				if(aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE()[i].getMILESTONE_EVENT() != null) {
				subJson.put("MILESTONE_EVENT", aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE()[i].getMILESTONE_EVENT());
				}else {
					subJson.put("MILESTONE_EVENT", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE()[i].getARABIC_MILESTONE_EVENT() != null) {
				subJson.put("ARABIC_MILESTONE_EVENT", aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE()[i].getARABIC_MILESTONE_EVENT());
				}else {
					subJson.put("ARABIC_MILESTONE_EVENT", JSONObject.NULL);	
				}
				arrJson.put(subJson);
String requestString ="{\"P_REGISTRATION_ID\":\""+REGISTRATION_ID+"\"}";
				
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), aoptmastermilestoneout.getX_RETURN_STATUS());

				
				//aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE()[i].ge
			}
			result.put("MILESTONE_TAB_TYPE", arrJson);
		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("status", "E");
			result.put("message", e.getMessage());
			result.put("MILESTONE_TAB_TYPE", arrJson);
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: "+response);
			logger.info("getMasterMilestone json output :: "+result);
		return result.toString();	
			
        }
	

	public String getMilestonePaymentDetails( String REGISTRATION_ID) {
		JSONObject result = new JSONObject();
		final String queueName = "IPMS.AOPT.MilestonePaymentDetailsUAT";
		//logger.info("queueName :: "+queueName);
//http://localhost:8080/CRM_SR_NEW/services/AOPT/AOPTRegistrationDetails?P_REGISTRATION_ID=10745&P_SR_NUMBER=123
			//"SRNumber":""+SRNumber+"",
		String jsonString ="{\"P_REGISTRATION_ID\":\""+REGISTRATION_ID+"\"}";
		logger.info("getMilestonePaymentDetails :: "+jsonString);
System.out.println("1");
		
		activemqcall=new ActiveMQCall();
			String correlationId = activemqcall.createRandomString();
//			String correlationId = P_REQUEST_NUMBER;
			System.out.println("1 :: "+correlationId);	
			correlationId=activemqcall.GetProducer(queueName,REGISTRATION_ID,correlationId,jsonString);
			System.out.println("2 :: "+correlationId);
JSONArray arrJson = new JSONArray();
JSONObject subJson = null;
		try {
			XXDC_AOPT_PKG_WS_ServiceLocator service_aopt = new XXDC_AOPT_PKG_WS_ServiceLocator();
			XXDC_AOPT_PKG_WS_PortType port_aopt = service_aopt.getXXDC_AOPT_PKG_WS_Port();
			SOAHeader header = new SOAHeader();
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.InputParameters aoptmastermilestonedet = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.InputParameters();
	   		aoptmastermilestonedet.setP_REGISTRATION_ID(REGISTRATION_ID);
	   		
	   		objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
	   		
	   		com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters aoptmastermilestoneout = port_aopt.GET_MILESTONE_PAYMENT_DET(header, aoptmastermilestonedet);
			System.out.println(aoptmastermilestoneout.getX_RETURN_STATUS());
			logger.info("getMilestonePaymentDetails response status :: "+aoptmastermilestoneout.getX_RETURN_STATUS());
			
			result.put("status", aoptmastermilestoneout.getX_RETURN_STATUS());
			result.put("message", aoptmastermilestoneout.getX_ERROR_MSG());
			for(int i=0;i<aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE().length;i++) {
				subJson = new JSONObject();
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getREGISTRATION_ID() != null) {
				subJson.put("REGISTRATION_ID", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getREGISTRATION_ID());
				}else {
					subJson.put("REGISTRATION_ID", JSONObject.NULL);	
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getTERM_ID() != null) {
				subJson.put("TERM_ID", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getTERM_ID());
				}else {
					subJson.put("TERM_ID", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getLINE_ID() != null) {
				subJson.put("LINE_ID", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getLINE_ID());
				}else {
					subJson.put("LINE_ID", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getINSTALLMENT() != null) {
				subJson.put("INSTALLMENT", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getINSTALLMENT());
				}else {
					subJson.put("INSTALLMENT", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getDESCRIPTION() != null) {
				subJson.put("DESCRIPTION", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getDESCRIPTION());
				}else {
					subJson.put("DESCRIPTION", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getMILESTONE_EVENT() != null) {
				subJson.put("MILESTONE_EVENT", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getMILESTONE_EVENT());
				}else {
					subJson.put("MILESTONE_EVENT", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getMILESTONE_EVENT_AR() != null) {
				subJson.put("MILESTONE_EVENT_AR", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getMILESTONE_EVENT_AR());
				}else {
					subJson.put("MILESTONE_EVENT_AR", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getMILESTEON_PERCENT_VALUE() != null) {
				subJson.put("MILESTEON_PERCENT_VALUE", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getMILESTEON_PERCENT_VALUE());
				}else {
					subJson.put("MILESTEON_PERCENT_VALUE", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getDUE_DATE() != null) {
				subJson.put("DUE_DATE", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getDUE_DATE());
				}else {
					subJson.put("DUE_DATE", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getINVOICE_AMOUNT() != null) {
				subJson.put("INVOICE_AMOUNT", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getINVOICE_AMOUNT());
				}else {
					subJson.put("INVOICE_AMOUNT", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getPAID_AMOUNT() != null) {
				subJson.put("PAID_AMOUNT", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getPAID_AMOUNT());
				}else {
					subJson.put("PAID_AMOUNT", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getDUE_AMOUNT() != null) {
				subJson.put("DUE_AMOUNT", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getDUE_AMOUNT());
				}else {
					subJson.put("DUE_AMOUNT", JSONObject.NULL);
				}
				if(aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getPAID_PERCENTAGE() != null) {
				subJson.put("PAID_PERCENTAGE", aoptmastermilestoneout.getX_REG_TERM_PYMNT_TABLE()[i].getPAID_PERCENTAGE());
				}else {
					subJson.put("PAID_PERCENTAGE", JSONObject.NULL);	
				}
				arrJson.put(subJson);
String requestString ="{\"P_REGISTRATION_ID\":\""+REGISTRATION_ID+"\"}";
				
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", result.toString(), aoptmastermilestoneout.getX_RETURN_STATUS());

				//aoptmastermilestoneout.getX_MILESTONE_TAB_TYPE()[i].ge
			}
			result.put("REG_TERM_PYMNT_TABLE", arrJson);
		}catch (Exception e) {
			// TODO: handle exception
			try {
			result.put("status", "E");
			result.put("message", e.getMessage());
			result.put("REG_TERM_PYMNT_TABLE", arrJson);
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		String response = activemqcall.GetConsumer(queueName);
			System.out.println("3 4:: "+response);
			logger.info("getMilestonePaymentDetails json output :: "+result);
		return result.toString();	
			
        }


	
	}
