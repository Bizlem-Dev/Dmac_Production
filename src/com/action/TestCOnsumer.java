package com.action;

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

import org.apache.activemq.ActiveMQConnectionFactory;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;

import gvjava.org.json.JSONArray;

public class TestCOnsumer {
	private static final long serialVersionUID = 1L;
	 private static MessageProducer replyProducer;
	 private static Connection connection = null;
	 private static Session session;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
			
			// TODO Auto-generated method stub
			// Getting JMS connection from the server and starting it
			ConnectionFactory connectionFactory  = new ActiveMQConnectionFactory("admin","KCMT7g4G6BUQ","tcp://34.235.40.111:61616?wireFormat.maxInactivityDuration=0");
			 connection = connectionFactory.createConnection();
			connection.start();
			// JMS messages are sent and received using a Session. We will
			// create here a non-transactional session object. If you want
			// to use transactions you should set the first parameter to 'true'
			 session = connection.createSession(false,
			Session.AUTO_ACKNOWLEDGE);
			// Destination represents here our queue 'VALLYSOFTQ' on the
			// JMS server. You don't have to do anything special on the
			// server to create it, it will be created automatically.
			   Destination destination = session.createQueue("IPMS.RulesUAT");
			// MessageConsumer is used for receiving (consuming) messages
			MessageConsumer consumer = session.createConsumer(destination);
			System.out.println("Consumer1234");
			
