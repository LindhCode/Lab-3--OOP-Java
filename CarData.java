import java.awt.*;
import java.awt.image.BufferedImage;

public class CarData {
    CarFeatures car;
    BufferedImage image;
    Point point;

    public CarData(CarFeatures car, BufferedImage image, Point point){
        this.car = car;
        this.image = image;
        this.point = point;
    }

}
