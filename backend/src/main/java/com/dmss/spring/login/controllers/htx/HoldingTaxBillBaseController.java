package com.dmss.spring.login.controllers.htx;

import com.dmss.spring.login.services.htx.HoldingTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class HoldingTaxBillBaseController {
    @Autowired
    protected HoldingTaxService holdingTaxService;

    @GetMapping("/user-type")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HTX_REPORT')")
    public List<String> userType() {
        return holdingTaxService.getUserType();
    }


}
