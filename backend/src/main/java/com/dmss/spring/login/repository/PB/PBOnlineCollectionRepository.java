package com.dmss.spring.login.repository.PB;

import com.dmss.spring.login.models.PB.PropertyBill;
import com.dmss.spring.login.models.PB.PropertyBillDemandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PBOnlineCollectionRepository  extends JpaRepository<PropertyBill, Long> {
    @Query(nativeQuery = true,
            value = "select 'Current' as 'item', count(propertyid) as 'numberOfProperty', sum(rent) as 'amount' from t_propertyleasebill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and offlinepayregisterid=0 " +
                    "and billyearmonth in :yearMonths  ")
    PropertyBillDemandData getCurrentDemandData(Integer municipalityId, List<Integer> yearMonths);

    @Query(nativeQuery = true,
            value = "select 'Arrear' as 'item', count(propertyid) as 'numberOfProperty', round(sum(arrearrent)) as 'amount' from t_propertyleasebill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and offlinepayregisterid=0 " +
                    "and billyearmonth in :yearMonths and arrearrent > 0  ")
    PropertyBillDemandData getArrearDemandData(Integer municipalityId, List<Integer> yearMonths);

    @Query(nativeQuery = true,
            value = "select 'VAT' as 'item', count(propertyid) as 'numberOfProperty', round(sum(vat)) as 'amount' from t_propertyleasebill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and offlinepayregisterid=0 " +
                    "and billyearmonth in :yearMonths and vat>0")
    PropertyBillDemandData getVATDemandData(Integer municipalityId, List<Integer> yearMonths);

    @Query(nativeQuery = true,
            value = "select 'Surcharge' as 'item', count(propertyid) as 'numberOfProperty', round(sum(surcharge)) as 'amount' from t_propertyleasebill " +
                    "where  (:municipalityId = 0 or municipalityid = :municipalityId )" +
                    "and offlinepayregisterid=0 " +
                    "and billyearmonth in :yearMonths and surcharge>0 ")
    PropertyBillDemandData getSurchargeDemandData(Integer municipalityId, List<Integer> yearMonths);
}
