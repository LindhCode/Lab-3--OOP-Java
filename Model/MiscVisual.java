package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MiscVisual<A extends MiscFeatures> {
    private BufferedImage image;
    private Point point;

    public MiscVisual(MiscFeatures misc, BufferedImage image, Point point){
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