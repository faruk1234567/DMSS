package com.dmss.spring.login.services;

import com.dmss.spring.login.models.wb.WBDemandReportData;
import com.dmss.spring.login.security.services.UserDetailsImpl;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class BaseReportService {

    @Value("${dmss.report.pdf.path}")
    public String reportPath;

    public JasperPrint getJasperPrint(Map<String, Object> reportData, String jrxml) throws IOException, JRException {
        InputStream is = this.getClass().getResourceAsStream(jrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(is);

        reportData.put("collectionBeanParam", new JRBeanCollectionDataSource((ArrayList<WBDemandReportData>) reportData.get("collectionBeanParam")));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportData, new JREmptyDataSource());
        return jasperPrint;
    }

    public String getFilePath(String reportPath, long fileId) {
        // Get logged in user session ID
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        File directory = new File(reportPath + File.separator + user.getId());
        if (!directory.exists()) {
            directory.mkdir();
        }

        String fileName = reportPath + File.separator + user.getId() + File.separator + fileId;
        System.out.println("path: " + fileName);
        return fileName;
    }

    public String getUploadPath(String fileFormat, JasperPrint jasperPrint, String fileName) throws IOException, JRException {
        if (fileFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
        } else if(fileFormat.equalsIgnoreCase("xlsx")){
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, fileName);

            exporter.exportReport();
        }

        return fileName;
    }

    protected Long generateReportFile(JasperPrint jasperPrint) throws JRException, IOException {
        long fileId = new Date().getTime();
        String fileName = this.getFilePath(reportPath, fileId);
        this.getUploadPath("pdf", jasperPrint, fileName + ".pdf");
        this.getUploadPath("xlsx", jasperPrint, fileName + ".xlsx");

        return fileId;
    }
}
