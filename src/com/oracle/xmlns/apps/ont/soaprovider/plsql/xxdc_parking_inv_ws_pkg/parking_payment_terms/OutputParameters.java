/**
 * OutputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms;

public class OutputParameters  implements java.io.Serializable {
    private java.lang.String x_RETURN_STATUS;

    private java.lang.String x_ERROR_MSG;

    public OutputParameters() {
    }

    public OutputParameters(
           java.lang.String x_RETURN_STATUS,
           java.lang.String x_ERROR_MSG) {
           this.x_RETURN_STATUS = x_RETURN_STATUS;
           this.x_ERROR_MSG = x_ERROR_MSG;
    }


    /**
     * Gets the x_RETURN_STATUS value for this OutputParameters.
     * 
     * @return x_RETURN_STATUS
     */
    public java.lang.String getX_RETURN_STATUS() {
        return x_RETURN_STATUS;
    }


    /**
     * Sets the x_RETURN_STATUS value for this OutputParameters.
     * 
     * @param x_RETURN_STATUS
     */
    public void setX_RETURN_STATUS(java.lang.String x_RETURN_STATUS) {
        this.x_RETURN_STATUS = x_RETURN_STATUS;
    }


    /**
     * Gets the x_ERROR_MSG value for this OutputParameters.
     * 
     * @return x_ERROR_MSG
     */
    public java.lang.String getX_ERROR_MSG() {
        return x_ERROR_MSG;
    }


    /**
     * Sets the x_ERROR_MSG value for this OutputParameters.
     * 
     * @param x_ERROR_MSG
     */
    public void setX_ERROR_MSG(java.lang.String x_ERROR_MSG) {
        this.x_ERROR_MSG = x_ERROR_MSG;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputParameters)) return false;
        OutputParameters other = (OutputParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.x_RETURN_STATUS==null && other.getX_RETURN_STATUS()==null) || 
             (this.x_RETURN_STATUS!=null &&
              this.x_RETURN_STATUS.equals(other.getX_RETURN_STATUS()))) &&
            ((this.x_ERROR_MSG==null && other.getX_ERROR_MSG()==null) || 
             (this.x_ERROR_MSG!=null &&
              this.x_ERROR_MSG.equals(other.getX_ERROR_MSG())));
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
        if (getX_RETURN_STATUS() != null) {
            _hashCode += getX_RETURN_STATUS().hashCode();
        }
        if (getX_ERROR_MSG() != null) {
            _hashCode += getX_ERROR_MSG().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", ">OutputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_RETURN_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "X_RETURN_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_ERROR_MSG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "X_ERROR_MSG"));
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
