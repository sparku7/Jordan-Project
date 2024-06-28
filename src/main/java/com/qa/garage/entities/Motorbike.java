package com.qa.garage.entities;

public class Motorbike extends Vehicle {
    private int engineCapacity;

    public Motorbike(int id, String make, String model, int year, int engineCapacity) {
        super(id, make, model, year);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateBill() {
        return 25 + (engineCapacity / 100);
    }
}
