package Model;

import java.awt.*;

public class TruckFactory {
    public static VehicleFeatures createScania(Color color, int enginePower, double x, double y) {
        VehicleFeatures t = new Scania(color ,enginePower, x, y);
        return t;
    }
}
