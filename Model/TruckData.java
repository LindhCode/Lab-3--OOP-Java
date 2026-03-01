package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TruckData {
    private TruckFeatures truck;
    private BufferedImage image;
    private Point point;

    public TruckData(TruckFeatures truck, BufferedImage image, Point point) {
        this.truck = truck;
        this.image = image;
        this.point = point;
    }

    public TruckFeatures getTruck() {
        return truck;
    }

    public Point getPoint() {
        return point;
    }

    public BufferedImage getImage() {
        return image;
    }
}
