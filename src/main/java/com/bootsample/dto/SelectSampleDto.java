package com.bootsample.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectSampleDto {
    
    private String startDate;
    private String endDate;

    private String errorSpcCode;
    private String errorSpcMessage;
    List<SatisfactionSurveyDto> listOfSatisfactionSurvey;
}
