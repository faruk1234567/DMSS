package com.dmss.spring.login.models.wb;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WBDemandRequest {

    private Integer municipalityId;
    private String connectionType;
    private Integer pipeDiameter;

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

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public Integer getPipeDiameter() {
        return pipeDiameter;
    }

    public void setPipeDiameter(Integer pipeDiameter) {
        this.pipeDiameter = pipeDiameter;
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
        return "WBDemandRequest{" +
                "municipalityId=" + municipalityId +
                ", connectionType='" + connectionType + '\'' +
                ", pipeDiameter=" + pipeDiameter +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
