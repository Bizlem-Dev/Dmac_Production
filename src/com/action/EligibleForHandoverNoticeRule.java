
package com.action;

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

import org.apache.activemq.ActiveMQConnectionFactory;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;

public class EligibleForHandoverNoticeRule {

	public com.activeMQ.ActiveMQCall activemqcall = null;
	public com.activeMQ.ActiveMQCall connection = null;
	MongoDB objMongoDB=null;


//	public String EligibleForHandoverNotice(String RegistrationId, String ProcessName, String SubProcessName,
//			String ProjectCity, String Project, String BuildingCode, String PermittedUse, String BedroomType,
//			String ApplicableUnits, String UnitType, String CustomerType, String ModeofRequest, String AggrementStatus,
//			String UnderAssignment) {
//		String res = "EligibleForHandoverNotice";
//		ConnectionFactory connectionFactory =null;
//	  	Connection connection = null;
//
//		// http://localhost:8080/CRM_SR_NEW/services/EligibleForHandoverNoticeRule/EligibleForHandoverNotice?RegistrationId=11&ProcessName=&SubProcessName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ApplicableUnits=&UnitType=&CustomerType=&ModeofRequest=&AggrementStatus=&UnderAssignment=
//		//
//		try {
//			String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
//					+ "\",\"SubProcessName\":\"" + SubProcessName + "\"," + "\"ProjectCity\":\"" + ProjectCity
//					+ "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\"" + BuildingCode + "\",\"PermittedUse\":\""
//					+ PermittedUse + "\",\"BedroomType\":\"" + BedroomType + "\",\"ApplicableUnits\":\""
//					+ ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\",\"CustomerType\":\"" + CustomerType
//					+ "\",\"ModeofRequest\":\"" + ModeofRequest + "\",\"AggrementStatus\":\"" + AggrementStatus
//					+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"}";
//
//			System.out.println(jsonString);
//
//			activemqcall = new ActiveMQCall();
//			// \"\":\"\"++\"\"
//			 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
//					"tcp://34.231.101.144:61616?wireFormat.maxInactivityDuration=0");
//			System.out.println(connectionFactory + " :: " + "connected to activemq server");
//			 connection = connectionFactory.createConnection();
//			connection.start();
//			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//			Destination destination = session
//					.createQueue("ELIGIBLEFORHANDOVERNOTICERULE.RULE.ELIGIBLEFORHANDOVERNOTICEUAT"); // **************queue
//																									// name***************
//			System.out.println("connected to queue");
//			MessageProducer producer = session.createProducer(destination);
//			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//			// listener code
//			Destination tempDest = session.createTemporaryQueue();
//			MessageConsumer responseConsumer = session.createConsumer(tempDest);
//
//		/*	MessageListener listener = new MessageListener() {
//
//				public void onMessage(Message message) {
//					// TODO Auto-generated method stub
//					String messageText = null;
//					try {
//						if (message instanceof TextMessage) {
//							TextMessage textMessage = (TextMessage) message;
//							messageText = textMessage.getText();
//							System.out.println("messageText = " + messageText);
//							System.out.println("listener");
//
//						}
//					} catch (JMSException e) {
//						// Handle the exception appropriately
//					}
//				}
//
//			};
//
//			responseConsumer.setMessageListener(listener);   */
//
//			TextMessage message = session.createTextMessage();
//			message.setText(jsonString);
//			// Set the reply to field to the temp queue you created above, this is the queue
//			// the server
//			// will respond to
//			message.setJMSReplyTo(tempDest);
//
//			String correlationId = activemqcall.createRandomString();
//			// String correlationId = P_REQUEST_NUMBER;
//			System.out.println("1 :: " + correlationId);
//			message.setJMSCorrelationID(correlationId);
//
//			// Tell the producer to send the message
//			System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
//			// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
//			// correlationId, jsonString);
//
//			// ((Object) producer).send(message);
//			objMongoDB = new MongoDB();
//	   		Date reqDate = new Date();
//			
//			producer.send(message);
//			
//			TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
//			System.out.println("message :: "+objTextMsg.getText());
//			//System.out.println("success");
//			while(true) {
//				if(objTextMsg.getText() != null) {
//					System.out.println("message if :: "+objTextMsg);
//					res = objTextMsg.getText();
//					
//					String requestString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
//							+ "\",\"SubProcessName\":\"" + SubProcessName + "\"," + "\"ProjectCity\":\"" + ProjectCity
//							+ "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\"" + BuildingCode + "\",\"PermittedUse\":\""
//							+ PermittedUse + "\",\"BedroomType\":\"" + BedroomType + "\",\"ApplicableUnits\":\""
//							+ ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\",\"CustomerType\":\"" + CustomerType
//							+ "\",\"ModeofRequest\":\"" + ModeofRequest + "\",\"AggrementStatus\":\"" + AggrementStatus
//							+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"}";
//
//					
//					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE",res, "s");
//
//					break;
//				}else {
//					objTextMsg = (TextMessage) responseConsumer.receive();
//					System.out.println("message else :: "+objTextMsg);
//				}
//			}
//			
//
//
//			System.out.println("success");
//		} catch (Exception e) {
//			System.out.println("error ::" + e.getMessage());
//		}finally {try {
//			connection.close();
//		} catch (JMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}}
//		return res;
//
//	}

