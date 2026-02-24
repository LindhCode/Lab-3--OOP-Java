import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class VehicleAndMiscHandling {
    private ArrayList<VehicleData> vehicles = new ArrayList<>();
    private ArrayList<MiscData> miscs = new ArrayList<>();

    public VehicleAndMiscHandling() throws IOException {
        vehicles.add(CarFactory.createVolvo240(Color.green, 200, 100, 200));
        vehicles.add(CarFactory.createSaab95(Color.green, 200, 200, 200));
        miscs.add(MiscFactory.createVolvoMechanicShop(10, 500, 200));
        vehicles.add(TruckFactory.createScania(Color.green, 700, 300, 200));
    }

    public ArrayList<VehicleData> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscData> getMiscs() {
        return miscs;
    }
}
