package com.dmss.spring.login.models.wb;

import java.io.Serializable;

public class WaterBillIDClass implements Serializable {
    protected Long oidConnection;
    protected String BillYearMonth;

    public WaterBillIDClass() {
    }

    public WaterBillIDClass(Long oidConnection, String billYearMonth) {
        this.oidConnection = oidConnection;
        BillYearMonth = billYearMonth;
    }
}
