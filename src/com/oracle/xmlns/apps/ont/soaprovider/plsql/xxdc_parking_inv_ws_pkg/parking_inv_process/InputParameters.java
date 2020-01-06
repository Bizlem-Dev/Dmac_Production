/**
 * InputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_inv_process;

public class InputParameters  implements java.io.Serializable {
    private java.math.BigDecimal p_BUILDING_ID;

    private java.lang.String p_PARKING_TYPE;

    public InputParameters() {
    }

    public InputParameters(
           java.math.BigDecimal p_BUILDING_ID,
           java.lang.String p_PARKING_TYPE) {
           this.p_BUILDING_ID = p_BUILDING_ID;
           this.p_PARKING_TYPE = p_PARKING_TYPE;
    }


    /**
     * Gets the p_BUILDING_ID value for this InputParameters.
     * 
     * @return p_BUILDING_ID
     */
    public java.math.BigDecimal getP_BUILDING_ID() {
        return p_BUILDING_ID;
    }


    /**
     * Sets the p_BUILDING_ID value for this InputParameters.
     * 
     * @param p_BUILDING_ID
     */
    public void setP_BUILDING_ID(java.math.BigDecimal p_BUILDING_ID) {
        this.p_BUILDING_ID = p_BUILDING_ID;
    }


    /**
     * Gets the p_PARKING_TYPE value for this InputParameters.
     * 
     * @return p_PARKING_TYPE
     */
    public java.lang.String getP_PARKING_TYPE() {
        return p_PARKING_TYPE;
    }


    /**
     * Sets the p_PARKING_TYPE value for this InputParameters.
     * 
     * @param p_PARKING_TYPE
     */
    public void setP_PARKING_TYPE(java.lang.String p_PARKING_TYPE) {
        this.p_PARKING_TYPE = p_PARKING_TYPE;
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
            ((this.p_BUILDING_ID==null && other.getP_BUILDING_ID()==null) || 
             (this.p_BUILDING_ID!=null &&
              this.p_BUILDING_ID.equals(other.getP_BUILDING_ID()))) &&
            ((this.p_PARKING_TYPE==null && other.getP_PARKING_TYPE()==null) || 
             (this.p_PARKING_TYPE!=null &&
              this.p_PARKING_TYPE.equals(other.getP_PARKING_TYPE())));
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
        if (getP_BUILDING_ID() != null) {
            _hashCode += getP_BUILDING_ID().hashCode();
        }
        if (getP_PARKING_TYPE() != null) {
            _hashCode += getP_PARKING_TYPE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_inv_process/", ">InputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_BUILDING_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_inv_process/", "P_BUILDING_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_PARKING_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_inv_process/", "P_PARKING_TYPE"));
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
