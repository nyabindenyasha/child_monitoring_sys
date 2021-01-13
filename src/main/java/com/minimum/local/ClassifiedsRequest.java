package com.minimum.local;

import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 1/13/2021
 * @project vehicle_gps_tracking_src
 */

@Data
public class ClassifiedsRequest {
    private String request_location = "web";
    private String request_type = "select";
    private String section = "classified";
    private String classified_type;
    private int category_id;
    private int sub_category_id = 0;

    public static ClassifiedsRequest fromCommand(int category_id, String classified_type) {

        ClassifiedsRequest classifiedsRequest = new ClassifiedsRequest();
        classifiedsRequest.setCategory_id(category_id);
        classifiedsRequest.setClassified_type(classified_type);
        classifiedsRequest.setRequest_location("web");
        classifiedsRequest.setRequest_type("select");
        classifiedsRequest.setSection("classified");
        classifiedsRequest.setSub_category_id(0);
        return classifiedsRequest;
    }
}
