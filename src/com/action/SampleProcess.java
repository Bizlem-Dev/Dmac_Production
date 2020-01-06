package com.action;

import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters;

public class SampleProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
			XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();
			
			SOAHeader header = new SOAHeader();
			
			InputParameters body = new InputParameters();
			body.setP_REQUEST_NUMBER("1-211");
			body.setP_REQUEST_NAME("COCD_LETTER");
			body.setP_SOURCE_SYSTEM("SFDC");
			APPSXXDC_PROCESS_SERX1794747X1X5 p_REQUEST_MESSAGE_item = new APPSXXDC_PROCESS_SERX1794747X1X5();
			p_REQUEST_MESSAGE_item.setPARAM_ID("12");
			//p_REQUEST_MESSAGE.
//			objX41.setATTRIBUTE1(AddressLine1);
//			objX41.setATTRIBUTE2(AddressLine2);
//			objX41.setATTRIBUTE3(AddressLine3);
//			objX41.setATTRIBUTE4(city);
//			objX41.setATTRIBUTE5(state);
//			objX41.setATTRIBUTE6(postalCode);
//			objX41.setATTRIBUTE7(country);
//			objX41.setATTRIBUTE8(CRNumber);
//			objX41.setATTRIBUTE9(PassportIssueDate);
//			objX41.setATTRIBUTE10(LandlineNo);
//			objX41.setATTRIBUTE11(MoileNo);
//			objX41.setATTRIBUTE12(Fax);
//			objX41.setATTRIBUTE13(Email);
			//i am connected
			//below  is the error
			APPSXXDC_PROCESS_SERX1794747X1X5[] arr = new APPSXXDC_PROCESS_SERX1794747X1X5[] {p_REQUEST_MESSAGE_item};
			body.setP_REQUEST_MESSAGE(arr);
			OutputParameters param = port.PROCESS(header, body);
			
			System.out.println("1::"+param.getX_RETURN_MESSAGE());
			System.out.println("2::"+param.getX_RETURN_STATUS());
			System.out.println("3::"+param.getX_RESPONSE_MESSAGE());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
