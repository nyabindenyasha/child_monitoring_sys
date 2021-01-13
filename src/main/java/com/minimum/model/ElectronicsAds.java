package com.minimum.model;

import lombok.Data;

import java.util.List;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class ElectronicsAds {

    private String basep;

    private ClassifiedArray classified_array;

    private String condition;
    private String description;

    private List<ImageDetails> img_details;

    private boolean is_delivery;
    private String localp;
    private String location;
    private boolean on_offer;

    private List<PhoneDetails> phone_details;

    private String status;
    private String title;

}

@Data
class ClassifiedArray {
    private int door_num;
    private String fuel_type;
    private int mileage;
    private String transmission;
    private String vehicle_color;
    private String vehicle_make;
    private String vehicle_model;
    private int vehicle_year;
}

@Data
class ImageDetails {
    private String link;
}

@Data
class PhoneDetails {
    private String phone_no;
    private String phone_type;
}