package com.dmss.spring.login.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {

    @Value("${dmss.report.pdf.path}")
    private String reportPath;

    public String getPDFFilePath(Integer userId, Long fileId) {
        return reportPath + File.separator + userId + File.separator + fileId + ".pdf";
    }

    public String getXLSXFilePath(Integer userId, Long fileId) {
        return reportPath + File.separator + userId + File.separator + fileId + ".xlsx";
    }
}
