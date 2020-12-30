package com.minimum.local;

import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 12/19/2020
 * @project vehicle_gps_tracking_src
 */

@Data
public class FeaturedAds {

    private long id;
    private String imageURL;
    private String title;
    private String description;
    private String location;
    private String phoneNumber;
    private String whatsAppNumber;
    private String priceZWL;
    private String priceUSD;
    private long mainCategoryId;
    private long subCategoryId;

}
