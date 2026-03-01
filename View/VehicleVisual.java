package View;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VehicleVisual {
    private BufferedImage image;
    private Point point;

    public VehicleVisual(BufferedImage image, Point point) {
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
