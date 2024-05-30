package com.dmss.spring.login.repository.htax;

import com.dmss.spring.login.models.htx.HoldingTaxBill;
import com.dmss.spring.login.models.htx.HoldingTaxDemandData;
import com.dmss.spring.login.models.wb.WBDemandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HTDemandRepository extends JpaRepository<HoldingTaxBill, Long> {
    @Query(value = "select distinct(usertype) from t_board_ct1035 where usertype <> ''", nativeQuery = true)
    List<String> findDistinctUserType();

    @Query(nativeQuery = true,
            value = "select 'Current' as 'item', count(distinct(a.oidholding)) as 'numberOfConnection', sum(a.QuarterTotalBill) as 'amount'  " +
                    "from t_holdingtaxbill a, t_board_ct1035 b \n"+
                    "where (:municipalityId = 0 or a.municipalityid = :municipalityId )" +
                    "and a.billingdate between :fromDateStr and :toDateStr \n" +
                    "and a.oidholding=b.oid \n "+
                    "and (:usertype= '0' or b.usertype= :usertype) ")
    WBDemandData getCurrentHoldingTaxDemandData(Integer municipalityId, Date fromDateStr, Date toDateStr, String usertype);

    @Query(nativeQuery = true,
            value = "select 'Arrear' as 'item', count(distinct(a.oidholding)) as 'numberOfConnection', sum(a.Arrearfees) as 'amount'  " +
                    "from t_holdingtaxbill a, t_board_ct1035 b \n"+
                    "where (:municipalityId = 0 or a.municipalityid = :municipalityId )" +
                    "and a.billingdate between :fromDateStr and :toDateStr \n" +
                    "and a.oidholding=b.oid \n "+
                    "and a.Arrearfees>0 \n"+
                    "and (:usertype= '0' or b.usertype= :usertype) ")
    WBDemandData getCurrentHoldingTaxArrearData(Integer municipalityId, Date fromDateStr, Date toDateStr, String usertype);
    @Query(nativeQuery = true,
            value = "select 'Surcharge' as 'item', count(distinct(a.oidholding)) as 'numberOfConnection', sum(a.surcharge) as 'amount'  " +
                    "from t_holdingtaxbill a, t_board_ct1035 b \n"+
                    "where (:municipalityId = 0 or a.municipalityid = :municipalityId )" +
                    "and a.billingdate between :fromDateStr and :toDateStr \n" +
                    "and a.oidholding=b.oid \n "+
                    "and a.surcharge>0 \n"+
                    "and a.Arrearfees>0 \n"+
                    "and (:usertype= '0' or b.usertype= :usertype) ")
    WBDemandData getCurrentHoldingTaxSurchargeData(Integer municipalityId, Date fromDateStr, Date toDateStr, String usertype);
}

