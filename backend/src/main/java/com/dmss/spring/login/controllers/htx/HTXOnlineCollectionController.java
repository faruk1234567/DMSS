package com.dmss.spring.login.controllers.htx;

import com.dmss.spring.login.models.htx.HoldingTaxDemandRequest;
import com.dmss.spring.login.services.htx.HtaxOnlineCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ht-onlineCollection")
public class HTXOnlineCollectionController extends HoldingTaxBillBaseController {
    @Autowired
    HtaxOnlineCollectionService htaxOnlineCollectionService;
    @PostMapping("/htxbill-onlinecollection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HTON_REPORT')")

    public Long generateHoldingTaxOnlineCollectionReport(@RequestBody HoldingTaxDemandRequest request){
        try {
            return htaxOnlineCollectionService.generateHaxOnlineCollectionReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
