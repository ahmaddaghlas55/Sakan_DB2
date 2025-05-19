package com.sample;


public class Sakanpayment {

  private long cashpaymentId;
  private java.sql.Date paymentdate;
  private long amount;
  private long customerId;
  private long adminId;


  public long getCashpaymentId() {
    return cashpaymentId;
  }

  public void setCashpaymentId(long cashpaymentId) {
    this.cashpaymentId = cashpaymentId;
  }


  public java.sql.Date getPaymentdate() {
    return paymentdate;
  }

  public void setPaymentdate(java.sql.Date paymentdate) {
    this.paymentdate = paymentdate;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  public long getAdminId() {
    return adminId;
  }

  public void setAdminId(long adminId) {
    this.adminId = adminId;
  }

}
