/**
 * XXDC_PARKING_INV_WS_PKG_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg;

public class XXDC_PARKING_INV_WS_PKG_ServiceLocator extends org.apache.axis.client.Service implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_Service {

    public XXDC_PARKING_INV_WS_PKG_ServiceLocator() {
    }


    public XXDC_PARKING_INV_WS_PKG_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public XXDC_PARKING_INV_WS_PKG_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for XXDC_PARKING_INV_WS_PKG_Port
    private java.lang.String XXDC_PARKING_INV_WS_PKG_Port_address = "https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_parking_inv_ws_pkg/";
   // private java.lang.String XXDC_PARKING_INV_WS_PKG_Port_address = "http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_parking_inv_ws_pkg/";

    public java.lang.String getXXDC_PARKING_INV_WS_PKG_PortAddress() {
        return XXDC_PARKING_INV_WS_PKG_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String XXDC_PARKING_INV_WS_PKG_PortWSDDServiceName = "XXDC_PARKING_INV_WS_PKG_Port";

    public java.lang.String getXXDC_PARKING_INV_WS_PKG_PortWSDDServiceName() {
        return XXDC_PARKING_INV_WS_PKG_PortWSDDServiceName;
    }

    public void setXXDC_PARKING_INV_WS_PKG_PortWSDDServiceName(java.lang.String name) {
        XXDC_PARKING_INV_WS_PKG_PortWSDDServiceName = name;
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType getXXDC_PARKING_INV_WS_PKG_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(XXDC_PARKING_INV_WS_PKG_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getXXDC_PARKING_INV_WS_PKG_Port(endpoint);
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType getXXDC_PARKING_INV_WS_PKG_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_BindingStub _stub = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_BindingStub(portAddress, this);
            _stub.setPortName(getXXDC_PARKING_INV_WS_PKG_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setXXDC_PARKING_INV_WS_PKG_PortEndpointAddress(java.lang.String address) {
        XXDC_PARKING_INV_WS_PKG_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_BindingStub _stub = new com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.XXDC_PARKING_INV_WS_PKG_BindingStub(new java.net.URL(XXDC_PARKING_INV_WS_PKG_Port_address), this);
                _stub.setPortName(getXXDC_PARKING_INV_WS_PKG_PortWSDDServiceName());
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
        if ("XXDC_PARKING_INV_WS_PKG_Port".equals(inputPortName)) {
            return getXXDC_PARKING_INV_WS_PKG_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/", "XXDC_PARKING_INV_WS_PKG_Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/", "XXDC_PARKING_INV_WS_PKG_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("XXDC_PARKING_INV_WS_PKG_Port".equals(portName)) {
            setXXDC_PARKING_INV_WS_PKG_PortEndpointAddress(address);
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
