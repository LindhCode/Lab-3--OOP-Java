package org.example.lab1;

import java.awt.*;
import java.lang.classfile.constantpool.ClassEntry;
import java.util.ArrayList;
import java.util.Stack;

public class CarTransportTruck<A extends StorableCar> {
    Truck<TurboEngine> truck;
    CarTransport transportTrailer;

    public CarTransportTruck(Color color, int enginePower) {
        this.truck = new Truck<>(new Automobile<>(color, "car transport truc", new TurboEngine(enginePower), 2, 5));
        this.transportTrailer = new CarTransport();
    }

    public void liftRamp() {
        transportTrailer.liftRamp();
    }

    public void lowerRamp() {
        if (truck.getCurrentSpeed() == 0) {
            transportTrailer.lowerRamp();
        }
    }

    public Stack<StorableCar> getCars() {
        return transportTrailer.getCars();
    }

    public double getyPos() {
        return truck.getyPos();
    }

    public double getxPos() {
        return truck.getxPos();
    }

    public void loadCar(A c) {
        double dDistance = Math.sqrt(Math.pow((c.getxPos() - truck.getxPos()), 2) + Math.pow((c.getyPos() - truck.getyPos()), 2));
        if (dDistance < 10 && c.getSize() < 3) {
            transportTrailer.loadCar(c);
        }
    }

    public void unloadCar() {
        if (getCurrentSpeed() == 0 && !transportTrailer.getRampUp()) {
            StorableCar c = transportTrailer.unloadCar();
            if (c != null) {
                c.setxPos(truck.getxPos() + 5);
                c.setyPos(truck.getyPos() + 5);
            }
        }
    }

    public void move(){
        if (transportTrailer.getRampUp()) {
            truck.move();
            for (StorableCar c : transportTrailer.getCars()) {
                c.setxPos(truck.getxPos());
                c.setyPos(truck.getyPos());
            }
        }
    }

    public void gas(double amount){
        if (transportTrailer.getRampUp()){
            truck.gas(amount);
        }
    }

    public void brake(double amount){
        if (transportTrailer.getRampUp()) {
            truck.brake(amount);
        }
    }

    public void turnLeft(){
        truck.turnLeft();
    }

    public void turnRight(){
        truck.turnRight();
    }

    public void startEngine(){
        if (transportTrailer.getRampUp()) {
            truck.startEngine();
        }
    }

    public void stopEngine(){
        truck.stopEngine();
    }

    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }
}