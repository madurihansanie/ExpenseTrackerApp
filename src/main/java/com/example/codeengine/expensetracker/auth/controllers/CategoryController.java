package com.example.codeengine.expensetracker.auth.controllers;

import com.example.codeengine.expensetracker.auth.entities.Category;
import com.example.codeengine.expensetracker.auth.repos.CategoryRepository;
import com.example.codeengine.expensetracker.auth.requests.CategoryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController

public class CategoryController {
private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
@Autowired
    CategoryRepository categoryRepository;
@PostMapping(value="/category")
    ResponseEntity<Category> createCategory(@RequestBody CategoryRequest categoryRequest){
    LOGGER.info("createCategory -> ".concat(categoryRequest.getName()));
    Category category= new Category();
    category.setName(categoryRequest.getName());
    categoryRepository.save(category);
    LOGGER.info("createCategory -> Success");
    return ResponseEntity.ok().body(category);
}
@GetMapping("/category/{id}")
    ResponseEntity<?>getCategory(@PathVariable Long id){
    LOGGER.info("getCategory -> id - > ".concat(id.toString()));
    Optional<Category>optionalCategory= categoryRepository.findById(id);
    return optionalCategory.map(response->ResponseEntity.ok().body(response) )
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

}
