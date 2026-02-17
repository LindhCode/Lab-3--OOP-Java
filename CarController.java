import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // Listan med bilar CarData params: StorableCar, BufferedImage, Point
    ArrayList<CarData> cars = new ArrayList<>();
    ArrayList<MiscData> miscs = new ArrayList<>();
    ArrayList<TruckData> trucks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Instance of this class
        CarController cc = new CarController();


        // TIDIGARE: cc.cars.add(new Volvo240(Color.black, 200));


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */



    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (CarData carObj : getCars()) {
                CarFeatures car = carObj.getCarObj();
                car.move();
                int x = (int)Math.round(car.getxPos());
                int y = (int)Math.round(car.getyPos());
                if (x > 700) {
                    car.setxPos(700);
                    carBounce(car);
                }
                if (x < 0) {
                    car.setxPos(0);
                    carBounce(car);
                }
                if (y > 500) {
                    car.setyPos(500);
                    carBounce(car);
                }
                if (y < 0) {
                    car.setyPos(0);
                    carBounce(car);
                }

                frame.drawPanel.moveit(carObj, x, y);
                frame.drawPanel.repaint();

                checkCollisionCarWorkshop(carObj);
            }
            for (TruckData truckObj : getTrucks()) {
                TruckFeatures truck = truckObj.getTruck();
                truck.move();
                int x = (int) Math.round(truck.getxPos());
                int y = (int) Math.round(truck.getyPos());

                if (x > 700) {
                    truck.setxPos(700);
                    truckBounce(truck);
                }
                if (x < 0) {
                    truck.setxPos(0);
                    truckBounce(truck);
                }
                if (y > 500) {
                    truck.setyPos(500);
                    truckBounce(truck);
                }
                if (y < 0) {
                    truck.setyPos(0);
                    truckBounce(truck);
                }
                frame.drawPanel.moveit(truckObj,x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    void checkCollisionCar(CarData car) {
        checkCollisionCarWorkshop(car);
    }

    void checkCollisionCarWorkshop(CarData car) {
        for (MiscData misc : miscs) {
            // Distance formula
            double deltaDistance = Math.sqrt(Math.pow((car.getCarObj().getxPos() - misc.getMiscObj().getxPos()), 2)
                    + Math.pow((car.getCarObj().getyPos() - misc.getMiscObj().getyPos()), 2));
            if (deltaDistance < 90 && misc.getMiscObj() instanceof MechanicShop<?>) {
                checkVolvoCollisionWorkshop(car, (MechanicShop) misc.getMiscObj());
            }
        }
    }

    // Stopped here
    void checkVolvoCollisionWorkshop(CarData car, MechanicShop mechShop) {
        if (car.getCarObj() instanceof Volvo240 && mechShop.getTag().equals("Volvo240MechanicShop")) {
            System.out.println("Fungerar");
            // This is weak as fuc
            mechShop.addToRepairList(car.getCarObj());
            car.getPoint().setLocation(0, 0);
            car.getCarObj().setxPos(0);
            car.getCarObj().setyPos(0);
            car.getCarObj().stopEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (CarData carObj : getCars()) {
            CarFeatures car = carObj.getCarObj();
            car.gas(gas);
        }
        for (TruckData truckObj : getTrucks()) {
            TruckFeatures truck = truckObj.getTruck();
            truck.gas(gas);
        }

    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (CarData carObj : getCars()) {
            CarFeatures car = carObj.getCarObj();
            car.brake(brake);
        }
        for (TruckData truckObj : getTrucks()) {
            TruckFeatures truck = truckObj.getTruck();
            truck.gas(brake);
        }
    }

    // Holy shit vilket bajslösning aja idgaf
    void setTurboOn() {
        for (CarData carObj : getCars()) {
            CarFeatures car = carObj.getCarObj();
            if (car instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (CarData carObj : getCars()) {
            CarFeatures car = carObj.getCarObj();
            if (car instanceof TurboFeatures carWithTurbo){
                carWithTurbo.setTurboOff();
            }
        }
    }

    void liftFlatbed() {
        for (TruckData truckObj : getTrucks()) {
            TruckFeatures truck = truckObj.getTruck();
            if (truck instanceof FlatbedFeatures flatbed){
                flatbed.liftFlatbed();
            }
        }
    }

    void lowerFlatbed() {
        for (TruckData truckObj : getTrucks()) {
            TruckFeatures truck = truckObj.getTruck();
            if (truck instanceof FlatbedFeatures flatbed){
                flatbed.lowerFlatbed();
            }
        }
    }
    // TODO - Make it work for trucks aswell
    void startEngine() {
        for (CarData carObj : getCars()) {
            CarFeatures car = carObj.getCarObj();
            car.startEngine();
        }
        for (TruckData truckObj : getTrucks()) {
            TruckFeatures truck = truckObj.getTruck();
            truck.startEngine();
        }
    }

    void stopEngine() {
        for (CarData carObj : getCars()) {
            CarFeatures car = carObj.getCarObj();
            car.stopEngine();
        }
        for (TruckData truckObj : getTrucks()) {
            TruckFeatures truck = truckObj.getTruck();
            truck.stopEngine();
        }
    }


    public ArrayList<CarData> getCars() {
        return cars;
    }

    public ArrayList<MiscData> getMiscs() {
        return miscs;
    }

    public ArrayList<TruckData> getTrucks() {
        return trucks;
    }

    private void carBounce(CarFeatures car) {
        car.stopEngine();
        car.turnAround();
        car.startEngine();
    }
    private void truckBounce(TruckFeatures truck) {
        truck.stopEngine();
        truck.turnAround();
        truck.startEngine();
    }

}
