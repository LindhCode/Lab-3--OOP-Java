package org.example.lab1;

import java.awt.*;

import static java.awt.Color.*;

public class Main {
    static void main(String[] args) {
        Saab95 mySaab = new Saab95(black, 211);
        Volvo240 myVolvo = new Volvo240(black, 211);
        CarTransportTruck<StorableCar> myTransportTruck = new CarTransportTruck<>(gray, 1500);
        myTransportTruck.lowerRamp();
        myTransportTruck.loadCar(mySaab);
        myTransportTruck.loadCar(myVolvo);
        myTransportTruck.unloadCar();

        System.out.println("==============================");
        System.out.println(myVolvo.getxPos());
        System.out.println(mySaab.getyPos());
        System.out.println("*************");
        System.out.println(myTransportTruck.getxPos());
        System.out.println(myTransportTruck.getyPos());
        System.out.println("---------------------");
        for (StorableCar c : myTransportTruck.getCars()) {
            System.out.println(c);
        }
        System.out.println("---------------------");
        System.out.println("==============================");
    }
}