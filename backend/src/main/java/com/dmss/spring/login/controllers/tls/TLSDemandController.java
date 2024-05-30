package com.dmss.spring.login.controllers.tls;

import com.dmss.spring.login.models.tls.TLSCollectionReportParam;
import com.dmss.spring.login.services.TLSDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tls-demand")
public class TLSDemandController {
    @Autowired
  protected   TLSDemandService tlsDemandService;

    @GetMapping("/signboard-type/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TLS_demand')")
    public List<String> getSignboardTypes() {
        return tlsDemandService.getSignboardTypes();
    }

    @PostMapping("/tls-demand/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TLS_collection')")
    public Long generateTLSCollectionReport(@RequestBody TLSCollectionReportParam requestParam) {
        try {
            return tlsDemandService.generateTLSDemandReport(requestParam);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
