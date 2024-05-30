package com.dmss.spring.login.controllers.htx;

import com.dmss.spring.login.models.htx.HoldingTaxDemandRequest;
import com.dmss.spring.login.services.htx.HtaxOfflineCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ht-offlineCollection")
public class HTXOfflineCollectionController extends HoldingTaxBillBaseController{
    @Autowired
    HtaxOfflineCollectionService htaxOfflineCollectionService;
    @PostMapping("/htxbill-offlinecollection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HTO_REPORT')")

    public Long generateHoldingTaxOfflineCollectionReport(@RequestBody HoldingTaxDemandRequest request){
        try {
            return htaxOfflineCollectionService.generateHaxOfflineCollectionReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
