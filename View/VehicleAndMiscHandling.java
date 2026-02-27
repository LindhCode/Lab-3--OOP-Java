package View;

import Model.CarModel;
import Model.MiscVisual;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VehicleAndMiscHandling {
    private ArrayList<VehicleVisual> vehicles;
    private ArrayList<MiscVisual> miscs;
    
    
    public VehicleAndMiscHandling() throws IOException {
        vehicles = new ArrayList<>();
        miscs  = new ArrayList<>();
        CarModel cc = new CarModel();

        vehicles.add(new VehicleVisual(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"))), new Point(100, 200)));
        vehicles.add(new VehicleVisual(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"))), new Point(200, 200)));
        vehicles.add(new VehicleVisual(ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"))), new Point(300, 200)));

        miscs.add(new MiscVisual(cc.getMiscs().get(0), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point((int) 400, (int) 200)));
    }


    public ArrayList<VehicleVisual> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscVisual> getMiscs() {
        return miscs;
    }
}