			//Setup a message producer to respond to messages from clients, we will get the destination
            //to send to from the JMSReplyTo header field from a Message
            replyProducer = session.createProducer(null);
            replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			// Listen for arriving messages 
			MessageListener listener = new MessageListener() { 
			

			@Override
			public void onMessage(Message message) {
				try {
				TextMessage response = session.createTextMessage();
				// TODO Auto-generated method stub
				System.out.println("Message");
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					// tbd parsing of json
									
						System.out.println("Receivedage '" + textMessage.getText()+ "'");
						
						
						System.out.println("JMSReply '" + textMessage.getJMSReplyTo()+ "'");
						System.out.println("JMSCore '" + textMessage.getJMSCorrelationID()+ "'");
						//String res = getRuleEngineValues(textMessage.getText(),textMessage.getJMSCorrelationID());
						//response.setText(res);
						//System.out.println(res);
						//response.setJMSReplyTo(textMessage.getJMSReplyTo());
						response.setJMSCorrelationID(textMessage.getJMSCorrelationID());
						replyProducer.send(textMessage.getJMSReplyTo(),response);
						// method call
						
						
						
	

					}
			    }
				 catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.print("error message :: "+e.getMessage());
					}
			} 
			};
			consumer.setMessageListener(listener);
			//connection.close();
			//session.close();
			}catch(Exception e){
				System.out.print("error :: "+e.getMessage());
			}

	}
	
	public String getRuleEngineValues(String RegistrationId, String correlationId)
	{
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		System.out.println("in method");
				String res = "";
				final String queueName = "IPMS.Rules";
				// "SRNumber":""+SRNumber+"",
				//String jsonString = "{\"RegistrationId\":\""+RegistrationId+"\"}";
				//	activemqcall = new ActiveMQCall();
				// String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				//correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
				//System.out.println("2 :: " + correlationId);
				// TextMessage textMessage = new
				String id = "";
				String idAttr1 = "";
				try {
					if(RegistrationId.indexOf("_") != -1) {
						id = RegistrationId.split("_")[0];
						idAttr1 = RegistrationId.split("_")[1];
					}else {
						id = RegistrationId;
						idAttr1 = "Registration";
					}
					System.out.println("id "+id);
					System.out.println("idATTR1 "+idAttr1);
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_RULE_ATTRIBUTES");
					body.setP_SOURCE_SYSTEM("SFDC");

					APPSXXDC_PROCESS_SERX1794747X2X4 objX4 = new APPSXXDC_PROCESS_SERX1794747X2X4();
					objX4.setPARAM_ID(id);
					objX4.setATTRIBUTE1(idAttr1);
					body.setP_REQUEST_MESSAGE(objX4);
					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters param = port
							.RETRIEVE(header, body);

					System.out.println(param.getX_RETURN_MESSAGE());
					System.out.println(param.getX_RETURN_STATUS());
					System.out.println(param.getX_RESPONSE_MESSAGE());
					APPSXXDC_PROCESS_SEX1794747X2X56[] objAPPSXXDC_PROCESS_SEX1794747X2X56 = param.getX_RESPONSE_MESSAGE();
					JSONArray arr = new JSONArray();
					for (int i = 0; i < objAPPSXXDC_PROCESS_SEX1794747X2X56.length; i++) {
						System.out.println("inside for");
						/*System.out.println("ATTRIBUTE1 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1());
						System.out.println("ATTRIBUTE2 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2());
						System.out.println("ATTRIBUTE3 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3());
						System.out.println("ATTRIBUTE4 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4());
						System.out.println("ATTRIBUTE5 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5());
						System.out.println("ATTRIBUTE6 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
						System.out.println("ATTRIBUTE7 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
						System.out.println("ATTRIBUTE8 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
						System.out.println("ATTRIBUTE9 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
						System.out.println("ATTRIBUTE10 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10());
						System.out.println("ATTRIBUTE11 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11());
						System.out.println("ATTRIBUTE12 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12());
						System.out.println("ATTRIBUTE13 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13());
						System.out.println("ATTRIBUTE14 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14());
						System.out.println("ATTRIBUTE15 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15());
						System.out.println("ATTRIBUTE16 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16());
						System.out.println("ATTRIBUTE17 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17());
						System.out.println("ATTRIBUTE18 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18());
						System.out.println("ATTRIBUTE19 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19());
						System.out.println("ATTRIBUTE20 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20());
						System.out.println("ATTRIBUTE21 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21());
						System.out.println("ATTRIBUTE22 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22());
						System.out.println("ATTRIBUTE23 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23());
						System.out.println("ATTRIBUTE24 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24());
						System.out.println("ATTRIBUTE25 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25());
						System.out.println("ATTRIBUTE26 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26());
						System.out.println("ATTRIBUTE27 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27());
						System.out.println("ATTRIBUTE28 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28());
						System.out.println("ATTRIBUTE29 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE29());
						System.out.println("ATTRIBUTE30 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30());
						System.out.println("ATTRIBUTE31 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31());
						System.out.println("ATTRIBUTE32 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32());
						System.out.println("ATTRIBUTE33 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33());
						System.out.println("ATTRIBUTE34 Response :: " + objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34());*/
						 res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\",\"ATTRIBUTE24\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24()+"\",\"ATTRIBUTE25\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25()+"\",\"ATTRIBUTE26\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26()+"\",\"ATTRIBUTE27\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27()+"\",\"ATTRIBUTE28\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28()+"\",\"ATTRIBUTE29\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE29()+"\",\"ATTRIBUTE30\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30()+"\",\"ATTRIBUTE31\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31()+"\",\"ATTRIBUTE32\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32()+"\",\"ATTRIBUTE33\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33()+"\",\"ATTRIBUTE34\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34()+"\",\"ATTRIBUTE35\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE35()+"\",\"ATTRIBUTE36\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE36()+"\",\"ATTRIBUTE37\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE37()+"\",\"ATTRIBUTE38\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE38()+"\",\"ATTRIBUTE39\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE39()+"\",\"ATTRIBUTE40\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE40()+"\"}";
arr.put(res);
					
					
									}
				//	String response = activemqcall.GetConsumer(queueName);
				//	System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
					System.out.print("res   "+arr.toString());
					return arr.toString();

				} catch (Exception e) {
					return e.getMessage();

				}
	}


}
