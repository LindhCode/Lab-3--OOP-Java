import java.awt.*;
import java.awt.image.BufferedImage;

public class CarData {
    private CarFeatures car;
    private BufferedImage image;
    private Point point;

    public CarData(CarFeatures car, BufferedImage image, Point point){
        this.car = car;
        this.image = image;
        this.point = point;
    }

    public CarFeatures getCarObj() {
        return car;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }
}
