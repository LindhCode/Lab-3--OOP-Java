package Model;

import java.awt.*;
public class Scania implements FlatbedFeatures {
    Truck<TurboEngine> truck;
    Flatbed flatbed = new Flatbed();

    public Scania(Color color, int enginePower, double x, double y) {
        this.truck = new Truck<>(new Automobile<>(color, "Model.Scania", new TurboEngine(enginePower), 2, 5, x, y));
    }

    @Override
    public void liftFlatbed() {
        if (truck.getCurrentSpeed() == 0) {
            flatbed.liftFlatbed();
        }
    }

    @Override
    public void lowerFlatbed() {
        if (truck.getCurrentSpeed() == 0) {
            flatbed.lowerFlatbed();
        }
    }
    public double getCurrentRotation() {
        return truck.getCurrentRotation();
    }

    public void setDriveState(DriveState newState) {
        truck.setDriveState(newState);
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

    @Override
    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
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

    public void turnAround(){
        truck.turnAround();
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

    @Override
    public void setxPos(double x) {
        truck.setxPos(x);
    }

    @Override
    public void setyPos(double y) {
        truck.setyPos(y);
    }
}

