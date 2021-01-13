package com.minimum.local;

import com.minimum.model.VehicleAds;
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
