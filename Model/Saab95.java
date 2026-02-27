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

    public void startEngine() {
        car.startEngine();
    }

    public int getSize() {
        return car.getSize();
    }

    public void stopEngine() {
        car.stopEngine();
    }

    public void turnRight() {
        car.turnRight();
    }

    public void turnAround() { car.turnAround();}

    public void setyPos(double y) {
        car.setyPos(y);
    }

    public void setxPos(double x) {
        car.setxPos(x);
    }

    public double getxPos() {
        return car.getxPos();
    }

    public double getyPos() {
        return car.getyPos();
    }

    public void turnLeft() {
        car.turnLeft();
    }

    public void move() {
        car.move();
    }

    public void gas(double amount) {
        car.gas(amount);
    }

    public void brake(double amount) {
        car.brake(amount);
    }

    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
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