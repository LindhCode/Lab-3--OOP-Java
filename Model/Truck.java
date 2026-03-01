package Model;

public class Truck<E extends Engine> implements TruckFeatures {
    private Automobile<E> automobile;

    public Truck(Automobile<E> automobile) {
        this.automobile = automobile;
    }

    @Override
    public double getCurrentSpeed() {
        return automobile.getCurrentSpeed();
    }

    @Override
    public double getCurrentRotation() {
        return automobile.getCurrentRotation();
    }

    @Override
    public void setDriveState(DriveState newState) {
        automobile.setDriveState(newState);
    }

    @Override
    public double getyPos() {
        return automobile.getyPos();
    }

    @Override
    public double getxPos() {
        return automobile.getxPos();
    }

    @Override
    public void move() {
        this.getAutomobile().move();
    }

    @Override
    public void gas(double amount) {
        this.getAutomobile().gas(amount);
    }

    @Override
    public void brake(double amount) {
        this.getAutomobile().brake(amount);
    }

    public void turnLeft() {
        this.getAutomobile().turnLeft();
    }

    public void turnRight() {
        this.getAutomobile().turnRight();
    }

    @Override
    public void turnAround() {
        this.getAutomobile().turnAround();
    }

    @Override
    public void startEngine() {
        this.getAutomobile().startEngine();
    }

    @Override
    public void stopEngine() {
        this.getAutomobile().stopEngine();
    }

    public Automobile<E> getAutomobile() {
        return automobile;
    }

    @Override
    public void setxPos(double x) {
        getAutomobile().setxPos(x);
    }

    @Override
    public void setyPos(double y) {
        getAutomobile().setyPos(y);
    }
}
