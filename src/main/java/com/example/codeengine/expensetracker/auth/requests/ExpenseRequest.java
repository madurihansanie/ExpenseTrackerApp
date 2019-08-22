package com.example.codeengine.expensetracker.auth.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequest {
    private String description;
    private String location;
}
