package com.example.codeengine.expensetracker.auth.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double test;


    public Category(String name) {
        this.name = name;
    }
    public Category(String name, Double test) {
        this.name = name;
        this.test =test;
    }
}
