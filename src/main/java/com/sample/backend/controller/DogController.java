package com.sample.backend.controller;

import com.sample.backend.model.Dog;
import com.sample.backend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;


    // Get All Dogs
    @RequestMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    // Get specific dog based on id
    @RequestMapping(value="/dog/{id}")
    public Dog getDog(@PathVariable int id)
    {
        return dogService.getDog(id);
    }


    // Add Dog
    @RequestMapping(value="/add-dog", method= RequestMethod.POST)
    public Dog addDog(@RequestBody Dog dog)
    {
        return dogService.addUser(dog);
    }


    // Update (Edit) a dog by name
    @RequestMapping(value="/update-dog", method=RequestMethod.PUT)
    public Dog updateUser(@RequestBody Dog dog)
    {
        return dogService.updateDog(dog);
    }


    // Delete a dog by name
    @RequestMapping(value="/dog/{id}", method=RequestMethod.DELETE)
    public void deleteDog(@PathVariable int id)
    {
        dogService.deleteDog(id);
    }

    // Update (Edit) a dog by ID
    @RequestMapping(value = "/update-dog/{id}", method = RequestMethod.PUT)
    public Dog updateUser(@PathVariable int id, @RequestBody Dog updatedDog) {
        return dogService.updateDog(id, updatedDog);
    }


}
