import java.awt.*;
import java.awt.image.BufferedImage;

public class VehicleData {
    // komposition av ett internt fordon
    private BufferedImage image;
    private Point point;

    public VehicleData(CarFeatures car, BufferedImage image, Point point){
        this.image = image;
        this.point = point;
    }

    public VehicleData(TruckFeatures truck, BufferedImage image, Point point){
        this.image = image;
        this.point = point;
    }

//    public VehicleFeatures getVehicle(){
//        return vehicle;
//    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        System.out.println(point);
        return point;
    }
}
