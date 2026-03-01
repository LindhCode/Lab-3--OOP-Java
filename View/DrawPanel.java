package View;

import Controller.UserInputs;
import Model.*;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements VehicleListener {
    CarModel cc;
    private VehicleAndMiscHandling handling;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel cc) throws IOException {
        this.handling = new VehicleAndMiscHandling();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cc = cc;
    }

    @Override
    public void updateVisuals(){
        repaint();
    }



    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(handling.getVehicles().size());
        for (int i = 0; i < handling.getVehicles().size(); i++) {
            VehicleVisual vehicleVisual = handling.getVehicles().get(i);
            VehicleFeatures vehicleObject = cc.getVehicles().get(i);
            int x = (int) Math.round(vehicleObject.getxPos());
            int y = (int) Math.round(vehicleObject.getyPos());
            g.drawImage(vehicleVisual.getImage(), x, y, null);
        }
        for (int i = 0; i < handling.getMiscs().size(); i++) {
            MiscVisual miscVisual = handling.getMiscs().get(i);
            MiscFeatures miscObject = cc.getMiscs().get(i);
            int x = (int) Math.round(miscObject.getxPos());
            int y = (int) Math.round(miscObject.getyPos());
            g.drawImage(miscVisual.getImage(), x, y, null);
        }
    }


}
