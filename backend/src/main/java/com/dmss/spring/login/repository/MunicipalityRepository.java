package com.dmss.spring.login.repository;

import com.dmss.spring.login.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

    @Query(nativeQuery = true, value = "select CabinetInstanceID from t_municipalitycabinetinstance  where servicekey = :serviceKey and FormKey=:formKey and MunicipalityID = :municipalityId")
    Integer getCabinetInstanceId(String serviceKey, String formKey, Integer municipalityId);

    @Query(nativeQuery = true, value = "select CabinetInstanceID from t_municipalitycabinetinstance  where servicekey = :serviceKey and FormKey in :formKeyList and MunicipalityID = :municipalityId")
    Integer getCabinetInstanceIdList(String serviceKey, String [] formKeyList, Integer municipalityId);

    Optional<Municipality> findById(Integer id);

}
