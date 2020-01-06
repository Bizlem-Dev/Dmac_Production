/**
 * APPSXXDC_PARKING_INVX1844909X3X2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_parking_inv_ws_pkg.parking_payment_terms;

public class APPSXXDC_PARKING_INVX1844909X3X2  implements java.io.Serializable {
    private java.lang.String SR_NUMBER;

    private java.lang.String UNIT_NAME;

    private java.lang.String INSTALLMENT;

    private java.util.Calendar PAYMENT_DATE;

    private java.math.BigDecimal AMOUNT;

    private java.lang.String PDC_NUMBER;

    private java.lang.String REMARKS;

    public APPSXXDC_PARKING_INVX1844909X3X2() {
    }

    public APPSXXDC_PARKING_INVX1844909X3X2(
           java.lang.String SR_NUMBER,
           java.lang.String UNIT_NAME,
           java.lang.String INSTALLMENT,
           java.util.Calendar PAYMENT_DATE,
           java.math.BigDecimal AMOUNT,
           java.lang.String PDC_NUMBER,
           java.lang.String REMARKS) {
           this.SR_NUMBER = SR_NUMBER;
           this.UNIT_NAME = UNIT_NAME;
           this.INSTALLMENT = INSTALLMENT;
           this.PAYMENT_DATE = PAYMENT_DATE;
           this.AMOUNT = AMOUNT;
           this.PDC_NUMBER = PDC_NUMBER;
           this.REMARKS = REMARKS;
    }


    /**
     * Gets the SR_NUMBER value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return SR_NUMBER
     */
    public java.lang.String getSR_NUMBER() {
        return SR_NUMBER;
    }


    /**
     * Sets the SR_NUMBER value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param SR_NUMBER
     */
    public void setSR_NUMBER(java.lang.String SR_NUMBER) {
        this.SR_NUMBER = SR_NUMBER;
    }


    /**
     * Gets the UNIT_NAME value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return UNIT_NAME
     */
    public java.lang.String getUNIT_NAME() {
        return UNIT_NAME;
    }


    /**
     * Sets the UNIT_NAME value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param UNIT_NAME
     */
    public void setUNIT_NAME(java.lang.String UNIT_NAME) {
        this.UNIT_NAME = UNIT_NAME;
    }


    /**
     * Gets the INSTALLMENT value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return INSTALLMENT
     */
    public java.lang.String getINSTALLMENT() {
        return INSTALLMENT;
    }


    /**
     * Sets the INSTALLMENT value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param INSTALLMENT
     */
    public void setINSTALLMENT(java.lang.String INSTALLMENT) {
        this.INSTALLMENT = INSTALLMENT;
    }


    /**
     * Gets the PAYMENT_DATE value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return PAYMENT_DATE
     */
    public java.util.Calendar getPAYMENT_DATE() {
        return PAYMENT_DATE;
    }


    /**
     * Sets the PAYMENT_DATE value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param PAYMENT_DATE
     */
    public void setPAYMENT_DATE(java.util.Calendar PAYMENT_DATE) {
        this.PAYMENT_DATE = PAYMENT_DATE;
    }


    /**
     * Gets the AMOUNT value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return AMOUNT
     */
    public java.math.BigDecimal getAMOUNT() {
        return AMOUNT;
    }


    /**
     * Sets the AMOUNT value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param AMOUNT
     */
    public void setAMOUNT(java.math.BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }


    /**
     * Gets the PDC_NUMBER value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return PDC_NUMBER
     */
    public java.lang.String getPDC_NUMBER() {
        return PDC_NUMBER;
    }


    /**
     * Sets the PDC_NUMBER value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param PDC_NUMBER
     */
    public void setPDC_NUMBER(java.lang.String PDC_NUMBER) {
        this.PDC_NUMBER = PDC_NUMBER;
    }


    /**
     * Gets the REMARKS value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @return REMARKS
     */
    public java.lang.String getREMARKS() {
        return REMARKS;
    }


    /**
     * Sets the REMARKS value for this APPSXXDC_PARKING_INVX1844909X3X2.
     * 
     * @param REMARKS
     */
    public void setREMARKS(java.lang.String REMARKS) {
        this.REMARKS = REMARKS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof APPSXXDC_PARKING_INVX1844909X3X2)) return false;
        APPSXXDC_PARKING_INVX1844909X3X2 other = (APPSXXDC_PARKING_INVX1844909X3X2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SR_NUMBER==null && other.getSR_NUMBER()==null) || 
             (this.SR_NUMBER!=null &&
              this.SR_NUMBER.equals(other.getSR_NUMBER()))) &&
            ((this.UNIT_NAME==null && other.getUNIT_NAME()==null) || 
             (this.UNIT_NAME!=null &&
              this.UNIT_NAME.equals(other.getUNIT_NAME()))) &&
            ((this.INSTALLMENT==null && other.getINSTALLMENT()==null) || 
             (this.INSTALLMENT!=null &&
              this.INSTALLMENT.equals(other.getINSTALLMENT()))) &&
            ((this.PAYMENT_DATE==null && other.getPAYMENT_DATE()==null) || 
             (this.PAYMENT_DATE!=null &&
              this.PAYMENT_DATE.equals(other.getPAYMENT_DATE()))) &&
            ((this.AMOUNT==null && other.getAMOUNT()==null) || 
             (this.AMOUNT!=null &&
              this.AMOUNT.equals(other.getAMOUNT()))) &&
            ((this.PDC_NUMBER==null && other.getPDC_NUMBER()==null) || 
             (this.PDC_NUMBER!=null &&
              this.PDC_NUMBER.equals(other.getPDC_NUMBER()))) &&
            ((this.REMARKS==null && other.getREMARKS()==null) || 
             (this.REMARKS!=null &&
              this.REMARKS.equals(other.getREMARKS())));
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
        if (getSR_NUMBER() != null) {
            _hashCode += getSR_NUMBER().hashCode();
        }
        if (getUNIT_NAME() != null) {
            _hashCode += getUNIT_NAME().hashCode();
        }
        if (getINSTALLMENT() != null) {
            _hashCode += getINSTALLMENT().hashCode();
        }
        if (getPAYMENT_DATE() != null) {
            _hashCode += getPAYMENT_DATE().hashCode();
        }
        if (getAMOUNT() != null) {
            _hashCode += getAMOUNT().hashCode();
        }
        if (getPDC_NUMBER() != null) {
            _hashCode += getPDC_NUMBER().hashCode();
        }
        if (getREMARKS() != null) {
            _hashCode += getREMARKS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(APPSXXDC_PARKING_INVX1844909X3X2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "APPS.XXDC_PARKING_INVX1844909X3X2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SR_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "SR_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UNIT_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "UNIT_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INSTALLMENT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "INSTALLMENT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAYMENT_DATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "PAYMENT_DATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMOUNT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "AMOUNT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PDC_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "PDC_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REMARKS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_parking_inv_ws_pkg/parking_payment_terms/", "REMARKS"));
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
