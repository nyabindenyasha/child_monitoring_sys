package com.minimum.local.zimbostoro.vehicle;

import com.minimum.model.zimbostoro.vehicle.VehicleAds;
import lombok.Data;

import java.util.List;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class VehicleAdsResponse {

    private String result;
    private List<VehicleAds> vehicle;

}
