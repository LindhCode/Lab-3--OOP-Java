package Model;

import java.lang.classfile.Attribute;

public class DriveableState implements DriveState {
    VehicleFeatures vehicle;

    public DriveableState(VehicleFeatures vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void move() {
        vehicle.setxPos(vehicle.getxPos() + Math.cos(vehicle.getCurrentRotation()) * vehicle.getCurrentSpeed());
        vehicle.setyPos(vehicle.getyPos() + Math.sin(vehicle.getCurrentRotation()) * vehicle.getCurrentSpeed());
    }
}
