package com.minimum.service;

import com.minimum.local.ClassifiedsRequest;
import com.minimum.local.zimbostoro.electronics.ElectronicsAdsList;
import com.minimum.local.zimbostoro.electronics.ElectronicsAdsResponse;
import com.minimum.local.zimbostoro.vehicle.VehicleAdsList;
import com.minimum.local.zimbostoro.vehicle.VehicleAdsResponse;
import com.minimum.model.zimbostoro.electronics.ElectronicsAds;
import com.minimum.model.zimbostoro.vehicle.VehicleAds;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Service
public class AdsService {

    public List<ElectronicsAdsList> getElectronicsAds() {
        try {
            ClassifiedsRequest classifiedsRequest = ClassifiedsRequest.fromCommand(1, "electronics");
            final String uri = "https://bot-dot-zimbostoro-289609.uc.r.appspot.com/database/live";
            RestTemplate restTemplate = new RestTemplate();
            ElectronicsAdsResponse result = restTemplate.postForObject(uri, classifiedsRequest, ElectronicsAdsResponse.class);
            Iterable<ElectronicsAds> electronicsAds = result.getElectronics();
            List<ElectronicsAdsList> electronicsAdsLists = new ArrayList<>();
            electronicsAds.forEach(electronicsAd -> {
                electronicsAd.setUpFields();
                ElectronicsAdsList adsList = ElectronicsAdsList.fromElectronicsAds(electronicsAd);
                electronicsAdsLists.add(adsList);
            });
            System.out.println("done");
            return electronicsAdsLists;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public List<VehicleAdsList> getVehicleAds() {
        try {
            ClassifiedsRequest classifiedsRequest = ClassifiedsRequest.fromCommand(2, "vehicle");
            final String uri = "https://bot-dot-zimbostoro-289609.uc.r.appspot.com/database/live";
            RestTemplate restTemplate = new RestTemplate();
            VehicleAdsResponse result = restTemplate.postForObject(uri, classifiedsRequest, VehicleAdsResponse.class);
            System.out.println(result);
            Iterable<VehicleAds> vehicleAds = result.getVehicle();
            List<VehicleAdsList> vehicleAdsLists = new ArrayList<>();
            vehicleAds.forEach(vehicleAds1 -> {
                vehicleAds1.setUpFields();
                VehicleAdsList adsList = VehicleAdsList.fromVehicleAds(vehicleAds1);
                vehicleAdsLists.add(adsList);
            });
            System.out.println("done");
            return vehicleAdsLists;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

}
