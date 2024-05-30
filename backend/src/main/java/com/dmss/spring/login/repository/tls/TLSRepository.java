package com.dmss.spring.login.repository.tls;

import com.dmss.spring.login.models.tls.TLSRecoveryData;
import com.dmss.spring.login.models.wb.WaterBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TLSRepository extends JpaRepository<WaterBill, Long> {

    @Query(nativeQuery = true, value = "select distinct signboardType from t_board_ct1021 where signboardType <> ''")
    List<String> findSignboardList();

    @Query(nativeQuery = true, value = "select xyz.serialno, xyz.licenseno, xyz.mobileno, abc.customername as customer, ifnull(xyz.categorynameB, xyz.categorynameEn) category,\n" +
            "       xyz.signboardtype, xyz.height, xyz.width, xyz.licensefee, xyz.sourcetax, xyz.vatfee as vat, xyz.incometax, xyz.signboardpersft as signboardPerSqft, xyz.signboardfee,\n" +
            "       xyz.arrearfee, xyz.otherfee, xyz.arrearvat, xyz.createday as createdDate, abc.transactiondate as tranDate, abc.transactionamount as tranAmount\n" +
            "from (\n" +
            "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
            "      from t_paymenthistory p, t_tradelicensehistory th\n" +
            "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
            "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
            "        and p.transactiontype = 6\n" +
            "    ) abc,\n" +
            "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
            "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
            "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
            "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
            "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
            "        and ti.businesscategory = tc.categoryid\n" +
            "     ) xyz\n" +
            "where abc.oid = xyz.oid and xyz.serialNo = :serialNo and xyz.municipalityid = abc.municipalityid\n" +
            "group by transactiondate\n")
    List<TLSRecoveryData> getTLSRecoveryDetailDataBySerialNo(String serialNo, String fromDateStr, String toDateStr, Integer cabinetInstanceId);


    @Query(nativeQuery = true, value = "select xyz.serialno, xyz.licenseno, xyz.mobileno, abc.customername as customer, ifnull(xyz.categorynameB, xyz.categorynameEn) category,\n" +
            "       xyz.signboardtype, xyz.height, xyz.width, xyz.licensefee, xyz.sourcetax, xyz.vatfee as vat, xyz.incometax, xyz.signboardpersft as signboardPerSqft, xyz.signboardfee,\n" +
            "       xyz.arrearfee, xyz.otherfee, xyz.arrearvat, xyz.createday as createdDate, abc.transactiondate as tranDate, abc.transactionamount as tranAmount\n" +
            "from (\n" +
            "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
            "      from t_paymenthistory p, t_tradelicensehistory th\n" +
            "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
            "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
            "        and p.transactiontype = 6\n" +
            "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
            "    ) abc,\n" +
            "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
            "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
            "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
            "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
            "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
            "        and ti.businesscategory = tc.categoryid\n" +
            "     ) xyz\n" +
            "where abc.oid = xyz.oid " +
            "and xyz.municipalityid = abc.municipalityid\n" +
            "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    List<TLSRecoveryData> getTLSRecoveryDetailData(Integer municipalityId, String signboardType, String fromDateStr, String toDateStr, Integer cabinetInstanceId);
}
