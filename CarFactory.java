import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class CarFactory {
    // Some IntelliJ spooke ahh shit right here
    public static VehicleFeatures createVolvo240(Color color, int enginePower, double x, double y) {
        VehicleFeatures c = new Volvo240(color, enginePower, x, y);
        return c;
    }

    public static VehicleFeatures createSaab95(Color color, int enginePower, double x, double y) {
        VehicleFeatures c = new Saab95(color, enginePower, x, y);
        return c;
    }
}
