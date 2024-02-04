package com.sample.backend.model;

import javax.persistence.*;

@Entity(name = "Dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String dogName;
    private String dogDescription;

    private String dogType;
    //private byte[] imageData; // Assuming you store the image as a byte array

    public Dog(String dogName, String dogDescription, byte[] imageData) {
        this.dogName = dogName;
        this.dogDescription = dogDescription;
        this.dogType = dogType;
        //this.imageData = imageData;
    }

    public Dog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogDescription() {
        return dogDescription;
    }

    public void setDogDescription(String dogDescription) {
        this.dogDescription = dogDescription;
    }

    public String getDogType() {
        return dogType;
    }

    public void setDogType(String dogType) {
        this.dogType = dogType;
    }

    //public byte[] getImageData() {
     //   return imageData;
   // }

    //public void setImageData(byte[] imageData) {
    //    this.imageData = imageData;
   //}
}
