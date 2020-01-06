package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws;

public class XXDC_AOPT_PKG_WS_PortTypeProxy implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType {
  private String _endpoint = null;
  private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType xXDC_AOPT_PKG_WS_PortType = null;
  
  public XXDC_AOPT_PKG_WS_PortTypeProxy() {
    _initXXDC_AOPT_PKG_WS_PortTypeProxy();
  }
  
  public XXDC_AOPT_PKG_WS_PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initXXDC_AOPT_PKG_WS_PortTypeProxy();
  }
  
  private void _initXXDC_AOPT_PKG_WS_PortTypeProxy() {
    try {
      xXDC_AOPT_PKG_WS_PortType = (new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_ServiceLocator()).getXXDC_AOPT_PKG_WS_Port();
      if (xXDC_AOPT_PKG_WS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)xXDC_AOPT_PKG_WS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)xXDC_AOPT_PKG_WS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (xXDC_AOPT_PKG_WS_PortType != null)
      ((javax.xml.rpc.Stub)xXDC_AOPT_PKG_WS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType getXXDC_AOPT_PKG_WS_PortType() {
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType;
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters AOPT_REGISTRATION_DETAILS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.AOPT_REGISTRATION_DETAILS(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters GET_MASTER_MILESTONE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.GET_MASTER_MILESTONE(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters GET_MILESTONE_PAYMENT_DET(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.GET_MILESTONE_PAYMENT_DET(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters PAYMENT_PLAN_CREATION(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.PAYMENT_PLAN_CREATION(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters PAYMENT_PLAN_REVERSAL(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.PAYMENT_PLAN_REVERSAL(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters PRIOR_AOPT_DETAILS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.PRIOR_AOPT_DETAILS(header, body);
  }
  
  public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters RETRIVAL_PROCESS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.InputParameters body) throws java.rmi.RemoteException{
    if (xXDC_AOPT_PKG_WS_PortType == null)
      _initXXDC_AOPT_PKG_WS_PortTypeProxy();
    return xXDC_AOPT_PKG_WS_PortType.RETRIVAL_PROCESS(header, body);
  }
  
  
}