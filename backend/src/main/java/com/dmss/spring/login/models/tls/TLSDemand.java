package com.dmss.spring.login.models.tls;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_board_ct1021")
public class TLSDemand {
    private Integer CabinetInstanceID;
   @Id
    private Long OID;
    private Integer ApplyType;
    private String signboardType;
    private Integer applyFee;
    private Integer licenseFee;
    private Double vatFee;
    private Integer settlementFee;
    private Integer inComeTax;
    private Double sc;
    private String serialNo;
    private String licenseNo;
    private Integer otherFee;
    private Integer sourceTax;
    private Integer advertisementFee;
    private Integer arrearFee;
    private Double totalFee;

    public TLSDemand() {
    }

    public TLSDemand(Integer cabinetInstanceID, Long OID, Integer applyType, String signboardType, Integer applyFee, Integer licenseFee, Double vatFee, Integer settlementFee, Integer inComeTax, Double sc, String serialNo, String licenseNo, Integer otherFee, Integer sourceTax, Integer advertisementFee, Integer arrearFee, Double totalFee) {
        CabinetInstanceID = cabinetInstanceID;
        this.OID = OID;
        ApplyType = applyType;
        this.signboardType = signboardType;
        this.applyFee = applyFee;
        this.licenseFee = licenseFee;
        this.vatFee = vatFee;
        this.settlementFee = settlementFee;
        this.inComeTax = inComeTax;
        this.sc = sc;
        this.serialNo = serialNo;
        this.licenseNo = licenseNo;
        this.otherFee = otherFee;
        this.sourceTax = sourceTax;
        this.advertisementFee = advertisementFee;
        this.arrearFee = arrearFee;
        this.totalFee = totalFee;
    }

    public Integer getCabinetInstanceID() {
        return CabinetInstanceID;
    }

    public void setCabinetInstanceID(Integer cabinetInstanceID) {
        CabinetInstanceID = cabinetInstanceID;
    }

    public Long getOID() {
        return OID;
    }

    public void setOID(Long OID) {
        this.OID = OID;
    }

    public Integer getApplyType() {
        return ApplyType;
    }

    public void setApplyType(Integer applyType) {
        ApplyType = applyType;
    }

    public String getSignboardType() {
        return signboardType;
    }

    public void setSignboardType(String signboardType) {
        this.signboardType = signboardType;
    }

    public Integer getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(Integer applyFee) {
        this.applyFee = applyFee;
    }

    public Integer getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(Integer licenseFee) {
        this.licenseFee = licenseFee;
    }

    public Double getVatFee() {
        return vatFee;
    }

    public void setVatFee(Double vatFee) {
        this.vatFee = vatFee;
    }

    public Integer getSettlementFee() {
        return settlementFee;
    }

    public void setSettlementFee(Integer settlementFee) {
        this.settlementFee = settlementFee;
    }

    public Integer getInComeTax() {
        return inComeTax;
    }

    public void setInComeTax(Integer inComeTax) {
        this.inComeTax = inComeTax;
    }

    public Double getSc() {
        return sc;
    }

    public void setSc(Double sc) {
        this.sc = sc;
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

    public Integer getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Integer otherFee) {
        this.otherFee = otherFee;
    }

    public Integer getSourceTax() {
        return sourceTax;
    }

    public void setSourceTax(Integer sourceTax) {
        this.sourceTax = sourceTax;
    }

    public Integer getAdvertisementFee() {
        return advertisementFee;
    }

    public void setAdvertisementFee(Integer advertisementFee) {
        this.advertisementFee = advertisementFee;
    }

    public Integer getArrearFee() {
        return arrearFee;
    }

    public void setArrearFee(Integer arrearFee) {
        this.arrearFee = arrearFee;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
