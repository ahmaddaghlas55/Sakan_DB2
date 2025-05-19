package com.sample;


public class Sakanpropertysale {

  private long propertyId;
  private long customerId;
  private java.sql.Date dateofpurchase;
  private long amount;


  public long getPropertyId() {
    return propertyId;
  }

  public void setPropertyId(long propertyId) {
    this.propertyId = propertyId;
  }


  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  public java.sql.Date getDateofpurchase() {
    return dateofpurchase;
  }

  public void setDateofpurchase(java.sql.Date dateofpurchase) {
    this.dateofpurchase = dateofpurchase;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

}
