package com.dmss.spring.login.models.htx;

import java.io.Serializable;

public class HoldingTaxBillIdClass implements Serializable {
    protected Long oidHolding;
    protected Integer YearQuarter;

    public HoldingTaxBillIdClass() {
    }

    public HoldingTaxBillIdClass(Long oidHolding, Integer yearQuarter) {
        this.oidHolding = oidHolding;
        this.YearQuarter = yearQuarter;
    }
}
