package com.dmss.spring.login.services;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.tls.TLSCollectionReportParam;
import com.dmss.spring.login.models.tls.TLSDemandData;
import com.dmss.spring.login.models.tls.TLSDemandReportData;
import com.dmss.spring.login.repository.tls.TLSCollectionRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class TLSCollectionService extends  BaseReportService {

    @Autowired
    MunicipalityService municipalityService;
    @Autowired
    TLSCollectionRepository tlsCollectionRepository;

    public List<String> getSignboardTypes() {
        return tlsCollectionRepository.findSignboardList();
    }

    public Long generateTLSCollectionReport(TLSCollectionReportParam requestParam) throws JRException, IOException {

        Map<String, Object> reportData = prepareReportData(requestParam);
        String jrxml = "/TLC_Recovery.jrxml";
        JasperPrint jasperPrint = this.getJasperPrint(reportData, jrxml);

        Long fileId = this.generateReportFile(jasperPrint);

        return fileId;
    }

    private Map<String, Object> prepareReportData(TLSCollectionReportParam requestParam) {

        Map<String, Object> reportData = new HashMap<>();
        Integer cabinetInstanceId = 0;
        Municipality municipality = municipalityService.getMunicipalityById(requestParam.getMunicipalityId());

        if (municipality.getId() != null && municipality.getId() > 0) {

            reportData.put("Municipality", municipality.getName());
            cabinetInstanceId = this.municipalityService.getCabinetInstanceId("TLS", "TradeLicense", municipality.getId());

        } else {
            reportData.put("Municipality", "");
            cabinetInstanceId = 0;
        }

        reportData.put("SignboardType", (requestParam.getSignboardType().equals('0') ? "" : requestParam.getSignboardType()));
        reportData.put("FromDate", requestParam.getFromDate());
        reportData.put("ToDate", requestParam.getToDate());

        List<TLSDemandReportData> dataList = new ArrayList<>();

        this.getTlsCollectionData(municipality,  requestParam.getSignboardType(),requestParam.getFromDate(),requestParam.getToDate(), cabinetInstanceId, dataList);

        reportData.put("collectionBeanParam", dataList);

        return reportData;
    }

    private void getTlsCollectionData(Municipality municipality, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId, List<TLSDemandReportData> dataList) {
        TLSDemandData currentCollectionData = tlsCollectionRepository.getApplicationFeeCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        TLSDemandReportData tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

        currentCollectionData = tlsCollectionRepository.getLicenseFeeCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

        currentCollectionData = tlsCollectionRepository.getOtherFeeCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

        currentCollectionData = tlsCollectionRepository.getVatCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

        currentCollectionData = tlsCollectionRepository.getIncomeTaxCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

        currentCollectionData = tlsCollectionRepository.getSourceTaxCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

        currentCollectionData = tlsCollectionRepository.getArrearCollectionData(municipality.getId(), signboardType, fromDateStr, toDateStr,cabinetInstanceId);
        tlsDemandReportData = TLSDemandReportData.getTlsDemandReportData(currentCollectionData);
        dataList.add(tlsDemandReportData);

    }

}
