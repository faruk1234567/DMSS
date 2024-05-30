package com.dmss.spring.login.controllers.PB;

import com.dmss.spring.login.models.PB.PBDemandRequest;
import com.dmss.spring.login.services.PB.PBOfflineCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PB-OfflineCollection")
public class PBOfflineCollectionReportController {
    @Autowired
    PBOfflineCollectionService pbOfflineCollectionService;

    @PostMapping("/PropertyBill-Offlinecollection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PbDemand_REPORT')")
    public Long generatePropertyOfflineCollectionReport(@RequestBody PBDemandRequest request){
        try {
            return pbOfflineCollectionService.generatePBOfflineCollection(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
