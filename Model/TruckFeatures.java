package Model;

public interface TruckFeatures extends VehicleFeatures {
    void setxPos(double x);
    void setyPos(double y);
    void move();
    void gas(double amount);
    void brake(double amount);
    //    void setTurboOn();
//    void setTurboOff();
    void startEngine();
    void stopEngine();
    void turnAround();
}
