/**
 * XXDC_AOPT_PKG_WS_BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws;

import org.apache.axis.message.MessageElement;
import org.apache.axis.message.PrefixedQName;

public class XXDC_AOPT_PKG_WS_BindingStub extends org.apache.axis.client.Stub implements com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.XXDC_AOPT_PKG_WS_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AOPT_REGISTRATION_DETAILS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/aopt_registration_details/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/aopt_registration_details/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/aopt_registration_details/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/aopt_registration_details/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GET_MASTER_MILESTONE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GET_MILESTONE_PAYMENT_DET");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PAYMENT_PLAN_CREATION");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PAYMENT_PLAN_REVERSAL");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_reversal/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_reversal/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_reversal/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_reversal/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PRIOR_AOPT_DETAILS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RETRIVAL_PROCESS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", "SOAHeader"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class, true, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", "InputParameters"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">InputParameters"), com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.InputParameters.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">OutputParameters"));
        oper.setReturnClass(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", "OutputParameters"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

    }

    public XXDC_AOPT_PKG_WS_BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public XXDC_AOPT_PKG_WS_BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public XXDC_AOPT_PKG_WS_BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/aopt_registration_details/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/aopt_registration_details/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">APPS.XXDC_AOPT_PKG_WSX1843128X8X3>ARABIC_MILESTONE_EVENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">APPS.XXDC_AOPT_PKG_WSX1843128X8X3>MILESTONE_EVENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "APPS.XXDC_AOPT_PKG_WSX1843128X8X2");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.APPSXXDC_AOPT_PKG_WSX1843128X8X3[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "APPS.XXDC_AOPT_PKG_WSX1843128X8X3");
            qName2 = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "X_MILESTONE_TAB_TYPE_ITEM");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_master_milestone/", "APPS.XXDC_AOPT_PKG_WSX1843128X8X3");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.APPSXXDC_AOPT_PKG_WSX1843128X8X3.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>DESCRIPTION");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>DUE_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>DUE_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>INSTALLMENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>INVOICE_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>LINE_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>MILESTEON_PERCENT_VALUE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>MILESTONE_EVENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>MILESTONE_EVENT_AR");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>PAID_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>PAID_PERCENTAGE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>REGISTRATION_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">APPS.XXDC_AOPT_PKG_WSX1843128X9X3>TERM_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", "APPS.XXDC_AOPT_PKG_WSX1843128X9X2");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.APPSXXDC_AOPT_PKG_WSX1843128X9X3[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", "APPS.XXDC_AOPT_PKG_WSX1843128X9X3");
            qName2 = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", "X_REG_TERM_PYMNT_TABLE_ITEM");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/get_milestone_payment_det/", "APPS.XXDC_AOPT_PKG_WSX1843128X9X3");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.APPSXXDC_AOPT_PKG_WSX1843128X9X3.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>DESCRIPTION");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>EXPECTED_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>INSTALLMENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>LINE_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>MILESTONE_EVENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>PAYMENT_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>PAYMENT_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>PDC_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>PDC_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>PDC_NUMBER");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>PERCENT_VALUE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>REGISTRATION_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>STATUS");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>TERM_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">APPS.XXDC_AOPT_PKG_WSX1843128X6X5>TRANSFER_AR_INTER_FLAG");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "APPS.XXDC_AOPT_PKG_WSX1843128X6X4");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "APPS.XXDC_AOPT_PKG_WSX1843128X6X5");
            qName2 = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "P_REG_TERMS_ITEM");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_creation/", "APPS.XXDC_AOPT_PKG_WSX1843128X6X5");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.APPSXXDC_AOPT_PKG_WSX1843128X6X5.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_reversal/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/payment_plan_reversal/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>DESCRIPTION");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>EXPECTED_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>INSTALLMENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>LINE_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>MILESTONE_EVENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>PAYMENT_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>PAYMENT_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>PDC_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>PDC_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>PDC_NUMBER");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>PERCENT_VALUE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>REGISTRATION_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>STATUS");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>TERM_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">APPS.XXDC_AOPT_PKG_WSX1843128X4X4>TRANSFER_AR_INTER_FLAG");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", "APPS.XXDC_AOPT_PKG_WSX1843128X4X3");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.APPSXXDC_AOPT_PKG_WSX1843128X4X4[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", "APPS.XXDC_AOPT_PKG_WSX1843128X4X4");
            qName2 = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", "X_PRIOR_REG_TERMS_TABLE_ITEM");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/prior_aopt_details/", "APPS.XXDC_AOPT_PKG_WSX1843128X4X4");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.APPSXXDC_AOPT_PKG_WSX1843128X4X4.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>DESCRIPTION");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>EXPECTED_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>INSTALLMENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>LINE_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>MILESTONE_EVENT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>PAYMENT_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>PAYMENT_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>PDC_AMOUNT");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>PDC_DATE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>PDC_NUMBER");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>PERCENT_VALUE");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>REGISTRATION_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>STATUS");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>TERM_ID");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">APPS.XXDC_AOPT_PKG_WSX1843128X1X4>TRANSFER_AR_INTER_FLAG");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">InputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.InputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", ">OutputParameters");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", "APPS.XXDC_AOPT_PKG_WSX1843128X1X3");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.APPSXXDC_AOPT_PKG_WSX1843128X1X4[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", "APPS.XXDC_AOPT_PKG_WSX1843128X1X4");
            qName2 = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", "X_REG_TYPE_RECORDS_ITEM");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/retrival_process/", "APPS.XXDC_AOPT_PKG_WSX1843128X1X4");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.APPSXXDC_AOPT_PKG_WSX1843128X1X4.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://xmlns.oracle.com/apps/ont/soaprovider/plsql/xxdc_aopt_pkg_ws/", ">SOAHeader");
            cachedSerQNames.add(qName);
            cls = com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            org.apache.axis.message.SOAPHeaderElement wsseSecurity = new org.apache.axis.message.SOAPHeaderElement(new PrefixedQName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd","Security", "wsse"));
            String nullString = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
            MessageElement usernameToken = new MessageElement(nullString, "wsse:UsernameToken");
            MessageElement username = new MessageElement(nullString, "wsse:Username");
            MessageElement password = new MessageElement(nullString, "wsse:Password");
            username.setObjectValue("oracle_user");
            usernameToken.addChild(username);
            password.setObjectValue("crp1user");
            usernameToken.addChild(password);
            wsseSecurity.addChild(usernameToken);
            
            _call.addHeader(wsseSecurity);
            
            
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters AOPT_REGISTRATION_DETAILS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AOPT_REGISTRATION_DETAILS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.aopt_registration_details.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters GET_MASTER_MILESTONE(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GET_MASTER_MILESTONE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_master_milestone.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters GET_MILESTONE_PAYMENT_DET(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GET_MILESTONE_PAYMENT_DET"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.get_milestone_payment_det.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters PAYMENT_PLAN_CREATION(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PAYMENT_PLAN_CREATION"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_creation.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters PAYMENT_PLAN_REVERSAL(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PAYMENT_PLAN_REVERSAL"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.payment_plan_reversal.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters PRIOR_AOPT_DETAILS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PRIOR_AOPT_DETAILS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.prior_aopt_details.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters RETRIVAL_PROCESS(com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.SOAHeader header, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.InputParameters body) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("https://dxbhoebizapp.damacholding.home/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        //_call.setSOAPActionURI("http://83.111.194.181:8045/webservices/SOAProvider/plsql/xxdc_aopt_pkg_ws/");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RETRIVAL_PROCESS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {header, body});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters) org.apache.axis.utils.JavaUtils.convert(_resp, com.oracle.xmlns.apps.ont.soaprovider.plsql.xxdc_aopt_pkg_ws.retrival_process.OutputParameters.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
