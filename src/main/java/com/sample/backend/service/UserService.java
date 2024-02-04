package com.sample.backend.service;

import com.sample.backend.model.Admin;
import com.sample.backend.model.User;
import com.sample.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Get All User Info
    public List<User> getAllUsers()
    {
        List<User>userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }


    // Get Specific User Info
    public User getUser(int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        else
            return null;
    }


    // Add User Info
    public User addUser(User user) {return userRepository.save(user);}


    // Update User Info
    public User updateUser(User user)
    {
        return userRepository.save(user);
    }



    // Delete Dog Info
    public void deleteUser(int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
        }
    }
}
