import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VehicleAndMiscHandling {
    private ArrayList<VehicleData> vehicles;
    private ArrayList<MiscData> miscs;
    
    
    public VehicleAndMiscHandling() throws IOException {
        vehicles = new ArrayList<>();
        miscs  = new ArrayList<>();
        CarController cc = new CarController();

        // Lägger till alla fordon, kopplar de med de fysiska bilarna
        vehicles.add(new VehicleData((CarFeatures) cc.getVehicles().get(0), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(100, 200)));
        vehicles.add(new VehicleData((CarFeatures) cc.getVehicles().get(1), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))), new Point(200, 200)));
        vehicles.add(new VehicleData((TruckFeatures) cc.getVehicles().get(2), ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))), new Point(300, 200)));

        miscs.add(new MiscData(cc.getMiscs().get(0), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point((int) 400, (int) 200)));
        //vehicles.add(CarFactory.createVolvo240(Color.green, 200, 100, 200));
        //vehicles.add(CarFactory.createSaab95(Color.green, 200, 200, 200));
        //miscs.add(MiscFactory.createVolvoMechanicShop(10, 500, 200));
        //vehicles.add(TruckFactory.createScania(Color.green, 700, 300, 200));
    }


    public ArrayList<VehicleData> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscData> getMiscs() {
        return miscs;
    }
}
// Att göra: skapa en ny ArrayList med bara vehicles/miscs
//           I view - ha en lista med alla tre