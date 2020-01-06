/**
 * XXDC_PROCESS_SERVICE_WS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws;

public interface XXDC_PROCESS_SERVICE_WS_PortType extends java.rmi.Remote {
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.OutputParameters PROCESS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.InputParameters body) throws java.rmi.RemoteException;
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.OutputParameters RETRIEVE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.InputParameters body) throws java.rmi.RemoteException;
}
