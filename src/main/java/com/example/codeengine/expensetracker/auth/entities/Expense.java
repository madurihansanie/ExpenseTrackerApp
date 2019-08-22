package com.example.codeengine.expensetracker.auth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "expense_date", nullable = false)
    private Date expenseDate;
    private String description;
    private String location;
    @ManyToOne
    private Category category;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Expense(String description, String location, Category category, User user){
        this.description=description;
        this.location=location;
        this.category=category;
        this.user=user;
    }

}
