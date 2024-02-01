package com.sample.backend.controller;

import com.sample.backend.model.Admin;
import com.sample.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;



    // Get specific admin based on id
    @RequestMapping(value="/admin/{id}")
    public Admin getAdmin(@PathVariable int id)
    {
        return adminService.getAdmin(id);
    }

}
