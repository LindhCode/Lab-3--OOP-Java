package Model;

public interface CarFeatures extends VehicleFeatures {
    void setxPos(double x);
    void setyPos(double y);
    int getSize();
    void move();
    void gas(double amount);
    void brake(double amount);
//    void setTurboOn();
//    void setTurboOff();
    void startEngine();
    void stopEngine();
    void turnLeft();
    void turnRight();
    void turnAround();
}
