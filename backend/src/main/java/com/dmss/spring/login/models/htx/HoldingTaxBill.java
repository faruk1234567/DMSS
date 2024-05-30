package com.dmss.spring.login.models.htx;



import javax.persistence.*;
import java.util.Date;



@Entity

@Table(name = "t_holdingtaxbill")
@IdClass(HoldingTaxBillIdClass.class)
public class HoldingTaxBill {
    private Date BillingDate;

    private String usertype;

    private Long OrderID;



    @Id
    private Long oidHolding;
    private String HoldingNo;
    @Id
    private Integer YearQuarter;
    private Integer OwnerUserID;
    private String OwnerID;
    private String OwnerName;
    private Double AnnualValue1;
    private Double AnnualValue2;
    private Double AnnualValue3;
    private Double AnnualValue4;
    private Double OthersRate;
    private Double ArrearFees;
    private Double SurCharge;
    private Double YearTotalBill;
    private Double UnpaidBill;
    private Double Quarter1Tax;
    private Double Quarter2Tax;
    private Double Quarter3Tax;
    private Double Quarter4Tax;
    private Double OfficialValue;
    private Date IssueDate;
    private Date PaidDate;
    private Double PaidMoney;
    private Double FinallyUnpaid;
    private String BankName;
    private String BranchName;
    private String SerialNo;
    private Integer OfflinePayRegisterID;
    @ManyToOne(optional=false)
    @JoinColumn(name="oidHolding",referencedColumnName="oid",insertable=false, updatable=false)
    private t_board_ct1035 t_board_ct1035;
    public HoldingTaxBill() {
    }

    public HoldingTaxBill(Date billingDate, String usertype, Long orderID, Long oidHolding, String holdingNo, Integer yearQuarter, Integer ownerUserID, String ownerID, String ownerName, Double annualValue1, Double annualValue2, Double annualValue3, Double annualValue4, Double othersRate, Double arrearFees, Double surCharge, Double yearTotalBill, Double unpaidBill, Double quarter1Tax, Double quarter2Tax, Double quarter3Tax, Double quarter4Tax, Double officialValue, Date issueDate, Date paidDate, Double paidMoney, Double finallyUnpaid, String bankName, String branchName, String serialNo, Integer offlinePayRegisterID, com.dmss.spring.login.models.htx.t_board_ct1035 t_board_ct1035) {
        BillingDate = billingDate;
        this.usertype = usertype;
        OrderID = orderID;
        this.oidHolding = oidHolding;
        HoldingNo = holdingNo;
        YearQuarter = yearQuarter;
        OwnerUserID = ownerUserID;
        OwnerID = ownerID;
        OwnerName = ownerName;
        AnnualValue1 = annualValue1;
        AnnualValue2 = annualValue2;
        AnnualValue3 = annualValue3;
        AnnualValue4 = annualValue4;
        OthersRate = othersRate;
        ArrearFees = arrearFees;
        SurCharge = surCharge;
        YearTotalBill = yearTotalBill;
        UnpaidBill = unpaidBill;
        Quarter1Tax = quarter1Tax;
        Quarter2Tax = quarter2Tax;
        Quarter3Tax = quarter3Tax;
        Quarter4Tax = quarter4Tax;
        OfficialValue = officialValue;
        IssueDate = issueDate;
        PaidDate = paidDate;
        PaidMoney = paidMoney;
        FinallyUnpaid = finallyUnpaid;
        BankName = bankName;
        BranchName = branchName;
        SerialNo = serialNo;
        OfflinePayRegisterID = offlinePayRegisterID;
        this.t_board_ct1035 = t_board_ct1035;
    }

    public Date getBillingDate() {
        return BillingDate;
    }

    public void setBillingDate(Date billingDate) {
        BillingDate = billingDate;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long orderID) {
        OrderID = orderID;
    }

    public Long getOidHolding() {
        return oidHolding;
    }

    public void setOidHolding(Long oidHolding) {
        this.oidHolding = oidHolding;
    }

    public String getHoldingNo() {
        return HoldingNo;
    }

    public void setHoldingNo(String holdingNo) {
        HoldingNo = holdingNo;
    }

    public Integer getYearQuarter() {
        return YearQuarter;
    }

    public void setYearQuarter(Integer yearQuarter) {
        YearQuarter = yearQuarter;
    }

    public Integer getOwnerUserID() {
        return OwnerUserID;
    }

