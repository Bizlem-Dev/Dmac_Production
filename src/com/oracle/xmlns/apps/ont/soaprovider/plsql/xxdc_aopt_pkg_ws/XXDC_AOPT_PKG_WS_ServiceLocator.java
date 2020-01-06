/**
 * XXDC_AOPT_PKG_WS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws;

public class XXDC_AOPT_PKG_WS_ServiceLocator extends org.apache.axis.client.Service implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_Service {

    public XXDC_AOPT_PKG_WS_ServiceLocator() {
    }


    public XXDC_AOPT_PKG_WS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public XXDC_AOPT_PKG_WS_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for XXDC_AOPT_PKG_WS_Port
    private java.lang.String XXDC_AOPT_PKG_WS_Port_address = "https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/";
  //  private java.lang.String XXDC_AOPT_PKG_WS_Port_address = "http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/";

    public java.lang.String getXXDC_AOPT_PKG_WS_PortAddress() {
        return XXDC_AOPT_PKG_WS_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String XXDC_AOPT_PKG_WS_PortWSDDServiceName = "XXDC_AOPT_PKG_WS_Port";

    public java.lang.String getXXDC_AOPT_PKG_WS_PortWSDDServiceName() {
        return XXDC_AOPT_PKG_WS_PortWSDDServiceName;
    }

    public void setXXDC_AOPT_PKG_WS_PortWSDDServiceName(java.lang.String name) {
        XXDC_AOPT_PKG_WS_PortWSDDServiceName = name;
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType getXXDC_AOPT_PKG_WS_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(XXDC_AOPT_PKG_WS_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getXXDC_AOPT_PKG_WS_Port(endpoint);
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType getXXDC_AOPT_PKG_WS_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_BindingStub _stub = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_BindingStub(portAddress, this);
            _stub.setPortName(getXXDC_AOPT_PKG_WS_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setXXDC_AOPT_PKG_WS_PortEndpointAddress(java.lang.String address) {
        XXDC_AOPT_PKG_WS_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_BindingStub _stub = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_BindingStub(new java.net.URL(XXDC_AOPT_PKG_WS_Port_address), this);
                _stub.setPortName(getXXDC_AOPT_PKG_WS_PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("XXDC_AOPT_PKG_WS_Port".equals(inputPortName)) {
            return getXXDC_AOPT_PKG_WS_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "XXDC_AOPT_PKG_WS_Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "XXDC_AOPT_PKG_WS_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("XXDC_AOPT_PKG_WS_Port".equals(portName)) {
            setXXDC_AOPT_PKG_WS_PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
