package View;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VehicleVisual {
    // komposition av ett internt fordon
    private BufferedImage image;
    // Point is not used at the moment but we follow OCP
    private Point point;

    public VehicleVisual(BufferedImage image, Point point){
        this.image = image;
        this.point = point;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }
}
