package com.dmss.spring.login.controllers.htx;

import com.dmss.spring.login.models.htx.HoldingTaxDemandRequest;
import com.dmss.spring.login.models.wb.WBDemandRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ht-demand")
public class HTXDemandController extends HoldingTaxBillBaseController {

    @PostMapping("/htxbill-demand/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HTD_REPORT')")
    public Long generateWaterBillCollectionReport(@RequestBody HoldingTaxDemandRequest request){
        try {
            return holdingTaxService.generateHTXCollectionReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
