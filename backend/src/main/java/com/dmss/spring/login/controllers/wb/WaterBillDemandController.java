package com.dmss.spring.login.controllers.wb;

import com.dmss.spring.login.models.wb.WBDemandRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wb-demand")
public class WaterBillDemandController extends WaterBillBaseController {

    @PostMapping("/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_WB_REPORT')")
    public Long generateWBDemandReport(@RequestBody WBDemandRequest request) {
        try {
            return service.generateWBDemandReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
