import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TruckFactory {
    public static VehicleData createScania(Color color, int enginePower, int xPos, int yPos) throws IOException {
        VehicleData t = new VehicleData(new Scania(color, enginePower, xPos, yPos), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))), new Point(xPos, yPos));
        return t;
    }
}
