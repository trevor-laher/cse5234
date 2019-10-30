package com.chase.payment;

public class PaymentProcessorProxy implements com.chase.payment.PaymentProcessor {
  private String _endpoint = null;
  private com.chase.payment.PaymentProcessor paymentProcessor = null;
  
  public PaymentProcessorProxy() {
    _initPaymentProcessorProxy();
  }
  
  public PaymentProcessorProxy(String endpoint) {
    _endpoint = endpoint;
    _initPaymentProcessorProxy();
  }
  
  private void _initPaymentProcessorProxy() {
    try {
      paymentProcessor = new PaymentProcessorServiceLocator().getPaymentProcessor();
      if (paymentProcessor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)paymentProcessor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)paymentProcessor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (paymentProcessor != null)
      ((javax.xml.rpc.Stub)paymentProcessor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.chase.payment.PaymentProcessor getPaymentProcessor() {
    if (paymentProcessor == null)
      _initPaymentProcessorProxy();
    return paymentProcessor;
  }
  
  public java.lang.String ping() throws java.rmi.RemoteException{
    if (paymentProcessor == null)
      _initPaymentProcessorProxy();
    return paymentProcessor.ping();
  }
  
  public java.lang.String processPayment(com.chase.payment.CreditCardPayment payment) throws java.rmi.RemoteException{
    if (paymentProcessor == null)
      _initPaymentProcessorProxy();
    return paymentProcessor.processPayment(payment);
  }
  
  
}