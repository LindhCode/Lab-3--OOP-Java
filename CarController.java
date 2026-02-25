import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private VehicleAndMiscHandling handling;

    public CarController() throws IOException {
        this.handling = new VehicleAndMiscHandling();
    }

    // Make private and a getter
    CarView frame;

    public void update() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
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

    void checkCollisionCar(VehicleData vehicle) {
        checkCollisionCarWorkshop(vehicle);
    }

    void checkCollisionCarWorkshop(VehicleData vehicle) {
        for (MiscData misc : handling.getMiscs()) {
            // Distance formula
            double deltaDistance = Math.sqrt(Math.pow((vehicle.getVehicle().getxPos() - misc.getMiscObj().getxPos()), 2)
                    + Math.pow((vehicle.getVehicle().getyPos() - misc.getMiscObj().getyPos()), 2));
            if (deltaDistance < 90 && misc.getMiscObj() instanceof MechanicShop<?>) {
                checkVolvoCollisionWorkshop(vehicle, (MechanicShop) misc.getMiscObj());
            }
        }
    }

    // Stopped here
    void checkVolvoCollisionWorkshop(VehicleData vehicle, MechanicShop mechShop) {
        if (vehicle.getVehicle() instanceof Volvo240 && mechShop.getTag().equals("Volvo240MechanicShop")) {
            System.out.println("Fungerar");
            // This is weak as fuc
            mechShop.addToRepairList(vehicle.getVehicle());
            vehicle.getVehicle().setxPos(0);
            vehicle.getVehicle().setyPos(0);
            vehicle.getVehicle().stopEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            vehicle.brake(brake);
        }

    }
    void setTurboOn() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            if (vehicle instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            if (vehicle instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOff();
            }
        }
    }

    void liftFlatbed() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            if (vehicle instanceof FlatbedFeatures flatbed){
                flatbed.liftFlatbed();
            }
        }
    }

    void lowerFlatbed() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            if (vehicle instanceof FlatbedFeatures flatbed){
                flatbed.lowerFlatbed();
            }
        }
    }

    void startEngine() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            vehicle.startEngine();
        }
    }

    void stopEngine() {
        for (VehicleData vehObj : handling.getVehicles()) {
            VehicleFeatures vehicle = vehObj.getVehicle();
            vehicle.stopEngine();
        }
    }

    private void vehicleBounce(VehicleFeatures vehicle) {
        vehicle.stopEngine();
        vehicle.turnAround();
        vehicle.startEngine();
    }

    public VehicleAndMiscHandling getHandler(){
        return handling;
    }
}
