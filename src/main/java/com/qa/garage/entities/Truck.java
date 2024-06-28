package com.qa.garage.entities;

public class Truck extends Vehicle{
    private boolean hasHonker;

    public Truck(int id, String make, String model, int year, boolean hasHonker) {
        super(id, make, model, year);
        this.hasHonker = hasHonker;
    }

    public boolean getHasHonker() {
        return hasHonker;
    }

    public void setHasHonker(boolean hasHonker) {
        this.hasHonker = hasHonker;
    }

    @Override
    public double calculateBill() {
        return hasHonker ? 200 : 100;
    }
}


