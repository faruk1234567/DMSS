package com.dmss.spring.login.models.PB;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PBDemandRequest {

    private Integer municipalityId;


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
        return "PBDemandRequest{" +
                "municipalityId=" + municipalityId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}

