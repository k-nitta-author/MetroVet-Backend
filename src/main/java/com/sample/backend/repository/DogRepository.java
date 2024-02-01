package com.sample.backend.repository;

import com.sample.backend.model.Dog;
import org.springframework.data.repository.CrudRepository;



public interface DogRepository extends CrudRepository<Dog, Integer> {

}
