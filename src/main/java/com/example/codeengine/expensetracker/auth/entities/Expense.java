package com.example.codeengine.expensetracker.auth.entities;

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
    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;
}
