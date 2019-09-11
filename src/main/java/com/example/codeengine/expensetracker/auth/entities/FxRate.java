package com.example.codeengine.expensetracker.auth.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name = "fx_rate")
public class FxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="currency_code")
    private String currencyCode;
    private Double rate;
    @Column(name="transaction_type")
    private String transactionType;
    private String status;

    public FxRate(String currencyCode, Double rate, String transactionType, String status) {
        this.currencyCode = currencyCode;
        this.rate = rate;
        this.transactionType = transactionType;
        this.status = status;
    }
}
