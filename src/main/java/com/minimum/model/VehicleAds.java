package com.minimum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class VehicleAds {

    @JsonIgnore
    private static final String BASE_URL = "https://storage.googleapis.com/zimbostoro/adverts/vehicles/";

    private String basep;

    private ClassifiedArray classified_array;

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

    private List<ImageDetails> img_details;

    private String mainPicture;
    private String secondPicture;
    private String thirdPicture;
    private String fourthPicture;

    private boolean is_delivery;
    private String localp;
    private String location;
    private boolean on_offer;

    private List<PhoneDetails> phone_details;

    private String phoneNumber1;
    private String phoneNumber2;
    private String whatsappNumber1;
    private String whatsappNumber2;

    private String status;
    private String title;

    public void setUpFields() {
        this.door_num = this.classified_array.getDoor_num();
        this.fuel_type = this.classified_array.getFuel_type();
        this.mileage = this.classified_array.getMileage();
        this.transmission = this.classified_array.getTransmission();
        this.vehicle_color = this.classified_array.getVehicle_color();
        this.vehicle_make = this.classified_array.getVehicle_make();
        this.vehicle_model = this.classified_array.getVehicle_model();
        this.vehicle_year = this.classified_array.getVehicle_year();

        if (this.img_details.size() > 2) {
            this.secondPicture = BASE_URL + this.img_details.get(1).getLink();
            this.thirdPicture = BASE_URL + this.img_details.get(2).getLink();
            this.mainPicture = BASE_URL + this.img_details.get(0).getLink();
        } else if (this.img_details.size() > 1) {
            this.secondPicture = BASE_URL + this.img_details.get(1).getLink();
            this.mainPicture = BASE_URL + this.img_details.get(0).getLink();
        } else if (this.img_details.size() > 0) {
            this.mainPicture = BASE_URL + this.img_details.get(0).getLink();
        }

        if (this.phone_details.size() > 1) {
            if (this.phone_details.get(0).getPhone_type().equals("call")) {
                this.phoneNumber1 = this.phone_details.get(0).getPhone_no();
            }
            if (this.phone_details.get(1).getPhone_type().equals("call")) {
                this.phoneNumber2 = this.phone_details.get(1).getPhone_no();
            }
            if (this.phone_details.get(0).getPhone_type().equals("whatsapp")) {
                this.whatsappNumber1 = this.phone_details.get(0).getPhone_no();
            }
            if (this.phone_details.get(1).getPhone_type().equals("whatsapp")) {
                this.whatsappNumber1 = this.phone_details.get(1).getPhone_no();
            }
        }

//        this.phone_details.forEach(phoneDetails -> {
//            if(phoneDetails.getPhone_type().equals("call"))
//                this.phoneNumber1 = phoneDetails.getPhone_no();
//            if(phoneDetails.getPhone_type().equals("whatsapp"))
//                this.whatsappNumber1 = phoneDetails.getPhone_no();
//        });

    }

}

