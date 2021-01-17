package com.minimum.model.zimbostoro.electronics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class ElectronicsAds {

    @JsonIgnore
    private static final String BASE_URL = "https://storage.googleapis.com/zimbostoro/adverts/electronics/";

    private String basep;

    private ClassifiedArray classified_array;

    private double display_size;
    private String elec_color;
    private String elec_make;
    private String elec_model;
    private String elec_os;

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
        this.display_size = this.classified_array.getDisplay_size();
        this.elec_color = this.classified_array.getElec_color();
        this.elec_make = this.classified_array.getElec_make();
        this.elec_model = this.classified_array.getElec_model();
        this.elec_os = this.classified_array.getElec_os();

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
    }

}





