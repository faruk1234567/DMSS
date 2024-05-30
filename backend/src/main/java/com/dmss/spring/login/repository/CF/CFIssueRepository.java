package com.dmss.spring.login.repository.CF;

import com.dmss.spring.login.models.PB.PropertyBillDemandData;
import com.dmss.spring.login.models.tls.TLSDemandData;
import com.dmss.spring.login.models.wb.WaterBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface CFIssueRepository extends JpaRepository<WaterBill, Long> {

    @Query(nativeQuery = true, value ="select 'Succession' as 'item', count(ct1015.serialNo) as 'numberOfProperty', sum(p.amount) as 'amount' " +
            "      from t_paymenthistory p,t_Board_CT1015 ct1015\n" +
            "      where p.orderid=ct1015.oid and ct1015.fee<>-1 and p.status = 1\n" +
            "       and p.transactiondate between :fromDateStr and :toDateStr \n" +
            "and (:cabinetInstanceId = 0 or ct1015.cabinetinstanceid = :cabinetInstanceId)\n"+
            "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)")
    PropertyBillDemandData getSuccessionIssue(Integer municipalityId, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true, value ="select 'Character' as 'item', count(ct1015.serialNo) as 'numberOfProperty', sum(p.amount) as 'amount' " +
            "      from t_paymenthistory p,t_Board_CT1016 ct1015\n" +
            "      where p.orderid=ct1015.oid and ct1015.fee<>-1 and p.status = 1\n" +
            "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
            "and (:cabinetInstanceId = 0 or ct1015.cabinetinstanceid = :cabinetInstanceId)\n"+
            "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)")
    PropertyBillDemandData getCharacterIssue(Integer municipalityId,  Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

}
