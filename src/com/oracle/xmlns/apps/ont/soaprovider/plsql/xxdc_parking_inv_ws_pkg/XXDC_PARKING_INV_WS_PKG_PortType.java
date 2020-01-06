/**
 * XXDC_PARKING_INV_WS_PKG_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg;

public interface XXDC_PARKING_INV_WS_PKG_PortType extends java.rmi.Remote {
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.OutputParameters PARKING_INV_PROCESS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process.InputParameters body) throws java.rmi.RemoteException;
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.OutputParameters PARKING_PAYMENT_TERMS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.InputParameters body) throws java.rmi.RemoteException;
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.OutputParameters XXDC_ADD_PARKING(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking.InputParameters body) throws java.rmi.RemoteException;
}
