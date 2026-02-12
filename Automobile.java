package org.example.lab1;
import java.awt.*;
public class Automobile<E extends Engine> implements Movable, Storable {
    private double currentSpeed = 0;
    private double currentRotation;
    private double xPos;
    private double yPos;
    private E engine;
    private Color color;
    private int nrDoors;
    private String modelName;
    private final int size;

    public Automobile(Color color, String modelName, E engine , int nrDoors, int size) {
        this.color = color;
        this.modelName = modelName;
        this.engine = engine;
        this.nrDoors = nrDoors;
        this.size = size;
    }

    public void incrementSpeed(double amount){
        if (currentSpeed != 0) {
            currentSpeed = getCurrentSpeed() + engine.speedFactor() * amount;
            if (currentSpeed < 0.1) {
                currentSpeed = 0.1;
            }
            else if (currentSpeed > engine.getEnginePower()){
                currentSpeed = engine.getEnginePower();
            }
        }
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(-amount);
        }
    }

    public void setxPos(double x) {
        xPos = x;
    }

    public void setyPos(double y) {
        yPos = y;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getCurrentRotation() {
        return currentRotation;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public E getEngine() {
        return engine;
    }

    public Color getColor() {
        return color;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void move(){
        xPos += Math.cos(getCurrentRotation()) * getCurrentSpeed();
        yPos += Math.sin(getCurrentRotation()) * getCurrentSpeed();
        System.out.printf("The car moved to X:%f, Y:%f\n",xPos,yPos);
    }

    @Override
    public void turnLeft(){
        currentRotation += (Math.PI/12);
        currentRotation %= (2*Math.PI);
    }

    @Override
    public void turnRight(){
        double prevRad = currentRotation;
        currentRotation -= (Math.PI/12);
        currentRotation %= (2*Math.PI);
        if (currentRotation < 0 && prevRad >= 0) {
            currentRotation += 2*Math.PI;
        }
    }
}