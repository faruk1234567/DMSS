package com.dmss.spring.login.controllers.PB;

import com.dmss.spring.login.models.PB.PBDemandRequest;
import com.dmss.spring.login.services.PB.PBOnlineCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/PB-OnlineCollection")
public class PBOnlineCollectionReportController {
    @Autowired
    PBOnlineCollectionService pbOnlineCollectionService;




    @PostMapping("/PropertyBill-Onlinecollection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PbDemand_REPORT')")
    public Long generatePropertyOnlineCollectionReport(@RequestBody PBDemandRequest request){
        try {
            return pbOnlineCollectionService.generateOnlineCollectionReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
