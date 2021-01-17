package com.minimum.local.zimbostoro.electronics;

import com.minimum.model.zimbostoro.electronics.ElectronicsAds;
import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 1/17/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class ElectronicsAdsList {

    private String basep;

    private double display_size;
    private String elec_color;
    private String elec_make;
    private String elec_model;
    private String elec_os;

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

    public static ElectronicsAdsList fromElectronicsAds(ElectronicsAds electronicsAds) {
        ElectronicsAdsList electronicsAdsList = new ElectronicsAdsList();

        electronicsAdsList.setBasep(electronicsAds.getBasep());
        electronicsAdsList.setDisplay_size(electronicsAds.getDisplay_size());
        electronicsAdsList.setElec_color(electronicsAds.getElec_color());
        electronicsAdsList.setElec_make(electronicsAds.getElec_make());
        electronicsAdsList.setElec_model(electronicsAds.getElec_model());
        electronicsAdsList.setElec_os(electronicsAds.getElec_os());
        electronicsAdsList.setCondition(electronicsAds.getCondition());
        electronicsAdsList.setDescription(electronicsAds.getDescription());
        electronicsAdsList.setMainPicture(electronicsAds.getMainPicture());
        electronicsAdsList.setSecondPicture(electronicsAds.getSecondPicture());
        electronicsAdsList.setThirdPicture(electronicsAds.getThirdPicture());
        electronicsAdsList.setFourthPicture(electronicsAds.getFourthPicture());
        electronicsAdsList.setDelivery(electronicsAds.is_delivery());
        electronicsAdsList.setLocalp(electronicsAds.getLocalp());
        electronicsAdsList.setLocation(electronicsAds.getLocation());
        electronicsAdsList.setOn_offer(electronicsAds.isOn_offer());
        electronicsAdsList.setPhoneNumber1(electronicsAds.getPhoneNumber1());
        electronicsAdsList.setPhoneNumber2(electronicsAds.getPhoneNumber2());
        electronicsAdsList.setWhatsappNumber1(electronicsAds.getWhatsappNumber1());
        electronicsAdsList.setWhatsappNumber2(electronicsAds.getWhatsappNumber2());
        electronicsAdsList.setStatus(electronicsAds.getStatus());
        electronicsAdsList.setTitle(electronicsAds.getTitle());

        return electronicsAdsList;
    }
}
