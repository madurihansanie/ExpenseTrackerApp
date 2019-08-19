package com.example.codeengine.expensetracker.auth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense-tracker/init")
public class TaskInitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskInitController.class);

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String createUser(@RequestBody String name){
        return "user Created";
    }
    @RequestMapping(value = "/userNew",method = RequestMethod.POST)
    public String createUser2(@RequestBody String name){
        return "user Created 2";
    }

}

