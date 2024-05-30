package com.dmss.spring.login.controllers.tls;

import com.dmss.spring.login.models.tls.TLSCollectionReportParam;
import com.dmss.spring.login.services.TLSCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tls-collection")
public class TLSCollectionController {

    @Autowired
    protected TLSCollectionService tlsCollectionService;

    @GetMapping("/signboard-type/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TLS_collection')")
    public List<String> getSignboardTypes() {
        return tlsCollectionService.getSignboardTypes();
    }

    @PostMapping("/tls-collection/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TLS_collection')")
    public Long generateTLSCollectionReport(@RequestBody TLSCollectionReportParam requestParam) {
        try {
            return tlsCollectionService.generateTLSCollectionReport(requestParam);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
