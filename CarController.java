import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */



public class CarController {
    // member fields:
    private ArrayList<VehicleFeatures> vehicles = new ArrayList<>();
    private ArrayList<MiscFeatures> miscs = new ArrayList<>();

    public CarController() throws IOException {
        vehicles.add(new Volvo240(Color.black,200, 100, 200));
        vehicles.add(new Saab95(Color.black,200, 200, 200));
        vehicles.add(new Scania(Color.black,700, 300, 200));

        miscs.add(new MechanicShop<Volvo240>(10,400, 200,"Volvo240MechanicShop"));
    }

    public ArrayList<VehicleFeatures> getVehicles() {
        return vehicles;
    }

    public ArrayList<MiscFeatures> getMiscs() {
        return miscs;
    }

    // Make private and a getter
    CarView frame;

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

            checkCollisionCarWorkshop(vehObj);
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
            vehicle.setxPos(0);
            vehicle.setyPos(0);
            vehicle.stopEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.brake(brake);
        }

    }
    void setTurboOn() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOff();
            }
        }
    }

    void liftFlatbed() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof FlatbedFeatures flatbed){
                flatbed.liftFlatbed();
            }
        }
    }

    void lowerFlatbed() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            if (vehicle instanceof FlatbedFeatures flatbed){
                flatbed.lowerFlatbed();
            }
        }
    }

    void startEngine() {
        for (VehicleFeatures vehObj : vehicles) {
            VehicleFeatures vehicle = vehObj;
            vehicle.startEngine();
        }
    }

    void stopEngine() {
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

}
