package com.sample.backend.service;

import com.sample.backend.model.Dog;
import com.sample.backend.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public List<Dog> getAllDogs()
    {
        List<Dog>dogRecords = new ArrayList<>();
        dogRepository.findAll().forEach(dogRecords::add);
        return dogRecords;
    }

    // Add Dog Info
    public Dog addUser(Dog dog) {return dogRepository.save(dog);}


    // Update Dog Info
    public Dog updateDog(Dog dog)
    {
        return dogRepository.save(dog);
    }


    // Get Specific Dog Info
    public Dog getDog(int id)
    {
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()) {
            return dog.get();
        }
        else
            return null;
    }


    // Delete Dog Info
    public void deleteDog(int id)
    {
        Optional<Dog> dog = dogRepository.findById(id);
        if(dog.isPresent()) {
            dogRepository.delete(dog.get());
        }
    }


}
