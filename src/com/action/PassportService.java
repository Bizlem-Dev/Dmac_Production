package com.action;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.apache.axis2.databinding.types.soapencoding.Base64Binary;
import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.bean.MongoDB;

public class PassportService {
	//final static Logger logger = Logger.getLogger(COCD.class); 
	public com.activeMQ.ActiveMQCall activemqcall=new ActiveMQCall();
	MongoDB objMongoDB = null;
	 /**
     * Binary data is saved in server {$wso2wsas.home/tmp/mtom} appending the fileName
     *
     * @param fileName   file name
     * @param binaryData DataHandler object wrapper
     * @return String : status; Success of Fail
     */
    public String Passportserv(String url) {
    	final String queueName = "PASSPORTSERVICE";
	//	logger.info("queueName :: "+queueName);
      String res="";
      ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
      try { 
//      DataHandler s=b.getBase64Binary();
//     BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
//		ByteArrayOutputStream buf = new ByteArrayOutputStream();
//		int result = bis.read();
//		while(result != -1) {
//		    buf.write((byte) result);
//		    result = bis.read();
//		}
		
		//return buf.toString("UTF-8");
		String correlationId = activemqcall.createRandomString();

		 String jsonString ="{\"fileurl\":\""+url+"\",\"ReferenceID\":\""+correlationId+"\"}";
	//		logger.info("jsonString of SFDC param :: "+jsonString); 
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
					.createQueue(queueName); // **************queue
			// name***************
			System.out.println("connected to queue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// listener code
			Destination tempDest = session.createTemporaryQueue();
			MessageConsumer responseConsumer = session.createConsumer(tempDest);

			/*
			 * MessageListener listener = new MessageListener() {
			 * 
			 * public void onMessage(Message message) { // TODO Auto-generated method stub
			 * String messageText = null; try { if (message instanceof TextMessage) {
			 * TextMessage textMessage = (TextMessage) message; messageText =
			 * textMessage.getText(); System.out.println("messageText = " + messageText);
			 * System.out.println("listener");
			 * 
			 * } } catch (JMSException e) { // Handle the exception appropriately } }
			 * 
			 * };
			 * 
			 * responseConsumer.setMessageListener(listener);
			 */
			
			TextMessage message = session.createTextMessage();
			message.setText(jsonString);
			// Set the reply to field to the temp queue you created above, this is the queue
			// the server
			// will respond to
			message.setJMSReplyTo(tempDest);

			//String correlationId = activemqcall.createRandomString();
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
			System.out.println("message :: " + objTextMsg.getText());
			// System.out.println("success");
			while (true) {
				if (objTextMsg.getText() != null) {
					System.out.println("message if :: " + objTextMsg);
					res = objTextMsg.getText();
					

					String requestString="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"url\":\""+url+"\"}";
					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, "s");
					
					break;
				} else {
					objTextMsg = (TextMessage) responseConsumer.receive();
					System.out.println("message else :: " + objTextMsg);
				}
			}

			System.out.println("success");
		} catch (Exception e) {
			//System.out.println();
			System.out.println("error ::" + e.getMessage());
		}finally {try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	return res;
	   		
      }   

    
    public String PassportServiceBase64(String filename,Base64Binary b) {
    	final String queueName = "PASSPORTSERVICEBlobUAT";
	//	logger.info("queueName :: "+queueName);
    	ResourceBundle bunlde = ResourceBundle.getBundle("serverConfig");
      String res="";
      ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
      try { 
//      DataHandler s=b.getBase64Binary();
//     BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
//		ByteArrayOutputStream buf = new ByteArrayOutputStream();
//		int result = bis.read();
//		while(result != -1) {
//		    buf.write((byte) result);
//		    result = bis.read();
//		}
    	  activemqcall = new ActiveMQCall();
			
    	  DataHandler s=b.getBase64Binary();
    	InputStream in=  s.getInputStream();
    	  byte[] buffer= new byte[in.available()];
    	  in.read(buffer);
    	  File file= new File(filename);
    	  String fileUrl = bunlde.getString("passportloc")+file;
    	  FileOutputStream out= new FileOutputStream(fileUrl);
    	  out.write(buffer);
    	  out.close();
		String url = bunlde.getString("passportip")+filename;
		//return buf.toString("UTF-8");
		String correlationId = activemqcall.createRandomString();

		 String jsonString ="{\"fileurl\":\""+url+"\",\"ReferenceID\":\""+correlationId+"\"}";
	//		logger.info("jsonString of SFDC param :: "+jsonString); 
			System.out.println(jsonString);

			// \"\":\"\"++\"\"
			 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
					"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
			System.out.println(connectionFactory + " :: " + "connected to activemq server");
			 connection = connectionFactory.createConnection();
			connection.start();
			//Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			ActiveMQSession session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session
					.createQueue(queueName); // **************queue
			// name***************
			System.out.println("connected to queue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// listener code
			Destination tempDest = session.createTemporaryQueue();
			MessageConsumer responseConsumer = session.createConsumer(tempDest);

			/*
			 * MessageListener listener = new MessageListener() {
			 * 
			 * public void onMessage(Message message) { // TODO Auto-generated method stub
			 * String messageText = null; try { if (message instanceof TextMessage) {
			 * TextMessage textMessage = (TextMessage) message; messageText =
			 * textMessage.getText(); System.out.println("messageText = " + messageText);
			 * System.out.println("listener");
			 * 
			 * } } catch (JMSException e) { // Handle the exception appropriately } }
			 * 
			 * };
			 * 
			 * responseConsumer.setMessageListener(listener);
			 */
//			DataHandler h = url.getBase64Binary();
//			ObjectMessage bm = session.createObjectMessage();
//			bm.set
//			DataHandler h = b.getBase64Binary();
//			BlobMessage message =session.createBlobMessage(h.getInputStream());
//			message.setName(filename);
			TextMessage message = session.createTextMessage();
			
			message.setText(jsonString);
			// Set the reply to field to the temp queue you created above, this is the queue
			// the server
			// will respond to
			message.setJMSReplyTo(tempDest);

			//String correlationId = activemqcall.createRandomString();
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
//			BlobMessage objTextMsgBlob = (BlobMessage) responseConsumer.receive();
//			objTextMsgBlob.getName();
//			objTextMsgBlob.getInputStream();
			System.out.println("message :: " + objTextMsg.getText());
			// System.out.println("success");
			while (true) {
				if (objTextMsg.getText() != null) {
					System.out.println("message if :: " + objTextMsg);
					res = objTextMsg.getText();
					File doc = new File(bunlde.getString("passportloc")+filename);
					if(doc.exists()) {
						doc.delete();
					}
					
					String requestString="{\"P_REQUEST_NUMBER\":\""+correlationId+"\",\"filename\":\""+filename+"\"}";
					objMongoDB.mongoDBInsertFull(correlationId, requestString, "SFDC",reqDate, "IPMS", res, "s");
					
					break;
				} else {
					objTextMsg = (TextMessage) responseConsumer.receive();
					System.out.println("message else :: " + objTextMsg);
				}
			}

			System.out.println("success");
		} catch (Exception e) {
			//System.out.println();
			System.out.println("error ::" + e.getMessage());
			res = e.getMessage();
		}finally {try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	return res;
	   		
      }   

    
}
	


