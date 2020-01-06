package com.action;

import org.apache.log4j.Logger;

import com.activeMQ.ActiveMQCall;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SERX1794747X2X4;
import com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56;

import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONObject;

public class UnitDetails {
	final static Logger logger = Logger.getLogger(UnitDetails.class);
	public String getUnitDetailValues(String RegistrationId)
	{
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		System.out.println("in method");
				String res = "";
				final String queueName = "IPMS.GETUNITDETAILSUAT";
				// "SRNumber":""+SRNumber+"",
				String jsonString = "{\"RegistrationId\":\""+RegistrationId+"\"}";
					activemqcall = new ActiveMQCall();
				 String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
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
						idAttr1 = "REGISTRATION";
					}
					System.out.println("id "+id);
					System.out.println("idATTR1 "+idAttr1);
					XXDC_PROCESS_SERVICE_WS_ServiceLocator service = new XXDC_PROCESS_SERVICE_WS_ServiceLocator();
					XXDC_PROCESS_SERVICE_WS_PortType port = service.getXXDC_PROCESS_SERVICE_WS_Port();

					SOAHeader header = new SOAHeader();

					com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters();
					body.setP_REQUEST_NUMBER(correlationId);
					body.setP_REQUEST_NAME("GET_360_CUST_DETAILS");
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
					String blank = "";
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
						 //res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\",\"ATTRIBUTE24\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24()+"\",\"ATTRIBUTE25\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25()+"\",\"ATTRIBUTE26\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26()+"\",\"ATTRIBUTE27\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27()+"\",\"ATTRIBUTE28\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28()+"\",\"ATTRIBUTE29\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE29()+"\",\"ATTRIBUTE30\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30()+"\",\"ATTRIBUTE31\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31()+"\",\"ATTRIBUTE32\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32()+"\",\"ATTRIBUTE33\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33()+"\",\"ATTRIBUTE34\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34()+"\",\"ATTRIBUTE35\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE35()+"\",\"ATTRIBUTE36\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE36()+"\",\"ATTRIBUTE37\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE37()+"\",\"ATTRIBUTE38\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE38()+"\",\"ATTRIBUTE39\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE39()+"\",\"ATTRIBUTE40\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE40()+"\""
						JSONObject obj6 = new JSONObject(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6());
						JSONObject obj7 = new JSONObject(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7());
						JSONObject obj8 = new JSONObject(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8());
						JSONObject obj9 = new JSONObject(objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
						logger.info("UnitDetails :: URN :: "+correlationId + " RegistrationId/PartyId "+" Attribute6 :: "+ objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6() +" Attribute7 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+" Attribute8 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8() + " Attribute9 :: "+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9());
								 res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+blank+"\",\"ATTRIBUTE3\":\""+obj8.getString("AgStatus")+"\",\"ATTRIBUTE4\":\""+obj8.getString("Bulk")+"\",\"ATTRIBUTE5\":\""+obj8.getString("AreaVar")+"\",\"ATTRIBUTE6\":\""+obj7.getString("TypeVari")+"\",\"ATTRIBUTE7\":\""+obj8.getString("Recovery")+"\",\"ATTRIBUTE8\":\""+obj9.getString("AmountPaid")+"\",\"ATTRIBUTE9\":\""+obj9.getString("AmountPaid")+"\",\"ATTRIBUTE10\":\""+obj9.getString("TotOutstanding")+"\",\"ATTRIBUTE11\":\""+obj9.getString("OverDue")+"\",\"ATTRIBUTE12\":\""+obj8.getString("Default")+"\",\"ATTRIBUTE13\":\""+obj8.getString("HoFlag")+"\",\"ATTRIBUTE14\":\""+obj8.getString("EhoFlag")+"\",\"ATTRIBUTE15\":\""+obj6.getString("POA")+"\",\"ATTRIBUTE16\":\""+obj8.getString("UndTerminat")+"\",\"ATTRIBUTE17\":\""+obj8.getString("RentalPool")+"\",\"ATTRIBUTE18\":\""+obj6.getString("PortfolioValue")+"\",\"ATTRIBUTE19\":\""+obj9.getString("PdcCoverage")+"\",\"ATTRIBUTE20\":\""+obj8.getString("ReraPercent")+"\",\"ATTRIBUTE21\":\""+obj7.getString("NoOfParking")+"\",\"ATTRIBUTE22\":\""+obj8.getString("SpaSigned")+"\",\"ATTRIBUTE23\":\""+obj9.getString("PenaltyCharged")+"\",\"ATTRIBUTE24\":\""+obj9.getString("PrevWaive")+"\",\"ATTRIBUTE25\":\""+obj9.getString("PenaltyRemaining")+"\",\"ATTRIBUTE26\":\""+obj6.getString("CustClass")+"\",\"ATTRIBUTE27\":\""+obj8.getString("Bcc")+"\",\"ATTRIBUTE28\":\""+obj8.getString("FTLSent")+"\",\"ATTRIBUTE29\":\""+obj7.getString("ReadyOffplan")+"\",\"ATTRIBUTE30\":\""+obj9.getString("Pcc")+"\",\"ATTRIBUTE31\":\""+obj7.getString("CourtCase")+"\",\"ATTRIBUTE32\":\""+blank+"\",\"ATTRIBUTE33\":\""+obj8.getString("DiffWithOrigACD")+"\",\"ATTRIBUTE34\":\""+obj9.getString("ServChargePaid")+"\",\"ATTRIBUTE35\":\""+obj9.getString("OtherCharges")+"\",\"ATTRIBUTE36\":\""+blank+"\",\"ATTRIBUTE37\":\""+blank+"\",\"ATTRIBUTE38\":\""+blank+"\",\"ATTRIBUTE39\":\""+obj8.getString("BookDate")+"\",\"ATTRIBUTE40\":\""+obj8.getString("UnitName")+"\""
								 +",\"ATTRIBUTE41\":\""+obj9.getString("InvoicesRaised")+"\""
								 +",\"ATTRIBUTE42\":\""+obj9.getString("Penalties")+"\""
								 +",\"ATTRIBUTE43\":\""+obj9.getString("OverDue")+"\""
								 +",\"ATTRIBUTE44\":\""+obj9.getString("BuiltUpPrice")+"\""
								 +",\"ATTRIBUTE45\":\""+obj7.getString("Dispute")+"\""
								 +",\"ATTRIBUTE46\":\""+obj7.getString("Enforcement")+"\""
								 +",\"ATTRIBUTE47\":\""+obj7.getString("Litigation")+"\""
								 +",\"ATTRIBUTE48\":\""+obj7.getString("CourtCase")+"\""
								 +",\"ATTRIBUTE49\":\""+obj9.getString("RegFeesPaidYN")+"\""
								 +",\"ATTRIBUTE50\":\""+obj8.getString("PrcSta")+"\""
								 +",\"ATTRIBUTE51\":\""+obj8.getString("AgStatusDe")+"\""
								 +",\"ATTRIBUTE52\":\""+obj8.getString("PercentComplete")+"\""
								 +",\"ATTRIBUTE53\":\""+obj8.getString("ReraPercent")+"\""
								 +",\"ATTRIBUTE54\":\""+obj8.getString("OrigACD")+"\""
								 +",\"ATTRIBUTE55\":\""+obj8.getString("CurrentACD")+"\""
								 +",\"ATTRIBUTE56\":\""+obj8.getString("AreaVar")+"\""
								 +",\"ATTRIBUTE57\":\""+obj9.getString("AreaVarVal")+"\""
								 +",\"ATTRIBUTE58\":\""+obj9.getString("OtherCharges")+"\""
								 +",\"ATTRIBUTE59\":\""+obj9.getString("PaidPC")+"\""
								 +",\"ATTRIBUTE60\":\""+obj9.getString("OverDuePer")+"\""
								 +",\"ATTRIBUTE61\":\""+obj9.getString("PdcCoverage")+"\""
								 +",\"ATTRIBUTE62\":\""+obj9.getString("TimesDefaulted")+"\""
								 +",\"ATTRIBUTE63\":\""+obj8.getString("Recovery")+"\""
								 +",\"ATTRIBUTE64\":\""+blank+"\""
								 +",\"ATTRIBUTE65\":\""+obj9.getString("PccEho")+"\""
								 +",\"ATTRIBUTE66\":\""+obj9.getString("FmPcc")+"\""
								 +",\"ATTRIBUTE67\":\""+obj8.getString("Bcc")+"\""
								 +",\"ATTRIBUTE68\":\""+obj9.getString("TotOutstanding")+"\""
								 +",\"ATTRIBUTE69\":\""+obj8.getString("Default")+"\""
								 +",\"ATTRIBUTE70\":\""+blank+"\""
								 +",\"ATTRIBUTE71\":\""+blank+"\""
								 +",\"ATTRIBUTE72\":\""+obj7.getString("NoOfParking")+"\""
								 +",\"ATTRIBUTE73\":\""+obj7.getString("BayNo")+"\""
								 +",\"ATTRIBUTE74\":\""+obj7.getString("TypeOfParking")+"\""
								 +",\"ATTRIBUTE75\":\""+obj9.getString("FMOverDues")+"\""
								 +",\"ATTRIBUTE76\":\""+obj9.getString("PenaltyOnServ")+"\""
								 +",\"ATTRIBUTE77\":\""+obj9.getString("lastPDCOn")+"\""
								 +",\"ATTRIBUTE78\":\""+obj9.getString("BTP")+"\""
								 +",\"ATTRIBUTE79\":\""+blank+"\""
								 +",\"ATTRIBUTE80\":\""+obj7.getString("MinPCEho")+"\""
								 +",\"ATTRIBUTE81\":\""+blank+"\""
								 +",\"ATTRIBUTE82\":\""+obj8.getString("ConStatusDe")+"\""
								 +",\"ATTRIBUTE83\":\""+obj7.getString("SellerName")+"\""
								 +",\"ATTRIBUTE84\":\""+obj8.getString("UrcSigned")+"\""
								 +",\"ATTRIBUTE85\":\""+obj8.getString("psf")+"\""
								 +",\"ATTRIBUTE86\":\""+obj9.getString("PdcCoverageVal")+"\""
								 +",\"ATTRIBUTE87\":\""+obj9.getString("TotalCoverage")+"\""
								 +",\"ATTRIBUTE88\":\""+obj9.getString("TotalCoverageVal")+"\""
								 +",\"ATTRIBUTE89\":\""+obj8.getString("DaysToACD")+"\""
								 +",\"ATTRIBUTE90\":\""+obj7.getString("BuildingCode")+"\""
								 +",\"ATTRIBUTE91\":\""+obj7.getString("Building")+"\""
								 +",\"ATTRIBUTE92\":\""+obj8.getString("RpStart")+"\""
								 +",\"ATTRIBUTE93\":\""+obj8.getString("RpEnd")+"\""
								 +",\"ATTRIBUTE94\":\""+obj6.getString("PartyId")+"\""
								 +",\"ATTRIBUTE95\":\""+obj8.getString("Jb")+"\""
								 +",\"ATTRIBUTE96\":\""+obj8.getString("Area")+"\""
								 +",\"ATTRIBUTE97\":\""+obj8.getString("BookingType")+"\""
								 +",\"ATTRIBUTE98\":\""+obj8.getString("AgrDate")+"\""
								 +",\"ATTRIBUTE99\":\""+obj7.getString("Type")+"\""
								 +",\"ATTRIBUTE100\":\""+obj8.getString("JopdArea")+"\""
								 +",\"ATTRIBUTE101\":\""+obj8.getString("DpOk")+"\""
								 +",\"ATTRIBUTE102\":\""+obj9.getString("UnitPrice")+"\""
								 +",\"ATTRIBUTE103\":\""+obj8.getString("DocOk")+"\""
								 +",\"ATTRIBUTE104\":\""+obj8.getString("OqoodReg")+"\""
								 +",\"ATTRIBUTE105\":\""+obj9.getString("PlotPrice")+"\""
								 +",\"ATTRIBUTE106\":\""+obj8.getString("BookDate")+"\""
								 +",\"ATTRIBUTE107\":\""+obj7.getString("Conservation")+"\""
								 +",\"ATTRIBUTE108\":\""+obj7.getString("Project")+"\""
								 +",\"ATTRIBUTE109\":\""+obj7.getString("ProjCity")+"\""
								 +",\"ATTRIBUTE110\":\""+obj7.getString("UnitType")+"\""
								 +",\"ATTRIBUTE111\":\""+obj7.getString("PermittedUse")+"\""
								 +",\"ATTRIBUTE112\":\""+blank+"\""
								 +",\"ATTRIBUTE113\":\""+blank+"\""
								 +",\"ATTRIBUTE114\":\""+blank+"\""
								 +",\"ATTRIBUTE115\":\""+blank+"\""
								 +",\"ATTRIBUTE116\":\""+blank+"\""
								 +",\"ATTRIBUTE117\":\""+blank+"\""
								 +",\"ATTRIBUTE118\":\""+blank+"\""
								 +",\"ATTRIBUTE119\":\""+blank+"\""
								 +",\"ATTRIBUTE120\":\""+blank+"\""

						 		+ "}";
arr.put(res);
					
					
									}
					String response = activemqcall.GetConsumer(queueName);
					System.out.println("3 4:: " + response);
					/*
					 * Thread t1 = new Thread(new Runnable() { public void run() { String response =
					 * activemqcall.GetConsumer(queueName); System.out.println("3 4:: "+response); }
					 * }); t1.start();
					 */
					System.out.print("res   "+arr.toString());
					return arr.toString();

				} catch (Exception e) {
					return "{\"status\":\"E\",\"message\":\""+e.getMessage()+"\"}";

				}
	}

	
