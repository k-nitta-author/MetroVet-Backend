package com.sample.backend.service;

import com.sample.backend.model.Admin;
import com.sample.backend.model.Dog;
import com.sample.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // Get All Admin Info
    public List<Admin> getAllAdmins()
    {
        List<Admin>adminRecords = new ArrayList<>();
        adminRepository.findAll().forEach(adminRecords::add);
        return adminRecords;
    }


    // Add Admin Info
    public Admin addAdmin(Admin admin) {return adminRepository.save(admin);}


    // Update Admin Info
    public Admin updateAdmin(Admin admin)
    {
        return adminRepository.save(admin);
    }


    // Get Specific Dog Info
    public Admin getAdmin(int id)
    {
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isPresent()) {
            return admin.get();
        }
        else
            return null;
    }


    // Delete Dog Info
    public void deleteAdmin(int id)
    {
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isPresent()) {
            adminRepository.delete(admin.get());
        }
    }


}
