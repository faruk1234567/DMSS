package com.dmss.spring.login.controllers.CF;

import com.dmss.spring.login.models.CF.CFReportParam;
import com.dmss.spring.login.services.CF.CFIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/CF-ISSUE")
public class CFIssueController {
    @Autowired
    CFIssueService cfIssueService;

    @PostMapping("/CF-Issue/generate-report")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_Issue_REPORT')")
    public Long generateCfIssueReport(@RequestBody CFReportParam request){
        try {
            return cfIssueService.generateCertificateIssueReport(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
