package com.example.codeengine.expensetracker.auth.repos;

import com.example.codeengine.expensetracker.auth.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
