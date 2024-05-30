package com.dmss.spring.login.models.wb;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_waterbill")
@IdClass(WaterBillIDClass.class)
public class WaterBill {

    private Integer MunicipalityID;

    @Id
    private Long oidConnection;

    private String ConnectionID;
    private String UseYearMonth;

    @Id
    private String BillYearMonth;

    private Integer UserID;
    private Integer CustomerID;
    private String CustomerName;
    private Date LastPayment;
    private Double LastMonthMeterReading;
    private Date PreviousReadingDate;
    private Double PresentMeterReading;
    private Date PresentMeterReadingDate;
    private Double TotalVolumeUsed;
    private Double MonthlyWaterBill;
    private Double OthersFee;
    private String OthersFeeComment;
    private Double ArrearBill;
    private Double NetBill;
    private Double VAT;
    private Double Surcharge;
    private Double TotalBill;
    private Long BillNo;
    private Date IssueDate;
    private String billingmethod;
    private Double PaidAmount;
    private Date PaidDate;
    private String ConnectionType;
    private String PipeDiameter;
    private String ConnectionStatus;
    private String Remark;
    private Long originOidConnection;
    private String OldConnectionID;
    private String BankName;
    private String BranchName;
    private String SerialNo;
    private Integer NoOfUnit;
    private Integer OfflinePayRegisterID;

    public WaterBill() {
    }

    public WaterBill(Integer municipalityID, Long oidConnection, String connectionID, String useYearMonth, String billYearMonth, Integer userID, Integer customerID, String customerName, Date lastPayment, Double lastMonthMeterReading, Date previousReadingDate, Double presentMeterReading, Date presentMeterReadingDate, Double totalVolumeUsed, Double monthlyWaterBill, Double othersFee, String othersFeeComment, Double arrearBill, Double netBill, Double VAT, Double surcharge, Double totalBill, Long billNo, Date issueDate, String billingmethod, Double paidAmount, Date paidDate, String connectionType, String pipeDiameter, String connectionStatus, String remark, Long originOidConnection, String oldConnectionID, String bankName, String branchName, String serialNo, Integer noOfUnit, Integer offlinePayRegisterID) {
        MunicipalityID = municipalityID;
        this.oidConnection = oidConnection;
        ConnectionID = connectionID;
        UseYearMonth = useYearMonth;
        BillYearMonth = billYearMonth;
        UserID = userID;
        CustomerID = customerID;
        CustomerName = customerName;
        LastPayment = lastPayment;
        LastMonthMeterReading = lastMonthMeterReading;
        PreviousReadingDate = previousReadingDate;
        PresentMeterReading = presentMeterReading;
        PresentMeterReadingDate = presentMeterReadingDate;
        TotalVolumeUsed = totalVolumeUsed;
        MonthlyWaterBill = monthlyWaterBill;
        OthersFee = othersFee;
        OthersFeeComment = othersFeeComment;
        ArrearBill = arrearBill;
        NetBill = netBill;
        this.VAT = VAT;
        Surcharge = surcharge;
        TotalBill = totalBill;
        BillNo = billNo;
        IssueDate = issueDate;
        this.billingmethod = billingmethod;
        PaidAmount = paidAmount;
        PaidDate = paidDate;
        ConnectionType = connectionType;
        PipeDiameter = pipeDiameter;
        ConnectionStatus = connectionStatus;
        Remark = remark;
        this.originOidConnection = originOidConnection;
        OldConnectionID = oldConnectionID;
        BankName = bankName;
        BranchName = branchName;
        SerialNo = serialNo;
        NoOfUnit = noOfUnit;
        OfflinePayRegisterID = offlinePayRegisterID;
    }

    public Integer getMunicipalityID() {
        return MunicipalityID;
    }

    public void setMunicipalityID(Integer municipalityID) {
        MunicipalityID = municipalityID;
    }

    public Long getOidConnection() {
        return oidConnection;
    }

    public void setOidConnection(Long oidConnection) {
        this.oidConnection = oidConnection;
    }

    public String getConnectionID() {
        return ConnectionID;
    }

    public void setConnectionID(String connectionID) {
        ConnectionID = connectionID;
    }

    public String getUseYearMonth() {
        return UseYearMonth;
    }

    public void setUseYearMonth(String useYearMonth) {
        UseYearMonth = useYearMonth;
    }

