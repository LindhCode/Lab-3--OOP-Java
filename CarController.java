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
            for (CarData carObj : cars) {
                CarFeatures car = carObj.car;
                car.move();
                int x = (int) Math.round(car.getxPos());
                int y = (int) Math.round(car.getyPos());
                frame.drawPanel.moveit(carObj,x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (CarData carObj : cars) {
            CarFeatures car = carObj.car;
            car.gas(gas);
        }
    }

    void brake(int amount) {
    }

    void setTurboOn() {

    }

    void setTurboOff() {

    }

    void liftFlatbed() {

    }

    void lowerFlatbed() {

    }

    void startEngine() {
        for (CarData carObj : cars) {
            CarFeatures car = carObj.car;
            car.startEngine();
        }
    }

    void stopEngine() {
        for (CarData carObj : cars) {
            CarFeatures car = carObj.car;
            car.stopEngine();
        }
    }

    public ArrayList<CarData> getCars() {
        return cars;
    }
}
