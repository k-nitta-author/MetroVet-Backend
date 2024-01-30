package com.sample.backend.repository;

import com.sample.backend.model.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DogRepository extends CrudRepository<Dog, Integer> {
    Optional<Dog> findByDogName(String dogName);
}