    public String getBillYearMonth() {
        return BillYearMonth;
    }

    public void setBillYearMonth(String billYearMonth) {
        BillYearMonth = billYearMonth;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer customerID) {
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

    public Double getLastMonthMeterReading() {
        return LastMonthMeterReading;
    }

    public void setLastMonthMeterReading(Double lastMonthMeterReading) {
        LastMonthMeterReading = lastMonthMeterReading;
    }

    public Date getPreviousReadingDate() {
        return PreviousReadingDate;
    }

    public void setPreviousReadingDate(Date previousReadingDate) {
        PreviousReadingDate = previousReadingDate;
    }

    public Double getPresentMeterReading() {
        return PresentMeterReading;
    }

    public void setPresentMeterReading(Double presentMeterReading) {
        PresentMeterReading = presentMeterReading;
    }

    public Date getPresentMeterReadingDate() {
        return PresentMeterReadingDate;
    }

    public void setPresentMeterReadingDate(Date presentMeterReadingDate) {
        PresentMeterReadingDate = presentMeterReadingDate;
    }

    public Double getTotalVolumeUsed() {
        return TotalVolumeUsed;
    }

    public void setTotalVolumeUsed(Double totalVolumeUsed) {
        TotalVolumeUsed = totalVolumeUsed;
    }

    public Double getMonthlyWaterBill() {
        return MonthlyWaterBill;
    }

    public void setMonthlyWaterBill(Double monthlyWaterBill) {
        MonthlyWaterBill = monthlyWaterBill;
    }

    public Double getOthersFee() {
        return OthersFee;
    }

    public void setOthersFee(Double othersFee) {
        OthersFee = othersFee;
    }

    public String getOthersFeeComment() {
        return OthersFeeComment;
    }

    public void setOthersFeeComment(String othersFeeComment) {
        OthersFeeComment = othersFeeComment;
    }

    public Double getArrearBill() {
        return ArrearBill;
    }

    public void setArrearBill(Double arrearBill) {
        ArrearBill = arrearBill;
    }

    public Double getNetBill() {
        return NetBill;
    }

    public void setNetBill(Double netBill) {
        NetBill = netBill;
    }

    public Double getVAT() {
        return VAT;
    }

    public void setVAT(Double VAT) {
        this.VAT = VAT;
    }

    public Double getSurcharge() {
        return Surcharge;
    }

    public void setSurcharge(Double surcharge) {
        Surcharge = surcharge;
    }

    public Double getTotalBill() {
        return TotalBill;
    }

    public void setTotalBill(Double totalBill) {
        TotalBill = totalBill;
    }

    public Long getBillNo() {
        return BillNo;
    }

    public void setBillNo(Long billNo) {
        BillNo = billNo;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public String getBillingmethod() {
        return billingmethod;
    }

    public void setBillingmethod(String billingmethod) {
        this.billingmethod = billingmethod;
    }

    public Double getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        PaidAmount = paidAmount;
    }

    public Date getPaidDate() {
        return PaidDate;
    }

    public void setPaidDate(Date paidDate) {
        PaidDate = paidDate;
    }

    public String getConnectionType() {
        return ConnectionType;
    }

    public void setConnectionType(String connectionType) {
        ConnectionType = connectionType;
    }

    public String getPipeDiameter() {
        return PipeDiameter;
    }

    public void setPipeDiameter(String pipeDiameter) {
        PipeDiameter = pipeDiameter;
    }

    public String getConnectionStatus() {
        return ConnectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        ConnectionStatus = connectionStatus;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public Long getOriginOidConnection() {
        return originOidConnection;
    }

    public void setOriginOidConnection(Long originOidConnection) {
        this.originOidConnection = originOidConnection;
    }

    public String getOldConnectionID() {
        return OldConnectionID;
    }

    public void setOldConnectionID(String oldConnectionID) {
        OldConnectionID = oldConnectionID;
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

    public Integer getNoOfUnit() {
        return NoOfUnit;
    }

    public void setNoOfUnit(Integer noOfUnit) {
        NoOfUnit = noOfUnit;
    }

    public Integer getOfflinePayRegisterID() {
        return OfflinePayRegisterID;
    }

    public void setOfflinePayRegisterID(Integer offlinePayRegisterID) {
        OfflinePayRegisterID = offlinePayRegisterID;
    }
}