    public void setOwnerUserID(Integer ownerUserID) {
        OwnerUserID = ownerUserID;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String ownerID) {
        OwnerID = ownerID;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public Double getAnnualValue1() {
        return AnnualValue1;
    }

    public void setAnnualValue1(Double annualValue1) {
        AnnualValue1 = annualValue1;
    }

    public Double getAnnualValue2() {
        return AnnualValue2;
    }

    public void setAnnualValue2(Double annualValue2) {
        AnnualValue2 = annualValue2;
    }

    public Double getAnnualValue3() {
        return AnnualValue3;
    }

    public void setAnnualValue3(Double annualValue3) {
        AnnualValue3 = annualValue3;
    }

    public Double getAnnualValue4() {
        return AnnualValue4;
    }

    public void setAnnualValue4(Double annualValue4) {
        AnnualValue4 = annualValue4;
    }

    public Double getOthersRate() {
        return OthersRate;
    }

    public void setOthersRate(Double othersRate) {
        OthersRate = othersRate;
    }

    public Double getArrearFees() {
        return ArrearFees;
    }

    public void setArrearFees(Double arrearFees) {
        ArrearFees = arrearFees;
    }

    public Double getSurCharge() {
        return SurCharge;
    }

    public void setSurCharge(Double surCharge) {
        SurCharge = surCharge;
    }

    public Double getYearTotalBill() {
        return YearTotalBill;
    }

    public void setYearTotalBill(Double yearTotalBill) {
        YearTotalBill = yearTotalBill;
    }

    public Double getUnpaidBill() {
        return UnpaidBill;
    }

    public void setUnpaidBill(Double unpaidBill) {
        UnpaidBill = unpaidBill;
    }

    public Double getQuarter1Tax() {
        return Quarter1Tax;
    }

    public void setQuarter1Tax(Double quarter1Tax) {
        Quarter1Tax = quarter1Tax;
    }

    public Double getQuarter2Tax() {
        return Quarter2Tax;
    }

    public void setQuarter2Tax(Double quarter2Tax) {
        Quarter2Tax = quarter2Tax;
    }

    public Double getQuarter3Tax() {
        return Quarter3Tax;
    }

    public void setQuarter3Tax(Double quarter3Tax) {
        Quarter3Tax = quarter3Tax;
    }

    public Double getQuarter4Tax() {
        return Quarter4Tax;
    }

    public void setQuarter4Tax(Double quarter4Tax) {
        Quarter4Tax = quarter4Tax;
    }

    public Double getOfficialValue() {
        return OfficialValue;
    }

    public void setOfficialValue(Double officialValue) {
        OfficialValue = officialValue;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public Date getPaidDate() {
        return PaidDate;
    }

    public void setPaidDate(Date paidDate) {
        PaidDate = paidDate;
    }

    public Double getPaidMoney() {
        return PaidMoney;
    }

    public void setPaidMoney(Double paidMoney) {
        PaidMoney = paidMoney;
    }

    public Double getFinallyUnpaid() {
        return FinallyUnpaid;
    }

    public void setFinallyUnpaid(Double finallyUnpaid) {
        FinallyUnpaid = finallyUnpaid;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    public Integer getOfflinePayRegisterID() {
        return OfflinePayRegisterID;
    }

    public void setOfflinePayRegisterID(Integer offlinePayRegisterID) {
        OfflinePayRegisterID = offlinePayRegisterID;
    }

    public com.dmss.spring.login.models.htx.t_board_ct1035 getT_board_ct1035() {
        return t_board_ct1035;
    }

    public void setT_board_ct1035(com.dmss.spring.login.models.htx.t_board_ct1035 t_board_ct1035) {
        this.t_board_ct1035 = t_board_ct1035;
    }

    @Override
    public String toString() {
        return "HoldingTaxBill{" +
                "BillingDate=" + BillingDate +
                ", usertype='" + usertype + '\'' +
                ", OrderID=" + OrderID +
                ", oidHolding=" + oidHolding +
                ", HoldingNo='" + HoldingNo + '\'' +
                ", YearQuarter=" + YearQuarter +
                ", OwnerUserID=" + OwnerUserID +
                ", OwnerID='" + OwnerID + '\'' +
                ", OwnerName='" + OwnerName + '\'' +
                ", AnnualValue1=" + AnnualValue1 +
                ", AnnualValue2=" + AnnualValue2 +
                ", AnnualValue3=" + AnnualValue3 +
                ", AnnualValue4=" + AnnualValue4 +
                ", OthersRate=" + OthersRate +
                ", ArrearFees=" + ArrearFees +
                ", SurCharge=" + SurCharge +
                ", YearTotalBill=" + YearTotalBill +
                ", UnpaidBill=" + UnpaidBill +
                ", Quarter1Tax=" + Quarter1Tax +
                ", Quarter2Tax=" + Quarter2Tax +
                ", Quarter3Tax=" + Quarter3Tax +
                ", Quarter4Tax=" + Quarter4Tax +
                ", OfficialValue=" + OfficialValue +
                ", IssueDate=" + IssueDate +
                ", PaidDate=" + PaidDate +
                ", PaidMoney=" + PaidMoney +
                ", FinallyUnpaid=" + FinallyUnpaid +
                ", BankName='" + BankName + '\'' +
                ", BranchName='" + BranchName + '\'' +
                ", SerialNo='" + SerialNo + '\'' +
                ", OfflinePayRegisterID=" + OfflinePayRegisterID +
                ", t_board_ct1035=" + t_board_ct1035 +
                '}';
    }
}
