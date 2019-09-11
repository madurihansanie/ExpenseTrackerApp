package com.example.codeengine.expensetracker.auth.requests;

import lombok.Data;

@Data
public class FxRateUpdateRequest {
    private Long id;
    private Double rate;
    private String status;

}
