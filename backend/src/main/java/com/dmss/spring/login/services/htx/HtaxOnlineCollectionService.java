package com.dmss.spring.login.services.htx;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.htx.HoldingTaxDemandRequest;
import com.dmss.spring.login.models.wb.WBDemandData;
import com.dmss.spring.login.models.wb.WBDemandReportData;
import com.dmss.spring.login.repository.htax.HTDemandRepository;
import com.dmss.spring.login.repository.htax.HTOnLineCollectionRepository;
import com.dmss.spring.login.services.BaseReportService;
import com.dmss.spring.login.services.MunicipalityService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class HtaxOnlineCollectionService extends BaseReportService {
    @Value("${dmss.report.pdf.path}")
    private String reportPath;

    @Autowired
    MunicipalityService municipalityService;
    @Autowired
    HTOnLineCollectionRepository htOnLineCollectionRepository;



    public long generateHaxOnlineCollectionReport(HoldingTaxDemandRequest request) throws IOException, JRException {
        Map<String, Object> HTaxOnlineCollectionReportData = HoldingTaxOnlineCollectionReport(request);
        String jrxml = "/HtaxOnlineCollection.jrxml";
        JasperPrint jasperPrint = this.getJasperPrint(HTaxOnlineCollectionReportData, jrxml);
        Long fileId = this.generateReportFile(jasperPrint);
        return fileId;

    }
    private Map<String, Object> HoldingTaxOnlineCollectionReport(HoldingTaxDemandRequest request) {
        Map<String, Object> reportData = new HashMap<>();
        Municipality municipality = municipalityService.getMunicipalityById(request.getMunicipalityId());
        if (municipality.getId() != null && municipality.getId() > 0) {
            reportData.put("Municipality", municipality.getName());
        } else {
            reportData.put("Municipality", "");
        }
        reportData.put("userType", request.getUserType());
        reportData.put("FromDate", request.getFromDate());
        reportData.put("ToDate", request.getToDate());

        List<WBDemandReportData> dataList = new ArrayList<>();




        this.getHoldingTaxOnlineCollectionData(municipality,request.getFromDate(),request.getToDate(), request.getUserType(),  dataList);

        reportData.put("collectionBeanParam", dataList);

        return reportData;

    }

    public void getHoldingTaxOnlineCollectionData(Municipality municipality, Date fromDateStr, Date toDateStr, String usertype, List<WBDemandReportData> dataList){
        WBDemandData currentHoldingCollectionData = htOnLineCollectionRepository.getCurrentHoldingTaxCollectionData(municipality.getId(), fromDateStr, toDateStr, usertype);
        WBDemandReportData HTaxCollectionReportData = WBDemandReportData.getWBDemandReportData(currentHoldingCollectionData);
        dataList.add(HTaxCollectionReportData);

        currentHoldingCollectionData = htOnLineCollectionRepository.getCurrentHoldingTaxArrearCollectionData(municipality.getId(), fromDateStr, toDateStr, usertype);
        HTaxCollectionReportData = WBDemandReportData.getWBDemandReportData(currentHoldingCollectionData);
        dataList.add(HTaxCollectionReportData);

        currentHoldingCollectionData = htOnLineCollectionRepository.getCurrentHoldingTaxSurchargeCollectionData(municipality.getId(), fromDateStr, toDateStr, usertype);
        HTaxCollectionReportData = WBDemandReportData.getWBDemandReportData(currentHoldingCollectionData);
        dataList.add(HTaxCollectionReportData);


    }
}
