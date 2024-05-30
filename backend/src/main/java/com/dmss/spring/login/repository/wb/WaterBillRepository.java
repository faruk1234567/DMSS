package com.dmss.spring.login.repository.wb;

import com.dmss.spring.login.models.wb.WBDemandData;
import com.dmss.spring.login.models.wb.WaterBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WaterBillRepository extends JpaRepository<WaterBill, Long> {

    @Query(value = "SELECT distinct PipeDiameter FROM t_waterbill", nativeQuery = true)
    List<String> findDistinctPipeDiameters();

    @Query(value = "select distinct ConnectionType from t_waterbill", nativeQuery = true)
    List<String> findDistinctConnectionType();

    @Query(nativeQuery = true,
            value = "select 'Current' as 'item', count(connectionid) as 'numberOfConnection', sum(monthlywaterbill) as 'amount' from t_waterbill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and billyearmonth in :yearMonths " +
                    "and (:connectionType = 0 or ConnectionType = :connectionType) " +
                    "and (:pipeDiameter=0 or PipeDiameter= :pipeDiameter) ")
    WBDemandData getCurrentDemandData(Integer municipalityId, List<Integer> yearMonths, String connectionType, Integer pipeDiameter);

    @Query(nativeQuery = true,
            value = "select 'Arrear' as 'item', count(connectionid) as 'numberOfConnection', round(sum(arrearbill)) as 'amount' from t_waterbill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and billyearmonth in :yearMonths and arrearbill > 0 " +
                    "and (:connectionType = 0 or ConnectionType = :connectionType) " +
                    "and (:pipeDiameter=0 or PipeDiameter= :pipeDiameter) ")
    WBDemandData getArrearDemandData(Integer municipalityId, List<Integer> yearMonths, String connectionType, Integer pipeDiameter);

    @Query(nativeQuery = true,
            value = "select 'VAT' as 'item', count(connectionid) as 'numberOfConnection', round(sum(vat)) as 'amount' from t_waterbill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and billyearmonth in :yearMonths and vat > 0 " +
                    "and (:connectionType = 0 or ConnectionType = :connectionType) " +
                    "and (:pipeDiameter=0 or PipeDiameter= :pipeDiameter) ")
    WBDemandData getVATDemandData(Integer municipalityId, List<Integer> yearMonths, String connectionType, Integer pipeDiameter);

    @Query(nativeQuery = true,
            value = "select 'Surcharge' as 'item', count(connectionid) as 'numberOfConnection', round(sum(surcharge)) as 'amount' from t_waterbill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and billyearmonth in :yearMonths and surcharge > 0 " +
                    "and (:connectionType = 0 or ConnectionType = :connectionType) " +
                    "and (:pipeDiameter=0 or PipeDiameter= :pipeDiameter) ")
    WBDemandData getSurchargeDemandData(Integer municipalityId, List<Integer> yearMonths, String connectionType, Integer pipeDiameter);
}