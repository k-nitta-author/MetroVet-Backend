package com.sample.backend.service;

import com.sample.backend.model.Dog;
import com.sample.backend.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public Optional<Dog> getDogByName(String dogName) {
        return dogRepository.findByDogName(dogName);
    }
}
