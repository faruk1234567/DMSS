package com.dmss.spring.login.models.tls;

import java.util.Date;

public interface TLSRecoveryData {

    String getSerialNo();
    String getLicenseNo();
    String getMobileNo();
    String getCustomer();
    String getCategory();
    String getSignboardType();
    Integer getHeight();
    Integer getWidth();
    Double getLicenseFee();
    Double getSourceTax();
    Double getVat();
    Double getIncomeTax();
    Double getSignboardPerSqft();
    Double getSignboardFee();
    Double getArrearFee();
    Double getOtherFee();
    Double getArrearVat();
    String getCreatedDate();
    Date getTranDate();
    Double getTranAmount();
}
