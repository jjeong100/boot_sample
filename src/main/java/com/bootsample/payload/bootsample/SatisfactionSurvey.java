package com.bootsample.payload.bootsample;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SatisfactionSurvey {
    @Schema(description = "Connex asset id.", example = "1-OEZ-221")
    private String assetId;
    @Schema(description = "Chassis number.", example = "9BHBH41DBGP633658")
    private String vin;
    @Schema(description = "Product FSC OCN Name", example = "092214A000")
    @JsonProperty("fsc_ocn")
    private String fscOcn;
    @Schema(description = "Car description.", example = "ADAPTADOR COM ANGULO PARA INSTALACOES DE PARAFUSOS E PORCAS")
    private String description;
    @Schema(description = "Billing date.", example = "2012-10-15")
    private String assignedDate;
    @Schema(description = "Fiscal Receipt.", example = "006674-001")
    private String fiscalReceipt;
    @Schema(description = "Connex dealer id.", example = "1-WT-15")
    private String dealerId;
    @Schema(description = "Dealer code.", example = "B05AM09004")
    private String dealerCode;
    @Schema(description = "Dealer name.", example = "TOKSAN COM DE VEIC E PECAS LTD")
    private String dealerName;
    @Schema(description = "Dealer nickname.", example = "Toksan - Valparaiso de  Goias")
    private String dealerNickname;
    @Schema(description = "Salesperson name.", example = "Carlos Soto")
    private String salesManName;
    @Schema(description = "Salesperson code.", example = "23351")
    private String salesManNumber;
    @JsonProperty("ListOfContact")
    List<SurveyContact> listOfContact;
    @JsonProperty("ListOfAccount")
    List<SurveyAccount> listOfAccount;
}
