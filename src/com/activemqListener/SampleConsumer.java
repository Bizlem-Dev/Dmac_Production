package com.activemqListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.BlobMessage;
import org.apache.commons.codec.binary.Base64;

public class SampleConsumer {

	private static final long serialVersionUID = 1L;
	 private static MessageProducer replyProducer;

	
	private static ActiveMQSession session;
	private static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}
	public static void main(String[] args) {
		try{
	//		Base64.encodeFileToBase64Binary
			//String attachment_string= Base64.encodeFileToBase64Binary("D:\\CRFDemo.pdf");
			
			File file = new File("D:\\CRFDemo.pdf");
			byte[] bytes = loadFile(file);
			byte[] encoded = Base64.encodeBase64(bytes);
			String encodedString = new String(encoded);
			System.out.println(encodedString);
			
		// TODO Auto-generated method stub
//		   ConnectionFactory connectionFactory  = new ActiveMQConnectionFactory("admin","KCMT7g4G6BUQ","tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
//				Connection connection = connectionFactory.createConnection();
//				connection.start();
//				// JMS messages are sent and received using a Session. We will
//				// create here a non-transactional session object. If you want
//				// to use transactions you should set the first parameter to 'true'
//				 session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//				// Destination represents here our queue 'VALLYSOFTQ' on the
//				// JMS server. You don't have to do anything special on the
//				// server to create it, it will be created automatically.
//		   Destination destination = session.createQueue("PASSPORTSERVICEBlobNot");
//				// MessageConsumer is used for receiving (consuming) messages
//				MessageConsumer consumer = session.createConsumer(destination);
//				System.out.println("Consumer1234");
//				
//				//Setup a message producer to respond to messages from clients, we will get the destination
//	            //to send to from the JMSReplyTo header field from a Message
//	            replyProducer = session.createProducer(null);
//	            replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//
//				// Listen for arriving messages 
//				MessageListener listener = new MessageListener() { 
//				
//
//				@Override
//				public void onMessage(Message message) {
//					try {
//					TextMessage response = session.createTextMessage();
//					// TODO Auto-generated method stub
//					System.out.println("Message");
//					if (message instanceof TextMessage) {
//						TextMessage textMessage = (TextMessage) message;
//						// tbd parsing of json
//										
//							System.out.println("Receivedage '" + textMessage.getText()+ "'");
//							
//							
//							System.out.println("JMSReply '" + textMessage.getJMSReplyTo()+ "'");
//							System.out.println("JMSCore '" + textMessage.getJMSCorrelationID()+ "'");
//							
//							response.setText("Back Please delete the file");
//							//System.out.println(res);
//							//response.setJMSReplyTo(textMessage.getJMSReplyTo());
//							response.setJMSCorrelationID(textMessage.getJMSCorrelationID());
//							replyProducer.send(textMessage.getJMSReplyTo(),response);		
//
//						}else if (message instanceof BlobMessage) {
//							BlobMessage textMessageBlob = (BlobMessage) message;
//							System.out.println(textMessageBlob.getInputStream());
//							System.out.println(textMessageBlob.getName());
//							System.out.println(textMessageBlob.getJMSCorrelationID());
//							System.out.println(textMessageBlob.getStringProperty("vvvvv"));
//						}
//				    }
//					 catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//							System.out.print("error message :: "+e.getMessage());
//						}
//				} 
//				};
//				consumer.setMessageListener(listener);
				//connection.close();
				//session.close();
				}catch(Exception e){
					System.out.print("error :: "+e.getMessage());
				}

	}

}
