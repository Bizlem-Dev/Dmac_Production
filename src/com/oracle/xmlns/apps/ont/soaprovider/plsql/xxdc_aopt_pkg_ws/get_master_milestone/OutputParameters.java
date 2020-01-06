/**
 * OutputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone;

public class OutputParameters  implements java.io.Serializable {
    private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.APPSXXDC_AOPT_PKG_WSX1843128X8X3[] x_MILESTONE_TAB_TYPE;

    private java.lang.String x_RETURN_STATUS;

    private java.lang.String x_ERROR_MSG;

    public OutputParameters() {
    }

    public OutputParameters(
           com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.APPSXXDC_AOPT_PKG_WSX1843128X8X3[] x_MILESTONE_TAB_TYPE,
           java.lang.String x_RETURN_STATUS,
           java.lang.String x_ERROR_MSG) {
           this.x_MILESTONE_TAB_TYPE = x_MILESTONE_TAB_TYPE;
           this.x_RETURN_STATUS = x_RETURN_STATUS;
           this.x_ERROR_MSG = x_ERROR_MSG;
    }


    /**
     * Gets the x_MILESTONE_TAB_TYPE value for this OutputParameters.
     * 
     * @return x_MILESTONE_TAB_TYPE
     */
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.APPSXXDC_AOPT_PKG_WSX1843128X8X3[] getX_MILESTONE_TAB_TYPE() {
        return x_MILESTONE_TAB_TYPE;
    }


    /**
     * Sets the x_MILESTONE_TAB_TYPE value for this OutputParameters.
     * 
     * @param x_MILESTONE_TAB_TYPE
     */
    public void setX_MILESTONE_TAB_TYPE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.APPSXXDC_AOPT_PKG_WSX1843128X8X3[] x_MILESTONE_TAB_TYPE) {
        this.x_MILESTONE_TAB_TYPE = x_MILESTONE_TAB_TYPE;
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
            ((this.x_MILESTONE_TAB_TYPE==null && other.getX_MILESTONE_TAB_TYPE()==null) || 
             (this.x_MILESTONE_TAB_TYPE!=null &&
              java.util.Arrays.equals(this.x_MILESTONE_TAB_TYPE, other.getX_MILESTONE_TAB_TYPE()))) &&
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
        if (getX_MILESTONE_TAB_TYPE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getX_MILESTONE_TAB_TYPE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getX_MILESTONE_TAB_TYPE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">OutputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_MILESTONE_TAB_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "X_MILESTONE_TAB_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "APPS.XXDC_AOPT_PKG_WSX1843128X8X3"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "X_MILESTONE_TAB_TYPE_ITEM"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_RETURN_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "X_RETURN_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("x_ERROR_MSG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "X_ERROR_MSG"));
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
