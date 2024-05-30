package com.dmss.spring.login.models.wb;

public class WBDemandReportData {

    private String item;
    private int noOfConnection;
    private int amount;


    public WBDemandReportData(String item, int numberOfConnection, int amount) {
        this.item = item;
        this.noOfConnection = numberOfConnection;
        this.amount = amount;

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getNoOfConnection() {
        return noOfConnection;
    }

    public void setNoOfConnection(int noOfConnection) {
        this.noOfConnection = noOfConnection;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WBDemandReportData{" +
                "item='" + item + '\'' +
                ", numberOfConnection=" + noOfConnection +
                ", amount=" + amount +
                '}';
    }

    public static WBDemandReportData getWBDemandReportData(WBDemandData data) {
        String item = (data.getItem() == null) ? "" : data.getItem();
        int amount = (data.getAmount() == null) ? 0 : data.getAmount();
        int noOfConnection = (data.getNumberOfConnection() == null) ? 0 : data.getNumberOfConnection();
        return new WBDemandReportData(item, noOfConnection, amount);
    }
}
