package com.dmss.spring.login.services.dashboard;

import com.dmss.spring.login.models.dashboard.MunicipalityServiceCountAndIncomeData;
import com.dmss.spring.login.models.dashboard.ServiceCountAndIncomeData;
import com.dmss.spring.login.repository.dashboard.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public ServiceCountAndIncomeData serviceCountAndIncome() {
        ServiceCountAndIncomeData serviceCountAndIncomeData = new ServiceCountAndIncomeData();
        try{
            Map<String, Object> serviceCountAndIncome = this.dashboardRepository.getTotalServiceCountAndIncome().get(0);
            this.prepareResponseData(serviceCountAndIncome, serviceCountAndIncomeData);

        } catch (Exception e){
            e.printStackTrace();
        }

        return serviceCountAndIncomeData;
    }

    public ServiceCountAndIncomeData getWaterBillServiceCountAndIncome() {
        ServiceCountAndIncomeData serviceCountAndIncomeData = new ServiceCountAndIncomeData();
        try{
            Map<String, Object> serviceCountAndIncome = this.dashboardRepository.getWaterBillServiceCountAndIncome().get(0);
            this.prepareResponseData(serviceCountAndIncome, serviceCountAndIncomeData);

        } catch (Exception e){
            e.printStackTrace();
        }

        return serviceCountAndIncomeData;
    }

    public ServiceCountAndIncomeData getTLServiceCountAndIncome() {
        ServiceCountAndIncomeData serviceCountAndIncomeData = new ServiceCountAndIncomeData();
        try{
            Map<String, Object> serviceCountAndIncome = this.dashboardRepository.getTLServiceCountAndIncome().get(0);
            this.prepareResponseData(serviceCountAndIncome, serviceCountAndIncomeData);

        } catch (Exception e){
            e.printStackTrace();
        }

        return serviceCountAndIncomeData;
    }

    public ServiceCountAndIncomeData getHTServiceCountAndIncome() {
        ServiceCountAndIncomeData serviceCountAndIncomeData = new ServiceCountAndIncomeData();
        try{
            Map<String, Object> serviceCountAndIncome = this.dashboardRepository.getHTServiceCountAndIncome().get(0);
            this.prepareResponseData(serviceCountAndIncome, serviceCountAndIncomeData);

        } catch (Exception e){
            e.printStackTrace();
        }

        return serviceCountAndIncomeData;
    }

    public ServiceCountAndIncomeData getCertificateServiceCountAndIncome() {
        ServiceCountAndIncomeData serviceCountAndIncomeData = new ServiceCountAndIncomeData();
        try{
            Map<String, Object> serviceCountAndIncome = this.dashboardRepository.getCertificateServiceCountAndIncome().get(0);
            this.prepareResponseData(serviceCountAndIncome, serviceCountAndIncomeData);

        } catch (Exception e){
            e.printStackTrace();
        }

        return serviceCountAndIncomeData;
    }

    public ServiceCountAndIncomeData getPropertyServiceCountAndIncome() {
        ServiceCountAndIncomeData serviceCountAndIncomeData = new ServiceCountAndIncomeData();
        try{
            Map<String, Object> serviceCountAndIncome = this.dashboardRepository.getPropertyServiceCountAndIncome().get(0);
            this.prepareResponseData(serviceCountAndIncome, serviceCountAndIncomeData);
        } catch (Exception e){
            e.printStackTrace();
        }

        return serviceCountAndIncomeData;
    }

    private void prepareResponseData(Map<String, Object> serviceCountAndIncome, ServiceCountAndIncomeData serviceCountAndIncomeData) {
        serviceCountAndIncomeData.setTotalService(Long.parseLong(serviceCountAndIncome.get("totalService").toString()));
        serviceCountAndIncomeData.setTotalIncome((long) Double.parseDouble(serviceCountAndIncome.get("totalIncome").toString()));
    }

    public List<MunicipalityServiceCountAndIncomeData> getServiceCountAndIncomeByMunicipality() {
        List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList = new ArrayList<>();

        try {
            List<Object[]> totalServiceCountAndIncomeMunicipality = this.dashboardRepository.getTotalServiceCountAndIncomeMunicipality();
            this.prepareResponseData(municipalityServiceCountAndIncomeDataList, totalServiceCountAndIncomeMunicipality);
        } catch (Exception e){
            e.printStackTrace();
        }

        return municipalityServiceCountAndIncomeDataList;
    }

    public List<MunicipalityServiceCountAndIncomeData> getWaterServiceCountAndIncomeByMunicipality() {
        List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList = new ArrayList<>();

        try {
            List<Object[]> totalServiceCountAndIncomeMunicipality = this.dashboardRepository.getTotalServiceCountAndIncomeMunicipalityForWater();
            this.prepareResponseData(municipalityServiceCountAndIncomeDataList, totalServiceCountAndIncomeMunicipality);
        } catch (Exception e){
            e.printStackTrace();
        }

        return municipalityServiceCountAndIncomeDataList;
    }

    public List<MunicipalityServiceCountAndIncomeData> getHTServiceCountAndIncomeByMunicipality() {
        List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList = new ArrayList<>();

        try {
            List<Object[]> totalServiceCountAndIncomeMunicipality = this.dashboardRepository.getHTServiceCountAndIncomeByMunicipality();
            this.prepareResponseData(municipalityServiceCountAndIncomeDataList, totalServiceCountAndIncomeMunicipality);
        } catch (Exception e){
            e.printStackTrace();
        }

        return municipalityServiceCountAndIncomeDataList;
    }

    public List<MunicipalityServiceCountAndIncomeData> getTLServiceCountAndIncomeByMunicipality() {
        List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList = new ArrayList<>();

        try {
            List<Object[]> totalServiceCountAndIncomeMunicipality = this.dashboardRepository.getTLServiceCountAndIncomeByMunicipality();
            this.prepareResponseData(municipalityServiceCountAndIncomeDataList, totalServiceCountAndIncomeMunicipality);
        } catch (Exception e){
            e.printStackTrace();
        }

        return municipalityServiceCountAndIncomeDataList;
    }

    public List<MunicipalityServiceCountAndIncomeData> getPropertyServiceCountAndIncomeByMunicipality() {
        List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList = new ArrayList<>();

        try {
            List<Object[]> totalServiceCountAndIncomeMunicipality = this.dashboardRepository.getPropertyServiceCountAndIncomeByMunicipality();
            this.prepareResponseData(municipalityServiceCountAndIncomeDataList, totalServiceCountAndIncomeMunicipality);
        } catch (Exception e){
            e.printStackTrace();
        }

        return municipalityServiceCountAndIncomeDataList;
    }

    public List<MunicipalityServiceCountAndIncomeData> getCertificateServiceCountAndIncomeByMunicipality() {
        List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList = new ArrayList<>();

        try {
            List<Object[]> totalServiceCountAndIncomeMunicipality = this.dashboardRepository.getCertificateServiceCountAndIncomeByMunicipality();
            this.prepareResponseData(municipalityServiceCountAndIncomeDataList, totalServiceCountAndIncomeMunicipality);
        } catch (Exception e){
            e.printStackTrace();
        }

        return municipalityServiceCountAndIncomeDataList;
    }

    private void prepareResponseData(List<MunicipalityServiceCountAndIncomeData> municipalityServiceCountAndIncomeDataList, List<Object[]> totalServiceCountAndIncomeMunicipality) {
        for (Object[] objects : totalServiceCountAndIncomeMunicipality) {
            MunicipalityServiceCountAndIncomeData municipalityServiceCountAndIncomeData = new MunicipalityServiceCountAndIncomeData();
            municipalityServiceCountAndIncomeData.setMunicipalityName(objects[0].toString());
            municipalityServiceCountAndIncomeData.setTotalService(Integer.parseInt(objects[1].toString()));
            municipalityServiceCountAndIncomeData.setTotalIncome((int) Double.parseDouble(objects[2].toString()));

            municipalityServiceCountAndIncomeDataList.add(municipalityServiceCountAndIncomeData);
        }
    }


}
