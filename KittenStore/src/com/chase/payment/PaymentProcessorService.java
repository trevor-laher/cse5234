/**
 * PaymentProcessorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chase.payment;

public interface PaymentProcessorService extends javax.xml.rpc.Service {
    public java.lang.String getPaymentProcessorAddress();

    public com.chase.payment.PaymentProcessor getPaymentProcessor() throws javax.xml.rpc.ServiceException;

    public com.chase.payment.PaymentProcessor getPaymentProcessor(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
