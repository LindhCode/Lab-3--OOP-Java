package org.example.lab1;

public class Engine{
    protected int enginePower;

    public Engine(int enginePower) {
        this.enginePower = enginePower;
    }

    public double speedFactor(){
        return enginePower * 0.01;
    }

    public double getEnginePower(){
        return enginePower;
    }

}
