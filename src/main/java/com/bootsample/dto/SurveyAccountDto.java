package com.bootsample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyAccountDto {
    private String id;
    private String integrationId;
    private String name;
    private String nickname;
    private String document;
    private String personType;
    private String zipCode;
    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String county;
    private String city;
    private String state;
    private String mainPhone;
    private String fax;
    private String mainEmailAddress;
}
