import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VisualUpdate {

    private final int delay = 50;
    private Timer timer;
    private CarController controller;
    private CarView frame;
    private VehicleAndMiscHandling handling;

    public VisualUpdate() throws IOException {
        // Initilzie  the logic, time and frame
        handling = new VehicleAndMiscHandling();
        controller = new CarController();
        frame = new CarView("CarSim 1.0", controller);
    }

    public void VehicleUppdate(){

        timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.update();
                    frame.drawPanel.repaint();
                }
            });

            timer.start();
        }
}