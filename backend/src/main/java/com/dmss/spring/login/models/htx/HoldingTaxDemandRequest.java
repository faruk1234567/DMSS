package com.dmss.spring.login.models.htx;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HoldingTaxDemandRequest {
    private Integer municipalityId;
    private String userType;


    @JsonFormat(pattern="yyyy/MM/dd")
    private Date fromDate;

    @JsonFormat(pattern="yyyy/MM/dd")
    private Date toDate;

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "HoldingTaxDemandRequest{" +
                "municipalityId=" + municipalityId +
                ", userType='" + userType + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
