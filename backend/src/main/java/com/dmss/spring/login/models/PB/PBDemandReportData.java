package com.dmss.spring.login.models.PB;

public class PBDemandReportData {

    private String item;
    private int noOfProperty;
    private int amount;

    public PBDemandReportData() {
    }

    public PBDemandReportData(String item, int  numberOfProperty, int amount) {
        this.item = item;
        this.noOfProperty = numberOfProperty;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getNoOfProperty() {
        return noOfProperty;
    }

    public void setNoOfProperty(int numberOfProperty) {
        this.noOfProperty = numberOfProperty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static PBDemandReportData getPBDemandReportData(PropertyBillDemandData data){
        String item = (data.getItem() == null) ? "" : data.getItem();
        int amount = (data.getAmount() == null) ? 0 : data.getAmount();
        int noOfProperty = (data.getNumberOfProperty() == null) ? 0 : data.getNumberOfProperty();
        return new PBDemandReportData(item, noOfProperty, amount);

    }

}
