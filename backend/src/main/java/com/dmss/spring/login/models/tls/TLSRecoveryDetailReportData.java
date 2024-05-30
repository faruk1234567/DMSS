package com.dmss.spring.login.models.tls;

import java.util.Date;

public class TLSRecoveryDetailReportData {

    private String serialNo;
    private String licenseNo;
    private String mobileNo;
    private String customer;
    private String category;
    private String signboardType;
    private Integer height;
    private Integer width;
    private Double licenseFee;
    private Double sourceTax;
    private Double vat;
    private Double incomeTax;
    private Double signboardPerSqft;
    private Double signboardFee;
    private Double arrearFee;
    private Double otherFee;
    private Double arrearVat;
    private String createdDate;
    private Date tranDate;
    private Double tranAmt;

    public TLSRecoveryDetailReportData() {
    }

    public TLSRecoveryDetailReportData(String serialNo, String licenseNo, String mobileNo, String customer, String category, String signboardType, Integer height, Integer width, Double licenseFee, Double sourceTax, Double vat, Double incomeTax, Double signboardPerSqft, Double signboardFee, Double arrearFee, Double otherFee, Double arrearVat, String createdDate, Date tranDate, Double tranAmt) {
        this.serialNo = serialNo;
        this.licenseNo = licenseNo;
        this.mobileNo = mobileNo;
        this.customer = customer;
        this.category = category;
        this.signboardType = signboardType;
        this.height = height;
        this.width = width;
        this.licenseFee = licenseFee;
        this.sourceTax = sourceTax;
        this.vat = vat;
        this.incomeTax = incomeTax;
        this.signboardPerSqft = signboardPerSqft;
        this.signboardFee = signboardFee;
        this.arrearFee = arrearFee;
        this.otherFee = otherFee;
        this.arrearVat = arrearVat;
        this.createdDate = createdDate;
        this.tranDate = tranDate;
        this.tranAmt = tranAmt;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSignboardType() {
        return signboardType;
    }

    public void setSignboardType(String signboardType) {
        this.signboardType = signboardType;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Double getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(Double licenseFee) {
        this.licenseFee = licenseFee;
    }

    public Double getSourceTax() {
        return sourceTax;
    }

    public void setSourceTax(Double sourceTax) {
        this.sourceTax = sourceTax;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(Double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Double getSignboardPerSqft() {
        return signboardPerSqft;
    }

    public void setSignboardPerSqft(Double signboardPerSqft) {
        this.signboardPerSqft = signboardPerSqft;
    }

    public Double getSignboardFee() {
        return signboardFee;
    }

    public void setSignboardFee(Double signboardFee) {
        this.signboardFee = signboardFee;
    }

    public Double getArrearFee() {
        return arrearFee;
    }

    public void setArrearFee(Double arrearFee) {
        this.arrearFee = arrearFee;
    }

    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    public Double getArrearVat() {
        return arrearVat;
    }

    public void setArrearVat(Double arrearVat) {
        this.arrearVat = arrearVat;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public Double getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(Double tranAmt) {
        this.tranAmt = tranAmt;
    }

    @Override
    public String toString() {
        return "TLSRecoveryDetailReportData{" +
                "serialNo='" + serialNo + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", customer='" + customer + '\'' +
                ", category='" + category + '\'' +
                ", signboardType='" + signboardType + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", licenseFee=" + licenseFee +
                ", sourceTax=" + sourceTax +
                ", vat=" + vat +
                ", incomeTax=" + incomeTax +
                ", signboardPerSqft=" + signboardPerSqft +
                ", signboardFee=" + signboardFee +
                ", arrearFee=" + arrearFee +
                ", otherFee=" + otherFee +
                ", arrearVat=" + arrearVat +
                ", createdDate=" + createdDate +
                ", tranDate=" + tranDate +
                ", tranAmt=" + tranAmt +
                '}';
    }

    public void convertTLSRecoveryDetailReportData(TLSRecoveryData tlsRecoveryData) {
        this.setSerialNo(tlsRecoveryData.getSerialNo());
        this.setLicenseNo(tlsRecoveryData.getLicenseNo());
        this.setMobileNo(tlsRecoveryData.getMobileNo());
        this.setCustomer(tlsRecoveryData.getCustomer());
        this.setCategory(tlsRecoveryData.getCategory());
        this.setSignboardType(tlsRecoveryData.getSignboardType());
        this.setHeight(tlsRecoveryData.getHeight());
        this.setWidth(tlsRecoveryData.getWidth());
        this.setLicenseFee(tlsRecoveryData.getLicenseFee());
        this.setSourceTax(tlsRecoveryData.getSourceTax());
        this.setVat(tlsRecoveryData.getVat());
        this.setIncomeTax(tlsRecoveryData.getIncomeTax());
        this.setSignboardPerSqft(tlsRecoveryData.getSignboardPerSqft());
        this.setSignboardFee(tlsRecoveryData.getSignboardFee());
        this.setArrearFee(tlsRecoveryData.getArrearFee());
        this.setOtherFee(tlsRecoveryData.getOtherFee());
        this.setArrearVat(tlsRecoveryData.getArrearVat());
        this.setCreatedDate(tlsRecoveryData.getCreatedDate());
        this.setTranDate(tlsRecoveryData.getTranDate());
        this.setTranAmt(tlsRecoveryData.getTranAmount());
    }
}
