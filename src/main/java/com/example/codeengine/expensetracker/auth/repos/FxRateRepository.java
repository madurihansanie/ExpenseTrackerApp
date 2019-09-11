package com.example.codeengine.expensetracker.auth.repos;

import com.example.codeengine.expensetracker.auth.entities.FxRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FxRateRepository extends JpaRepository<FxRate, Long> {
}
