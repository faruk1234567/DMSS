package com.dmss.spring.login.services;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.repository.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository repository;

    public List<Municipality> getAllMunicipality() {
        return repository.findAll();
    }

    public Municipality getMunicipalityById(Integer municipalityId) {
        return repository.findById(municipalityId).get();
    }

    public Integer getCabinetInstanceId(String serviceKey, String formKey, Integer municipalityId) {
        return repository.getCabinetInstanceId(serviceKey, formKey, municipalityId);
    }

    public Integer getCabinetInstanceById(String serviceKey, String[] formKeyList, Integer municipalityId) {
        return repository.getCabinetInstanceIdList(serviceKey,  formKeyList, municipalityId);
    }
}
