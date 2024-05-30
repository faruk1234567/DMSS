package com.dmss.spring.login.controllers.wb;

import com.dmss.spring.login.models.wb.WBDemandRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wb-collection")
public class WaterBillCollectionController extends WaterBillBaseController {



    @PostMapping("/waterbill-collection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_Collection_REPORT')")
    public Long generateWaterBillCollectionReport(@RequestBody WBDemandRequest request){
        try {
            return waterBillCollectionService.generateWBCollectionReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    }




