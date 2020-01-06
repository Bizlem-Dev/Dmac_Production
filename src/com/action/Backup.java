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

public class Backup {
	
	final static Logger logger = Logger.getLogger(BouncedCheque.class); 
	public com.activeMQ.ActiveMQCall activemqcall=null;
	
	public  String UpdateCOCD(String P_REQUEST_NUMBER,String P_REQUEST_NAME,String P_SOURCE_SYSTEM,
			String IPMSPartyID,String SRNumber,String P_ADDRESS1,String P_ADDRESS2,String P_ADDRESS3,String P_ADDRESS4, 
			String City, String  P_POSTAL_CODE, String P_STATE ,String P_COUNTRY,String P_WORK_COUNTRY_CODE,String P_WORK_AREA_CODE, String P_WORK_NUMBER,
			String  P_MOBILE_COUNTRY_CODE,String  P_MOBILE_AREA_CODE, String  P_MOBILE_NUMBER,
			String P_FAX_COUNTRY_CODE,String P_FAX_AREA_CODE, String P_FAX_NUMBER,String P_EMAIL_ADDRESS, String P_url,
			String P_NATIONALITY,String P_PASSPORT_NUMBER, String  P_PASSPORT_ISSUE_DATE, String  P_PASSPORT_ISSUE_PLACE,
			String P_CR_REG_PLACE,String P_CR_REG_DATE, String P_ADDRESS1_AR,String P_ADDRESS2_AR,String P_ADDRESS3_AR,String P_ADDRESS4_AR,
			String P_CITY_AR,String P_COUNTRY_AR, String  P_POSTAL_CODE_AR)
			{//process
		/*UpdateCOCD?P_REQUEST_NUMBER=r55&P_REQUEST_NAME=COCD&P_SOURCE_SYSTEM=SFDC&partyID=P-66&SRNumber=&P_ADDRESS1=&P_ADDRESS2=&P_ADDRESS3=&P_ADDRESS4=&City=&P_POSTAL_CODE=&P_STATE=&P_COUNTRY=&P_WORK_COUNTRY_CODE=&P_WORK_AREA_CODE=&P_WORK_NUMBER=&P_MOBILE_COUNTRY_CODE=&P_MOBILE_AREA_CODE=&P_MOBILE_NUMBER=&P_FAX_COUNTRY_CODE=&P_FAX_AREA_CODE=&P_FAX_NUMBER=&P_EMAIL_ADDRESS=&P_url=& P_NATIONALITY=&P_PASSPORT_NUMBER=&P_PASSPORT_ISSUE_DATE=&P_PASSPORT_ISSUE_PLACE=&P_CR_REG_PLACE=&P_CR_REG_DATE=&P_ADDRESS1_AR=&P_ADDRESS2_AR=&P_ADDRESS3_AR=&P_ADDRESS4_AR=&P_CITY_AR=&P_COUNTRY_AR=&P_POSTAL_CODE_AR=
		*/
		final String queueName = "IPMS.COCD.UPDATECOCD";
		String jsonString =	"{\"P_REQUEST_NUMBER\":\""+P_REQUEST_NUMBER+"\",\"P_REQUEST_NAME\":\""+P_REQUEST_NAME+"\",\"P_SOURCE_SYSTEM\":\""+P_SOURCE_SYSTEM+"\",\"IPMSPartyID\":\""+IPMSPartyID+"\",\"SRNumber\":\""+SRNumber+"\",\"P_ADDRESS1\":\""+P_ADDRESS1+"\",\"P_ADDRESS2\":\""+P_ADDRESS2+"\",\"P_ADDRESS3\":\""+P_ADDRESS3+"\",\"P_ADDRESS4\":\""+P_ADDRESS4+"\",\"City\":\""+City+"\",\"P_POSTAL_CODE\":\""+P_POSTAL_CODE+"\",\"P_STATE\":\""+P_STATE+"\",\"P_COUNTRY\":\""+P_COUNTRY+"\",\"P_WORK_COUNTRY_CODE\":\""+P_WORK_COUNTRY_CODE+"\",\"P_WORK_AREA_CODE\":\""+P_WORK_AREA_CODE+"\",\"P_WORK_NUMBER\":\""+P_WORK_NUMBER+"\",\"P_FAX_COUNTRY_CODE\":\""+P_FAX_COUNTRY_CODE+"\",\"P_FAX_AREA_CODE\":\""+P_FAX_AREA_CODE+"\",\"P_FAX_NUMBER\":\""+P_FAX_NUMBER+"\",\"P_EMAIL_ADDRESS\":\""+P_EMAIL_ADDRESS+"\",\"P_url\":\""+P_url+"\",\"P_NATIONALITY\":\""+P_NATIONALITY+"\",\"P_PASSPORT_NUMBER\":\""+P_PASSPORT_NUMBER+"\",\"P_PASSPORT_ISSUE_DATE\":\""+P_PASSPORT_ISSUE_DATE+"\",\"P_PASSPORT_ISSUE_PLACE\":\""+P_PASSPORT_ISSUE_PLACE+"\",\"P_CR_REG_PLACE\":\""+P_CR_REG_PLACE+"\",\"P_CR_REG_DATE\":\""+P_CR_REG_DATE+"\",\"P_ADDRESS1_AR\":\""+P_ADDRESS1_AR+"\",\"P_ADDRESS2_AR\":\""+P_ADDRESS2_AR+"\",\"P_ADDRESS3_AR\":\""+P_ADDRESS3_AR+"\",\"P_ADDRESS4_AR\":\""+P_ADDRESS4_AR+"\",\"P_CITY_AR\":\""+P_CITY_AR+"\",\"P_COUNTRY_AR\":\""+P_COUNTRY_AR+"\",\"P_POSTAL_CODE_AR\":\""+P_POSTAL_CODE_AR+"\"}";
   		activemqcall=new ActiveMQCall();
   		//String correlationId = activemqcall.createRandomString();
   		String correlationId = P_REQUEST_NUMBER;
   		System.out.println("1 :: "+correlationId);	
   		correlationId=activemqcall.GetProducer(queueName,IPMSPartyID,correlationId,jsonString);
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
   		objX41.setPARAM_ID(IPMSPartyID);
   		objX41.setATTRIBUTE1(SRNumber);
   		objX41.setATTRIBUTE2(P_ADDRESS1);
   		objX41.setATTRIBUTE3(P_ADDRESS2);
   		objX41.setATTRIBUTE4(P_ADDRESS3);
   		objX41.setATTRIBUTE5(P_ADDRESS4);
   		objX41.setATTRIBUTE6(City);
   		objX41.setATTRIBUTE7(P_POSTAL_CODE);
   		objX41.setATTRIBUTE8(P_STATE);
   		objX41.setATTRIBUTE9(P_WORK_COUNTRY_CODE);
   		objX41.setATTRIBUTE10(P_WORK_AREA_CODE);
   		objX41.setATTRIBUTE11(P_WORK_NUMBER);
   		objX41.setATTRIBUTE12(P_MOBILE_COUNTRY_CODE);
   		objX41.setATTRIBUTE13(P_MOBILE_AREA_CODE);
   		objX41.setATTRIBUTE14(P_MOBILE_NUMBER);
   		objX41.setATTRIBUTE15(P_FAX_COUNTRY_CODE);
   		objX41.setATTRIBUTE16(P_FAX_AREA_CODE);
   		objX41.setATTRIBUTE17(P_FAX_NUMBER);
   		objX41.setATTRIBUTE18(P_EMAIL_ADDRESS);
   		objX41.setATTRIBUTE19(P_url);
   		objX41.setATTRIBUTE20(P_NATIONALITY);
   		objX41.setATTRIBUTE21(P_PASSPORT_NUMBER);
   		objX41.setATTRIBUTE22(P_PASSPORT_ISSUE_DATE);
   		objX41.setATTRIBUTE23(P_PASSPORT_ISSUE_PLACE);
   		objX41.setATTRIBUTE24(P_CR_REG_PLACE);
   		objX41.setATTRIBUTE25(P_CR_REG_DATE);
   		objX41.setATTRIBUTE26(P_CR_REG_PLACE);
   		objX41.setATTRIBUTE27(P_CR_REG_DATE);
   		objX41.setATTRIBUTE28(P_ADDRESS1_AR);
   		objX41.setATTRIBUTE29(P_ADDRESS2_AR);
   		objX41.setATTRIBUTE30(P_ADDRESS3_AR);
   		objX41.setATTRIBUTE31(P_ADDRESS4_AR);
   		objX41.setATTRIBUTE32(P_CITY_AR);
   		objX41.setATTRIBUTE33(P_COUNTRY_AR);
   		objX41.setATTRIBUTE34(P_POSTAL_CODE_AR);
   		
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


}
