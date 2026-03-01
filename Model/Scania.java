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

    @Override
    public double getCurrentRotation() {
        return truck.getCurrentRotation();
    }

    @Override
    public void setDriveState(DriveState newState) {
        truck.setDriveState(newState);
    }

    @Override
    public void move() {
        if (flatbed.getFlatbedAngle() == 0) {
            truck.move();
        }
    }

    @Override
    public void gas(double amount) {
        if (flatbed.getFlatbedAngle() == 0) {
            truck.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (flatbed.getFlatbedAngle() == 0) {
            truck.brake(amount);
        }
    }

    @Override
    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    @Override
    public void startEngine() {
        if (flatbed.getFlatbedAngle() != 0) {
            truck.stopEngine();
        } else {
            truck.startEngine();
        }
    }

    public void turnLeft() {
        truck.turnLeft();
    }

    public void turnRight() {
        truck.turnRight();
    }

    @Override
    public void turnAround() {
        truck.turnAround();
    }

    @Override
    public void stopEngine() {
        truck.stopEngine();
    }

    @Override
    public double getxPos() {
        return truck.getxPos();
    }

    @Override
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

