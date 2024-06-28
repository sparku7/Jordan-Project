package com.qa.garage;

import com.qa.garage.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garage garage = new Garage();

        garage.addVehicle(new Car(1, "Renault", "Clio", 1998, 4));
        garage.addVehicle(new Motorbike(2, "Harley Davidson", "Big Handlebars", 2019, 883));
        garage.addVehicle(new Truck(3, "Ford", "MegaTruck", 2018, true));

        garage.addVehicleFromInput();
        garage.showBills();
        garage.removeVehicleById();
        garage.showBills();
        garage.removeVehicleByType();
        garage.showBills();
        garage.emptyGarage();
        garage.showBills();
        garage.closeScanner();

        //need to work out how to do this by request rather than run through in order, next weeks task
    }
}
