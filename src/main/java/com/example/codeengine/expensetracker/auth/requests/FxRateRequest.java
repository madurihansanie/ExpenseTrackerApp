package com.example.codeengine.expensetracker.auth.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FxRateRequest {
    @JsonProperty("currency_code")
    private String currencyCode;
    private Double rate;
    @JsonProperty("transaction_type")
    private String transactionType;
    private String status;
}
