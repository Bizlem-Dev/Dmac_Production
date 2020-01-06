/**
 * APPSXXDC_SFDC_REGIX1809884X4X337.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking;

public class APPSXXDC_SFDC_REGIX1809884X4X337  implements java.io.Serializable {
    private java.lang.String EXT_CUST_NUMBER;

    private java.lang.String JB_PARTY_ID;

    public APPSXXDC_SFDC_REGIX1809884X4X337() {
    }

    public APPSXXDC_SFDC_REGIX1809884X4X337(
           java.lang.String EXT_CUST_NUMBER,
           java.lang.String JB_PARTY_ID) {
           this.EXT_CUST_NUMBER = EXT_CUST_NUMBER;
           this.JB_PARTY_ID = JB_PARTY_ID;
    }


    /**
     * Gets the EXT_CUST_NUMBER value for this APPSXXDC_SFDC_REGIX1809884X4X337.
     * 
     * @return EXT_CUST_NUMBER
     */
    public java.lang.String getEXT_CUST_NUMBER() {
        return EXT_CUST_NUMBER;
    }


    /**
     * Sets the EXT_CUST_NUMBER value for this APPSXXDC_SFDC_REGIX1809884X4X337.
     * 
     * @param EXT_CUST_NUMBER
     */
    public void setEXT_CUST_NUMBER(java.lang.String EXT_CUST_NUMBER) {
        this.EXT_CUST_NUMBER = EXT_CUST_NUMBER;
    }


    /**
     * Gets the JB_PARTY_ID value for this APPSXXDC_SFDC_REGIX1809884X4X337.
     * 
     * @return JB_PARTY_ID
     */
    public java.lang.String getJB_PARTY_ID() {
        return JB_PARTY_ID;
    }


    /**
     * Sets the JB_PARTY_ID value for this APPSXXDC_SFDC_REGIX1809884X4X337.
     * 
     * @param JB_PARTY_ID
     */
    public void setJB_PARTY_ID(java.lang.String JB_PARTY_ID) {
        this.JB_PARTY_ID = JB_PARTY_ID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof APPSXXDC_SFDC_REGIX1809884X4X337)) return false;
        APPSXXDC_SFDC_REGIX1809884X4X337 other = (APPSXXDC_SFDC_REGIX1809884X4X337) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EXT_CUST_NUMBER==null && other.getEXT_CUST_NUMBER()==null) || 
             (this.EXT_CUST_NUMBER!=null &&
              this.EXT_CUST_NUMBER.equals(other.getEXT_CUST_NUMBER()))) &&
            ((this.JB_PARTY_ID==null && other.getJB_PARTY_ID()==null) || 
             (this.JB_PARTY_ID!=null &&
              this.JB_PARTY_ID.equals(other.getJB_PARTY_ID())));
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
        if (getEXT_CUST_NUMBER() != null) {
            _hashCode += getEXT_CUST_NUMBER().hashCode();
        }
        if (getJB_PARTY_ID() != null) {
            _hashCode += getJB_PARTY_ID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(APPSXXDC_SFDC_REGIX1809884X4X337.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "APPS.XXDC_SFDC_REGIX1809884X4X337"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EXT_CUST_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "EXT_CUST_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("JB_PARTY_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "JB_PARTY_ID"));
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
