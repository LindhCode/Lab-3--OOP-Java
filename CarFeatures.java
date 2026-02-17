public interface CarFeatures extends Storable{
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
