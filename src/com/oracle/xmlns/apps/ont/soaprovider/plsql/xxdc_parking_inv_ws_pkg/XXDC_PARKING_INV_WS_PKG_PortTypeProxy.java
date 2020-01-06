package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg;

public class XXDC_PARKING_INV_WS_PKG_PortTypeProxy implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType {
  private String _endpoint = null;
  private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType xXDC_PARKING_INV_WS_PKG_PortType = null;
  
  public XXDC_PARKING_INV_WS_PKG_PortTypeProxy() {
    _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy();
  }
  
  public XXDC_PARKING_INV_WS_PKG_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy();
  }
  
  private void _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy() {
    try {
      xXDC_PARKING_INV_WS_PKG_PortType = (new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_ServiceLocator()).getXXDC_PARKING_INV_WS_PKG_Port();
      if (xXDC_PARKING_INV_WS_PKG_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)xXDC_PARKING_INV_WS_PKG_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)xXDC_PARKING_INV_WS_PKG_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (xXDC_PARKING_INV_WS_PKG_PortType != null)
      ((javax.xml.rpc.Stub)xXDC_PARKING_INV_WS_PKG_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType getXXDC_PARKING_INV_WS_PKG_PortType() {
    if (xXDC_PARKING_INV_WS_PKG_PortType == null)
      _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy();
    return xXDC_PARKING_INV_WS_PKG_PortType;
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.OutputParameters PARKING_INV_PROCESS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_PARKING_INV_WS_PKG_PortType == null)
      _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy();
    return xXDC_PARKING_INV_WS_PKG_PortType.PARKING_INV_PROCESS(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.OutputParameters PARKING_PAYMENT_TERMS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_PARKING_INV_WS_PKG_PortType == null)
      _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy();
    return xXDC_PARKING_INV_WS_PKG_PortType.PARKING_PAYMENT_TERMS(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.OutputParameters XXDC_ADD_PARKING(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_PARKING_INV_WS_PKG_PortType == null)
      _initXXDC_PARKING_INV_WS_PKG_PortTypeProxy();
    return xXDC_PARKING_INV_WS_PKG_PortType.XXDC_ADD_PARKING(header, body);
  }
  
  
}