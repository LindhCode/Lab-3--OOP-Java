import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class CarFactory {
    // Some IntelliJ spooke ahh shit right here
    public static VehicleData createVolvo240(Color color, int enginePower, int xPos, int yPos) throws IOException {
        VehicleData c = new VehicleData(new Volvo240(color, enginePower), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(xPos, yPos));
        return c;
    }
    public static VehicleData createSaab95(Color color, int enginePower, int xPos, int yPos) throws IOException {
        VehicleData c = new VehicleData(new Saab95(color, enginePower), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))), new Point(xPos,yPos));
        return c;
    }
}
