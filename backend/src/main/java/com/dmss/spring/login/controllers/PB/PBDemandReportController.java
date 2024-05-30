package com.dmss.spring.login.controllers.PB;

import com.dmss.spring.login.models.PB.PBDemandRequest;
import com.dmss.spring.login.services.PB.PropertyBillDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PB-Demand")
public class PBDemandReportController {
    @Autowired
    protected PropertyBillDemandService propertyBillDemandService;

    @PostMapping("/PropertyBill-demand/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PbDemand_REPORT')")
    public Long generatePropertyDemandReport(@RequestBody PBDemandRequest request){
        try {
            return propertyBillDemandService.generatePBDemandReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
