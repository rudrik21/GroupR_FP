package com.example.groupr_fp.models;


public class Vehicle {
    private String model;
    private String plate;
    private String color;
    private String category;

    public Vehicle(String model, String plate, String color) {
        this.model = model;
        this.plate = plate;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "model='" + model + "\n" +
                ", plate='" + plate +  "\n" +
                ", color='" + color + "\n";
    }
}
