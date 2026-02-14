import java.awt.*;
import java.awt.image.BufferedImage;

public class CarData {
    StorableCar car;
    BufferedImage image;
    Point point;

    public CarData(StorableCar car, BufferedImage image, Point point){
        this.car = car;
        this.image = image;
        this.point = point;
    }

}
