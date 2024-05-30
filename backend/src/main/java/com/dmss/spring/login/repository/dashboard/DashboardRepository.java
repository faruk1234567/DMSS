package com.dmss.spring.login.repository.dashboard;

import com.dmss.spring.login.models.Municipality;
import com.dmss.spring.login.models.dashboard.MunicipalityServiceCountAndIncomeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DashboardRepository extends JpaRepository<Municipality, Integer> {

    @Query(nativeQuery = true, value ="select count(transactionid) totalService, round(sum(amount), 2) totalIncome from t_paymenthistory where status=1")
    List<Map<String, Object>> getTotalServiceCountAndIncome() throws Exception;

    @Query(nativeQuery = true, value ="select count(transactionid) totalService, round(sum(amount), 2) totalIncome from t_paymenthistory where transactiontype=2 and status=1")
    List<Map<String, Object>> getWaterBillServiceCountAndIncome() throws Exception;

    @Query(nativeQuery = true, value ="select count(transactionid) totalService, round(sum(amount), 2) totalIncome from t_paymenthistory where transactiontype in(5,6) and status=1")
    List<Map<String, Object>> getTLServiceCountAndIncome() throws Exception;

    @Query(nativeQuery = true, value ="select count(transactionid) totalService, round(sum(amount), 2) totalIncome from t_paymenthistory where transactiontype=1 and status=1")
    List<Map<String, Object>> getHTServiceCountAndIncome() throws Exception;

    @Query(nativeQuery = true, value ="select count(transactionid) totalService, round(sum(amount), 2) totalIncome from t_paymenthistory where transactiontype=4 and status=1")
    List<Map<String, Object>> getCertificateServiceCountAndIncome() throws Exception;

    @Query(nativeQuery = true, value ="select count(transactionid) totalService, round(sum(amount), 2) totalIncome from t_paymenthistory where transactiontype=3 and status=1")
    List<Map<String, Object>> getPropertyServiceCountAndIncome() throws Exception;

    @Query(nativeQuery = true, value ="SELECT t_municipality.NameLang3 municipalityName ,COUNT(transactionid) totalService, round(SUM(amount)) totalIncome\n" +
            "FROM t_paymenthistory inner join t_municipality on t_municipality.MunicipalityID = t_paymenthistory.MunicipalityID\n" +
            "WHERE status = 1\n" +
            "GROUP BY municipalityName\n" +
            "order BY municipalityName")
    List<Object[]> getTotalServiceCountAndIncomeMunicipality();

    @Query(nativeQuery = true, value ="SELECT t_municipality.NameLang3 municipalityName , COUNT(transactionid) totalService, round(SUM(amount)) totalIncome\n" +
            "FROM t_paymenthistory inner join t_municipality on t_municipality.MunicipalityID = t_paymenthistory.MunicipalityID and t_paymenthistory.status = 1 and t_paymenthistory.transactiontype=2\n" +
            "GROUP BY municipalityName\n" +
            "order BY municipalityName")
    List<Object[]> getTotalServiceCountAndIncomeMunicipalityForWater();

    @Query(nativeQuery = true, value ="SELECT t_municipality.NameLang3 municipalityName , COUNT(transactionid) totalService, round(SUM(amount)) totalIncome\n" +
            "FROM t_paymenthistory inner join t_municipality on t_municipality.MunicipalityID = t_paymenthistory.MunicipalityID WHERE status = 1 and t_paymenthistory.transactiontype=1\n" +
            "GROUP BY municipalityName\n" +
            "order BY municipalityName")
    List<Object[]> getHTServiceCountAndIncomeByMunicipality();

    @Query(nativeQuery = true, value ="SELECT t_municipality.NameLang3 municipalityName , COUNT(transactionid) totalService, round(SUM(amount)) totalIncome\n" +
            "FROM t_paymenthistory inner join t_municipality on t_municipality.MunicipalityID = t_paymenthistory.MunicipalityID WHERE status = 1 and t_paymenthistory.transactiontype in(5,6)\n" +
            "GROUP BY municipalityName\n" +
            "order BY municipalityName")
    List<Object[]> getTLServiceCountAndIncomeByMunicipality();

    @Query(nativeQuery = true, value ="SELECT t_municipality.NameLang3 municipalityName , COUNT(transactionid) totalService, round(SUM(amount)) totalIncome\n" +
            "FROM t_paymenthistory inner join t_municipality on t_municipality.MunicipalityID = t_paymenthistory.MunicipalityID WHERE status = 1 and t_paymenthistory.transactiontype=3\n" +
            "GROUP BY municipalityName\n" +
            "order BY municipalityName")
    List<Object[]> getPropertyServiceCountAndIncomeByMunicipality();

    @Query(nativeQuery = true, value ="SELECT t_municipality.NameLang3 municipalityName , COUNT(transactionid) totalService, round(SUM(amount)) totalIncome\n" +
            "FROM t_paymenthistory inner join t_municipality on t_municipality.MunicipalityID = t_paymenthistory.MunicipalityID WHERE status = 1 and t_paymenthistory.transactiontype=4\n" +
            "GROUP BY municipalityName\n" +
            "order BY municipalityName")
    List<Object[]> getCertificateServiceCountAndIncomeByMunicipality();
}
