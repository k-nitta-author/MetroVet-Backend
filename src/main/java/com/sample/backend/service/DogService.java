package com.sample.backend.service;

import com.sample.backend.model.Dog;

import java.util.Optional;

public interface DogService {
    void addDog(Dog dog);
    Optional<Dog> getDogByName(String dogName);
}
