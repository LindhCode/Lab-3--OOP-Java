import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VisualUpdate {

    private final int delay = 50;
    private Timer timer;
    private CarController controller;
    private CarView frame;

    public VisualUpdate() throws IOException {
        // Initilzie  the logic, time and frame
        controller = new CarController();
        frame = new CarView("CarSim 1.0", controller);
    }

    public void VehicleUppdate(){

        timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    controller.update();

                    //Update position for vehicles
                    for (VehicleData vehObj : controller.getHandler().getVehicles()) {
                        int x = (int)Math.round(vehObj.getVehicle().getxPos());
                        int y = (int)Math.round(vehObj.getVehicle().getyPos());

                        frame.drawPanel.moveit(vehObj, x, y);
                    }

                    frame.drawPanel.repaint();
                }
            });

            timer.start();
        }
}