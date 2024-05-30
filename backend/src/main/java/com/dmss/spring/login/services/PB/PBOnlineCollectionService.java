package com.dmss.spring.login.services.PB;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.PB.PBDemandReportData;
import com.dmss.spring.login.models.PB.PBDemandRequest;
import com.dmss.spring.login.models.PB.PropertyBillDemandData;
import com.dmss.spring.login.repository.PB.PBOnlineCollectionRepository;
import com.dmss.spring.login.services.BaseReportService;
import com.dmss.spring.login.services.MunicipalityService;
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
public class PBOnlineCollectionService extends BaseReportService {
    @Value("${dmss.report.pdf.path}")
    private String reportPath;

 @Autowired
 PBOnlineCollectionRepository pbOnlineCollectionRepository;

    @Autowired
    MunicipalityService municipalityService;

    public Long generateOnlineCollectionReport(PBDemandRequest request) throws IOException, JRException {

        Map<String, Object> reportData = prepareReportData(request);
        String jrxml = "/PBCollection.jrxml";
        JasperPrint jasperPrint = this.getJasperPrint(reportData, jrxml);
        Long fileId = this.generateReportFile(jasperPrint);
        return fileId;
    }


    private Map<String, Object> prepareReportData(PBDemandRequest request) {

        Map<String, Object> reportData = new HashMap<>();

        Municipality municipality = municipalityService.getMunicipalityById(request.getMunicipalityId());

        if (municipality.getId() != null && municipality.getId() > 0) {
            reportData.put("Municipality", municipality.getName());
        } else {
            reportData.put("Municipality", "");
        }

        reportData.put("FromDate", request.getFromDate());
        reportData.put("ToDate", request.getToDate());

        List<PBDemandReportData> dataList = new ArrayList<>();

        List<Integer> yearMonths = new ArrayList<>();
        this.getYearMonths(request.getFromDate(), request.getToDate(), yearMonths);

        this.getPBOnlineCollectionData(municipality, yearMonths, dataList);


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

    private void getPBOnlineCollectionData(Municipality municipality,  List<Integer> yearMonths, List<PBDemandReportData> dataList) {

        PropertyBillDemandData currentCollectionData = pbOnlineCollectionRepository.getCurrentDemandData(municipality.getId(), yearMonths);
        PBDemandReportData propertyBillDemandData= PBDemandReportData.getPBDemandReportData(currentCollectionData);
        dataList.add(propertyBillDemandData);

        currentCollectionData = pbOnlineCollectionRepository.getArrearDemandData(municipality.getId(), yearMonths);
        propertyBillDemandData = PBDemandReportData.getPBDemandReportData(currentCollectionData);
        dataList.add(propertyBillDemandData);

        currentCollectionData = pbOnlineCollectionRepository.getVATDemandData(municipality.getId(), yearMonths);
        propertyBillDemandData = PBDemandReportData.getPBDemandReportData(currentCollectionData);
        dataList.add(propertyBillDemandData);

        currentCollectionData = pbOnlineCollectionRepository.getSurchargeDemandData(municipality.getId(), yearMonths);
        propertyBillDemandData = PBDemandReportData.getPBDemandReportData(currentCollectionData);
        dataList.add(propertyBillDemandData);

    }
}
