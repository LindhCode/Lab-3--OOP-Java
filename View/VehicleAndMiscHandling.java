package View;

import Model.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class VehicleAndMiscHandling implements CarManager {
    private static ArrayList<VehicleVisual> vehicles;
    private static ArrayList<MiscVisual> miscs;


    public VehicleAndMiscHandling() throws IOException {
        vehicles = new ArrayList<>();
        miscs = new ArrayList<>();
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

    @Override
    public void removeCar() {
        if (!vehicles.isEmpty()) {
            vehicles.removeLast();
        }
    }

    public ArrayList<VehicleVisual> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscVisual> getMiscs() {
        return miscs;
    }


}