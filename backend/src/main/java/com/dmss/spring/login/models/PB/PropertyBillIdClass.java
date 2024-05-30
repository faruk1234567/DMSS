package com.dmss.spring.login.models.PB;

import java.io.Serializable;

public class PropertyBillIdClass implements Serializable {
    protected Long oidProperty;
    protected Integer BillYearMonth;

    public PropertyBillIdClass() {
    }

    public PropertyBillIdClass(Long oidProperty, Integer billYearMonth) {
        this.oidProperty = oidProperty;
        BillYearMonth = billYearMonth;
    }
}
