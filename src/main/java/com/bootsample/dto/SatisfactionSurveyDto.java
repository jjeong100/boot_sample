package com.bootsample.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SatisfactionSurveyDto {
    private String assetId;
    private String vin;
    private String fscOcn;
    private String description;
    private String assignedDate;
    private String fiscalReceipt;
    private String dealerId;
    private String dealerCode;
    private String dealerName;
    private String dealerNickname;
    private String salesManName;
    private String salesManNumber;
    private String businessAccountId;
    private String personAccountId;
    List<SurveyContactDto> listOfContact;
    List<SurveyAccountDto> listOfAccount;
}
