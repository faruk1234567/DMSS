package com.dmss.spring.login.controllers.wb;

import com.dmss.spring.login.services.WaterBillCollectionService;
import com.dmss.spring.login.services.WaterBillService;
import com.dmss.spring.login.services.WbOfflineCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class WaterBillBaseController {

    @Autowired
    protected WaterBillService service;
    @Autowired
    WaterBillCollectionService waterBillCollectionService;
    @Autowired
    WbOfflineCollectionService wbOfflineCollectionService;

    @GetMapping("/pipe-diameters")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_WB_REPORT')")
    public List<String> getPipeDiameters() {
        return service.getPipeDiameter();
    }

    @GetMapping("/connection-type")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_WB_REPORT')")
    public List<String> getConnectionType() {
        return service.getConnectionType();
    }
}
