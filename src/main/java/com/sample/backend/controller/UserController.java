package com.sample.backend.controller;


import com.sample.backend.model.User;
import com.sample.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get specific dog based on id
    @RequestMapping(value="/user/{id}")
    public User getUser(@PathVariable int id)
    {
        return userService.getUser(id);
    }


}
