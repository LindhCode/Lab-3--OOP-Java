package View;

import Controller.UserInputs;
import Model.CarModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class VisualUpdate {
    private final int delay = 50;
    private Timer timer;
    private CarModel controller;
    private UserInputs frame;

    private ArrayList<VehicleListener> listeners = new ArrayList<>();

    public VisualUpdate() throws IOException {
        // Initilzie  the logic, time and frame

        controller = new CarModel();
        frame = new UserInputs("CarSim 1.0", controller);

        // Lägger till alla listeners
        listeners.add(frame.drawPanel);
    }

    public void notifyListeners(){
        for(VehicleListener v : listeners){
            v.updateVisuals();
        }
    }


    public void VehicleUppdate(){

        timer = new Timer(delay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.update();
                    notifyListeners();
                }
            });

            timer.start();
        }
}