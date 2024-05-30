package com.dmss.spring.login.models.PB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_propertyleasebill")
@IdClass(PropertyBillIdClass.class)
public class PropertyBill {

    private Integer MunicipalityID;
    private Long OrderID;

    @Id
    private Long oidProperty;

    private String PropertyID;
    private String BengaliYear;

    @Id
    private Integer BillYearMonth;
    private Long oidCustomer;
    private Integer CustomerUserID;
    private String CustomerID;
    private String CustomerName;
    private Date LastPayment;
    private Double OfficialValue;
    private Double Rent;
    private Double ArrearRent;
    private Double Others;
    private Double Surcharge;
    private Double VAT;
    private Double TotalBill;
    private Date IssueDate;
    private Date PaidDate;
    private Double PaidMoney;
    private Double FinallyUnpaid;
    private String BankName;
    private String BranchName;
    private String SerialNo;
    private Integer OfflinePayRegisterID;

    public PropertyBill(Integer municipalityID, Long orderID, Long oidProperty, String propertyID, String bengaliYear, Integer billYearMonth, Long oidCustomer, Integer customerUserID, String customerID, String customerName, Date lastPayment, Double officialValue, Double rent, Double arrearRent, Double others, Double surcharge, Double VAT, Double totalBill, Date issueDate, Date paidDate, Double paidMoney, Double finallyUnpaid, String bankName, String branchName, String serialNo, Integer offlinePayRegisterID) {
        MunicipalityID = municipalityID;
        OrderID = orderID;
        this.oidProperty = oidProperty;
        PropertyID = propertyID;
        BengaliYear = bengaliYear;
        BillYearMonth = billYearMonth;
        this.oidCustomer = oidCustomer;
        CustomerUserID = customerUserID;
        CustomerID = customerID;
        CustomerName = customerName;
        LastPayment = lastPayment;
        OfficialValue = officialValue;
        Rent = rent;
        ArrearRent = arrearRent;
        Others = others;
        Surcharge = surcharge;
        this.VAT = VAT;
        TotalBill = totalBill;
        IssueDate = issueDate;
        PaidDate = paidDate;
        PaidMoney = paidMoney;
        FinallyUnpaid = finallyUnpaid;
        BankName = bankName;
        BranchName = branchName;
        SerialNo = serialNo;
        OfflinePayRegisterID = offlinePayRegisterID;
    }

    public PropertyBill() {

    }

    public Integer getMunicipalityID() {
        return MunicipalityID;
    }

    public void setMunicipalityID(Integer municipalityID) {
        MunicipalityID = municipalityID;
    }

    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long orderID) {
        OrderID = orderID;
    }

    public Long getOidProperty() {
        return oidProperty;
    }

    public void setOidProperty(Long oidProperty) {
        this.oidProperty = oidProperty;
    }

    public String getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(String propertyID) {
        PropertyID = propertyID;
    }

    public String getBengaliYear() {
        return BengaliYear;
    }

    public void setBengaliYear(String bengaliYear) {
        BengaliYear = bengaliYear;
    }

    public Integer getBillYearMonth() {
        return BillYearMonth;
    }

    public void setBillYearMonth(Integer billYearMonth) {
        BillYearMonth = billYearMonth;
    }

    public Long getOidCustomer() {
        return oidCustomer;
    }

    public void setOidCustomer(Long oidCustomer) {
        this.oidCustomer = oidCustomer;
    }

    public Integer getCustomerUserID() {
        return CustomerUserID;
    }

    public void setCustomerUserID(Integer customerUserID) {
        CustomerUserID = customerUserID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Date getLastPayment() {
        return LastPayment;
    }

    public void setLastPayment(Date lastPayment) {
        LastPayment = lastPayment;
    }

    public Double getOfficialValue() {
        return OfficialValue;
    }

    public void setOfficialValue(Double officialValue) {
        OfficialValue = officialValue;
    }

    public Double getRent() {
        return Rent;
    }

    public void setRent(Double rent) {
        Rent = rent;
    }

    public Double getArrearRent() {
        return ArrearRent;
    }

    public void setArrearRent(Double arrearRent) {
        ArrearRent = arrearRent;
    }

    public Double getOthers() {
        return Others;
    }

    public void setOthers(Double others) {
        Others = others;
    }

    public Double getSurcharge() {
        return Surcharge;
    }

    public void setSurcharge(Double surcharge) {
        Surcharge = surcharge;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public Double getTotalBill() {
        return TotalBill;
    }

    public void setTotalBill(Double totalBill) {
        TotalBill = totalBill;
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
}
