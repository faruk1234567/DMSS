package com.dmss.spring.login.controllers.dashboard;

import com.dmss.spring.login.models.dashboard.MunicipalityServiceCountAndIncomeData;
import com.dmss.spring.login.models.dashboard.ServiceCountAndIncomeData;
import com.dmss.spring.login.services.dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/service/data")
    public ServiceCountAndIncomeData getServiceCountAndIncome(){
        return this.dashboardService.serviceCountAndIncome();
    }

    @GetMapping("/municipality/service/data")
    public List<MunicipalityServiceCountAndIncomeData> getServiceCountAndIncomeByMunicipality(){
        return this.dashboardService.getServiceCountAndIncomeByMunicipality();
    }

    @GetMapping("/municipality/water/service/data")
    public List<MunicipalityServiceCountAndIncomeData> getWaterServiceCountAndIncomeByMunicipality(){
        return this.dashboardService.getWaterServiceCountAndIncomeByMunicipality();
    }

    @GetMapping("/municipality/ht/service/data")
    public List<MunicipalityServiceCountAndIncomeData> getHTServiceCountAndIncomeByMunicipality(){
        return this.dashboardService.getHTServiceCountAndIncomeByMunicipality();
    }

    @GetMapping("/municipality/tls/service/data")
    public List<MunicipalityServiceCountAndIncomeData> getTLServiceCountAndIncomeByMunicipality(){
        return this.dashboardService.getTLServiceCountAndIncomeByMunicipality();
    }

    @GetMapping("/municipality/property/service/data")
    public List<MunicipalityServiceCountAndIncomeData> getPropertyServiceCountAndIncomeByMunicipality(){
        return this.dashboardService.getPropertyServiceCountAndIncomeByMunicipality();
    }

    @GetMapping("/municipality/certificate/service/data")
    public List<MunicipalityServiceCountAndIncomeData> getCertificateServiceCountAndIncomeByMunicipality(){
        return this.dashboardService.getCertificateServiceCountAndIncomeByMunicipality();
    }

    @GetMapping("/water-bill/data")
    public ServiceCountAndIncomeData getWaterBillServiceCountAndIncome(){
        return this.dashboardService.getWaterBillServiceCountAndIncome();
    }

    @GetMapping("/tls/data")
    public ServiceCountAndIncomeData getTLServiceCountAndIncome(){
        return this.dashboardService.getTLServiceCountAndIncome();
    }

    @GetMapping("/ht/data")
    public ServiceCountAndIncomeData getHTServiceCountAndIncome(){
        return this.dashboardService.getHTServiceCountAndIncome();
    }

    @GetMapping("/certificate/data")
    public ServiceCountAndIncomeData getCertificateServiceCountAndIncome(){
        return this.dashboardService.getCertificateServiceCountAndIncome();
    }

    @GetMapping("/property/data")
    public ServiceCountAndIncomeData getPropertyServiceCountAndIncome(){
        return this.dashboardService.getPropertyServiceCountAndIncome();
    }


}
