package com.minimum.contrroller;

import com.minimum.local.VehicleAdsList;
import com.minimum.service.AdsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Api(tags = "ZimboStoroAds")
@RestController
@CrossOrigin
@RequestMapping("/zimbostoroAds")
public class AdsController {

    @Autowired
    private AdsService adsService;

    @ApiOperation(value = "Get Vehicle Ads", response = Iterable.class)
    @GetMapping("/vehicle")
    public ResponseEntity<Iterable<VehicleAdsList>> getVehicleAds() {
        try {
            Iterable<VehicleAdsList> vehicleAds = adsService.getVehicleAds();
            return ResponseEntity.ok().body(vehicleAds);
        } catch (Exception exception) {
            Iterable<VehicleAdsList> iterable = null;
            return new ResponseEntity<Iterable<VehicleAdsList>>(iterable, HttpStatus.BAD_GATEWAY);
        }
    }

}