/*	public String getUnitDetailValues(String RegistrationId)
	{
		ActiveMQCall activemqcall = null;
	//retrive
		//   getRuleEngineValues?P_REQUEST_NUMBER=&P_REQUEST_NAME=GET_RULE_ATTRIBUTES&P_SOURCE_SYSTEM=SFDC&RegistrationId=
		System.out.println("in method");
				String res = "";
				final String queueName = "IPMS.GETUNITDETAILS";
				// "SRNumber":""+SRNumber+"",
				String jsonString = "{\"RegistrationId\":\""+RegistrationId+"\"}";
					activemqcall = new ActiveMQCall();
				 String correlationId = activemqcall.createRandomString();
				//String correlationId = P_REQUEST_NUMBER;

				//System.out.println("1 :: " + correlationId);
				correlationId = activemqcall.GetProducer(queueName, RegistrationId, correlationId, jsonString);
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
						idAttr1 = "REGISTRATION";
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
					String blank = "";
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
						 //res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE2()+"\",\"ATTRIBUTE3\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE4()+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE15()+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\",\"ATTRIBUTE24\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24()+"\",\"ATTRIBUTE25\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25()+"\",\"ATTRIBUTE26\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26()+"\",\"ATTRIBUTE27\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27()+"\",\"ATTRIBUTE28\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28()+"\",\"ATTRIBUTE29\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE29()+"\",\"ATTRIBUTE30\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30()+"\",\"ATTRIBUTE31\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31()+"\",\"ATTRIBUTE32\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32()+"\",\"ATTRIBUTE33\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33()+"\",\"ATTRIBUTE34\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34()+"\",\"ATTRIBUTE35\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE35()+"\",\"ATTRIBUTE36\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE36()+"\",\"ATTRIBUTE37\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE37()+"\",\"ATTRIBUTE38\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE38()+"\",\"ATTRIBUTE39\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE39()+"\",\"ATTRIBUTE40\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE40()+"\""
						/*		 res="{\"ATTRIBUTE1\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE1()+"\",\"ATTRIBUTE2\":\""+blank+"\",\"ATTRIBUTE3\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE3()+"\",\"ATTRIBUTE4\":\""+blank+"\",\"ATTRIBUTE5\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE5()+"\",\"ATTRIBUTE6\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE6()+"\",\"ATTRIBUTE7\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE7()+"\",\"ATTRIBUTE8\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE8()+"\",\"ATTRIBUTE9\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE9()+"\",\"ATTRIBUTE10\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE10()+"\",\"ATTRIBUTE11\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE11()+"\",\"ATTRIBUTE12\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE12()+"\",\"ATTRIBUTE13\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE13()+"\",\"ATTRIBUTE14\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE14()+"\",\"ATTRIBUTE15\":\""+blank+"\",\"ATTRIBUTE16\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE16()+"\",\"ATTRIBUTE17\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE17()+"\",\"ATTRIBUTE18\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE18()+"\",\"ATTRIBUTE19\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE19()+"\",\"ATTRIBUTE20\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE20()+"\",\"ATTRIBUTE21\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE21()+"\",\"ATTRIBUTE22\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE22()+"\",\"ATTRIBUTE23\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE23()+"\",\"ATTRIBUTE24\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE24()+"\",\"ATTRIBUTE25\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE25()+"\",\"ATTRIBUTE26\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE26()+"\",\"ATTRIBUTE27\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE27()+"\",\"ATTRIBUTE28\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE28()+"\",\"ATTRIBUTE29\":\""+blank+"\",\"ATTRIBUTE30\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE30()+"\",\"ATTRIBUTE31\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE31()+"\",\"ATTRIBUTE32\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE32()+"\",\"ATTRIBUTE33\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE33()+"\",\"ATTRIBUTE34\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE34()+"\",\"ATTRIBUTE35\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE35()+"\",\"ATTRIBUTE36\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE36()+"\",\"ATTRIBUTE37\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE37()+"\",\"ATTRIBUTE38\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE38()+"\",\"ATTRIBUTE39\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE39()+"\",\"ATTRIBUTE40\":\""+objAPPSXXDC_PROCESS_SEX1794747X2X56[i].getATTRIBUTE40()+"\""
								 +",\"ATTRIBUTE41\":\""+blank+"\""
								 +",\"ATTRIBUTE42\":\""+blank+"\""
								 +",\"ATTRIBUTE43\":\""+blank+"\""
								 +",\"ATTRIBUTE44\":\""+blank+"\""
								 +",\"ATTRIBUTE45\":\""+blank+"\""
								 +",\"ATTRIBUTE46\":\""+blank+"\""
								 +",\"ATTRIBUTE47\":\""+blank+"\""
								 +",\"ATTRIBUTE48\":\""+blank+"\""
								 +",\"ATTRIBUTE49\":\""+blank+"\""
								 +",\"ATTRIBUTE50\":\""+blank+"\""
								 +",\"ATTRIBUTE51\":\""+blank+"\""
								 +",\"ATTRIBUTE52\":\""+blank+"\""
								 +",\"ATTRIBUTE53\":\""+blank+"\""
								 +",\"ATTRIBUTE54\":\""+blank+"\""
								 +",\"ATTRIBUTE55\":\""+blank+"\""
								 +",\"ATTRIBUTE56\":\""+blank+"\""
								 +",\"ATTRIBUTE57\":\""+blank+"\""
								 +",\"ATTRIBUTE58\":\""+blank+"\""
								 +",\"ATTRIBUTE59\":\""+blank+"\""
								 +",\"ATTRIBUTE60\":\""+blank+"\""
								 +",\"ATTRIBUTE61\":\""+blank+"\""
								 +",\"ATTRIBUTE62\":\""+blank+"\""
								 +",\"ATTRIBUTE63\":\""+blank+"\""
								 +",\"ATTRIBUTE64\":\""+blank+"\""
								 +",\"ATTRIBUTE65\":\""+blank+"\""
								 +",\"ATTRIBUTE66\":\""+blank+"\""
								 +",\"ATTRIBUTE67\":\""+blank+"\""
								 +",\"ATTRIBUTE68\":\""+blank+"\""
								 +",\"ATTRIBUTE69\":\""+blank+"\""
								 +",\"ATTRIBUTE70\":\""+blank+"\""
								 +",\"ATTRIBUTE71\":\""+blank+"\""
								 +",\"ATTRIBUTE72\":\""+blank+"\""
								 +",\"ATTRIBUTE73\":\""+blank+"\""
								 +",\"ATTRIBUTE74\":\""+blank+"\""
								 +",\"ATTRIBUTE75\":\""+blank+"\""
								 +",\"ATTRIBUTE76\":\""+blank+"\""
								 +",\"ATTRIBUTE77\":\""+blank+"\""
								 +",\"ATTRIBUTE78\":\""+blank+"\""
								 +",\"ATTRIBUTE79\":\""+blank+"\""
								 +",\"ATTRIBUTE80\":\""+blank+"\""
								 +",\"ATTRIBUTE81\":\""+blank+"\""
								 +",\"ATTRIBUTE82\":\""+blank+"\""
								 +",\"ATTRIBUTE83\":\""+blank+"\""
								 +",\"ATTRIBUTE84\":\""+blank+"\""
								 +",\"ATTRIBUTE85\":\""+blank+"\""
								 +",\"ATTRIBUTE86\":\""+blank+"\""
								 +",\"ATTRIBUTE87\":\""+blank+"\""
								 +",\"ATTRIBUTE88\":\""+blank+"\""
								 +",\"ATTRIBUTE89\":\""+blank+"\""
								 +",\"ATTRIBUTE90\":\""+blank+"\""
								 +",\"ATTRIBUTE91\":\""+blank+"\""
								 +",\"ATTRIBUTE92\":\""+blank+"\""
								 +",\"ATTRIBUTE93\":\""+blank+"\""
								 +",\"ATTRIBUTE94\":\""+blank+"\""
								 +",\"ATTRIBUTE95\":\""+blank+"\""
								 +",\"ATTRIBUTE96\":\""+blank+"\""
								 +",\"ATTRIBUTE97\":\""+blank+"\""
								 +",\"ATTRIBUTE98\":\""+blank+"\""
								 +",\"ATTRIBUTE99\":\""+blank+"\""
								 +",\"ATTRIBUTE100\":\""+blank+"\""
								 +",\"ATTRIBUTE101\":\""+blank+"\""
								 +",\"ATTRIBUTE102\":\""+blank+"\""
								 +",\"ATTRIBUTE103\":\""+blank+"\""
								 +",\"ATTRIBUTE104\":\""+blank+"\""
								 +",\"ATTRIBUTE105\":\""+blank+"\""
								 +",\"ATTRIBUTE106\":\""+blank+"\""
								 +",\"ATTRIBUTE107\":\""+blank+"\""
								 +",\"ATTRIBUTE108\":\""+blank+"\""
								 +",\"ATTRIBUTE109\":\""+blank+"\""
								 +",\"ATTRIBUTE110\":\""+blank+"\""
								 +",\"ATTRIBUTE111\":\""+blank+"\""
								 +",\"ATTRIBUTE112\":\""+blank+"\""
								 +",\"ATTRIBUTE113\":\""+blank+"\""
								 +",\"ATTRIBUTE114\":\""+blank+"\""
								 +",\"ATTRIBUTE115\":\""+blank+"\""
								 +",\"ATTRIBUTE116\":\""+blank+"\""
								 +",\"ATTRIBUTE117\":\""+blank+"\""
								 +",\"ATTRIBUTE118\":\""+blank+"\""
								 +",\"ATTRIBUTE119\":\""+blank+"\""
								 +",\"ATTRIBUTE120\":\""+blank+"\""

						 		+ "}";
arr.put(res);
					
					
									}
					System.out.print("res   "+arr.toString());
					return arr.toString();

				} catch (Exception e) {
					return e.getMessage();

				}
	}
*/
	
	
}
