import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class VehicleAndMiscHandling {
    private ArrayList<VehicleData> vehicles = new ArrayList<>();
    private ArrayList<MiscData> miscs = new ArrayList<>();

    public VehicleAndMiscHandling() throws IOException {
        vehicles.add(new VehicleData(new Volvo240(Color.black, 200), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")), new Point(100,200)));
        vehicles.add(new VehicleData(new Saab95(Color.green, 200), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")), new Point(200,200)));
        miscs.add(new MiscData(new MechanicShop<Volvo240>(10, 500, 200, "Volvo240MechanicShop"), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point(500, 200)));
        vehicles.add(new VehicleData(new Scania(Color.black, 700), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")), new Point(300,200)));
    }

    public ArrayList<VehicleData> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscData> getMiscs() {
        return miscs;
    }
}
