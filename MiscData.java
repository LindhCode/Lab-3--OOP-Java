import java.awt.*;
import java.awt.image.BufferedImage;

public class MiscData {
    MiscFeatures misc;
    BufferedImage image;
    Point point;

    public MiscData(MiscFeatures misc, BufferedImage image, Point point){
        this.misc = misc;
        this.image = image;
        this.point = point;
    }

    public MiscFeatures getMisc() {
        return misc;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }
}