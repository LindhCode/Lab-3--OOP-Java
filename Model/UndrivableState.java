package Model;

public class UndrivableState implements DriveState  {
    VehicleFeatures vehicle;

    public UndrivableState(VehicleFeatures vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void move() {
        System.out.println("The car can not be moved at this point");
    }
}
