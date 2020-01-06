package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws;

public class XXDC_SFDC_REGISTRATION_WS_PortTypeProxy implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_PortType {
  private String _endpoint = null;
  private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_PortType xXDC_SFDC_REGISTRATION_WS_PortType = null;
  
  public XXDC_SFDC_REGISTRATION_WS_PortTypeProxy() {
    _initXXDC_SFDC_REGISTRATION_WS_PortTypeProxy();
  }
  
  public XXDC_SFDC_REGISTRATION_WS_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initXXDC_SFDC_REGISTRATION_WS_PortTypeProxy();
  }
  
  private void _initXXDC_SFDC_REGISTRATION_WS_PortTypeProxy() {
    try {
      xXDC_SFDC_REGISTRATION_WS_PortType = (new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_ServiceLocator()).getXXDC_SFDC_REGISTRATION_WS_Port();
      if (xXDC_SFDC_REGISTRATION_WS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)xXDC_SFDC_REGISTRATION_WS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)xXDC_SFDC_REGISTRATION_WS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (xXDC_SFDC_REGISTRATION_WS_PortType != null)
      ((javax.xml.rpc.Stub)xXDC_SFDC_REGISTRATION_WS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.XXDC_SFDC_REGISTRATION_WS_PortType getXXDC_SFDC_REGISTRATION_WS_PortType() {
    if (xXDC_SFDC_REGISTRATION_WS_PortType == null)
      _initXXDC_SFDC_REGISTRATION_WS_PortTypeProxy();
    return xXDC_SFDC_REGISTRATION_WS_PortType;
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking.OutputParameters CREATE_BOOKING(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_SFDC_REGISTRATION_WS_PortType == null)
      _initXXDC_SFDC_REGISTRATION_WS_PortTypeProxy();
    return xXDC_SFDC_REGISTRATION_WS_PortType.CREATE_BOOKING(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.customer_creation.OutputParameters CUSTOMER_CREATION(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.customer_creation.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_SFDC_REGISTRATION_WS_PortType == null)
      _initXXDC_SFDC_REGISTRATION_WS_PortTypeProxy();
    return xXDC_SFDC_REGISTRATION_WS_PortType.CUSTOMER_CREATION(header, body);
  }
  
  
}