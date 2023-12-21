package com.bootsample.payload.bootsample;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyContact {
    @Schema(description = "Connex contact id.", example = "1-U1V4")
    private String id;
    @Schema(description = "External system unique identifier.", example = "1-7890WX")
    private String integrationId;
    @Schema(description = "Contact first name", example = "Jose")
    private String firstName;
    @Schema(description = "Contact last name", example = "Ciclano")
    private String lastName;
    @Schema(description = "Individual's document number (numbers only)", example = "12337343006")
    private String document;
    @Schema(description = "Gender.", example = "Male")
    private String sex;
    @Schema(description = "It will return PF, meaning an individual.", example = "Dealer")
    private String personType;
    @Schema(description = "Zipcode.", example = "4007001")
    private String postalCode;
    @Schema(description = "Address street.", example = "Rua Tutoia")
    private String street;
    @Schema(description = "Address number.", example = "380")
    private String number;
    @Schema(description = "Address complement.", example = "Andar 3")
    private String complement;
    @Schema(description = "Address country.", example = "Paraiso")
    private String county;
    @Schema(description = "Address city.", example = "Brasil")
    private String city;
    @Schema(description = "Address state.", example = "São Paulo ")
    private String state;
    @Schema(description = "Home phone.", example = "+55(15)30349000")
    private String homePhone;
    @Schema(description = "Work phone.", example = "3456789")
    private String workPhone;
    @Schema(description = "Cel phone.", example = "1196588890")
    private String cellularPhone;
    @Schema(description = "Email.", example = "kilosolution2s@gmail.com")
    private String email;
}
