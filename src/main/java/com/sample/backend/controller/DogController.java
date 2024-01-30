package com.sample.backend.controller;

import com.sample.backend.model.Dog;
import com.sample.backend.repository.DogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogRepository dogRepository;

    public DogController(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDog(@RequestBody Dog dog) {
        try {
            dogRepository.save(dog);
            return new ResponseEntity<>("Dog information saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to save dog information", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{dogName}")
    public ResponseEntity<Dog> getDogByName(@PathVariable String dogName) {
        return dogRepository.findByDogName(dogName)
                .map(dog -> new ResponseEntity<>(dog, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update (Edit) a dog by name
    @PutMapping("/edit/{dogName}")
    public ResponseEntity<String> updateDogByName(@PathVariable String dogName, @RequestBody Dog updatedDog) {
        return dogRepository.findByDogName(dogName)
                .map(existingDog -> {
                    existingDog.setDogName(updatedDog.getDogName());
                    existingDog.setDogDescription(updatedDog.getDogDescription());
                    existingDog.setImageData(updatedDog.getImageData());
                    dogRepository.save(existingDog);
                    return new ResponseEntity<>("Dog information updated successfully", HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Dog not found", HttpStatus.NOT_FOUND));
    }
    // Delete a dog by name
    @DeleteMapping("/delete/{dogName}")
    public ResponseEntity<String> deleteDogByName(@PathVariable String dogName) {
        return dogRepository.findByDogName(dogName)
                .map(existingDog -> {
                    dogRepository.delete(existingDog);
                    return new ResponseEntity<>("Dog deleted successfully", HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Dog not found", HttpStatus.NOT_FOUND));
    }
}
