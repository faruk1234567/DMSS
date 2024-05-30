package com.dmss.spring.login.models.dashboard;

public class MunicipalityServiceCountAndIncomeData {

    private String municipalityName;
    private Integer totalService;
    private Integer totalIncome;

    public MunicipalityServiceCountAndIncomeData() {
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public Integer getTotalService() {
        return totalService;
    }

    public void setTotalService(Integer totalService) {
        this.totalService = totalService;
    }

    public Integer getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Integer totalIncome) {
        this.totalIncome = totalIncome;
    }
}
