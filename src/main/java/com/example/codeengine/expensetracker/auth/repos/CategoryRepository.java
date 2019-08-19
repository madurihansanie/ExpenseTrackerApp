package com.example.codeengine.expensetracker.auth.repos;

import com.example.codeengine.expensetracker.auth.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
