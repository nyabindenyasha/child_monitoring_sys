package com.minimum.local.zimbostoro.vehicle;

import com.minimum.model.zimbostoro.vehicle.VehicleAds;
import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class VehicleAdsList {

    private String basep;

    private int door_num;
    private String fuel_type;
    private int mileage;
    private String transmission;
    private String vehicle_color;
    private String vehicle_make;
    private String vehicle_model;
    private int vehicle_year;

    private String condition;
    private String description;

    private String mainPicture;
    private String secondPicture;
    private String thirdPicture;
    private String fourthPicture;

    private boolean isDelivery;
    private String localp;
    private String location;
    private boolean on_offer;

    private String phoneNumber1;
    private String phoneNumber2;
    private String whatsappNumber1;
    private String whatsappNumber2;

    private String status;
    private String title;

    public static VehicleAdsList fromVehicleAds(VehicleAds vehicleAds) {
        VehicleAdsList vehicleAdsList = new VehicleAdsList();

        vehicleAdsList.setBasep(vehicleAds.getBasep());
        vehicleAdsList.setDoor_num(vehicleAds.getDoor_num());
        vehicleAdsList.setFuel_type(vehicleAds.getFuel_type());
        vehicleAdsList.setMileage(vehicleAds.getMileage());
        vehicleAdsList.setTransmission(vehicleAds.getTransmission());
        vehicleAdsList.setVehicle_color(vehicleAds.getVehicle_color());
        vehicleAdsList.setVehicle_make(vehicleAds.getVehicle_make());
        vehicleAdsList.setVehicle_model(vehicleAds.getVehicle_model());
        vehicleAdsList.setVehicle_year(vehicleAds.getVehicle_year());
        vehicleAdsList.setCondition(vehicleAds.getCondition());
        vehicleAdsList.setDescription(vehicleAds.getDescription());
        vehicleAdsList.setMainPicture(vehicleAds.getMainPicture());
        vehicleAdsList.setSecondPicture(vehicleAds.getSecondPicture());
        vehicleAdsList.setThirdPicture(vehicleAds.getThirdPicture());
        vehicleAdsList.setFourthPicture(vehicleAds.getFourthPicture());
        vehicleAdsList.setDelivery(vehicleAds.is_delivery());
        vehicleAdsList.setLocalp(vehicleAds.getLocalp());
        vehicleAdsList.setLocation(vehicleAds.getLocation());
        vehicleAdsList.setOn_offer(vehicleAds.isOn_offer());
        vehicleAdsList.setPhoneNumber1(vehicleAds.getPhoneNumber1());
        vehicleAdsList.setPhoneNumber2(vehicleAds.getPhoneNumber2());
        vehicleAdsList.setWhatsappNumber1(vehicleAds.getWhatsappNumber1());
        vehicleAdsList.setWhatsappNumber2(vehicleAds.getWhatsappNumber2());
        vehicleAdsList.setStatus(vehicleAds.getStatus());
        vehicleAdsList.setTitle(vehicleAds.getTitle());

        return vehicleAdsList;
    }
}
