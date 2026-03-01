package Model;

import java.awt.*;

public class Saab95 implements TurboFeatures {
    private Car<TurboEngine> car;

    public Saab95(Color color, int enginePower, double x, double y) {
        this.car = new Car<TurboEngine>(new Automobile(color, "Model.Saab95", new TurboEngine(enginePower), 5, 2, x, y));
    }

    public Car<TurboEngine> getCar() {
        return car;
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public int getSize() {
        return car.getSize();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
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
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public void move() {
        car.move();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount);
    }

    @Override
    public void brake(double amount) {
        car.brake(amount);
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public double getCurrentRotation() {
        return car.getCurrentRotation();
    }

    @Override
    public void setDriveState(DriveState newState) {
        car.setDriveState(newState);
    }

    @Override
    public void setTurboOn() {
        getCar().getAutomobile().getEngine().setTurboOn();
    }

    @Override
    public void setTurboOff() {
        getCar().getAutomobile().getEngine().setTurboOff();
    }
}