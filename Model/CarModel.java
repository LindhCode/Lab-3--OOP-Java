package Model;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class CarModel implements CarManager {
    // member fields:
    private ArrayList<VehicleFeatures> vehicles = new ArrayList<>();
    private ArrayList<MiscFeatures> miscs = new ArrayList<>();

    public CarModel() throws IOException {
        vehicles.add(CarFactory.createVolvo240(Color.black,200, 100, 200));
        vehicles.add(CarFactory.createSaab95(Color.black,200, 200, 200));
        vehicles.add(TruckFactory.createScania(Color.black,700, 300, 200));
        miscs.add(MiscFactory.createVolvoMechanicShop(10,400, 200));
    }

    public ArrayList<VehicleFeatures> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscFeatures> getMiscs() {
        return miscs;
    }


    public void update() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.move();

            int x = (int)Math.round(vehicle.getxPos());
            int y = (int)Math.round(vehicle.getyPos());

            if (x > 700) {
                vehicle.setxPos(700);
                vehicleBounce(vehicle);
            }
            if (x < 0) {
                vehicle.setxPos(0);
                vehicleBounce(vehicle);
            }
            if (y > 500) {
                vehicle.setyPos(500);
                vehicleBounce(vehicle);
            }
            if (y < 0) {
                vehicle.setyPos(0);
                vehicleBounce(vehicle);
            }

            checkCollisionCar(vehObj);
        }
    }

    void checkCollisionCar(VehicleFeatures vehicle) {
        checkCollisionCarWorkshop(vehicle);
    }

    void checkCollisionCarWorkshop(VehicleFeatures vehicle) {
        for (MiscFeatures misc : miscs){
            // Distance formula
            double deltaDistance = Math.sqrt(Math.pow((vehicle.getxPos() - misc.getxPos()), 2)
                    + Math.pow((vehicle.getyPos() - misc.getyPos()), 2));
            if (deltaDistance < 90 && misc instanceof MechanicShop<?>) {
                checkVolvoCollisionWorkshop(vehicle, (MechanicShop) misc);
            }
        }
    }

    // Stopped here
    void checkVolvoCollisionWorkshop(VehicleFeatures vehicle, MechanicShop mechShop) {
        if (vehicle instanceof Volvo240 && mechShop.getTag().equals("Volvo240MechanicShop")) {
            System.out.println("Fungerar");
            // This is weak as fuc
            mechShop.addToRepairList(vehicle);
            vehicle.setxPos((mechShop.getObjectsInShop().size()-1)*100);
            vehicle.setyPos(0);
            vehicle.stopEngine();
            vehicle.setDriveState(new UndrivableState(vehicle));
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.brake(brake);
        }

    }
    public void setTurboOn() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOff();
            }
        }
    }

    public void liftFlatbed() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof FlatbedFeatures flatbed){
                flatbed.liftFlatbed();
            }
        }
    }

    public void lowerFlatbed() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof FlatbedFeatures flatbed){
                flatbed.lowerFlatbed();
            }
        }
    }

    public void startEngine() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.startEngine();
        }
    }

    public void stopEngine() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.stopEngine();
        }
    }

    private void vehicleBounce(VehicleFeatures vehicle) {
        vehicle.stopEngine();
        vehicle.turnAround();
        vehicle.startEngine();
    }


    public void removeCar() {
        if (!vehicles.isEmpty()) {
            vehicles.remove(vehicles.size() -1 );
        }
    }

    public void addCar(int x, int y) {
        if (canAddCar()){
            vehicles.add(CarFactory.createVolvo240(Color.black,200, x, y));
        }
    }

    public boolean canAddCar(){
        return vehicles.size() < 10;
    }
}
