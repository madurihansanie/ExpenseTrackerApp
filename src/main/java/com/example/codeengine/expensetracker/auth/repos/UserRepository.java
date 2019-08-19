package com.example.codeengine.expensetracker.auth.repos;

import com.example.codeengine.expensetracker.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
