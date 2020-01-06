package com.activeMQ;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.util.ByteArrayInputStream;
import org.apache.axis2.databinding.types.soapencoding.Base64Binary;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.log4j.Logger;

import com.action.COCD;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class FtpClientIPMS {
	
	ResourceBundle bundle = ResourceBundle.getBundle("serverConfig");
	final static Logger logger = Logger.getLogger(FtpClientIPMS.class);
public String transferFileToIPMS(String filename,Base64Binary b) {
	System.out.println("blob :: "+b);
	DataHandler h = b.getBase64Binary();
	
	String server = bundle.getString("ipmsserver");
    int port = 22;
    String user = bundle.getString("ipmsuser");
    String pass = bundle.getString("ipmspass");
    try {
	JSch jsch = new JSch();
	com.jcraft.jsch.Session session = jsch.getSession(user,server,port);
    session.setConfig("StrictHostKeyChecking", "no");
    session.setPassword(pass);
    session.connect();
    
   Channel channel = session.openChannel("sftp");
    ChannelSftp sftp = ( ChannelSftp ) channel;
    sftp.connect();
    sftp.cd(bundle.getString("ipmsloc"));
    sftp.put(h.getInputStream(), filename);
    System.out.println(sftp.ls(bundle.getString("ipmsloc")));
    System.out.println(sftp.pwd());
    }catch (Exception ex) {
    	return ex.getMessage();
		// TODO: handle exception
	}
    return "true";
}

public String transferFileToIPMSFTPS(String P_REQUEST_NUMBER,String filename,Base64Binary b) {
	System.out.println("blob :: "+b);
	DataHandler h = b.getBase64Binary();
	String result = "false";
	String server = bundle.getString("ipmsserver");
    int port = 990;
    String user = bundle.getString("ipmsuser");
    String pass = bundle.getString("ipmspass");

    FTPSClient ftpClient = new FTPSClient(true);    
    try {
    	logger.info("transferFileToIPMSFTPS  ::  filename  ::  "+filename);
    	//ftpClient.
    	ftpClient.setConnectTimeout(1000);
        ftpClient.connect(server, port);
        boolean logIn = ftpClient.login(user, pass);
        System.out.println(logIn);
      //  ftpClient.
        ftpClient.setBufferSize(1024*1024);
        ftpClient.enterLocalPassiveMode();
      boolean cd =  ftpClient.changeWorkingDirectory(bundle.getString("ipmsloc"));
System.out.println(cd);

ftpClient.execPBSZ(0);
ftpClient.execPROT("P");
		// APPROACH #1: uploads first file using an InputStream
        
        System.out.println("Start uploading first file");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        boolean done = ftpClient.storeFile(filename, h.getInputStream());
        System.out.println("done :: "+done + ftpClient.getReplyCode() + ftpClient.getReplyString() + " :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER);
        if (done) {
            System.out.println("The first file is uploaded successfully.");
            result  = "fileupload  ::  file is uploaded successfully  :: ReplyCode  ::  "+ftpClient.getReplyCode()  + " ReplyMessage  ::  "+ftpClient.getReplyString();
            logger.info("transferFileToIPMSFTPS  ::  fileupload  ::  file is uploaded successfully  :: ReplyCode  ::  "+ftpClient.getReplyCode()  + " ReplyMessage  ::  "+ftpClient.getReplyString() + " :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER);
        }else {
        	result  = "fileupload  ::  file is not uploaded successfully  :: ReplyCode  ::  "+ftpClient.getReplyCode()  + " ReplyMessage  ::  "+ftpClient.getReplyString();
        	logger.info("transferFileToIPMSFTPS  ::  fileupload  ::  file is not uploaded successfully  :: ReplyCode  ::  "+ftpClient.getReplyCode()  + " ReplyMessage  ::  "+ftpClient.getReplyString() + " :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER);
        }

   
    } catch (Exception ex) {
    	System.out.println("transferFileToIPMSFTPS  ::  error message  ::  "+ex.getMessage() + " :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER);
        // ex.printStackTrace();
         logger.info("transferFileToIPMSFTPS  ::  error message  ::  "+ex.getMessage() + " :: P_REQUEST_NUMBER  :: "+P_REQUEST_NUMBER);
         //return ex.getMessage();
         //result = "error message  ::  "+ex.getMessage();
    	transferFileToIPMSFTPS(P_REQUEST_NUMBER,filename,b);
        
    } finally {
        try {
            if (ftpClient.isConnected()) {
            	System.out.println("Inside Finally");
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    return result;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String server = "10.8.8.152";
//        int port = 22;
//        String user = "mqdoc";
//        String pass = "mqdoc@123";
        try {
        	FtpClientIPMS.IPMSUploadBase641("2-1201", "abc.pdf");
        	FtpClientIPMS.IPMSUploadBase64N("2-1202", "abcN.pdf");
//        	JSch jsch = new JSch();
//            Session session = jsch.getSession(user,server,port);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.setPassword(pass);
//            session.connect();
//            
//           Channel channel = session.openChannel("ftp");
//            ChannelSftp sftp = ( ChannelSftp ) channel;
//            sftp.connect();
//            sftp.cd("/d03");
//           // sftp.put(in, dst);
//            System.out.println(sftp.ls("/d03"));
//            System.out.println(sftp.pwd());
//            session.disconnect();
        } catch (Exception ex) {
            System.out.println("Oops! Something wrong happened"+ex.getMessage());
            
        }
	}
	
	
	public static com.activeMQ.ActiveMQCall activemqcall=null;
	
	 public static String IPMSUploadBase64(String RequestNumber,String filename,Base64Binary b) {
	    	final String queueName = "IPMS.DocUpload1";
		//	logger.info("queueName :: "+queueName);
	    	ResourceBundle bunlde = ResourceBundle.getBundle("serverConfig");
	      String res="";
	      ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
	  	
			// \"\":\"\"++\"\"
	  	 DataHandler s = null;
	  	InputStream in = null;
	      try { 
	    	   s=b.getBase64Binary();
	      	in=  s.getInputStream();
	      	  byte[] buffer= new byte[in.available()];
	      	  in.read(buffer);
	      	  File file= new File(filename);
	      	  String fileUrl = bunlde.getString("consumertemploc")+file;
	      	  FileOutputStream out= new FileOutputStream(fileUrl);
	      	  out.write(buffer);
	      	  out.close();
	  		String url = bunlde.getString("consumerip")+filename;
	  		//return buf.toString("UTF-8");
	  		activemqcall = new ActiveMQCall();
	  		String correlationId = activemqcall.createRandomString();

	  		 String jsonString ="{\"filename\":\""+filename+"\",\"fileurl\":\""+url+"\",\"ReferenceID\":\""+correlationId+"\"}";
	  	//		logger.info("jsonString of SFDC param :: "+jsonString); 
	  			System.out.println(jsonString);

	  			
	  			// \"\":\"\"++\"\"
	  			 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
	  					"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
	  			System.out.println(connectionFactory + " :: " + "connected to activemq server");
	  			 connection = connectionFactory.createConnection();
	  			connection.start();
	  			//Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	  			ActiveMQSession session = (ActiveMQSession) connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
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
//	  			DataHandler h = url.getBase64Binary();
//	  			ObjectMessage bm = session.createObjectMessage();
//	  			bm.set
//	  			DataHandler h = b.getBase64Binary();
//	  			BlobMessage message =session.createBlobMessage(h.getInputStream());
//	  			message.setName(filename);
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

	  			producer.send(message);

	  			TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
//	  			BlobMessage objTextMsgBlob = (BlobMessage) responseConsumer.receive();
//	  			objTextMsgBlob.getName();
//	  			objTextMsgBlob.getInputStream();
	  			System.out.println("message :: " + objTextMsg.getText());
	  			logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Message :: "+objTextMsg.getText() + " Message Id :: " +RequestNumber);
	  			// System.out.println("success");
	  			
	  			while (true) {
	  				if (objTextMsg.getText() != null) {
	  					System.out.println("message if :: " + objTextMsg);
	  					res = objTextMsg.getText();
	  					File doc = new File(bunlde.getString("consumertemploc")+filename);
	  					if(doc.exists()) {
	  						doc.delete();
	  					}
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
	  			logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Last Error :: "+e.getMessage() + " Message Id :: " +RequestNumber);
	  			res = e.getMessage();
	  		}finally {
	  			try {
	  				connection.close();
	  				s = null;
	  				in.close();
	  			} catch (Exception e) {
	  				// TODO Auto-generated catch block
	  				logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Finally Error :: "+e.getMessage() + " Message Id :: " +RequestNumber);
	  			}
	  		}
	  	return res;
		   		
	      }

	 public static String IPMSUploadBase641(String RequestNumber,String filename) {
	    	final String queueName = "IPMS.DocUpload1";
		//	logger.info("queueName :: "+queueName);
	    	ResourceBundle bunlde = ResourceBundle.getBundle("serverConfig");
	      String res="";
	      ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
	  	
			// \"\":\"\"++\"\"
	  	 DataHandler s = null;
	  	InputStream in = null;
	      try { 
	    	   
	  		String url = bunlde.getString("consumerip")+filename;
	  		//return buf.toString("UTF-8");
	  		activemqcall = new ActiveMQCall();
	  		String correlationId = activemqcall.createRandomString();

	  		 String jsonString ="{\"filename\":\""+filename+"\",\"fileurl\":\""+url+"\",\"ReferenceID\":\""+correlationId+"\"}";
	  	//		logger.info("jsonString of SFDC param :: "+jsonString); 
	  			System.out.println(jsonString);

	  			
	  			// \"\":\"\"++\"\"
	  			 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
	  					"tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
	  			System.out.println(connectionFactory + " :: " + "connected to activemq server");
	  			 connection = connectionFactory.createConnection();
	  			connection.start();
	  			//Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	  			ActiveMQSession session = (ActiveMQSession) connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
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
//	  			DataHandler h = url.getBase64Binary();
//	  			ObjectMessage bm = session.createObjectMessage();
//	  			bm.set
//	  			DataHandler h = b.getBase64Binary();
//	  			BlobMessage message =session.createBlobMessage(h.getInputStream());
//	  			message.setName(filename);
	  			TextMessage message = session.createTextMessage();
	  			
	  			message.setText(jsonString);
	  			message.setJMSReplyTo(tempDest);
	  			System.out.println("1 :: " + correlationId);
	  			message.setJMSCorrelationID(correlationId);
	  			System.out.println("success");
	  			producer.send(message);
	  			TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
	  			System.out.println("message :: " + objTextMsg.getText());
	  			logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Message :: "+objTextMsg.getText() + " Message Id :: " +RequestNumber);
	  			// System.out.println("success");
	  			
	  			while (true) {
	  				if (objTextMsg.getText() != null) {
	  					System.out.println("message if :: " + objTextMsg);
	  					res = objTextMsg.getText();
	  					File doc = new File(bunlde.getString("consumertemploc")+filename);
	  					if(doc.exists()) {
	  						doc.delete();
	  					}
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
	  			logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Last Error :: "+e.getMessage() + " Message Id :: " +RequestNumber);
	  			res = e.getMessage();
	  		}finally {
	  			try {
	  				connection.close();
	  				s = null;
	  				in.close();
	  			} catch (Exception e) {
	  				// TODO Auto-generated catch block
	  				logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Finally Error :: "+e.getMessage() + " Message Id :: " +RequestNumber);
	  			}
	  		}
	  	return res;
		   		
	      }
 
	 public static String IPMSUploadBase64N(String RequestNumber,String filename) {
	    	final String queueName = "IPMS.DocUpload1";
		//	logger.info("queueName :: "+queueName);
	    	ResourceBundle bunlde = ResourceBundle.getBundle("serverConfig");
	      String res="";
	      ConnectionFactory connectionFactory =null;
	  	Connection connection = null;
	  	
			// \"\":\"\"++\"\"
	  	 DataHandler s = null;
	  	InputStream in = null;
	      try { 
	    	   
	  		String url = bunlde.getString("consumerip")+filename;
	  		//return buf.toString("UTF-8");
	  		activemqcall = new ActiveMQCall();
	  		String correlationId = activemqcall.createRandomString();

	  		 String jsonString ="{\"filename\":\""+filename+"\",\"fileurl\":\""+url+"\",\"ReferenceID\":\""+correlationId+"\"}";
	  	//		logger.info("jsonString of SFDC param :: "+jsonString); 
	  			System.out.println(jsonString);

	  			
	  			// \"\":\"\"++\"\"
	  			 connectionFactory = new ActiveMQConnectionFactory("admin", "KCMT7g4G6BUQ",
	  					"tcp://34.231.101.144:61616?wireFormat.maxInactivityDuration=0");
	  			System.out.println(connectionFactory + " :: " + "connected to activemq server");
	  			 connection = connectionFactory.createConnection();
	  			connection.start();
	  			//Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	  			ActiveMQSession session = (ActiveMQSession) connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
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
//	  			DataHandler h = url.getBase64Binary();
//	  			ObjectMessage bm = session.createObjectMessage();
//	  			bm.set
//	  			DataHandler h = b.getBase64Binary();
//	  			BlobMessage message =session.createBlobMessage(h.getInputStream());
//	  			message.setName(filename);
	  			TextMessage message = session.createTextMessage();
	  			
	  			message.setText(jsonString);
	  			message.setJMSReplyTo(tempDest);
	  			System.out.println("1 :: " + correlationId);
	  			message.setJMSCorrelationID(correlationId);
	  			System.out.println("success");
	  			producer.send(message);
	  			TextMessage objTextMsg = (TextMessage) responseConsumer.receive();
	  			System.out.println("message :: " + objTextMsg.getText());
	  			logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Message :: "+objTextMsg.getText() + " Message Id :: " +RequestNumber);
	  			// System.out.println("success");
	  			
	  			while (true) {
	  				if (objTextMsg.getText() != null) {
	  					System.out.println("message if :: " + objTextMsg);
	  					res = objTextMsg.getText();
	  					File doc = new File(bunlde.getString("consumertemploc")+filename);
	  					if(doc.exists()) {
	  						doc.delete();
	  					}
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
	  			logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Last Error :: "+e.getMessage() + " Message Id :: " +RequestNumber);
	  			res = e.getMessage();
	  		}finally {
	  			try {
	  				connection.close();
	  				s = null;
	  				in.close();
	  			} catch (Exception e) {
	  				// TODO Auto-generated catch block
	  				logger.info("FtpClientIPMS :: IPMSUploadBase64 :: Finally Error :: "+e.getMessage() + " Message Id :: " +RequestNumber);
	  			}
	  		}
	  	return res;
		   		
	      }
	 


}
