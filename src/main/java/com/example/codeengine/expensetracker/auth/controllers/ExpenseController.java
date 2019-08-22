package com.example.codeengine.expensetracker.auth.controllers;

import com.example.codeengine.expensetracker.auth.entities.Category;
import com.example.codeengine.expensetracker.auth.entities.Expense;
import com.example.codeengine.expensetracker.auth.entities.User;
import com.example.codeengine.expensetracker.auth.repos.CategoryRepository;
import com.example.codeengine.expensetracker.auth.repos.ExpenseRepository;
import com.example.codeengine.expensetracker.auth.repos.UserRepository;
import com.example.codeengine.expensetracker.auth.requests.ExpenseRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
public class ExpenseController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ExpenseController.class);
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/expenses")
    List<Expense> getExpenses(){
        LOGGER.info("ExpenseController -> Get Expense");
        List<Expense> expenseList= new ArrayList<Expense>();
        try{
            expenseList=expenseRepository.findAll();
        }
        catch (Exception ex){
            LOGGER.error(ex.toString());

        }
        return expenseList;
    }
    @DeleteMapping("/expense/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id){
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }
    @PostMapping("/expenses")
    ResponseEntity<Expense> createExpense(@RequestParam Long categoryId, @RequestParam Long userId, @RequestBody ExpenseRequest request)throws URISyntaxException{
//     Optional<Category> category= categoryRepository.findById(categoryId);
        Category category= categoryRepository.findById(categoryId).orElse(categoryRepository.save(new Category("Other Expenses")));

        User user = userRepository.findById(userId).orElse(userRepository.save(new User("Random","User","rando.user@gmail.com")));
        Expense exp= new Expense(request.getDescription(),request.getLocation(),category,user);

        Expense result = expenseRepository.save(exp);
        return ResponseEntity.created(new URI("/api/expenses"+result.getId())).body(result);
    }

}
