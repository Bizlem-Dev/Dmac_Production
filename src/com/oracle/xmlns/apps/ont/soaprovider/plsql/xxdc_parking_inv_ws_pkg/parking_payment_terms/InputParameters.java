/**
 * InputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms;

public class InputParameters  implements java.io.Serializable {
    private com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2[] p_PARKING_PAYMENT_TERMS;

    public InputParameters() {
    }

    public InputParameters(
           com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2[] p_PARKING_PAYMENT_TERMS) {
           this.p_PARKING_PAYMENT_TERMS = p_PARKING_PAYMENT_TERMS;
    }


    /**
     * Gets the p_PARKING_PAYMENT_TERMS value for this InputParameters.
     * 
     * @return p_PARKING_PAYMENT_TERMS
     */
    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2[] getP_PARKING_PAYMENT_TERMS() {
        return p_PARKING_PAYMENT_TERMS;
    }


    /**
     * Sets the p_PARKING_PAYMENT_TERMS value for this InputParameters.
     * 
     * @param p_PARKING_PAYMENT_TERMS
     */
    public void setP_PARKING_PAYMENT_TERMS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms.APPSXXDC_PARKING_INVX1844909X3X2[] p_PARKING_PAYMENT_TERMS) {
        this.p_PARKING_PAYMENT_TERMS = p_PARKING_PAYMENT_TERMS;
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
            ((this.p_PARKING_PAYMENT_TERMS==null && other.getP_PARKING_PAYMENT_TERMS()==null) || 
             (this.p_PARKING_PAYMENT_TERMS!=null &&
              java.util.Arrays.equals(this.p_PARKING_PAYMENT_TERMS, other.getP_PARKING_PAYMENT_TERMS())));
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
        if (getP_PARKING_PAYMENT_TERMS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getP_PARKING_PAYMENT_TERMS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getP_PARKING_PAYMENT_TERMS(), i);
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", ">InputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_PARKING_PAYMENT_TERMS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "P_PARKING_PAYMENT_TERMS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "APPS.XXDC_PARKING_INVX1844909X3X2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "P_PARKING_PAYMENT_TERMS_ITEM"));
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
