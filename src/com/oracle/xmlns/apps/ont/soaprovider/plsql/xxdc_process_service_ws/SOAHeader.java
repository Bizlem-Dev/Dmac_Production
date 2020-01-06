/**
 * SOAHeader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws;

public class SOAHeader  implements java.io.Serializable {
    private java.lang.String responsibility;

    private java.lang.String respApplication;

    private java.lang.String securityGroup;

    private java.lang.String NLSLanguage;

    private java.lang.String org_Id;

    public SOAHeader() {
    }

    public SOAHeader(
           java.lang.String responsibility,
           java.lang.String respApplication,
           java.lang.String securityGroup,
           java.lang.String NLSLanguage,
           java.lang.String org_Id) {
           this.responsibility = responsibility;
           this.respApplication = respApplication;
           this.securityGroup = securityGroup;
           this.NLSLanguage = NLSLanguage;
           this.org_Id = org_Id;
    }


    /**
     * Gets the responsibility value for this SOAHeader.
     * 
     * @return responsibility
     */
    public java.lang.String getResponsibility() {
        return responsibility;
    }


    /**
     * Sets the responsibility value for this SOAHeader.
     * 
     * @param responsibility
     */
    public void setResponsibility(java.lang.String responsibility) {
        this.responsibility = responsibility;
    }


    /**
     * Gets the respApplication value for this SOAHeader.
     * 
     * @return respApplication
     */
    public java.lang.String getRespApplication() {
        return respApplication;
    }


    /**
     * Sets the respApplication value for this SOAHeader.
     * 
     * @param respApplication
     */
    public void setRespApplication(java.lang.String respApplication) {
        this.respApplication = respApplication;
    }


    /**
     * Gets the securityGroup value for this SOAHeader.
     * 
     * @return securityGroup
     */
    public java.lang.String getSecurityGroup() {
        return securityGroup;
    }


    /**
     * Sets the securityGroup value for this SOAHeader.
     * 
     * @param securityGroup
     */
    public void setSecurityGroup(java.lang.String securityGroup) {
        this.securityGroup = securityGroup;
    }


    /**
     * Gets the NLSLanguage value for this SOAHeader.
     * 
     * @return NLSLanguage
     */
    public java.lang.String getNLSLanguage() {
        return NLSLanguage;
    }


    /**
     * Sets the NLSLanguage value for this SOAHeader.
     * 
     * @param NLSLanguage
     */
    public void setNLSLanguage(java.lang.String NLSLanguage) {
        this.NLSLanguage = NLSLanguage;
    }


    /**
     * Gets the org_Id value for this SOAHeader.
     * 
     * @return org_Id
     */
    public java.lang.String getOrg_Id() {
        return org_Id;
    }


    /**
     * Sets the org_Id value for this SOAHeader.
     * 
     * @param org_Id
     */
    public void setOrg_Id(java.lang.String org_Id) {
        this.org_Id = org_Id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SOAHeader)) return false;
        SOAHeader other = (SOAHeader) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responsibility==null && other.getResponsibility()==null) || 
             (this.responsibility!=null &&
              this.responsibility.equals(other.getResponsibility()))) &&
            ((this.respApplication==null && other.getRespApplication()==null) || 
             (this.respApplication!=null &&
              this.respApplication.equals(other.getRespApplication()))) &&
            ((this.securityGroup==null && other.getSecurityGroup()==null) || 
             (this.securityGroup!=null &&
              this.securityGroup.equals(other.getSecurityGroup()))) &&
            ((this.NLSLanguage==null && other.getNLSLanguage()==null) || 
             (this.NLSLanguage!=null &&
              this.NLSLanguage.equals(other.getNLSLanguage()))) &&
            ((this.org_Id==null && other.getOrg_Id()==null) || 
             (this.org_Id!=null &&
              this.org_Id.equals(other.getOrg_Id())));
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
        if (getResponsibility() != null) {
            _hashCode += getResponsibility().hashCode();
        }
        if (getRespApplication() != null) {
            _hashCode += getRespApplication().hashCode();
        }
        if (getSecurityGroup() != null) {
            _hashCode += getSecurityGroup().hashCode();
        }
        if (getNLSLanguage() != null) {
            _hashCode += getNLSLanguage().hashCode();
        }
        if (getOrg_Id() != null) {
            _hashCode += getOrg_Id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SOAHeader.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/", ">SOAHeader"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsibility");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/", "Responsibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respApplication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/", "RespApplication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/", "SecurityGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NLSLanguage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/", "NLSLanguage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("org_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/", "Org_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
