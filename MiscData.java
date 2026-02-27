import java.awt.*;
import java.awt.image.BufferedImage;

public class MiscData<A extends MiscFeatures> {
    private BufferedImage image;
    private Point point;

    public MiscData(MiscFeatures misc, BufferedImage image, Point point){
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