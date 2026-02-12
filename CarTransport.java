package org.example.lab1;

import java.util.Stack;

public class CarTransport extends Trailer{
    private boolean rampUp = true;
    Stack<StorableCar> cars = new Stack<>();

    public void lowerRamp(){
        rampUp = false;
    }

    public void liftRamp(){
        rampUp = true;
    }

    public boolean getRampUp() {
        return rampUp;
    }

    public Stack<StorableCar> getCars() {
        return cars;
    }

    public void loadCar(StorableCar c) {
        if (!rampUp && cars.size() < 10) {
            cars.push(c);
        }
    }

    public StorableCar unloadCar() {
        if (!cars.isEmpty()) {
            return cars.pop();
        }
        return null;
    }
}
