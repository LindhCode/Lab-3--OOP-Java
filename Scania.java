package org.example.lab1;
import java.awt.*;
public class Scania implements StorableTruck {
    Truck<TurboEngine> truck;
    Flatbed flatbed = new Flatbed();

    public Scania(Color color, int enginePower) {
        this.truck = new Truck<>(new Automobile<>(color, "Scania", new TurboEngine(enginePower), 2, 5));
    }

    public void liftFlatbed() {
        if (truck.getCurrentSpeed() == 0) {
            flatbed.liftFlatbed();
        }
    }

    public void lowerFlatbed() {
        if (truck.getCurrentSpeed() == 0) {
            flatbed.lowerFlatbed();
        }
    }

    public void move(){
        if (flatbed.getFlatbedAngle() == 0){
            truck.move();
        }
    }
    public void gas(double amount){
        if (flatbed.getFlatbedAngle() == 0){
            truck.gas(amount);
        }
    }

    public void brake(double amount){
        if (flatbed.getFlatbedAngle() == 0){
            truck.brake(amount);
        }
    }
    public void startEngine() {
        if (flatbed.getFlatbedAngle() != 0) {
            truck.stopEngine();
        } else {
            truck.startEngine();
        }
    }

    public void turnLeft(){
        truck.turnLeft();
    }

    public void turnRight(){
        truck.turnRight();
    }

    public void stopEngine(){
        truck.stopEngine();
    }

    public double getxPos() {
        return truck.getxPos();
    }

    public double getyPos() {
        return truck.getyPos();
    }

}

