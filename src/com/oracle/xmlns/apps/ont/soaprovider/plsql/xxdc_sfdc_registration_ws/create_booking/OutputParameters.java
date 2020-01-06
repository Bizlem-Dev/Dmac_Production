/**
 * OutputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking;

public class OutputParameters  implements java.io.Serializable {
    private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking.APPSXXDC_SFDC_REGIX1809884X4X329[] x_RESPONSE_RECORDS;

    private java.lang.String x_REQUEST_STATUS;

    private java.lang.String x_ERROR_MESSAGE;

    public OutputParameters() {
    }

    public OutputParameters(
           com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking.APPSXXDC_SFDC_REGIX1809884X4X329[] x_RESPONSE_RECORDS,
           java.lang.String x_REQUEST_STATUS,
           java.lang.String x_ERROR_MESSAGE) {
           this.x_RESPONSE_RECORDS = x_RESPONSE_RECORDS;
           this.x_REQUEST_STATUS = x_REQUEST_STATUS;
           this.x_ERROR_MESSAGE = x_ERROR_MESSAGE;
    }


    /**
     * Gets the x_RESPONSE_RECORDS value for this OutputParameters.
     * 
     * @return x_RESPONSE_RECORDS
     */
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking.APPSXXDC_SFDC_REGIX1809884X4X329[] getX_RESPONSE_RECORDS() {
        return x_RESPONSE_RECORDS;
    }


    /**
     * Sets the x_RESPONSE_RECORDS value for this OutputParameters.
     * 
     * @param x_RESPONSE_RECORDS
     */
    public void setX_RESPONSE_RECORDS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_sfdc_registration_ws.create_booking.APPSXXDC_SFDC_REGIX1809884X4X329[] x_RESPONSE_RECORDS) {
        this.x_RESPONSE_RECORDS = x_RESPONSE_RECORDS;
    }


    /**
     * Gets the x_REQUEST_STATUS value for this OutputParameters.
     * 
     * @return x_REQUEST_STATUS
     */
    public java.lang.String getX_REQUEST_STATUS() {
        return x_REQUEST_STATUS;
    }


    /**
     * Sets the x_REQUEST_STATUS value for this OutputParameters.
     * 
     * @param x_REQUEST_STATUS
     */
    public void setX_REQUEST_STATUS(java.lang.String x_REQUEST_STATUS) {
        this.x_REQUEST_STATUS = x_REQUEST_STATUS;
    }


    /**
     * Gets the x_ERROR_MESSAGE value for this OutputParameters.
     * 
     * @return x_ERROR_MESSAGE
     */
    public java.lang.String getX_ERROR_MESSAGE() {
        return x_ERROR_MESSAGE;
    }


    /**
     * Sets the x_ERROR_MESSAGE value for this OutputParameters.
     * 
     * @param x_ERROR_MESSAGE
     */
    public void setX_ERROR_MESSAGE(java.lang.String x_ERROR_MESSAGE) {
        this.x_ERROR_MESSAGE = x_ERROR_MESSAGE;
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
            ((this.x_RESPONSE_RECORDS==null && other.getX_RESPONSE_RECORDS()==null) || 
             (this.x_RESPONSE_RECORDS!=null &&
              java.util.Arrays.equals(this.x_RESPONSE_RECORDS, other.getX_RESPONSE_RECORDS()))) &&
            ((this.x_REQUEST_STATUS==null && other.getX_REQUEST_STATUS()==null) || 
             (this.x_REQUEST_STATUS!=null &&
              this.x_REQUEST_STATUS.equals(other.getX_REQUEST_STATUS()))) &&
            ((this.x_ERROR_MESSAGE==null && other.getX_ERROR_MESSAGE()==null) || 
             (this.x_ERROR_MESSAGE!=null &&
              this.x_ERROR_MESSAGE.equals(other.getX_ERROR_MESSAGE())));
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
        if (getX_RESPONSE_RECORDS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getX_RESPONSE_RECORDS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getX_RESPONSE_RECORDS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getX_REQUEST_STATUS() != null) {
            _hashCode += getX_REQUEST_STATUS().hashCode();
        }
        if (getX_ERROR_MESSAGE() != null) {
            _hashCode += getX_ERROR_MESSAGE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", ">OutputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_RESPONSE_RECORDS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "X_RESPONSE_RECORDS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "APPS.XXDC_SFDC_REGIX1809884X4X329"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "X_RESPONSE_RECORDS_ITEM"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_REQUEST_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "X_REQUEST_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_ERROR_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_sfdc_registration_ws/create_booking/", "X_ERROR_MESSAGE"));
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
