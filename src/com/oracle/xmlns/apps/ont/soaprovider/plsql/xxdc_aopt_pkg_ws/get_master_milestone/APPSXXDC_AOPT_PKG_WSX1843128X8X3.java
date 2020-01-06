/**
 * APPSXXDC_AOPT_PKG_WSX1843128X8X3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone;

public class APPSXXDC_AOPT_PKG_WSX1843128X8X3  implements java.io.Serializable {
    private java.lang.String MILESTONE_EVENT;

    private java.lang.String ARABIC_MILESTONE_EVENT;

    public APPSXXDC_AOPT_PKG_WSX1843128X8X3() {
    }

    public APPSXXDC_AOPT_PKG_WSX1843128X8X3(
           java.lang.String MILESTONE_EVENT,
           java.lang.String ARABIC_MILESTONE_EVENT) {
           this.MILESTONE_EVENT = MILESTONE_EVENT;
           this.ARABIC_MILESTONE_EVENT = ARABIC_MILESTONE_EVENT;
    }


    /**
     * Gets the MILESTONE_EVENT value for this APPSXXDC_AOPT_PKG_WSX1843128X8X3.
     * 
     * @return MILESTONE_EVENT
     */
    public java.lang.String getMILESTONE_EVENT() {
        return MILESTONE_EVENT;
    }


    /**
     * Sets the MILESTONE_EVENT value for this APPSXXDC_AOPT_PKG_WSX1843128X8X3.
     * 
     * @param MILESTONE_EVENT
     */
    public void setMILESTONE_EVENT(java.lang.String MILESTONE_EVENT) {
        this.MILESTONE_EVENT = MILESTONE_EVENT;
    }


    /**
     * Gets the ARABIC_MILESTONE_EVENT value for this APPSXXDC_AOPT_PKG_WSX1843128X8X3.
     * 
     * @return ARABIC_MILESTONE_EVENT
     */
    public java.lang.String getARABIC_MILESTONE_EVENT() {
        return ARABIC_MILESTONE_EVENT;
    }


    /**
     * Sets the ARABIC_MILESTONE_EVENT value for this APPSXXDC_AOPT_PKG_WSX1843128X8X3.
     * 
     * @param ARABIC_MILESTONE_EVENT
     */
    public void setARABIC_MILESTONE_EVENT(java.lang.String ARABIC_MILESTONE_EVENT) {
        this.ARABIC_MILESTONE_EVENT = ARABIC_MILESTONE_EVENT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof APPSXXDC_AOPT_PKG_WSX1843128X8X3)) return false;
        APPSXXDC_AOPT_PKG_WSX1843128X8X3 other = (APPSXXDC_AOPT_PKG_WSX1843128X8X3) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.MILESTONE_EVENT==null && other.getMILESTONE_EVENT()==null) || 
             (this.MILESTONE_EVENT!=null &&
              this.MILESTONE_EVENT.equals(other.getMILESTONE_EVENT()))) &&
            ((this.ARABIC_MILESTONE_EVENT==null && other.getARABIC_MILESTONE_EVENT()==null) || 
             (this.ARABIC_MILESTONE_EVENT!=null &&
              this.ARABIC_MILESTONE_EVENT.equals(other.getARABIC_MILESTONE_EVENT())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMILESTONE_EVENT() != null) {
            _hashCode += getMILESTONE_EVENT().hashCode();
        }
        if (getARABIC_MILESTONE_EVENT() != null) {
            _hashCode += getARABIC_MILESTONE_EVENT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(APPSXXDC_AOPT_PKG_WSX1843128X8X3.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "APPS.XXDC_AOPT_PKG_WSX1843128X8X3"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MILESTONE_EVENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "MILESTONE_EVENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ARABIC_MILESTONE_EVENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "ARABIC_MILESTONE_EVENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
