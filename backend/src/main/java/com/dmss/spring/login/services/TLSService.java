package com.dmss.spring.login.services;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.tls.TLSRecoveryData;
import com.dmss.spring.login.models.tls.TLSRecoveryDetailReportData;
import com.dmss.spring.login.models.tls.TLSReportParam;
import com.dmss.spring.login.repository.tls.TLSRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TLSService extends BaseReportService {

    @Autowired
    private TLSRepository tlsRepository;

    @Autowired
    MunicipalityService municipalityService;

    public List<String> getSignboardTypes() {
        return tlsRepository.findSignboardList();
    }

    public Long generateTLSRecoveryDetailReport(TLSReportParam requestParam) throws JRException, IOException {

        Map<String, Object> reportData = prepareReportData(requestParam);
        String jrxml = "/TLC_Recovery_Detail.jrxml";
        JasperPrint jasperPrint = this.getJasperPrint(reportData, jrxml);

        Long fileId = this.generateReportFile(jasperPrint);

        return fileId;
    }

    private Map<String, Object> prepareReportData(TLSReportParam requestParam) {

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
        reportData.put("SerialNo", requestParam.getSerialNo());
        reportData.put("FromDate", requestParam.getFromDate());
        reportData.put("ToDate", requestParam.getToDate());

        List<TLSRecoveryDetailReportData> dataList = new ArrayList<>();

        this.getTLSRecoveryReportData(municipality, cabinetInstanceId, requestParam.getSignboardType(), requestParam.getSerialNo(),requestParam.getFromDate(), requestParam.getToDate(), dataList);

        reportData.put("collectionBeanParam", dataList);

        return reportData;
    }

    private void getTLSRecoveryReportData(Municipality municipality, Integer cabinetInstanceId, String signboardType, String serialNo, Date fromDate, Date toDate, List<TLSRecoveryDetailReportData> dataList) {
        List<TLSRecoveryData> list = new ArrayList<>();
        String fromDateStr = new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
        String toDateStr = new SimpleDateFormat("yyyy-MM-dd").format(toDate);
        if(StringUtils.isNotEmpty(serialNo)){

            list =  this.tlsRepository.getTLSRecoveryDetailDataBySerialNo(serialNo, fromDateStr, toDateStr, cabinetInstanceId);

        } else {
            list =  this.tlsRepository.getTLSRecoveryDetailData(municipality.getId(), signboardType, fromDateStr, toDateStr, cabinetInstanceId);
        }

        for (int i = 0; i < list.size(); i++) {
            TLSRecoveryDetailReportData tlsRecoveryDetailReportData = new TLSRecoveryDetailReportData();
            tlsRecoveryDetailReportData.convertTLSRecoveryDetailReportData(list.get(i));

            dataList.add(tlsRecoveryDetailReportData);
        }
    }
}
