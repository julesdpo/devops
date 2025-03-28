package com.example.demo;

public class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rented;
    private Dates dates; // Pour stocker les dates de location

    // Constructeur
    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = false; // Par défaut, la voiture n'est pas louée
        this.dates = null;
    }

    // Getters & Setters
    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public boolean isRented() { return rented; }
    public void setRented(boolean rented) { this.rented = rented; }

    public Dates getDates() { return dates; }
    public void setDates(Dates dates) { this.dates = dates; }
}