	public String EligibleForHandoverNotice(String RegistrationId,String processName,String subProcessName,String modeOfRequest,
			   String noOfMajorSnagsInApartment,String accessPresent,String utilitiesAvailable,String percAptsSnagged,String EHOCase,String DaysToEarliestViewing,
			   String extra1,String extra2,String extra3,String extra4,String extra5,String extra6,
			   String extra7,String extra8,String extra9,String extra10,String extra11,String extra12,String extra13,String extra14,String extra15,
			   String extra16,String extra17,String extra18,String extra19,String extra20) {
		String res = "EligibleForHandoverNotice";
		 ConnectionFactory connectionFactory =null;
		  	Connection connection = null;
		  	

		// http://localhost:8080/CRM_SR_NEW/services/EligibleForHandoverNoticeRule/EligibleForHandoverNotice?RegistrationId=11&ProcessName=&SubProcessName=&ProjectCity=&Project=&BuildingCode=&PermittedUse=&BedroomType=&ApplicableUnits=&UnitType=&CustomerType=&ModeofRequest=&AggrementStatus=&UnderAssignment=
		//
		try {
			
//			String RegistrationId,
//			   String ProcessName,String SubProcessName,String ProjectCity,String NotApplicableCity,String Project,String 
//			   NotApplicableProject,String BuildingCode,String NotApplicableBuildingCode,String PermittedUse,
//			   String NotApplicablePermittedUse,String BedroomType,String NotApplicableBedroomType,String ApplicableUnits,
//			   String NotApplicableUnits,String UnitType,String AreaVariation,String TypeVariation,String Recoveryflag,String Paid,
//			   String DefaultPercentage,String CustomerType,String ModeofRequest,String AgreementStatus,String Default,
//			   String UnderTermination,String Dispute, String Enforcement,String Litigation,String CourtCasorCounterclaim,
//			   String Mortgage,String UnderAssignment,String NoofMajorSnagsinApartment,String BCCavailable,String AccessPresent,
//			   String Utilitiesavailable,String AptsSnagged,String extra1,String extra2,String extra3,String extra4,String extra5,String extra6,
//			   String extra7,String extra8,String extra9,String extra10,String extra11,String extra12,String extra13,String extra14,String extra15
			
			
//			String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
//					+ "\",\"SubProcessName\":\"" + SubProcessName + "\"," + "\"ProjectCity\":\"" + ProjectCity
//					+ "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\"" + BuildingCode + "\",\"PermittedUse\":\""
//					+ PermittedUse + "\",\"BedroomType\":\"" + BedroomType + "\",\"ApplicableUnits\":\""
//					+ ApplicableUnits + "\",\"UnitType\":\"" + UnitType + "\",\"CustomerType\":\"" + CustomerType
//					+ "\",\"ModeofRequest\":\"" + ModeofRequest + "\",\"AggrementStatus\":\"" + AggrementStatus
//					+ "\",\"UnderAssignment\":\"" + UnderAssignment + "\"}";

//			String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName
//				     + "\",\"SubProcessName\":\"" + SubProcessName + "\"," + "\"ProjectCity\":\"" + ProjectCity
//				     + "\",\"NotApplicableCity\":\"" + NotApplicableCity + "\"," + "\"Project\":\"" + Project
//				     + "\",\"NotApplicableProject\":\"" + NotApplicableProject + "\"," + "\"BuildingCode\":\"" + BuildingCode
//				     + "\",\"NotApplicableBuildingCode\":\"" + NotApplicableBuildingCode + "\"," + "\"PermittedUse\":\"" + PermittedUse
//				     + "\",\"NotApplicablePermittedUse\":\"" + NotApplicablePermittedUse + "\"," + "\"BedroomType\":\"" + BedroomType
//				     + "\",\"NotApplicableBedroomType\":\"" + NotApplicableBedroomType + "\"," + "\"ApplicableUnits\":\"" + ApplicableUnits
//				     + "\",\"NotApplicableUnits\":\"" + NotApplicableUnits + "\"," + "\"UnitType\":\"" + UnitType
//				     + "\",\"AreaVariation\":\"" + AreaVariation + "\"," + "\"TypeVariation\":\"" + TypeVariation
//				     + "\",\"Recoveryflag\":\"" + Recoveryflag + "\"," + "\"Paid\":\"" + Paid
//				     + "\",\"DefaultPercentage\":\"" + DefaultPercentage + "\"," + "\"CustomerType\":\"" + CustomerType
//				     + "\",\"ModeofRequest\":\"" + ModeofRequest + "\"," + "\"AgreementStatus\":\"" + AgreementStatus
//				     + "\",\"Default\":\"" + Default + "\"," + "\"UnderTermination\":\"" + UnderTermination
//				     + "\",\"Dispute\":\"" + Dispute + "\"," + "\"Enforcement\":\"" + Enforcement
//				     + "\",\"Litigation\":\"" + Litigation + "\"," + "\"CourtCasorCounterclaim\":\"" + CourtCasorCounterclaim
//				     + "\",\"Mortgage\":\"" + Mortgage + "\"," + "\"UnderAssignment\":\"" + UnderAssignment
//				     + "\",\"NoofMajorSnagsinApartment\":\"" + NoofMajorSnagsinApartment + "\"," + "\"BCCavailable\":\"" + BCCavailable
//				     + "\",\"AccessPresent\":\"" + AccessPresent + "\"," + "\"Utilitiesavailable\":\"" + Utilitiesavailable
//				     + "\",\"AptsSnagged\":\"" + AptsSnagged + "\""
//				     +",\"extra1\":\"" + extra1 + "\""
//				       +",\"extra2\":\"" + extra2 + "\""
//				       +",\"extra3\":\"" + extra3 + "\""
//				       +",\"extra4\":\"" + extra4 + "\""
//				       +",\"extra5\":\"" + extra5 + "\""
//				       +",\"extra6\":\"" + extra6 + "\""
//				       +",\"extra7\":\"" + extra7 + "\""
//				       +",\"extra8\":\"" + extra8 + "\""
//				       +",\"extra9\":\"" + extra9 + "\""
//				       +",\"extra10\":\"" + extra10 + "\""
//				       +",\"extra11\":\"" + extra11 + "\""
//				       +",\"extra12\":\"" + extra12 + "\""
//				       +",\"extra13\":\"" + extra13 + "\""
//				       +",\"extra14\":\"" + extra14 + "\""
//				       +",\"extra15\":\"" + extra15 + "\""
//				     +"}";		
			
			String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"processName\":\"" + processName
				     + "\",\"subProcessName\":\"" + subProcessName + "\"," + "\"modeOfRequest\":\"" + modeOfRequest
				     + "\",\"noOfMajorSnagsInApartment\":\"" + noOfMajorSnagsInApartment
				     + "\",\"accessPresent\":\"" + accessPresent + "\"," + "\"utilitiesAvailable\":\"" + utilitiesAvailable
				     + "\",\"percAptsSnagged\":\"" + percAptsSnagged + "\"," + "\"EHOCase\":\"" + EHOCase
				     + "\",\"DaysToEarliestViewing\":\"" + DaysToEarliestViewing + "\",\"extra1\":\"" + extra1 + "\""
				       +",\"extra2\":\"" + extra2 + "\""
				       +",\"extra3\":\"" + extra3 + "\""
				       +",\"extra4\":\"" + extra4 + "\""
				       +",\"extra5\":\"" + extra5 + "\""
				       +",\"extra6\":\"" + extra6 + "\""
				       +",\"extra7\":\"" + extra7 + "\""
				       +",\"extra8\":\"" + extra8 + "\""
				       +",\"extra9\":\"" + extra9 + "\""
				       +",\"extra10\":\"" + extra10 + "\""
				       +",\"extra11\":\"" + extra11+ "\""
				       +",\"extra12\":\"" + extra12+ "\""
				       +",\"extra13\":\"" + extra13+ "\""
				       +",\"extra14\":\"" + extra14+ "\""
				       +",\"extra15\":\"" + extra15+ "\""
				        +",\"extra16\":\"" + extra16+ "\""
				         +",\"extra17\":\"" + extra17+ "\""
				          +",\"extra18\":\"" + extra18+ "\""
				           +",\"extra19\":\"" + extra19+ "\""
				            +",\"extra20\":\"" + extra20+ "\""
				                     
				     +"}";
			
			
			
			
			
			System.out.println(jsonString);

			activemqcall = new ActiveMQCall();
			// \"\":\"\"++\"\"
			 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
					"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
			System.out.println(connectionFactory + " :: " + "connected to activemq server");
			 connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session
					.createQueue("ELIGIBLEFORHANDOVERNOTICERULE.RULE.ELIGIBLEFORHANDOVERNOTICEUAT"); // **************queue
																									// name***************
			System.out.println("connected to queue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// listener code
			Destination tempDest = session.createTemporaryQueue();
			MessageConsumer responseConsumer = session.createConsumer(tempDest);

		/*	MessageListener listener = new MessageListener() {

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

			responseConsumer.setMessageListener(listener);   */

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

			// Tell the producer to send the message
			System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
			// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
			// correlationId, jsonString);

			// ((Object) producer).send(message);

			producer.send(message);
			
			TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
			System.out.println("message :: "+objTextMsg.getText());
			//System.out.println("success");
			while(true) {
				if(objTextMsg.getText() != null) {
					System.out.println("message if :: "+objTextMsg);
					res = objTextMsg.getText();
					break;
				}else {
					objTextMsg = (TextMessage) responseConsumer.receive();
					System.out.println("message else :: "+objTextMsg);
				}
			}
			


			System.out.println("success");
		} catch (Exception e) {
			
			System.out.println("error ::" + e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;

	}

	
}
