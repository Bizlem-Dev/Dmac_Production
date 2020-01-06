package com.action;

import java.util.ResourceBundle;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectorConfig;

import gvjava.org.json.JSONArray;

public class SFDCConnection {
	static EnterpriseConnection connection;
public static void main(String args[]) {
	try{
		 ResourceBundle bundle = null;
		String sfdcUserName="";
		String sfdcPassword="";
		String sfdcUrl="";
		 bundle = ResourceBundle.getBundle("serverConfig");
		 sfdcUserName="sfdc.mq@damacgroup.com.uat";
		 sfdcPassword="damac@123wcavLvLA2iMpBS5W68KAT7Z3m";
		 sfdcUrl = "https://test.salesforce.com/services/Soap/c/40.0";
		 ConnectorConfig config = new ConnectorConfig();
			config.setUsername(sfdcUserName);
			config.setPassword(sfdcPassword);
			//config.setAuthEndpoint("https://login.salesforce.com/services/Soap/c/40.0");
		//	config.setAuthEndpoint("https://test.salesforce.com/services/Soap/c/40.0");

			config.setAuthEndpoint(sfdcUrl);

			connection = Connector.newConnection(config);
		        System.out.println("Auth EndPoint: "+config.getAuthEndpoint());
			System.out.println("Service EndPoint: "+config.getServiceEndpoint());
			System.out.println("Username: "+config.getUsername());
			System.out.println("SessionId: "+config.getSessionId());
			
	        
		
		 
		}catch(Exception e){
			 e.printStackTrace();
		}
	
}
	
	public static EnterpriseConnection SfdcConnect(){
		try{
			 ResourceBundle bundle = null;
			String sfdcUserName="";
			String sfdcPassword="";
			String sfdcUrl="";
			 bundle = ResourceBundle.getBundle("serverConfig");
			 sfdcUserName=bundle.getString("USERNAME");
			 sfdcPassword=bundle.getString("PASSWORD");
			 System.out.println("sfdcUserName  :: "+sfdcUserName);
			 System.out.println("sfdcPassword  :: "+sfdcPassword);
//			 sfdcUserName="crm.integration@damacgroup.com";
//			 sfdcPassword="crmintegration@1aZMBTSttOlQbn3TVcg6PdXueT";
			 sfdcUrl = bundle.getString("sfdcUrl");
			 ConnectorConfig config = new ConnectorConfig();
				config.setUsername(sfdcUserName);
				config.setPassword(sfdcPassword);
				//config.setAuthEndpoint("https://login.salesforce.com/services/Soap/c/40.0");
			//	config.setAuthEndpoint("https://test.salesforce.com/services/Soap/c/40.0");

				config.setAuthEndpoint(sfdcUrl);
	
				connection = Connector.newConnection(config);
			        System.out.println("Auth EndPoint: "+config.getAuthEndpoint());
				System.out.println("Service EndPoint: "+config.getServiceEndpoint());
				System.out.println("Username: "+config.getUsername());
				System.out.println("SessionId: "+config.getSessionId());
				
		        
			
			 
			}catch(Exception e){
				 e.printStackTrace();
			}
		
		return connection;
		
	}
	
	
}
