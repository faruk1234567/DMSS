package com.dmss.spring.login.repository.tls;

import com.dmss.spring.login.models.tls.TLSDemand;
import com.dmss.spring.login.models.tls.TLSDemandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TLSDemandRepository extends JpaRepository<TLSDemand, Long> {

    @Query(nativeQuery = true, value = "select distinct signboardType from t_board_ct1021 where signboardType <> ''")
    List<String> findSignboardList();


    @Query(nativeQuery = true, value ="select 'Application Fee' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.applyfee) as 'amount' " +
            " from (\n" +
            "select a.licenseno ,a.applyfee, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
           " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
   " ) xyz\n" +
          "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getApplicationFeeDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);


    @Query(nativeQuery = true, value ="select 'License Fee' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.licensefee) as 'amount' " +
            " from (\n" +
            " select a.licenseno ,a.licensefee, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and a.licensefee >0\n" +
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
            " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
            " ) xyz\n" +
            "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getLicenseFeeDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true, value ="select 'Other Fee' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.otherfee) as 'amount' " +
            "from (\n" +
            "select a.licenseno ,a.otherfee, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and a.otherfee>0\n"+
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
            " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
            " ) xyz\n" +
            "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getOtherFeeDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true, value ="select 'Vat ' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.vatfee) as 'amount' " +
            "from (\n" +
            "select a.licenseno ,a.vatfee, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and a.vatfee>0\n"+
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
            " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
            " ) xyz\n" +
            "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getVatDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);
    @Query(nativeQuery = true, value ="select 'Income Tax ' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.incometax) as 'amount' " +
            "from (\n" +
            "select a.licenseno ,a.incometax, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and a.incometax>0\n"+
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
            " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
            " ) xyz\n" +
            "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getIncomeTaxDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true, value ="select 'Arrear Fee' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.arrearfee) as 'amount' " +
            "from (\n" +
            "select a.licenseno ,a.arrearfee, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and a.arrearfee>0\n"+
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
            " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
            " ) xyz\n" +
            "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getArrearDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true, value ="select 'Source Tax' as 'item', count(abc.licenseno) as 'NumberOfLicense', sum(abc.sourcetax) as 'amount' " +
            "from (\n" +
            "select a.licenseno ,a.sourcetax, a.cabinetinstanceid \n"+
            "from t_Board_CT1021 a, t_totaldatabasic b \n"+
            "where a.oid=b.oid \n"+
            "and b.registerdate between :fromDateStr and :toDateStr \n" +
            "and a.applyfee >0\n" +
            "and a.sourcetax>0\n"+
            "and (:cabinetInstanceId = 0 or a.cabinetinstanceid = :cabinetInstanceId)\n"+
            "and (:signboardType = '0' or a.signboardtype = :signboardType)" +
            " ) abc,\n" +
            " (select t.cabinetinstanceid, t.municipalityid \n" +
            "from t_municipalitycabinetinstance t\n"+
            "where (:municipalityId = 0 or t.municipalityid = :municipalityId)\n"+
            " ) xyz\n" +
            "  where abc.cabinetinstanceid=xyz.cabinetinstanceid \n")

    TLSDemandData getSourceTaxDemandData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);
}


