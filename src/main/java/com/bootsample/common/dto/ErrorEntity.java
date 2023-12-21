package com.bootsample.common.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorEntity {

	@JsonProperty("timestamp")
    private String responDate;
	
    @JsonProperty("status")
    private int httpCode;
    
    @JsonProperty("error")
    private String errorType;
    
    @JsonProperty("message")
    private String errorMesage;
    
    public ErrorEntity() {}

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String message) {
        this.errorMesage = message;
    }
    
    public String getResponDate() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'-0300'");
        return format.format(new Date());
    }
    
    public String getErrorType() {
    	return errorType;
    }
    
    public void setErrorType(String errorType) {
    	this.errorType = errorType;
    }
}