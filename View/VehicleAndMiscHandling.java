package View;

import Model.AddsCar;
import Model.CarModel;
import Model.MiscVisual;
import Model.VehicleFeatures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VehicleAndMiscHandling implements AddsCar {
    private static ArrayList<VehicleVisual> vehicles;
    private static ArrayList<MiscVisual> miscs;
    
    
    public VehicleAndMiscHandling() throws IOException {
        vehicles = new ArrayList<>();
        miscs  = new ArrayList<>();
        CarModel cc = new CarModel();

        vehicles.add(new VehicleVisual(ImageHandler.VOLVO240_IMAGE, new Point(100, 200)));
        vehicles.add(new VehicleVisual(ImageHandler.SAAB95_IMAGE, new Point(200, 200)));
        vehicles.add(new VehicleVisual(ImageHandler.SCANIA_IMAGE, new Point(300, 200)));

        miscs.add(new MiscVisual(cc.getMiscs().get(0), ImageHandler.VOLVO_WORKSHOP_IMAGE, new Point((int) 400, (int) 200)));
    }

    @Override
    public void addCar(int x, int y) {
        if (canAddCar()) {
            vehicles.add(new VehicleVisual(ImageHandler.VOLVO240_IMAGE, new Point(x, y)));
        }
    }

    @Override
    public boolean canAddCar() {
        return vehicles.size() < 10;
    }

    public ArrayList<VehicleVisual> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscVisual> getMiscs() {
        return miscs;
    }


}