package Model;

import java.awt.*;

public class Volvo240 implements CarFeatures {
    private Car<RegularEngine> car;

    public Volvo240(Color color, int enginePower, double x, double y) {
        this.car = new Car<RegularEngine>(new Automobile(color, "Model.Saab95", new RegularEngine(enginePower), 5, 2, x, y));
    }

    @Override
    public double getCurrentRotation() {
        return car.getCurrentRotation();
    }

    @Override
    public void setDriveState(DriveState newState) {
        car.setDriveState(newState);
    }

    public Car<RegularEngine> getCar() {
        return car;
    }

    @Override
    public int getSize() {
        return car.getSize();
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public void setyPos(double y) {
        car.setyPos(y);
    }

    @Override
    public void setxPos(double x) {
        car.setxPos(x);
    }

    @Override
    public double getxPos() {
        return car.getxPos();
    }

    @Override
    public double getyPos() {
        return car.getyPos();
    }

    @Override
    public void brake(double amount) {
        car.brake(amount);
    }

    @Override
    public void gas(double amount) {
        car.gas(amount);
    }

    @Override
    public void move() {
        car.move();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void turnAround() {
        car.turnAround();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }
}
