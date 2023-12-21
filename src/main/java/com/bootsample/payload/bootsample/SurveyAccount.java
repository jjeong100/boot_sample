package com.bootsample.payload.bootsample;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyAccount {
    @Schema(description = "Connex account id.", example = "1-TYU56")
    private String id;
    @Schema(description = "Connex account integration id.", example = "B05AM99999")
    private String integrationId;
    @Schema(description = "Company name", example = "Motonet Comercio de Veiculos M")
    private String name;
    @Schema(description = "Company nickname", example = "Abrão Reze - Sorocaba")
    private String nickname;
    @Schema(description = "Legal entity CNPJ number.", example = "78753880000164")
    private String document;
    @Schema(description = "It will return PJ, meaning a legal entity.", example = "PJ")
    private String personType;
    @Schema(description = "Address zip code.", example = "4007001")
    @JsonProperty("postalCode")
    private String zipCode;
    @Schema(description = "Address street name.", example = "Rua Tutoia")
    @JsonProperty("street")
    private String streetAddress;
    @Schema(description = "Address house number", example = "380")
    @JsonProperty("number")
    private String streetAddress2;
    @Schema(description = "Address complement.", example = "Andar 3")
    @JsonProperty("complement")
    private String streetAddress3;
    @Schema(description = "Address country.", example = "Paraiso")
    private String county;
    @Schema(description = "Address city.", example = "Brasil")
    private String city;
    @Schema(description = "Address state.", example = "São Paulo ")
    private String state;
    @Schema(description = "Main phone.", example = "2345678")
    @JsonProperty("phone")
    private String mainPhone;
    @Schema(description = "Main Fax phone.", example = "3456789")
    private String fax;
    @Schema(description = "Company email address.", example = "kilosolution2s@gmail.com")
    @JsonProperty("email")
    private String mainEmailAddress;
}
