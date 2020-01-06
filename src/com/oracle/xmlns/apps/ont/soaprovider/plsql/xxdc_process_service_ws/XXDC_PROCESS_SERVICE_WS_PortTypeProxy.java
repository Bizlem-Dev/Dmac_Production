package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws;

public class XXDC_PROCESS_SERVICE_WS_PortTypeProxy implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType {
  private String _endpoint = null;
  private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType xXDC_PROCESS_SERVICE_WS_PortType = null;
  
  public XXDC_PROCESS_SERVICE_WS_PortTypeProxy() {
    _initXXDC_PROCESS_SERVICE_WS_PortTypeProxy();
  }
  
  public XXDC_PROCESS_SERVICE_WS_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initXXDC_PROCESS_SERVICE_WS_PortTypeProxy();
  }
  
  private void _initXXDC_PROCESS_SERVICE_WS_PortTypeProxy() {
    try {
      xXDC_PROCESS_SERVICE_WS_PortType = (new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_ServiceLocator()).getXXDC_PROCESS_SERVICE_WS_Port();
      if (xXDC_PROCESS_SERVICE_WS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)xXDC_PROCESS_SERVICE_WS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)xXDC_PROCESS_SERVICE_WS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (xXDC_PROCESS_SERVICE_WS_PortType != null)
      ((javax.xml.rpc.Stub)xXDC_PROCESS_SERVICE_WS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.XXDC_PROCESS_SERVICE_WS_PortType getXXDC_PROCESS_SERVICE_WS_PortType() {
    if (xXDC_PROCESS_SERVICE_WS_PortType == null)
      _initXXDC_PROCESS_SERVICE_WS_PortTypeProxy();
    return xXDC_PROCESS_SERVICE_WS_PortType;
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters PROCESS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_PROCESS_SERVICE_WS_PortType == null)
      _initXXDC_PROCESS_SERVICE_WS_PortTypeProxy();
    return xXDC_PROCESS_SERVICE_WS_PortType.PROCESS(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters RETRIEVE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_PROCESS_SERVICE_WS_PortType == null)
      _initXXDC_PROCESS_SERVICE_WS_PortTypeProxy();
    return xXDC_PROCESS_SERVICE_WS_PortType.RETRIEVE(header, body);
  }
  
  
}