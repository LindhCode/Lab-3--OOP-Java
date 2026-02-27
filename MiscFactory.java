import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class MiscFactory {
    public static MiscFeatures createVolvoMechanicShop(int capacity, double x, double y) {
        MiscFeatures m = new MechanicShop<Volvo240>(capacity, x, y, "Volvo240MechanicShop");
        return m;
    }
}
