package com.dmss.spring.login.services.CF;

import com.dmss.spring.login.models.CF.CFReportParam;
import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.PB.PBDemandReportData;
import com.dmss.spring.login.models.PB.PropertyBillDemandData;
import com.dmss.spring.login.repository.CF.CFIssueRepository;
import com.dmss.spring.login.services.BaseReportService;
import com.dmss.spring.login.services.MunicipalityService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class CFIssueService extends BaseReportService {
    @Autowired
   private  CFIssueRepository cfIssueRepository;
    @Autowired
    MunicipalityService municipalityService;
    public Long generateCertificateIssueReport(CFReportParam requestParam) throws JRException, IOException {

        Map<String, Object> CfReportData = prepareCfReportData(requestParam);
        String jrxml = "/Certificate_Issue.jrxml";
        JasperPrint jasperPrint = this.getJasperPrint(CfReportData, jrxml);

        Long fileId = this.generateReportFile(jasperPrint);

        return fileId;
    }
    private Map<String, Object> prepareCfReportData(CFReportParam requestParam) {

        Map<String, Object> CfreportData = new HashMap<>();
        int cabinetInstanceId = 0;
      // String[] a= {"Character"};
        Municipality municipality = municipalityService.getMunicipalityById(requestParam.getMunicipalityId());

        if (municipality.getId() != null && municipality.getId() > 0) {

            CfreportData.put("Municipality", municipality.getName());
            String[] a = {"Succession","Character" };
          //  for (int i = 0; i < a.length; i++) {

                cabinetInstanceId = this.municipalityService.getCabinetInstanceById("OCC", a, municipality.getId());
          //  }

        }

        else {

            CfreportData.put("Municipality", "");
            cabinetInstanceId = 0;
        }


        CfreportData.put("FromDate", requestParam.getFromDate());
        CfreportData.put("ToDate", requestParam.getToDate());

        List<PBDemandReportData> dataList = new ArrayList<>();

        this.getCertificateIssueData(municipality,   requestParam.getFromDate(), requestParam.getToDate(),cabinetInstanceId, dataList);

        CfreportData.put("collectionBeanParam", dataList);

        return CfreportData;
    }
    private void getCertificateIssueData(Municipality municipality, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId, List<PBDemandReportData> dataList) {
         PropertyBillDemandData CertificateIssue = cfIssueRepository.getSuccessionIssue(municipality.getId(),fromDateStr, toDateStr,cabinetInstanceId );
        PBDemandReportData pbDemandReportData = PBDemandReportData.getPBDemandReportData(CertificateIssue);
        dataList.add(pbDemandReportData);

        CertificateIssue = cfIssueRepository.getCharacterIssue(municipality.getId(),fromDateStr, toDateStr,cabinetInstanceId );
        pbDemandReportData = PBDemandReportData.getPBDemandReportData(CertificateIssue);
        dataList.add(pbDemandReportData);



    }
}
