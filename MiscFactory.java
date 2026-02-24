import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class MiscFactory {
    public static MiscData createVolvoMechanicShop(int capacity, double xPos, double yPos) throws IOException {
        MiscData m = new MiscData(new MechanicShop<Volvo240>(capacity, xPos, yPos, "Volvo240MechanicShop"), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point((int) xPos, (int) yPos));
        return m;
    }
}
