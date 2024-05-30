package com.dmss.spring.login.models.dashboard;

import java.util.List;

public class ServiceCountAndIncomeData {

    private Long totalService;
    private Long totalIncome;

    public ServiceCountAndIncomeData() {
    }

    public Long getTotalService() {
        return totalService;
    }

    public void setTotalService(Long totalService) {
        this.totalService = totalService;
    }

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }
}
