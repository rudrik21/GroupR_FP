package com.example.groupr_fp.models;

public class Car extends Vehicle {
    private String type;

    public Car(String model, String plate, String color, String type) {
        super(model, plate, color);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", type='" + type + "\n";
    }
}
