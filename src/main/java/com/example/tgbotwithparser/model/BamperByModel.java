package com.example.tgbotwithparser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BamperByModel {
    private String url;
    private String title;
    private String vendorCode;
    private String VIN;
    private String partNumber;
//    private String options;
    private String description;
    private String price;
    private String date;
    private String location;
}
