package com.example.groupr_fp.models;

public class Motorcycle extends Vehicle {

    private boolean sidecar = false;

    public Motorcycle(String model, String plate, String color, boolean sidecar) {
        super(model, plate, color);
        this.sidecar = sidecar;
    }

    public boolean isSidecar() {
        return sidecar;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", sidecar=" + sidecar + "\n";
    }
}
