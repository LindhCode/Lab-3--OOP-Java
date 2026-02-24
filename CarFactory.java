import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class CarFactory {
    // Some IntelliJ spooke ahh shit right here
    public static CarFeatures createVolvo240(Color color, int enginePower) throws IOException {
        CarFeatures c = new VehicleData(new Volvo240(color, enginePower), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(100,200)).getCarObj();
    }
    public static CarFeatures createSaab95(Color color, int enginePower) throws IOException {
        CarFeatures c = new VehicleData(new Saab95(color, enginePower), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(100,200)).getCarObj();
    }
}
