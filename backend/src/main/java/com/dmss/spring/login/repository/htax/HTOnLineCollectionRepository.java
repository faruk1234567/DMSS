package com.dmss.spring.login.repository.htax;

import com.dmss.spring.login.models.htx.HoldingTaxBill;
import com.dmss.spring.login.models.wb.WBDemandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface HTOnLineCollectionRepository extends JpaRepository<HoldingTaxBill, Long> {
    @Query(nativeQuery = true,
            value = "select 'Current Tax ' as 'item', count(distinct(a.oidholding)) as 'numberOfConnection', sum((a.paidmoney-(a.Arrearfees+a.surcharge))) as 'amount'  " +
                    "from t_holdingtaxbill a, t_board_ct1035 b \n"+
                    "where (:municipalityId = 0 or a.municipalityid = :municipalityId )" +
                    "and a.paidDate between :fromDateStr and :toDateStr \n" +
                    "and a.oidholding=b.oid \n "+
                    "and a.offlinepayregisterid=0 \n "+
                    "and a.paidmoney>0 \n "+
                    "and (:usertype= '0' or b.usertype= :usertype) ")
    WBDemandData getCurrentHoldingTaxCollectionData(Integer municipalityId, Date fromDateStr, Date toDateStr, String usertype);

    @Query(nativeQuery = true,
            value = "select 'Arrear' as 'item', count(distinct(a.Arrearfees)) as 'numberOfConnection', sum(a.Arrearfees) as 'amount'  " +
                    "from t_holdingtaxbill a, t_board_ct1035 b \n"+
                    "where (:municipalityId = 0 or a.municipalityid = :municipalityId )" +
                    "and a.paidDate between :fromDateStr and :toDateStr \n" +
                    "and a.oidholding=b.oid \n "+
                    "and a.offlinepayregisterid=0 \n "+
                    "and a.Arrearfees>0 \n "+
                    "and (:usertype= '0' or b.usertype= :usertype) ")
    WBDemandData getCurrentHoldingTaxArrearCollectionData(Integer municipalityId, Date fromDateStr, Date toDateStr, String usertype);
    @Query(nativeQuery = true,
            value = "select 'Surcharge' as 'item', count(distinct(a.surcharge)) as 'numberOfConnection', sum(a.surcharge) as 'amount'  " +
                    "from t_holdingtaxbill a, t_board_ct1035 b \n"+
                    "where (:municipalityId = 0 or a.municipalityid = :municipalityId )" +
                    "and a.paidDate between :fromDateStr and :toDateStr \n" +
                    "and a.oidholding=b.oid \n "+
                    "and a.offlinepayregisterid=0 \n "+
                    "and a.surcharge>0 \n "+
                    "and (:usertype= '0' or b.usertype= :usertype) ")
    WBDemandData getCurrentHoldingTaxSurchargeCollectionData(Integer municipalityId, Date fromDateStr, Date toDateStr, String usertype);

}
