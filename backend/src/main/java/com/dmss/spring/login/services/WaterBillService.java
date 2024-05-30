package com.dmss.spring.login.services;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.wb.WBDemandData;
import com.dmss.spring.login.models.wb.WBDemandReportData;
import com.dmss.spring.login.models.wb.WBDemandRequest;
import com.dmss.spring.login.repository.wb.WaterBillRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class WaterBillService extends BaseReportService{

    @Value("${dmss.report.pdf.path}")
    private String reportPath;

    @Autowired
    WaterBillRepository waterBillRepository;

    @Autowired
    MunicipalityService municipalityService;

    public List<String> getConnectionType() {
        return waterBillRepository.findDistinctConnectionType();
    }

    public List<String> getPipeDiameter() {
        return waterBillRepository.findDistinctPipeDiameters();
    }

    public Long generateWBDemandReport(WBDemandRequest request) throws IOException, JRException {

        Map<String, Object> reportData = prepareReportData(request);
        String jrxml = "/WBDemand.jrxml";
        JasperPrint jasperPrint = this.getJasperPrint(reportData, jrxml);
        Long fileId = this.generateReportFile(jasperPrint);
        return fileId;
    }

    private Map<String, Object> prepareReportData(WBDemandRequest request) {

        Map<String, Object> reportData = new HashMap<>();

        Municipality municipality = municipalityService.getMunicipalityById(request.getMunicipalityId());

        if (municipality.getId() != null && municipality.getId() > 0) {
            reportData.put("Municipality", municipality.getName());
        } else {
            reportData.put("Municipality", "");
        }

        reportData.put("ConnectionType", request.getConnectionType());
        reportData.put("PipeDiameter", request.getPipeDiameter());
        reportData.put("FromDate", request.getFromDate());
        reportData.put("ToDate", request.getToDate());

        List<WBDemandReportData> dataList = new ArrayList<>();

        List<Integer> yearMonths = new ArrayList<>();
        this.getYearMonths(request.getFromDate(), request.getToDate(), yearMonths);

        this.getDemandData(municipality, request.getConnectionType(), request.getPipeDiameter(), yearMonths, dataList);

        reportData.put("collectionBeanParam", dataList);

        return reportData;
    }

    private void getYearMonths(Date fromDate, Date toDate, List<Integer> yearMonths) {

        LocalDateTime fromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime toLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        long noOfMonths = ChronoUnit.MONTHS.between(fromLocalDate, toLocalDate);

        while (fromLocalDate.isBefore(toLocalDate)) {
            int yearMonth = (fromLocalDate.getYear() * 100) + fromLocalDate.getMonthValue();
            System.out.println("Year Month: " + yearMonth);
            yearMonths.add(yearMonth);
            fromLocalDate = fromLocalDate.plusMonths(1);
        }

    }

    private void getDemandData(Municipality municipality, String connectionType, Integer pipeDiameter, List<Integer> yearMonths, List<WBDemandReportData> dataList) {

        WBDemandData currentDemandData = waterBillRepository.getCurrentDemandData(municipality.getId(), yearMonths, connectionType, pipeDiameter);
        WBDemandReportData wbDemandReportData = WBDemandReportData.getWBDemandReportData(currentDemandData);
        dataList.add(wbDemandReportData);

        currentDemandData = waterBillRepository.getArrearDemandData(municipality.getId(), yearMonths, connectionType, pipeDiameter);
        wbDemandReportData = WBDemandReportData.getWBDemandReportData(currentDemandData);
        dataList.add(wbDemandReportData);

        currentDemandData = waterBillRepository.getVATDemandData(municipality.getId(), yearMonths, connectionType, pipeDiameter);
        wbDemandReportData = WBDemandReportData.getWBDemandReportData(currentDemandData);
        dataList.add(wbDemandReportData);

        currentDemandData = waterBillRepository.getSurchargeDemandData(municipality.getId(), yearMonths, connectionType, pipeDiameter);
        wbDemandReportData = WBDemandReportData.getWBDemandReportData(currentDemandData);
        dataList.add(wbDemandReportData);

    }
}
