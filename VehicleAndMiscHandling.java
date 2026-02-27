import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VehicleAndMiscHandling {
    private ArrayList<VehicleVisual> vehicles;
    private ArrayList<MiscData> miscs;
    
    
    public VehicleAndMiscHandling() throws IOException {
        vehicles = new ArrayList<>();
        miscs  = new ArrayList<>();
        CarController cc = new CarController();

        vehicles.add(new VehicleVisual(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(100, 200)));
        vehicles.add(new VehicleVisual(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))), new Point(200, 200)));
        vehicles.add(new VehicleVisual(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))), new Point(300, 200)));

        miscs.add(new MiscData(cc.getMiscs().get(0), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point((int) 400, (int) 200)));
    }


    public ArrayList<VehicleVisual> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscData> getMiscs() {
        return miscs;
    }
}