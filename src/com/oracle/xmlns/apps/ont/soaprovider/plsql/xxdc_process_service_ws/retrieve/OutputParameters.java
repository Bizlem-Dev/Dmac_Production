/**
 * OutputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve;

public class OutputParameters  implements java.io.Serializable {
    private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56[] x_RESPONSE_MESSAGE;

    private java.lang.String x_RETURN_STATUS;

    private java.lang.String x_RETURN_MESSAGE;

    public OutputParameters() {
    }

    public OutputParameters(
           com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56[] x_RESPONSE_MESSAGE,
           java.lang.String x_RETURN_STATUS,
           java.lang.String x_RETURN_MESSAGE) {
           this.x_RESPONSE_MESSAGE = x_RESPONSE_MESSAGE;
           this.x_RETURN_STATUS = x_RETURN_STATUS;
           this.x_RETURN_MESSAGE = x_RETURN_MESSAGE;
    }


    /**
     * Gets the x_RESPONSE_MESSAGE value for this OutputParameters.
     * 
     * @return x_RESPONSE_MESSAGE
     */
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56[] getX_RESPONSE_MESSAGE() {
        return x_RESPONSE_MESSAGE;
    }


    /**
     * Sets the x_RESPONSE_MESSAGE value for this OutputParameters.
     * 
     * @param x_RESPONSE_MESSAGE
     */
    public void setX_RESPONSE_MESSAGE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.retrieve.APPSXXDC_PROCESS_SEX1794747X2X56[] x_RESPONSE_MESSAGE) {
        this.x_RESPONSE_MESSAGE = x_RESPONSE_MESSAGE;
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
     * Gets the x_RETURN_MESSAGE value for this OutputParameters.
     * 
     * @return x_RETURN_MESSAGE
     */
    public java.lang.String getX_RETURN_MESSAGE() {
        return x_RETURN_MESSAGE;
    }


    /**
     * Sets the x_RETURN_MESSAGE value for this OutputParameters.
     * 
     * @param x_RETURN_MESSAGE
     */
    public void setX_RETURN_MESSAGE(java.lang.String x_RETURN_MESSAGE) {
        this.x_RETURN_MESSAGE = x_RETURN_MESSAGE;
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
            ((this.x_RESPONSE_MESSAGE==null && other.getX_RESPONSE_MESSAGE()==null) || 
             (this.x_RESPONSE_MESSAGE!=null &&
              java.util.Arrays.equals(this.x_RESPONSE_MESSAGE, other.getX_RESPONSE_MESSAGE()))) &&
            ((this.x_RETURN_STATUS==null && other.getX_RETURN_STATUS()==null) || 
             (this.x_RETURN_STATUS!=null &&
              this.x_RETURN_STATUS.equals(other.getX_RETURN_STATUS()))) &&
            ((this.x_RETURN_MESSAGE==null && other.getX_RETURN_MESSAGE()==null) || 
             (this.x_RETURN_MESSAGE!=null &&
              this.x_RETURN_MESSAGE.equals(other.getX_RETURN_MESSAGE())));
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
        if (getX_RESPONSE_MESSAGE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getX_RESPONSE_MESSAGE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getX_RESPONSE_MESSAGE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getX_RETURN_STATUS() != null) {
            _hashCode += getX_RETURN_STATUS().hashCode();
        }
        if (getX_RETURN_MESSAGE() != null) {
            _hashCode += getX_RETURN_MESSAGE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/retrieve/", ">OutputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_RESPONSE_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/retrieve/", "X_RESPONSE_MESSAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/retrieve/", "APPS.XXDC_PROCESS_SEX1794747X2X56"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/retrieve/", "X_RESPONSE_MESSAGE_ITEM"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_RETURN_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/retrieve/", "X_RETURN_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_RETURN_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/retrieve/", "X_RETURN_MESSAGE"));
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
