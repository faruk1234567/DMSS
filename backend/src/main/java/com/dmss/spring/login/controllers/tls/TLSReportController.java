package com.dmss.spring.login.controllers.tls;

import com.dmss.spring.login.models.tls.TLSReportParam;
import com.dmss.spring.login.services.TLSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tls")
public class TLSReportController {

    @Autowired
    protected TLSService service;

    @GetMapping("/signboard-type/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TLS_REPORT')")
    public List<String> getSignboardTypes() {
        return service.getSignboardTypes();
    }

    @PostMapping("/tls-recovery-detail/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TLS_REPORT')")
    public Long generateTLSRecoveryDetailReport(@RequestBody TLSReportParam requestParam) {
        try {
            return service.generateTLSRecoveryDetailReport(requestParam);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
