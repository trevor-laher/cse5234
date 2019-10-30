/**
 * PaymentProcessor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.chase.payment;

public interface PaymentProcessor extends java.rmi.Remote {
    public java.lang.String ping() throws java.rmi.RemoteException;
    public java.lang.String processPayment(com.chase.payment.CreditCardPayment payment) throws java.rmi.RemoteException;
}
