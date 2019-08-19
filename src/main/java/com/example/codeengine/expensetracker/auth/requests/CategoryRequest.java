package com.example.codeengine.expensetracker.auth.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    @JsonProperty("category_name")
    private String name;

}
