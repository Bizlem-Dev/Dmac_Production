
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

public class RentalPoolRule {
	public com.activeMQ.ActiveMQCall activemqcall = null;
	public com.activeMQ.ActiveMQCall connection = null;
	MongoDB objMongoDB = null;

	
	public String RentalPoolDetails(String RegistrationId, String ProcessName,String SubProcessName, String ProjectCity, String Project,
			String BuildingCode, String BedroomType, String UnitType, String PermittedUse, String Units,
			String ReadyOffPlan, String ApplicableNationality,String CustomerClassification, String PortfolioValueLessthan,
			String PortfolioValueGreaterthan,String AggrementStatus) throws JMSException {
		String res = "RentalPoolDetails";
		ConnectionFactory connectionFactory =null;
	  	Connection connection = null;

		// url
//		 http://localhost:8080/CRM_SR_NEW/services/RentalPoolRule/RentalPoolDetails?RegistrationId=33=&ProcessName=&SubProcessName=&ProjectCity=&Project=&BuildingCode=&BedroomType=&UnitType=&PermittedUse=&Units=&ReadyOffPlan=&ApplicableNationality=&CustomerClassification=&PortfolioValueLessthan=&PortfolioValueGreaterthan=&AggrementStatus=
		try {
		String jsonString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcessName\":\"" + SubProcessName
				+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
				+ BuildingCode + "\",\"BedroomType\":\"" + BedroomType + "\",\"UnitType\":\"" + UnitType
				+ "\",\"PermittedUse\":\"" + PermittedUse + "\",\"Units\":\"" + Units + "\"," + "\"ReadyOffPlan\":\""
				+ ReadyOffPlan + "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"CustomerClassification\":\"" + CustomerClassification + "\",\"PortfolioValueLessthan\":\"" + PortfolioValueLessthan
				+ "\",\"PortfolioValueGreaterthan\":\"" + PortfolioValueGreaterthan
				+ "\",\"AggrementStatus\":\"" + AggrementStatus + "\"}";
		System.out.println(jsonString);
		
		activemqcall = new ActiveMQCall();
		// \"\":\"\"++\"\"
		 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
				"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
		System.out.println(connectionFactory + " :: " + "connected to activemq server");
		 connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("RENTALPOOLRULE.RULE.RENTALPOOLDETAILSUAT");      //**************queue name***************
		System.out.println("connected to queue");
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		// listener code
		Destination tempDest = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempDest);

	/*	MessageListener listener = new MessageListener() {

			public void onMessage(Message message) {
				// TODO Auto-generated method stubl
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

		responseConsumer.setMessageListener(listener);  */

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
		System.out.println("success");

		// Tell the producer to send the message
		System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
		// correlationId = activemqcall.GetProducer(queueName, RegistrationId,
		// correlationId, jsonString);

		// ((Object) producer).send(message);
		objMongoDB = new MongoDB();
   		Date reqDate = new Date();
		producer.send(message);
		
		TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
		System.out.println("message :: "+objTextMsg.getText());
		//System.out.println("success");
		while(true) {
			if(objTextMsg.getText() != null) {
				System.out.println("message if :: "+objTextMsg);
				res = objTextMsg.getText();
				String requestString = "{\"RegistrationId\":\"" + RegistrationId + "\",\"ProcessName\":\"" + ProcessName + "\",\"SubProcessName\":\"" + SubProcessName
						+ "\",\"ProjectCity\":\"" + ProjectCity + "\",\"Project\":\"" + Project + "\",\"BuildingCode\":\""
						+ BuildingCode + "\",\"BedroomType\":\"" + BedroomType + "\",\"UnitType\":\"" + UnitType
						+ "\",\"PermittedUse\":\"" + PermittedUse + "\",\"Units\":\"" + Units + "\"," + "\"ReadyOffPlan\":\""
						+ ReadyOffPlan + "\",\"ApplicableNationality\":\"" + ApplicableNationality + "\",\"CustomerClassification\":\"" + CustomerClassification + "\",\"PortfolioValueLessthan\":\"" + PortfolioValueLessthan
						+ "\",\"PortfolioValueGreaterthan\":\"" + PortfolioValueGreaterthan
						+ "\",\"AggrementStatus\":\"" + AggrementStatus + "\"}";
				objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "RULE", res, "s");

				break;
			}else {
				objTextMsg = (TextMessage) responseConsumer.receive();
				System.out.println("message else :: "+objTextMsg);
			}
		}
		


		System.out.println("success");
		}
		catch(Exception e)
		{
			System.out.println("error ::"+e.getMessage());
		}finally {try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

		return res;

	}

	
}