public interface VehicleFeatures {
    double getxPos();
    double getyPos();
    void move();
    void setxPos(double d);
    void setyPos(double d);
    void turnAround();
    void startEngine();
    void stopEngine();
    void gas(double i);
    void brake(double i);
}
