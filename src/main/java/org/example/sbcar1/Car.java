package org.example.sbcar1;  // Adaptez selon votre package

import java.util.UUID;

public class Car {
    private String id;
    private String brand;
    private String model;
    private int year;
    private String color;

    // Constructeur sans arguments
    public Car() {
    }

    // Constructeur avec tous les champs
    public Car(String id, String brand, String model, int year, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Constructeur avec uniquement les attributs de base, l'id sera généré
    public Car(String brand, String model, int year, String color) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}