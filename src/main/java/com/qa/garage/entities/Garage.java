package com.qa.garage.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garage {
    private List<Vehicle> vehicles;
    private Scanner scanner;

    public Garage() {
        vehicles = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addVehicleFromInput() {
        System.out.println("Enter vehicle details:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter type of vehicle (car/motorbike/truck): ");
        String vehicleType = scanner.nextLine().toLowerCase();

        Vehicle newVehicle = null;

        switch (vehicleType) {
            case "car":
                System.out.print("Enter number of doors: ");
                int numberOfDoors = scanner.nextInt();
                newVehicle = new Car(id, make, model, year, numberOfDoors);
                break;
            case "motorbike":
                System.out.print("Enter engine capacity (cc): ");
                int engineCapacity = scanner.nextInt();
                newVehicle = new Motorbike(id, make, model, year, engineCapacity);
                break;
            case "truck":
                System.out.print("Does the truck have a honker? (true/false): ");
                boolean hasHonker = scanner.nextBoolean();
                newVehicle = new Truck(id, make, model, year, hasHonker);
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        addVehicle(newVehicle);
        System.out.println("Vehicle added successfully.");

        // Display bill of the newly added vehicle
        System.out.println("Bill for the new vehicle:");
        double bill = newVehicle.calculateBill();
        System.out.println("Vehicle: " + newVehicle.getMake() + " " + newVehicle.getModel() + " (" + newVehicle.getYear() + ")");
        System.out.println("Bill: £" + bill);
    }

    public void showBills() {
        System.out.println("Current vehicles and bills:");
        for (Vehicle vehicle : vehicles) {
            double bill = vehicle.calculateBill();
            System.out.println("Vehicle: " + vehicle.getMake() + " " + vehicle.getModel() + " (" + vehicle.getYear() + ")");
            System.out.println("Bill: £" + bill);
            System.out.println();
        }
    }

    public void removeVehicleById() {
        System.out.print("Enter the ID of the vehicle to remove: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == idToRemove) {
                Vehicle removedVehicle = vehicles.remove(i);
                System.out.println("Vehicle removed: " + removedVehicle.getMake() + " " + removedVehicle.getModel() + " (" + removedVehicle.getYear() + ")");
                return;
            }
        }
        System.out.println("Vehicle with ID " + idToRemove + " not found.");
    }

    public void removeVehicleByType() {
        System.out.print("Enter vehicle type to remove (Car, Motorbike, Truck): ");
        String type = scanner.nextLine();

        Class<? extends Vehicle> vehicleType = null;
        switch (type.toLowerCase()) {
            case "car":
                vehicleType = Car.class;
                break;
            case "motorbike":
                vehicleType = Motorbike.class;
                break;
            case "truck":
                vehicleType = Truck.class;
                break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        boolean removed = false;
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicleType.isInstance(vehicle)) {
                vehicles.remove(i);
                System.out.println("Vehicle removed: " + vehicle.getMake() + " " + vehicle.getModel() + " (" + vehicle.getYear() + ")");
                removed = true;
                i--;
            }
        }
        if (!removed) {
            System.out.println("No vehicles of type " + type + " found.");
        }
    }


    public void emptyGarage() {
        vehicles.clear();
        System.out.println("Garage is now empty.");
    }


    public void closeScanner() {
        scanner.close();
    }
}
