/**
 * InputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.xxdc_add_parking;

public class InputParameters  implements java.io.Serializable {
    private java.math.BigDecimal p_UNIT_ID;

    private java.math.BigDecimal p_DETAIL_ID;

    private java.lang.String p_PARKING_BAY_NO;

    private java.math.BigDecimal p_PRICE;

    private java.lang.String p_STATUS;

    private java.lang.String p_SR_NUMBER;

    public InputParameters() {
    }

    public InputParameters(
           java.math.BigDecimal p_UNIT_ID,
           java.math.BigDecimal p_DETAIL_ID,
           java.lang.String p_PARKING_BAY_NO,
           java.math.BigDecimal p_PRICE,
           java.lang.String p_STATUS,
           java.lang.String p_SR_NUMBER) {
           this.p_UNIT_ID = p_UNIT_ID;
           this.p_DETAIL_ID = p_DETAIL_ID;
           this.p_PARKING_BAY_NO = p_PARKING_BAY_NO;
           this.p_PRICE = p_PRICE;
           this.p_STATUS = p_STATUS;
           this.p_SR_NUMBER = p_SR_NUMBER;
    }


    /**
     * Gets the p_UNIT_ID value for this InputParameters.
     * 
     * @return p_UNIT_ID
     */
    public java.math.BigDecimal getP_UNIT_ID() {
        return p_UNIT_ID;
    }


    /**
     * Sets the p_UNIT_ID value for this InputParameters.
     * 
     * @param p_UNIT_ID
     */
    public void setP_UNIT_ID(java.math.BigDecimal p_UNIT_ID) {
        this.p_UNIT_ID = p_UNIT_ID;
    }


    /**
     * Gets the p_DETAIL_ID value for this InputParameters.
     * 
     * @return p_DETAIL_ID
     */
    public java.math.BigDecimal getP_DETAIL_ID() {
        return p_DETAIL_ID;
    }


    /**
     * Sets the p_DETAIL_ID value for this InputParameters.
     * 
     * @param p_DETAIL_ID
     */
    public void setP_DETAIL_ID(java.math.BigDecimal p_DETAIL_ID) {
        this.p_DETAIL_ID = p_DETAIL_ID;
    }


    /**
     * Gets the p_PARKING_BAY_NO value for this InputParameters.
     * 
     * @return p_PARKING_BAY_NO
     */
    public java.lang.String getP_PARKING_BAY_NO() {
        return p_PARKING_BAY_NO;
    }


    /**
     * Sets the p_PARKING_BAY_NO value for this InputParameters.
     * 
     * @param p_PARKING_BAY_NO
     */
    public void setP_PARKING_BAY_NO(java.lang.String p_PARKING_BAY_NO) {
        this.p_PARKING_BAY_NO = p_PARKING_BAY_NO;
    }


    /**
     * Gets the p_PRICE value for this InputParameters.
     * 
     * @return p_PRICE
     */
    public java.math.BigDecimal getP_PRICE() {
        return p_PRICE;
    }


    /**
     * Sets the p_PRICE value for this InputParameters.
     * 
     * @param p_PRICE
     */
    public void setP_PRICE(java.math.BigDecimal p_PRICE) {
        this.p_PRICE = p_PRICE;
    }


    /**
     * Gets the p_STATUS value for this InputParameters.
     * 
     * @return p_STATUS
     */
    public java.lang.String getP_STATUS() {
        return p_STATUS;
    }


    /**
     * Sets the p_STATUS value for this InputParameters.
     * 
     * @param p_STATUS
     */
    public void setP_STATUS(java.lang.String p_STATUS) {
        this.p_STATUS = p_STATUS;
    }


    /**
     * Gets the p_SR_NUMBER value for this InputParameters.
     * 
     * @return p_SR_NUMBER
     */
    public java.lang.String getP_SR_NUMBER() {
        return p_SR_NUMBER;
    }


    /**
     * Sets the p_SR_NUMBER value for this InputParameters.
     * 
     * @param p_SR_NUMBER
     */
    public void setP_SR_NUMBER(java.lang.String p_SR_NUMBER) {
        this.p_SR_NUMBER = p_SR_NUMBER;
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
            ((this.p_UNIT_ID==null && other.getP_UNIT_ID()==null) || 
             (this.p_UNIT_ID!=null &&
              this.p_UNIT_ID.equals(other.getP_UNIT_ID()))) &&
            ((this.p_DETAIL_ID==null && other.getP_DETAIL_ID()==null) || 
             (this.p_DETAIL_ID!=null &&
              this.p_DETAIL_ID.equals(other.getP_DETAIL_ID()))) &&
            ((this.p_PARKING_BAY_NO==null && other.getP_PARKING_BAY_NO()==null) || 
             (this.p_PARKING_BAY_NO!=null &&
              this.p_PARKING_BAY_NO.equals(other.getP_PARKING_BAY_NO()))) &&
            ((this.p_PRICE==null && other.getP_PRICE()==null) || 
             (this.p_PRICE!=null &&
              this.p_PRICE.equals(other.getP_PRICE()))) &&
            ((this.p_STATUS==null && other.getP_STATUS()==null) || 
             (this.p_STATUS!=null &&
              this.p_STATUS.equals(other.getP_STATUS()))) &&
            ((this.p_SR_NUMBER==null && other.getP_SR_NUMBER()==null) || 
             (this.p_SR_NUMBER!=null &&
              this.p_SR_NUMBER.equals(other.getP_SR_NUMBER())));
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
        if (getP_UNIT_ID() != null) {
            _hashCode += getP_UNIT_ID().hashCode();
        }
        if (getP_DETAIL_ID() != null) {
            _hashCode += getP_DETAIL_ID().hashCode();
        }
        if (getP_PARKING_BAY_NO() != null) {
            _hashCode += getP_PARKING_BAY_NO().hashCode();
        }
        if (getP_PRICE() != null) {
            _hashCode += getP_PRICE().hashCode();
        }
        if (getP_STATUS() != null) {
            _hashCode += getP_STATUS().hashCode();
        }
        if (getP_SR_NUMBER() != null) {
            _hashCode += getP_SR_NUMBER().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", ">InputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_UNIT_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", "P_UNIT_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_DETAIL_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", "P_DETAIL_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_PARKING_BAY_NO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", "P_PARKING_BAY_NO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_PRICE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", "P_PRICE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", "P_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_SR_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/xxdc_add_parking/", "P_SR_NUMBER"));
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
