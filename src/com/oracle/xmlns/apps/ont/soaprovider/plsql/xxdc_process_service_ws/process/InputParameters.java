/**
 * InputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process;

public class InputParameters  implements java.io.Serializable {
    private java.lang.String p_REQUEST_NUMBER;

    private java.lang.String p_SOURCE_SYSTEM;

    private java.lang.String p_REQUEST_NAME;

    private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] p_REQUEST_MESSAGE;

    public InputParameters() {
    }

    public InputParameters(
           java.lang.String p_REQUEST_NUMBER,
           java.lang.String p_SOURCE_SYSTEM,
           java.lang.String p_REQUEST_NAME,
           com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] p_REQUEST_MESSAGE) {
           this.p_REQUEST_NUMBER = p_REQUEST_NUMBER;
           this.p_SOURCE_SYSTEM = p_SOURCE_SYSTEM;
           this.p_REQUEST_NAME = p_REQUEST_NAME;
           this.p_REQUEST_MESSAGE = p_REQUEST_MESSAGE;
    }


    /**
     * Gets the p_REQUEST_NUMBER value for this InputParameters.
     * 
     * @return p_REQUEST_NUMBER
     */
    public java.lang.String getP_REQUEST_NUMBER() {
        return p_REQUEST_NUMBER;
    }


    /**
     * Sets the p_REQUEST_NUMBER value for this InputParameters.
     * 
     * @param p_REQUEST_NUMBER
     */
    public void setP_REQUEST_NUMBER(java.lang.String p_REQUEST_NUMBER) {
        this.p_REQUEST_NUMBER = p_REQUEST_NUMBER;
    }


    /**
     * Gets the p_SOURCE_SYSTEM value for this InputParameters.
     * 
     * @return p_SOURCE_SYSTEM
     */
    public java.lang.String getP_SOURCE_SYSTEM() {
        return p_SOURCE_SYSTEM;
    }


    /**
     * Sets the p_SOURCE_SYSTEM value for this InputParameters.
     * 
     * @param p_SOURCE_SYSTEM
     */
    public void setP_SOURCE_SYSTEM(java.lang.String p_SOURCE_SYSTEM) {
        this.p_SOURCE_SYSTEM = p_SOURCE_SYSTEM;
    }


    /**
     * Gets the p_REQUEST_NAME value for this InputParameters.
     * 
     * @return p_REQUEST_NAME
     */
    public java.lang.String getP_REQUEST_NAME() {
        return p_REQUEST_NAME;
    }


    /**
     * Sets the p_REQUEST_NAME value for this InputParameters.
     * 
     * @param p_REQUEST_NAME
     */
    public void setP_REQUEST_NAME(java.lang.String p_REQUEST_NAME) {
        this.p_REQUEST_NAME = p_REQUEST_NAME;
    }


    /**
     * Gets the p_REQUEST_MESSAGE value for this InputParameters.
     * 
     * @return p_REQUEST_MESSAGE
     */
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] getP_REQUEST_MESSAGE() {
        return p_REQUEST_MESSAGE;
    }


    /**
     * Sets the p_REQUEST_MESSAGE value for this InputParameters.
     * 
     * @param p_REQUEST_MESSAGE
     */
    public void setP_REQUEST_MESSAGE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process.APPSXXDC_PROCESS_SERX1794747X1X5[] p_REQUEST_MESSAGE) {
        this.p_REQUEST_MESSAGE = p_REQUEST_MESSAGE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputParameters)) return false;
        InputParameters other = (InputParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_REQUEST_NUMBER==null && other.getP_REQUEST_NUMBER()==null) || 
             (this.p_REQUEST_NUMBER!=null &&
              this.p_REQUEST_NUMBER.equals(other.getP_REQUEST_NUMBER()))) &&
            ((this.p_SOURCE_SYSTEM==null && other.getP_SOURCE_SYSTEM()==null) || 
             (this.p_SOURCE_SYSTEM!=null &&
              this.p_SOURCE_SYSTEM.equals(other.getP_SOURCE_SYSTEM()))) &&
            ((this.p_REQUEST_NAME==null && other.getP_REQUEST_NAME()==null) || 
             (this.p_REQUEST_NAME!=null &&
              this.p_REQUEST_NAME.equals(other.getP_REQUEST_NAME()))) &&
            ((this.p_REQUEST_MESSAGE==null && other.getP_REQUEST_MESSAGE()==null) || 
             (this.p_REQUEST_MESSAGE!=null &&
              java.util.Arrays.equals(this.p_REQUEST_MESSAGE, other.getP_REQUEST_MESSAGE())));
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
        if (getP_REQUEST_NUMBER() != null) {
            _hashCode += getP_REQUEST_NUMBER().hashCode();
        }
        if (getP_SOURCE_SYSTEM() != null) {
            _hashCode += getP_SOURCE_SYSTEM().hashCode();
        }
        if (getP_REQUEST_NAME() != null) {
            _hashCode += getP_REQUEST_NAME().hashCode();
        }
        if (getP_REQUEST_MESSAGE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getP_REQUEST_MESSAGE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getP_REQUEST_MESSAGE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", ">InputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_REQUEST_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "P_REQUEST_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_SOURCE_SYSTEM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "P_SOURCE_SYSTEM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_REQUEST_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "P_REQUEST_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_REQUEST_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "P_REQUEST_MESSAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "APPS.XXDC_PROCESS_SERX1794747X1X5"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "P_REQUEST_MESSAGE_ITEM"));
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
