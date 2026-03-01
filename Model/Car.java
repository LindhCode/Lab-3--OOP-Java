package Model;

public class Car<E extends Engine> implements CarFeatures {
    private Automobile<E> automobile;

    public Car(Automobile<E> automobile) {
        this.automobile = automobile;
    }

    public Automobile<E> getAutomobile() {
        return automobile;
    }

    @Override
    public int getSize() {
        return automobile.getSize();
    }

    @Override
    public void startEngine() {
        automobile.startEngine();
    }

    @Override
    public double getxPos() {
        return automobile.getxPos();
    }

    @Override
    public double getyPos() {
        return automobile.getyPos();
    }

    @Override
    public void stopEngine() {
        automobile.stopEngine();
    }

    @Override
    public void setyPos(double y) {
        automobile.setyPos(y);
    }

    @Override
    public void setxPos(double x) {
        automobile.setxPos(x);
    }

    @Override
    public void turnRight() {
        automobile.turnRight();
    }

    @Override
    public void turnLeft() {
        automobile.turnLeft();
    }

    @Override
    public void turnAround() {
        automobile.turnAround();
    }

    @Override
    public void move() {
        automobile.move();
    }

    @Override
    public void gas(double amount) {
        automobile.gas(amount);
    }

    @Override
    public void brake(double amount) {
        automobile.brake(amount);
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
}
