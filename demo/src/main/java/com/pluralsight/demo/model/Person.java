package com.pluralsight.demo.model;

//If Serializable it will always be a bean
import java.io.Serializable;

public class Person implements Serializable {
    // Private properties
    private String name;

    // Default Constructor - no parameters
    public Person() {
    }

    // Getters / Setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}