package com.sfdc;

import com.action.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;

public class TestSFDC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSFDC objTestSFDC = new TestSFDC();
		objTestSFDC.callSFDC("Reject", "Payment is towards the Property, not towards Service Charges. Kindly re-submit the POP in the Hello DAMAC Customer Portal main page.",
				"00T1n00001IH6iy", "a4X1n000000BDJJ", "Verify Proof Of Payment details in IPMS.", 
				"", "");
//		objTestSFDC.testSFDC();
//		GeneratePCCSFDC objGeneratePCCSFDC = new GeneratePCCSFDC();
//		objGeneratePCCSFDC.setPCCUrl("null", "48984", "E", "[EX_ERROR][PCC-DP] Mesg=Penalty exists for the selected registration id", "5001n00000lF5mf");
	}

	public void callSFDC(String Status,String Comments_c,String Task_Id,String Case_Id,String subject,
			String optional1,String optional2) {
		try {
			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			 //////////////////////////////////////////////////////////////////////
			 com.sforce.soap.enterprise.sobject.Task task = new com.sforce.soap.enterprise.sobject.Task();
		
			 task.setId(Task_Id);
			 if(Status.equalsIgnoreCase("Approve")){
			 task.setStatus("Completed");
//			 if(subject.equalsIgnoreCase("Verify Proof of Payment Details in IPMS")) {
//			 		task.setDocument_Number__c(optional23);
//			 		task.setReceipt_Number__c(optional24);
//			 		task.setCash_Receipt_Id__c(optional25);
//			 	}
			 }else {
				 task.setStatus(Status);
			 }
			 task.setDescription(Comments_c);
			 //task.setDocument_URL__c(Document_URL__c);
			 task.setDocument_URL__c(optional2);
			 
			 com.sforce.soap.enterprise.SaveResult[] results1 = connection.update(new com.sforce.soap.enterprise.sobject.SObject[] { task });
			 System.out.println(subject +"::::::" + results1[0].getSuccess());
			// logger.info("IPMSToSFDC  :: Message "+ subject +" :::::: " + results1[0].getSuccess());
			 if(!results1[0].getSuccess()){
				 System.out.print(subject +"::::::" + results1[0].getErrors()[0].getMessage());
			 }
		}catch(Exception e) {
			
		}
	}
	
	
	public void testSFDC() {
		try {
			EnterpriseConnection connection=SFDCConnection.SfdcConnect();
			QueryResult queryResultsAttachment = connection.query("SELECT Attachment_URL__c,Case__c,Id FROM SR_Attachments__c WHERE Case__c = '5001n00000lF5mf' AND Name LIKE '%PCC%'");
			System.out.println("queryResultsAttachment  :: "+queryResultsAttachment);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception  :: "+e.getMessage());
		}
	}
	
}
