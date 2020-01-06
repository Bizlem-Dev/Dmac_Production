/**
 * APPSXXDC_PROCESS_SEX1794747X1X57.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_process_service_ws.process;

public class APPSXXDC_PROCESS_SEX1794747X1X57  implements java.io.Serializable {
    private java.lang.String PARAM_ID;

    private java.lang.String PROC_STATUS;

    private java.lang.String PROC_MESSAGE;

    private java.lang.String ATTRIBUTE1;

    private java.lang.String ATTRIBUTE2;

    private java.lang.String ATTRIBUTE3;

    private java.lang.String ATTRIBUTE4;

    public APPSXXDC_PROCESS_SEX1794747X1X57() {
    }

    public APPSXXDC_PROCESS_SEX1794747X1X57(
           java.lang.String PARAM_ID,
           java.lang.String PROC_STATUS,
           java.lang.String PROC_MESSAGE,
           java.lang.String ATTRIBUTE1,
           java.lang.String ATTRIBUTE2,
           java.lang.String ATTRIBUTE3,
           java.lang.String ATTRIBUTE4) {
           this.PARAM_ID = PARAM_ID;
           this.PROC_STATUS = PROC_STATUS;
           this.PROC_MESSAGE = PROC_MESSAGE;
           this.ATTRIBUTE1 = ATTRIBUTE1;
           this.ATTRIBUTE2 = ATTRIBUTE2;
           this.ATTRIBUTE3 = ATTRIBUTE3;
           this.ATTRIBUTE4 = ATTRIBUTE4;
    }


    /**
     * Gets the PARAM_ID value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return PARAM_ID
     */
    public java.lang.String getPARAM_ID() {
        return PARAM_ID;
    }


    /**
     * Sets the PARAM_ID value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param PARAM_ID
     */
    public void setPARAM_ID(java.lang.String PARAM_ID) {
        this.PARAM_ID = PARAM_ID;
    }


    /**
     * Gets the PROC_STATUS value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return PROC_STATUS
     */
    public java.lang.String getPROC_STATUS() {
        return PROC_STATUS;
    }


    /**
     * Sets the PROC_STATUS value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param PROC_STATUS
     */
    public void setPROC_STATUS(java.lang.String PROC_STATUS) {
        this.PROC_STATUS = PROC_STATUS;
    }


    /**
     * Gets the PROC_MESSAGE value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return PROC_MESSAGE
     */
    public java.lang.String getPROC_MESSAGE() {
        return PROC_MESSAGE;
    }


    /**
     * Sets the PROC_MESSAGE value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param PROC_MESSAGE
     */
    public void setPROC_MESSAGE(java.lang.String PROC_MESSAGE) {
        this.PROC_MESSAGE = PROC_MESSAGE;
    }


    /**
     * Gets the ATTRIBUTE1 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return ATTRIBUTE1
     */
    public java.lang.String getATTRIBUTE1() {
        return ATTRIBUTE1;
    }


    /**
     * Sets the ATTRIBUTE1 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param ATTRIBUTE1
     */
    public void setATTRIBUTE1(java.lang.String ATTRIBUTE1) {
        this.ATTRIBUTE1 = ATTRIBUTE1;
    }


    /**
     * Gets the ATTRIBUTE2 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return ATTRIBUTE2
     */
    public java.lang.String getATTRIBUTE2() {
        return ATTRIBUTE2;
    }


    /**
     * Sets the ATTRIBUTE2 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param ATTRIBUTE2
     */
    public void setATTRIBUTE2(java.lang.String ATTRIBUTE2) {
        this.ATTRIBUTE2 = ATTRIBUTE2;
    }


    /**
     * Gets the ATTRIBUTE3 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return ATTRIBUTE3
     */
    public java.lang.String getATTRIBUTE3() {
        return ATTRIBUTE3;
    }


    /**
     * Sets the ATTRIBUTE3 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param ATTRIBUTE3
     */
    public void setATTRIBUTE3(java.lang.String ATTRIBUTE3) {
        this.ATTRIBUTE3 = ATTRIBUTE3;
    }


    /**
     * Gets the ATTRIBUTE4 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @return ATTRIBUTE4
     */
    public java.lang.String getATTRIBUTE4() {
        return ATTRIBUTE4;
    }


    /**
     * Sets the ATTRIBUTE4 value for this APPSXXDC_PROCESS_SEX1794747X1X57.
     * 
     * @param ATTRIBUTE4
     */
    public void setATTRIBUTE4(java.lang.String ATTRIBUTE4) {
        this.ATTRIBUTE4 = ATTRIBUTE4;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof APPSXXDC_PROCESS_SEX1794747X1X57)) return false;
        APPSXXDC_PROCESS_SEX1794747X1X57 other = (APPSXXDC_PROCESS_SEX1794747X1X57) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PARAM_ID==null && other.getPARAM_ID()==null) || 
             (this.PARAM_ID!=null &&
              this.PARAM_ID.equals(other.getPARAM_ID()))) &&
            ((this.PROC_STATUS==null && other.getPROC_STATUS()==null) || 
             (this.PROC_STATUS!=null &&
              this.PROC_STATUS.equals(other.getPROC_STATUS()))) &&
            ((this.PROC_MESSAGE==null && other.getPROC_MESSAGE()==null) || 
             (this.PROC_MESSAGE!=null &&
              this.PROC_MESSAGE.equals(other.getPROC_MESSAGE()))) &&
            ((this.ATTRIBUTE1==null && other.getATTRIBUTE1()==null) || 
             (this.ATTRIBUTE1!=null &&
              this.ATTRIBUTE1.equals(other.getATTRIBUTE1()))) &&
            ((this.ATTRIBUTE2==null && other.getATTRIBUTE2()==null) || 
             (this.ATTRIBUTE2!=null &&
              this.ATTRIBUTE2.equals(other.getATTRIBUTE2()))) &&
            ((this.ATTRIBUTE3==null && other.getATTRIBUTE3()==null) || 
             (this.ATTRIBUTE3!=null &&
              this.ATTRIBUTE3.equals(other.getATTRIBUTE3()))) &&
            ((this.ATTRIBUTE4==null && other.getATTRIBUTE4()==null) || 
             (this.ATTRIBUTE4!=null &&
              this.ATTRIBUTE4.equals(other.getATTRIBUTE4())));
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
        if (getPARAM_ID() != null) {
            _hashCode += getPARAM_ID().hashCode();
        }
        if (getPROC_STATUS() != null) {
            _hashCode += getPROC_STATUS().hashCode();
        }
        if (getPROC_MESSAGE() != null) {
            _hashCode += getPROC_MESSAGE().hashCode();
        }
        if (getATTRIBUTE1() != null) {
            _hashCode += getATTRIBUTE1().hashCode();
        }
        if (getATTRIBUTE2() != null) {
            _hashCode += getATTRIBUTE2().hashCode();
        }
        if (getATTRIBUTE3() != null) {
            _hashCode += getATTRIBUTE3().hashCode();
        }
        if (getATTRIBUTE4() != null) {
            _hashCode += getATTRIBUTE4().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(APPSXXDC_PROCESS_SEX1794747X1X57.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "APPS.XXDC_PROCESS_SEX1794747X1X57"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PARAM_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "PARAM_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROC_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "PROC_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROC_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "PROC_MESSAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ATTRIBUTE1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "ATTRIBUTE1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ATTRIBUTE2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "ATTRIBUTE2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ATTRIBUTE3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "ATTRIBUTE3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ATTRIBUTE4");
        elemField.setXmlName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_process_service_ws/process/", "ATTRIBUTE4"));
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
