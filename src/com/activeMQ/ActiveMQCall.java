package com.activeMQ;

import java.io.InputStream;
import java.util.Random;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.log4j.Logger;

import com.action.COCD;

public class ActiveMQCall {
	
	ResourceBundle bundle = null;
	private Connection connection = null;
	private ActiveMQSession session = null;
	private Destination destination = null;
	private MessageProducer producer = null;
	private MessageConsumer consumer = null;
	QueueSender queueSender;
	String response = "";
	InputStream inputStream;
	final static Logger logger = Logger.getLogger(ActiveMQCall.class); 

	public String GetProducer(String queueName ,String Id,String correlationId,String jsonString) {
		
		//System.out.println("vds");
		try {
		 bundle = ResourceBundle.getBundle("serverConfig");
		 String activeMQURL ="";
			String activeMQUsername="";
			String activeMQPassword="";
			 bundle = ResourceBundle.getBundle("serverConfig");
			 activeMQURL=bundle.getString("activeMQ.URL");
			 activeMQUsername=bundle.getString("activeMQ.Username");
			 activeMQPassword = bundle.getString("activeMQ.Password");

		/*ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
		"tcp://" + prop.getProperty("activeMQ.URL") + ":61616");*/
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(activeMQUsername, activeMQPassword, activeMQURL);
     connection = connectionFactory.createConnection();
    session = (ActiveMQSession) connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
          queueName = queueName.toUpperCase();
            destination = session.createQueue(queueName);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
          connection.start();
          TextMessage textMessage = session.createTextMessage();
          textMessage.setStringProperty("id", Id);
  		logger.info(" jsonString in producer of SFDC param :: "+jsonString);

          textMessage.setText(jsonString);
          textMessage.setJMSCorrelationID(correlationId);
			textMessage.setJMSRedelivered(true);
			//producer.setDeliveryMode(arg0);
			//System.out.println("start");
			producer.send(textMessage);
			//System.out.println("end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			try {
			connection.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
  		logger.info("correlationId Producer :: "+correlationId);

		return correlationId;
	}
public String GetConsumer(String queueName) {
		String correlationId = "";
		try {
			
			 bundle = ResourceBundle.getBundle("serverConfig");
			 String activeMQURL ="";
				String activeMQUsername="";
				String activeMQPassword="";
				 bundle = ResourceBundle.getBundle("serverConfig");
				 activeMQURL=bundle.getString("activeMQ.URL");
				 activeMQUsername=bundle.getString("activeMQ.Username");
				 activeMQPassword = bundle.getString("activeMQ.Password");

			/*ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
			"tcp://" + prop.getProperty("activeMQ.URL") + ":61616");*/
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(activeMQUsername, activeMQPassword, activeMQURL);
	     connection = connectionFactory.createConnection();
	     connection.start();
	    session = (ActiveMQSession) connection.createSession(false,
			Session.AUTO_ACKNOWLEDGE);
	    queueName = queueName.toUpperCase();
		destination = session.createQueue(queueName);
		//destination = session.createTopic("Topic.File.Transport");
		consumer = session.createConsumer(destination);
	//	System.out.println("1");
			Message msg= consumer.receive();
			correlationId = msg.getJMSCorrelationID();
	//		System.out.println("2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "false";
		}finally {
			try {
			connection.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
  		logger.info("correlationId consumer :: "+correlationId);

		return correlationId;
		
	}

public String createRandomString() {
	Random random = new Random(System.currentTimeMillis());
	long randomLong = random.nextLong();
	return Long.toHexString(randomLong);
}

public static void main(String args[]) {
	ActiveMQCall a = new ActiveMQCall();
	a.GetProducer("AOPT.RULE.AOPTDETAILSUAT","33","1234","");
	/*try {
	ResourceBundle	bundle = ResourceBundle.getBundle("serverConfig");
	 String activeMQURL ="";
		String activeMQUsername="";
		String activeMQPassword="";
		 bundle = ResourceBundle.getBundle("serverConfig");
		 activeMQURL=bundle.getString("activeMQ.URL");
		 activeMQUsername=bundle.getString("activeMQ.Username");
		 activeMQPassword = bundle.getString("activeMQ.Password");
System.out.println("activeMQURL"+activeMQURL);
System.out.println("activeMQUsername "+		 activeMQUsername);
System.out.println("activeMQPassword "+activeMQPassword);
	
ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(activeMQUsername, activeMQPassword, activeMQURL);
//connection = connectionFactory.createConnection();
System.out.println(connectionFactory);
Connection connection = connectionFactory.createConnection();
System.out.println(connection);
connection.start();
Session session =  connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
System.out.println(session);
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}*/
}


}
