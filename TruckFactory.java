import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TruckFactory {
    public static TruckFeatures createScania(Color color, int enginePower) throws IOException {
        CarFeatures c = new VehicleData(new Scania(color, enginePower), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(100,200)).getCarObj();
    }
}
