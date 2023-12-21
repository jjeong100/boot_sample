package com.bootsample.payload.bootsample;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class SelectSamplePayload {
    
    @Schema(name = "IFHMBINNOCEANCDPP0089Payload.Request")
    @Getter
    @Setter
    public static class Request{
        @Schema(description = "Billing start date for search.Format: YYYY-MM-DD", example = "2017-11-29")
        @NotNull @NotBlank @NotEmpty
        private String startDate;
        @Schema(description = "Billing end date for search.Format: YYYY-MM-DD", example = "2017-11-30")
        @NotNull @NotBlank @NotEmpty
        private String endDate;
    }

    @Schema(name = "IFHMBINNOCEANCDPP0089Payload.Response")
    @Getter
    @Setter
    public static class Response{
        @Schema(description = "Connex error code. Code 0 means success.", example = "0")
        @JsonProperty("Error_spcCode")
        private String errorSpcCode;
        @Schema(description = "Connex error message.", example = "OK")
        @JsonProperty("Error_spcMessage")
        private String errorSpcMessage;
        @JsonProperty("ListOfSatisfactionSurveyOut")
        List<SatisfactionSurvey> listOfSatisfactionSurvey;
    }
}
