package com.dmss.spring.login.models.tls;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TLSCollectionReportParam {


    private Integer municipalityId;
    private String signboardType;


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

    public String getSignboardType() {
        return signboardType;
    }

    public void setSignboardType(String signboardType) {
        this.signboardType = signboardType;
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
        return "TLSReportParam{" +
                "municipalityId=" + municipalityId +
                ", signboardType='" + signboardType + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
