package com.example.codeengine.expensetracker.auth.controllers;

import com.example.codeengine.expensetracker.auth.entities.User;
import com.example.codeengine.expensetracker.auth.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/expense-tracker/init")
public class TaskInitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskInitController.class);
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        LOGGER.info("TaskInitController -> createUser");
        try {
            userRepository.save(user);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return ResponseEntity.badRequest().body(user);
        }

    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        LOGGER.info("Get Users");
        List<User> userList = new ArrayList<User>();
        try{
            userList=userRepository.findAll();
        }catch (Exception e){
            LOGGER.error(e.toString());
        }
        return userList;
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUsers(Long id){
        LOGGER.info("Delete Users");
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

