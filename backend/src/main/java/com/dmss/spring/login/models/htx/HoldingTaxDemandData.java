package com.dmss.spring.login.models.htx;

import java.util.Date;

public interface HoldingTaxDemandData {
   Date getBillingDate() ;

     String getUsertype() ;

     Long getOrderID();

     Long getOidHolding() ;

     String getHoldingNo() ;

     Integer getYearQuarter();

     Integer getOwnerUserID();

     String getOwnerID() ;

     String getOwnerName() ;

     Double getAnnualValue1() ;

     Double getAnnualValue2() ;

     Double getAnnualValue3() ;

     Double getAnnualValue4() ;

     Double getOthersRate() ;

     Double getArrearFees() ;

     Double getSurCharge();

     Double getYearTotalBill() ;

     Double getUnpaidBill();

     Double getQuarter1Tax() ;

     Double getQuarter2Tax() ;

     Double getQuarter3Tax();

     Double getQuarter4Tax() ;

     Double getOfficialValue() ;
     Date getIssueDate() ;

     Date getPaidDate() ;

     Double getPaidMoney();

     Double getFinallyUnpaid();

     String getBankName();

    public String getBranchName();

    public String getSerialNo();

    public Integer getOfflinePayRegisterID();
}
