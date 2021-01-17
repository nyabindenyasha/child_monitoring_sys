package com.minimum.model.zimbostoro.vehicle;

import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 1/17/2021
 * @project vehicle_gps_tracking_src
 */

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