package com.minimum.local;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PharmacyRequest {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String location;
    private MultipartFile file;

}
