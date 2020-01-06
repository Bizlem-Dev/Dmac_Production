package com.action;

import java.util.Calendar;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.sobject.Case;

public class RentalPoolTask {
	
	public boolean RentalPoolAgreement(String Status,String Comments,String Task_Id,Calendar Agreement_Commencement_date__c) {
		boolean result = false;
		try {
			 EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			 //////////////////////////////////////////////////////////////////////
			 com.sforce.soap.enterprise.sobject.Task task = new com.sforce.soap.enterprise.sobject.Task();
			 task.setId(Task_Id);;
			 task.setStatus(Status);
			 task.setDescription(Comments);
			 //task.Date
			// Calendar c = 
			 
			task.setAgreement_Commencement_Date__c(Agreement_Commencement_date__c);
			 com.sforce.soap.enterprise.SaveResult[] results = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { task });
			 System.out.println(results[0].getSuccess()+"::::::");
			 if(!results[0].getSuccess()){
				 System.out.print(results[0].getErrors()[0].getMessage());
			 }

			 result = results[0].getSuccess();
			
			
			}catch (Exception e) {
			// TODO: handle exception
				return result;
			}
		return result;
	}
	
	
	public boolean RentalPoolTermination(String Status,String Comments,String Task_Id,Calendar Updated_Termination_Date__c ) {
		boolean result = false;
		try {
			 EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			 //////////////////////////////////////////////////////////////////////
			 com.sforce.soap.enterprise.sobject.Task task = new com.sforce.soap.enterprise.sobject.Task();
			 task.setId(Task_Id);;
			 task.setStatus(Status);
			 task.setDescription(Comments);
			 //task.Date
			task.setUpdated_Termination_Date__c(Updated_Termination_Date__c);
			 com.sforce.soap.enterprise.SaveResult[] results = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { task });
			 System.out.println(results[0].getSuccess()+"::::::");
			 if(!results[0].getSuccess()){
				 System.out.print(results[0].getErrors()[0].getMessage());
			 }

			 result = results[0].getSuccess();
			
			
			}catch (Exception e) {
			// TODO: handle exception
				return result;
			}
		return result;
	}
}
