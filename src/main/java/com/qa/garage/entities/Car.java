package com.qa.garage.entities;

public class Car extends Vehicle {

    private int numberofDoors;

    public Car(int id, String make, String model, int year, int numberofDoors) {
        super(id, make, model, year);
        this.numberofDoors = numberofDoors;
    }

    public int getNumberofDoors() {
        return numberofDoors;
    }

    public void setNumberofDoors(int numberofDoors) {
        this.numberofDoors = numberofDoors;
    }

    @Override
    public double calculateBill(){
        return 50 + (numberofDoors * 50);
    }
}
