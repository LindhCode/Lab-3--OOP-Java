package org.example.lab1;

import java.awt.*;

public class Car<E extends Engine> implements StorableCar {
    private Automobile<E> automobile;

    public Car(Automobile<E> automobile) {
        this.automobile = automobile;
    }

    public Automobile<E> getAutomobile() {
        return automobile;
    }

    public int getSize() {
        return automobile.getSize();
    }

    public void startEngine() {
        automobile.startEngine();
    }

    public double getxPos() {
        return automobile.getxPos();
    }

    public double getyPos() {
        return automobile.getyPos();
    }

    public void stopEngine() {
        automobile.stopEngine();
    }

    public void setyPos(double y) {
        automobile.setyPos(y);
    }

    public void setxPos(double x) {
        automobile.setxPos(x);
    }

    public void turnRight() {
        automobile.turnRight();
    }

    public void turnLeft() {
        automobile.turnLeft();
    }

    public void move() {
        automobile.move();
    }

    public void gas(double amount) {
        automobile.gas(amount);
    }

    public void brake(double amount) {
        automobile.brake(amount);
    }

    public double getCurrentSpeed() {
        return automobile.getCurrentSpeed();
    }
}
