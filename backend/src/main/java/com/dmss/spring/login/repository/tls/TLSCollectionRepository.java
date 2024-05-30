package com.dmss.spring.login.repository.tls;

import com.dmss.spring.login.models.tls.TLSDemand;
import com.dmss.spring.login.models.tls.TLSDemandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TLSCollectionRepository extends  JpaRepository<TLSDemand, Long> {
    @Query(nativeQuery = true, value = "select distinct signboardType from t_board_ct1021 where signboardType <> ''")
    List<String> findSignboardList();

    @Query(nativeQuery = true, value ="select 'Application Fee' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.applyfee) as 'amount' " +
            "from (\n" +
            "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
            "      from t_paymenthistory p, t_tradelicensehistory th\n" +
            "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
            "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
            "        and p.transactiontype = 5\n" +
            "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
            "    ) abc,\n" +
            "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
            "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
            "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
            "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
            "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
            "        and ti.businesscategory = tc.categoryid\n" +
            "     ) xyz\n" +
            "where abc.oid = xyz.oid " +
            "and xyz.municipalityid = abc.municipalityid\n" +
            "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    TLSDemandData getApplicationFeeCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true, value ="select 'License Fee' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.licensefee) as 'amount' " +

            "from (\n" +
            "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
            "      from t_paymenthistory p, t_tradelicensehistory th\n" +
            "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
            "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
            "        and p.transactiontype = 6\n" +
            "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
            "    ) abc,\n" +
            "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
            "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
            "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
            "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
            "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
            "        and ti.businesscategory = tc.categoryid\n" +
            "     ) xyz\n" +
            "where abc.oid = xyz.oid " +
            "and xyz.municipalityid = abc.municipalityid\n" +
            "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    TLSDemandData getLicenseFeeCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true,
            value = "select 'Other Fee' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.otherfee) as 'amount'  " +
                    "from (\n" +
                    "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
                    "      from t_paymenthistory p, t_tradelicensehistory th\n" +
                    "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
                    "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
                    "        and p.transactiontype = 6\n" +
                    "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
                    "    ) abc,\n" +
                    "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
                    "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
                    "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
                    "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
                    "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
                    "       and ti.businesscategory = tc.categoryid\n" +
                    " and ti.otherfee>0\n"+
                    "     ) xyz\n" +
                    "where abc.oid = xyz.oid " +
                    "and xyz.municipalityid = abc.municipalityid\n" +
                    "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")

    TLSDemandData getOtherFeeCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);

    @Query(nativeQuery = true,
            value = "select 'Vat' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.vatfee) as 'amount'  " +
                    "from (\n" +
                    "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
                    "      from t_paymenthistory p, t_tradelicensehistory th\n" +
                    "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
                    "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
                    "        and p.transactiontype = 6\n" +
                    "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
                    "    ) abc,\n" +
                    "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
                    "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
                    "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
                    "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
                    "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
                    "        and ti.businesscategory = tc.categoryid\n" +
                    "       and ti.vatfee>0\n"+
                    "     ) xyz\n" +
                    "where abc.oid = xyz.oid " +
                    "and xyz.municipalityid = abc.municipalityid\n" +
                    "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    TLSDemandData getVatCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);
    @Query(nativeQuery = true,
            value = "select 'Income tax' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.incometax) as 'amount'  " +
                    "from (\n" +
                    "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
                    "      from t_paymenthistory p, t_tradelicensehistory th\n" +
                    "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
                    "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
                    "        and p.transactiontype = 6\n" +
                    "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
                    "    ) abc,\n" +
                    "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
                    "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
                    "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
                    "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
                    "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
                    "        and ti.businesscategory = tc.categoryid\n" +
                    "and ti.incometax>0\n"+
                    "     ) xyz\n" +
                    "where abc.oid = xyz.oid " +
                    "and xyz.municipalityid = abc.municipalityid\n" +
                    "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    TLSDemandData getIncomeTaxCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);
    @Query(nativeQuery = true,
            value = "select 'Arrear' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.arrearfee) as 'amount' " +
                    "from (\n" +
                    "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
                    "      from t_paymenthistory p, t_tradelicensehistory th\n" +
                    "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
                    "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
                    "        and p.transactiontype = 6\n" +
                    "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
                    "    ) abc,\n" +
                    "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
                    "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
                    "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
                    "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
                    "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
                    "        and ti.businesscategory = tc.categoryid\n" +
                    "        and ti.arrearfee>0\n" +
                    "     ) xyz\n" +
                    "where abc.oid = xyz.oid " +
                    "and xyz.municipalityid = abc.municipalityid\n" +
                    "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    TLSDemandData getArrearCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);
    @Query(nativeQuery = true,
            value = "select 'Source Tax' as 'item', count(xyz.licenseno) as 'NumberOfLicense', sum(xyz.sourceTax) as 'amount'  " +
                    "from (\n" +
                    "    select p.transactionid, p.transactiontype, p.municipalityid, p.transactiondate, p.customername, p.amount as Transactionamount, th.oid, p.status\n" +
                    "      from t_paymenthistory p, t_tradelicensehistory th\n" +
                    "      where p.orderid = th.oid and th.processtype = 9 and th.actiontype = 4 and p.status = 1\n" +
                    "        and p.transactiondate between :fromDateStr and :toDateStr \n" +
                    "        and p.transactiontype = 6\n" +
                    "        and (:municipalityId = 0 or p.municipalityid = :municipalityId)\n" +
                    "    ) abc,\n" +
                    "     (select ti.businesscategory as CategoryID, tc.namelang4 as CategoryNameEN, tc.namelang5 as CategoryNameB, tc.municipalityid, ti.fathername, ti.mobileno,\n" +
                    "             ti.height, ti.width, ti.signboardtype, ti.licensefee, ti.sourcetax, ti.vatfee,ti.applyfee, ti.incometax, ti.signboardpersft, ti.totalfee as Tfwithoutsf,\n" +
                    "             (ti.height * ti.width * ti.signboardpersft) as signboardfee, ti.serialno, ti.arrearfee, (ti.arrearfee) * 15 / 100 as arrearvat, otherfee, ti.licenseno, ti.createday, ti.oid\n" +
                    "      from t_board_ct1021 ti, t_tradelicensecategoryfee tc\n" +
                    "      where (:cabinetInstanceId = 0 or ti.cabinetinstanceid = :cabinetInstanceId) \n" +
                    "        and ti.businesscategory = tc.categoryid\n" +
                    "and ti.sourcetax>0\n"+
                    "     ) xyz\n" +
                    "where abc.oid = xyz.oid " +
                    "and xyz.municipalityid = abc.municipalityid\n" +
                    "and (:signboardType = '0' or xyz.signboardtype = :signboardType)")
    TLSDemandData getSourceTaxCollectionData(Integer municipalityId, String signboardType, Date fromDateStr, Date toDateStr, Integer cabinetInstanceId);



}


