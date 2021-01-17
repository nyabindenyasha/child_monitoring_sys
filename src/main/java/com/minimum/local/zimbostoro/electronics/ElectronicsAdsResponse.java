package com.minimum.local.zimbostoro.electronics;

import com.minimum.model.zimbostoro.electronics.ElectronicsAds;
import com.minimum.model.zimbostoro.vehicle.VehicleAds;
import lombok.Data;

import java.util.List;

/**
 * @author Nyabinde Nyasha
 * @created 1/17/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class ElectronicsAdsResponse {

    private String result;
    private List<ElectronicsAds> electronics;
}
