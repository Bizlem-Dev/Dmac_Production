package com.action;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.APPSXXDC_PARKING_INVX1844909X1X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.OutputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class Parking {
	final static Logger logger = Logger.getLogger(Parking.class);
	public com.activeMQ.ActiveMQCall activemqcall=null;
	MongoDB objMongoDB = null;

	public String getParking(BigDecimal P_BUILDING_ID,String P_PARKING_TYPE) {
		final String queueName = "IPMS.GetParkingUAT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"P_BUILDING_ID\":\""+P_BUILDING_ID+"\",\"P_PARKING_TYPE\":\""+ P_PARKING_TYPE + "\"}";
		
		activemqcall = new ActiveMQCall();
		String correlationId = activemqcall.createRandomString();
		//String correlationId = objTaskBean.getP_REQUEST_NUMBER();
		System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, String.valueOf(P_BUILDING_ID), correlationId, jsonString);
		System.out.println("2 :: " + correlationId);
		// TextMessage textMessage = new
		JSONObject mainJson = new JSONObject();
		try {
			XXDC_PARKING_INV_WS_PKG_ServiceLocator service = new XXDC_PARKING_INV_WS_PKG_ServiceLocator();
			XXDC_PARKING_INV_WS_PKG_PortType port = service.getXXDC_PARKING_INV_WS_PKG_Port();

			SOAHeader header = new SOAHeader();
			InputParameters body = new InputParameters();
			body.setP_BUILDING_ID(P_BUILDING_ID);
			body.setP_PARKING_TYPE(P_PARKING_TYPE);
			
			objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
	   		
			OutputParameters out  = port.PARKING_INV_PROCESS(header, body);
			if(out.getX_RETURN_STATUS() != null) {
			mainJson.put("status", out.getX_RETURN_STATUS());
			}else {
				mainJson.put("status", JSONObject.NULL);
			}
			if(out.getX_ERROR_MSG() != null) {
	   		mainJson.put("message", out.getX_ERROR_MSG());
			}else {
				mainJson.put("message", JSONObject.NULL);
			}
			logger.info("Parking :: getParking :: P_BUILDING_ID :: "+P_BUILDING_ID + " Response :: "+" Status :: "+out.getX_RETURN_STATUS() + " Message :: "+out.getX_ERROR_MSG());
			JSONObject results = null;
	   		JSONArray arr = new JSONArray();
	   		APPSXXDC_PARKING_INVX1844909X1X4[] resR = out.getX_PARKING_INV_RECORDS();
			for(int i=0;i<out.getX_PARKING_INV_RECORDS().length;i++) {
				results = new JSONObject();
		   		if(resR[i].getDETAIL_ID() != null) {
		   		results.put("DETAIL_ID", resR[i].getDETAIL_ID());
		   		}else {
		   			results.put("DETAIL_ID", JSONObject.NULL);	
		   		}
		   		if(resR[i].getORG_ID() != null) {
			   		results.put("ORG_ID", resR[i].getORG_ID());
			   		}else {
			   			results.put("ORG_ID", JSONObject.NULL);	
			   		}
		   		if(resR[i].getPROPERTY_ID() != null) {
			   		results.put("PROPERTY_ID", resR[i].getPROPERTY_ID());
			   		}else {
			   			results.put("PROPERTY_ID", JSONObject.NULL);	
			   		}
		   		if(resR[i].getPROPERTY_NAME() != null) {
			   		results.put("PROPERTY_NAME", resR[i].getPROPERTY_NAME());
			   		}else {
			   			results.put("PROPERTY_NAME", JSONObject.NULL);	
			   		}
		   		if(resR[i].getBUILDING_ID() != null) {
			   		results.put("BUILDING_ID", resR[i].getBUILDING_ID());
			   		}else {
			   			results.put("BUILDING_ID", JSONObject.NULL);	
			   		}
		   		if(resR[i].getBUILDING_NAME() != null) {
			   		results.put("BUILDING_NAME", resR[i].getBUILDING_NAME());
			   		}else {
			   			results.put("BUILDING_NAME", JSONObject.NULL);	
			   		}
		   		if(resR[i].getPARKING_TYPE() != null) {
			   		results.put("PARKING_TYPE", resR[i].getPARKING_TYPE());
			   		}else {
			   			results.put("PARKING_TYPE", JSONObject.NULL);	
			   		}
		   		
		   		if(resR[i].getPARKING_TYPE_DESC() != null) {
			   		results.put("PARKING_TYPE_DESC", resR[i].getPARKING_TYPE_DESC());
			   		}else {
			   			results.put("PARKING_TYPE_DESC", JSONObject.NULL);	
			   		}
		   		if(resR[i].getPARKING_BAY_NUMBER() != null) {
			   		results.put("PARKING_BAY_NUMBER", resR[i].getPARKING_BAY_NUMBER());
			   		}else {
			   			results.put("PARKING_BAY_NUMBER", JSONObject.NULL);	
			   		}
		   		if(resR[i].getPRICE() != null) {
			   		results.put("PRICE", resR[i].getPRICE());
			   		}else {
			   			results.put("PRICE", JSONObject.NULL);	
			   		}
		   		if(resR[i].getSTATUS_CODE() != null) {
			   		results.put("STATUS_CODE", resR[i].getSTATUS_CODE());
			   		}else {
			   			results.put("STATUS_CODE", JSONObject.NULL);	
			   		}
		   		if(resR[i].getSTATUS() != null) {
			   		results.put("STATUS", resR[i].getSTATUS());
			   		}else {
			   			results.put("STATUS", JSONObject.NULL);	
			   		}
		   		
		   		arr.put(results);

				String requestString = "{\"P_BUILDING_ID\":\""+P_BUILDING_ID+"\",\"P_PARKING_TYPE\":\""+ P_PARKING_TYPE + "\"}";
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", results.toString(), resR[i].getSTATUS());

			}
			mainJson.put("data", arr);
			logger.info("Parking :: getParking :: Response from IPMS :: "+mainJson );
			String response = activemqcall.GetConsumer(queueName);
			System.out.println("Consumer 3 4:: " + response);
		
	}catch (Exception e) {
		// TODO: handle exception
		try {
		mainJson.put("status", "Error");
		mainJson.put("message", e.getMessage());
		logger.info("Parking :: getParking :: Error :: "+mainJson );
		return mainJson.toString();
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
		return mainJson.toString();
		
	}
	
	public String createParking(APPSXXDC_PARKING_INVX1844909X3X2[] PARKING_PAYMENT_TERMS) {
		final String queueName = "IPMS.CreateParkingUAT";
		// "SRNumber":""+SRNumber+"",
		String jsonString = "{\"PARKING_PAYMENT_TERMS\":\""+PARKING_PAYMENT_TERMS+"\"}";
		
		activemqcall = new ActiveMQCall();
		String correlationId = activemqcall.createRandomString();
		//String correlationId = objTaskBean.getP_REQUEST_NUMBER();
		System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, correlationId, correlationId, jsonString);
		System.out.println("2 :: " + correlationId);
		// TextMessage textMessage = new
		JSONObject mainJson = new JSONObject();
		try {
			XXDC_PARKING_INV_WS_PKG_ServiceLocator service = new XXDC_PARKING_INV_WS_PKG_ServiceLocator();
			XXDC_PARKING_INV_WS_PKG_PortType port = service.getXXDC_PARKING_INV_WS_PKG_Port();

			SOAHeader header = new SOAHeader();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.InputParameters();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2[] arr = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2[PARKING_PAYMENT_TERMS.length];
	   		
	   		for(int j=0;j<PARKING_PAYMENT_TERMS.length;j++) {
	   	    com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2 objX41 = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2();
	   		objX41.setAMOUNT(PARKING_PAYMENT_TERMS[j].getAMOUNT());
	   		objX41.setINSTALLMENT(PARKING_PAYMENT_TERMS[j].getINSTALLMENT());
	   		objX41.setPAYMENT_DATE(PARKING_PAYMENT_TERMS[j].getPAYMENT_DATE());
	   		objX41.setPDC_NUMBER(PARKING_PAYMENT_TERMS[j].getPDC_NUMBER());
	   		objX41.setREMARKS(PARKING_PAYMENT_TERMS[j].getREMARKS());
	   		objX41.setSR_NUMBER(PARKING_PAYMENT_TERMS[j].getSR_NUMBER());
	   		objX41.setUNIT_NAME(PARKING_PAYMENT_TERMS[j].getUNIT_NAME());
	   		logger.info("Parking :: createParking :: SR_NUMBER :: "+PARKING_PAYMENT_TERMS[j].getSR_NUMBER() + " UNIT_NAME :: "+ PARKING_PAYMENT_TERMS[j].getUNIT_NAME() + " PDC_NUMBER :: "+PARKING_PAYMENT_TERMS[j].getPDC_NUMBER() + " PAYMENT_DATE :: "+PARKING_PAYMENT_TERMS[j].getPAYMENT_DATE() + " REMARKS :: "+PARKING_PAYMENT_TERMS[j].getREMARKS() + " INSTALLMENT :: "+PARKING_PAYMENT_TERMS[j].getINSTALLMENT() + " AMOUNT :: "+PARKING_PAYMENT_TERMS[j].getAMOUNT());
	   		 
			arr[j] = objX41;
	   		}
	   		body.setP_PARKING_PAYMENT_TERMS(arr);
	   		objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
	   		
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.OutputParameters out  = port.PARKING_PAYMENT_TERMS(header, body);
			if(out.getX_RETURN_STATUS() != null) {
				mainJson.put("status", out.getX_RETURN_STATUS());
				}else {
					mainJson.put("status", JSONObject.NULL);
				}
				if(out.getX_ERROR_MSG() != null) {
		   		mainJson.put("message", out.getX_ERROR_MSG());
				}else {
					mainJson.put("message", JSONObject.NULL);
				}
				

				String requestString = "{\"PARKING_PAYMENT_TERMS\":\""+PARKING_PAYMENT_TERMS+"\"}";
					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", mainJson.toString(), out.getX_RETURN_STATUS());

			logger.info("Parking :: createParking :: Response from IPMS :: "+mainJson );
			String response = activemqcall.GetConsumer(queueName);
			System.out.println("Consumer 3 4:: " + response);
		
	}catch (Exception e) {
		// TODO: handle exception
		try {
		mainJson.put("status", "Error");
		mainJson.put("message", e.getMessage());
		logger.info("Parking :: getParking :: Error :: "+mainJson );
		return mainJson.toString();
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
		return mainJson.toString();
		
	}

	
	
	public String updateParking(BigDecimal P_UNIT_ID,BigDecimal P_DETAIL_ID,String P_PARKING_BAY_NO,
			BigDecimal P_PRICE,String P_STATUS,String P_SR_NUMBER) {
		final String queueName = "IPMS.UpdateParkingUAT";
		// "SRNumber":""+SRNumber+"",
	String jsonString = "{\"P_UNIT_ID\":\""+P_UNIT_ID+"\",\"P_DETAIL_ID\":\""+ P_DETAIL_ID + "\",\"P_PARKING_BAY_NO\":\""+ P_PARKING_BAY_NO + "\",\"P_PRICE\":\""+ P_PRICE + "\",\"P_STATUS\":\""+ P_STATUS + "\", \"P_SR_NUMBER\":\""+ P_SR_NUMBER + "\"}";
		
		activemqcall = new ActiveMQCall();
		String correlationId = activemqcall.createRandomString();
		//String correlationId = objTaskBean.getP_REQUEST_NUMBER();
		System.out.println("1 :: " + correlationId);
		correlationId = activemqcall.GetProducer(queueName, String.valueOf(P_UNIT_ID), correlationId, jsonString);
		System.out.println("2 :: " + correlationId);
		// TextMessage textMessage = new
		JSONObject mainJson = new JSONObject();
		try {
			XXDC_PARKING_INV_WS_PKG_ServiceLocator service = new XXDC_PARKING_INV_WS_PKG_ServiceLocator();
			XXDC_PARKING_INV_WS_PKG_PortType port = service.getXXDC_PARKING_INV_WS_PKG_Port();

			SOAHeader header = new SOAHeader();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.InputParameters();
			body.setP_UNIT_ID(P_UNIT_ID);
			body.setP_DETAIL_ID(P_DETAIL_ID);
			body.setP_PARKING_BAY_NO(P_PARKING_BAY_NO);
			body.setP_PRICE(P_PRICE);
			body.setP_STATUS(P_STATUS);
			body.setP_SR_NUMBER(P_SR_NUMBER);
			objMongoDB = new MongoDB(); 
	   		Date reqDate = new Date();
			com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.OutputParameters out  = port.XXDC_ADD_PARKING(header, body);
			if(out.getX_RETURN_STATUS() != null) {
				mainJson.put("status", out.getX_RETURN_STATUS());
				}else {
					mainJson.put("status", JSONObject.NULL);
				}
				if(out.getX_ERR_MSG() != null) {
		   		mainJson.put("message", out.getX_ERR_MSG());
				}else {
					mainJson.put("message", JSONObject.NULL);
				}
				
				String requestString = "{\"P_UNIT_ID\":\""+P_UNIT_ID+"\",\"P_DETAIL_ID\":\""+ P_DETAIL_ID + "\",\"P_PARKING_BAY_NO\":\""+ P_PARKING_BAY_NO + "\",\"P_PRICE\":\""+ P_PRICE + "\",\"P_STATUS\":\""+ P_STATUS + "\", \"P_SR_NUMBER\":\""+ P_SR_NUMBER + "\"}";
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", mainJson.toString(), out.getX_RETURN_STATUS());

			logger.info("Parking :: getParking :: P_BUILDING_ID :: "+P_UNIT_ID + " Response :: "+" Status :: "+out.getX_RETURN_STATUS() + " Message :: "+out.getX_ERR_MSG());
			
			logger.info("Parking :: getParking :: Response from IPMS :: "+mainJson );
			String response = activemqcall.GetConsumer(queueName);
			System.out.println("Consumer 3 4:: " + response);
		
	}catch (Exception e) {
		// TODO: handle exception
		try {
		mainJson.put("status", "Error");
		mainJson.put("message", e.getMessage());
		logger.info("Parking :: getParking :: Error :: "+mainJson );
		return mainJson.toString();
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
		return mainJson.toString();
		
	}
	
}	

