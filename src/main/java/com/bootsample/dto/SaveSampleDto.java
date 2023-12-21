package com.bootsample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveSampleDto {
    private String rowId;
    private String contactId;
    private String appSource;
    private String appStatus;
    private String errorSpcCode;
    private String errorSpcMessage;
    private String loyaltyStatus;
}
