import java.awt.*;
import java.awt.image.BufferedImage;

public class TruckData {
    TruckFeatures truck;
    BufferedImage image;
    Point point;

    public TruckData(TruckFeatures truck, BufferedImage image, Point point){
        this.truck = truck;
        this.image = image;
        this.point = point;
    }
}
