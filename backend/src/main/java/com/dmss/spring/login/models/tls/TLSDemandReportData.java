package com.dmss.spring.login.models.tls;

import com.dmss.spring.login.models.wb.WBDemandReportData;

public class TLSDemandReportData {
    private String item;
    private int noOfLicense;
    private int amount;

    public TLSDemandReportData() {
    }

    public TLSDemandReportData(String item, int NumberOfLicense, int amount) {
        this.item = item;
        this.noOfLicense = NumberOfLicense;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getNoOfLicense() {
        return noOfLicense;
    }

    public void setNoOfLicense(int NumberOfLicense) {
        this.noOfLicense = NumberOfLicense;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TLSDemandReportData{" +
                "item='" + item + '\'' +
                ", noOfLicense='" + noOfLicense + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static TLSDemandReportData getTlsDemandReportData(TLSDemandData data){
        String item = (data.getItem() == null) ? "" : data.getItem();
        int amount = (data.getAmount() == null) ? 0 : data.getAmount();
        int noOfLicense = (data.getNumberOfLicense() == null) ? 0: data.getNumberOfLicense();
        return new TLSDemandReportData(item, noOfLicense, amount);


    }

}
