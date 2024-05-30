package com.dmss.spring.login.controllers;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.services.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {

    @Autowired
    private MunicipalityService service;

    @GetMapping("/all")
    public List<Municipality> municipalityList() {
        return service.getAllMunicipality();
    }
}
