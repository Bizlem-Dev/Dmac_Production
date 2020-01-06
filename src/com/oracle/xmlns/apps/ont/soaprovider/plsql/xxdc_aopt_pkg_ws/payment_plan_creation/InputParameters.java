/**
 * InputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation;

public class InputParameters  implements java.io.Serializable {
    private java.lang.String p_REGISTRATION_ID;

    private java.lang.String p_SR_NUMBER;

    private java.lang.String p_SR_TYPE;

    private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] p_REG_TERMS;

    public InputParameters() {
    }

    public InputParameters(
           java.lang.String p_REGISTRATION_ID,
           java.lang.String p_SR_NUMBER,
           java.lang.String p_SR_TYPE,
           com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] p_REG_TERMS) {
           this.p_REGISTRATION_ID = p_REGISTRATION_ID;
           this.p_SR_NUMBER = p_SR_NUMBER;
           this.p_SR_TYPE = p_SR_TYPE;
           this.p_REG_TERMS = p_REG_TERMS;
    }


    /**
     * Gets the p_REGISTRATION_ID value for this InputParameters.
     * 
     * @return p_REGISTRATION_ID
     */
    public java.lang.String getP_REGISTRATION_ID() {
        return p_REGISTRATION_ID;
    }


    /**
     * Sets the p_REGISTRATION_ID value for this InputParameters.
     * 
     * @param p_REGISTRATION_ID
     */
    public void setP_REGISTRATION_ID(java.lang.String p_REGISTRATION_ID) {
        this.p_REGISTRATION_ID = p_REGISTRATION_ID;
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


    /**
     * Gets the p_SR_TYPE value for this InputParameters.
     * 
     * @return p_SR_TYPE
     */
    public java.lang.String getP_SR_TYPE() {
        return p_SR_TYPE;
    }


    /**
     * Sets the p_SR_TYPE value for this InputParameters.
     * 
     * @param p_SR_TYPE
     */
    public void setP_SR_TYPE(java.lang.String p_SR_TYPE) {
        this.p_SR_TYPE = p_SR_TYPE;
    }


    /**
     * Gets the p_REG_TERMS value for this InputParameters.
     * 
     * @return p_REG_TERMS
     */
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] getP_REG_TERMS() {
        return p_REG_TERMS;
    }


    /**
     * Sets the p_REG_TERMS value for this InputParameters.
     * 
     * @param p_REG_TERMS
     */
    public void setP_REG_TERMS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[] p_REG_TERMS) {
        this.p_REG_TERMS = p_REG_TERMS;
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
            ((this.p_REGISTRATION_ID==null && other.getP_REGISTRATION_ID()==null) || 
             (this.p_REGISTRATION_ID!=null &&
              this.p_REGISTRATION_ID.equals(other.getP_REGISTRATION_ID()))) &&
            ((this.p_SR_NUMBER==null && other.getP_SR_NUMBER()==null) || 
             (this.p_SR_NUMBER!=null &&
              this.p_SR_NUMBER.equals(other.getP_SR_NUMBER()))) &&
            ((this.p_SR_TYPE==null && other.getP_SR_TYPE()==null) || 
             (this.p_SR_TYPE!=null &&
              this.p_SR_TYPE.equals(other.getP_SR_TYPE()))) &&
            ((this.p_REG_TERMS==null && other.getP_REG_TERMS()==null) || 
             (this.p_REG_TERMS!=null &&
              java.util.Arrays.equals(this.p_REG_TERMS, other.getP_REG_TERMS())));
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
        if (getP_REGISTRATION_ID() != null) {
            _hashCode += getP_REGISTRATION_ID().hashCode();
        }
        if (getP_SR_NUMBER() != null) {
            _hashCode += getP_SR_NUMBER().hashCode();
        }
        if (getP_SR_TYPE() != null) {
            _hashCode += getP_SR_TYPE().hashCode();
        }
        if (getP_REG_TERMS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getP_REG_TERMS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getP_REG_TERMS(), i);
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">InputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_REGISTRATION_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "P_REGISTRATION_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_SR_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "P_SR_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_SR_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "P_SR_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_REG_TERMS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "P_REG_TERMS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "APPS.XXDC_AOPT_PKG_WSX1843128X6X5"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "P_REG_TERMS_ITEM"));
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
