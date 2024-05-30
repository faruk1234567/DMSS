package com.dmss.spring.login.controllers;

import com.dmss.spring.login.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    protected FileService service;

    @GetMapping("/pdf/{userId}/{fileId}")
    public ResponseEntity<Resource> getPDFFile(@PathVariable("userId") Integer userId, @PathVariable("fileId") Long fileId) {

        try {
            String filePath = service.getPDFFilePath(userId, fileId);

            HttpHeaders header = new HttpHeaders();
            header.add("Cache-Control", "no-cache, no-store, must-revalidate");
            header.add("Pragma", "no-cache");
            header.add("Expires", "0");

            File file = new File(filePath);

            Path path = Paths.get(file.getAbsolutePath());
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

            return ResponseEntity.ok()
                    .headers(header)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/xlsx/{userId}/{fileId}")
    public ResponseEntity<Resource> getXLSXFile(@PathVariable("userId") Integer userId, @PathVariable("fileId") Long fileId) {

        try {
            String filePath = service.getXLSXFilePath(userId, fileId);

            HttpHeaders header = new HttpHeaders();
            header.add("Cache-Control", "no-cache, no-store, must-revalidate");
            header.add("Pragma", "no-cache");
            header.add("Expires", "0");

            File file = new File(filePath);

            Path path = Paths.get(file.getAbsolutePath());
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

            return ResponseEntity.ok()
                    .headers(header)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
