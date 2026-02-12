package org.example.lab1;

public class TurboEngine extends Engine{
    private boolean turboOn = true;

    public TurboEngine(int enginePower) {
        super(enginePower);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

}

