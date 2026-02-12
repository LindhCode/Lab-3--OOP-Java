public interface StorableCar extends Storable{
    void setxPos(double x);
    void setyPos(double y);
    int getSize();
    void move();
    void gas(double amount);
}
