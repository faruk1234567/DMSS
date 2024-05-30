package com.dmss.spring.login.controllers.wb;

import com.dmss.spring.login.models.wb.WBDemandRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wb-OfflineCollection")
public class WaterBillOfflineCollectionController extends WaterBillBaseController {
    @PostMapping("/waterBill-OfflineCollection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_OfflineCollection_REPORT')")
    public Long generateOfflineCollectionReport(@RequestBody WBDemandRequest request){

        try {
            return wbOfflineCollectionService.generateWBOfflineCollectionReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }
}
