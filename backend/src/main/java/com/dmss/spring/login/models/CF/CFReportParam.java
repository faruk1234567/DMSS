package com.dmss.spring.login.models.CF;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CFReportParam {
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
        return "CFReportParam{" +
                "municipalityId=" + municipalityId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
