package com.util;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
//import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_BindingStub;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortTypeProxy;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_Service;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;

public class SoapClient {
	private static final String WS_URL = "http://10.8.8.152:8033/webservices/SOAProvider/plsql/xxdc_process_service_ws/?wsdl";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
		URL url = new URL(WS_URL);
		System.out.print("1");
        QName qname = new QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/","XXDC_PROCESS_SERVICE_WS_Service");
//        QName qname1 =new QName("XXDC_PROCESS_SERVICE_WS_Service");
        System.out.print("2");
        Service service = Service.create(url, qname);
        //service.get
        System.out.print("3");
        service.getPort(XXDC_PROCESS_SERVICE_WS_PortType.class);
//        while (i.hasNext()){
//			      System.out.println(i.next());
//			    }
        /*******************UserName & Password ******************************/
//        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
//        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
//
//        Map<String, List<String>> headers = new HashMap<String, List<String>>();
//        headers.put("Username", Collections.singletonList("oracle_user"));
//        headers.put("Password", Collections.singletonList("crp1user"));
//        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/

      //  System.out.println(hello);
}catch (Exception e) {
	// TODO: handle exception
	System.out.print(e.getMessage());
}	
	}

}
