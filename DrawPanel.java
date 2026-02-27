import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    CarController cc;
    private VehicleAndMiscHandling handling;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) throws IOException {
        this.handling = new VehicleAndMiscHandling();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cc = cc;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < handling.getVehicles().size(); i++) {
            VehicleVisual vehicleVisual = handling.getVehicles().get(i);
            VehicleFeatures vehicleObject = cc.getVehicles().get(i);
            int x = (int) Math.round(vehicleObject.getxPos());
            int y = (int) Math.round(vehicleObject.getyPos());
            g.drawImage(vehicleVisual.getImage(), x, y, null);
        }
        for (int i = 0; i < handling.getMiscs().size(); i++) {
            MiscData miscVisual = handling.getMiscs().get(i);
            MiscFeatures miscObject = cc.getMiscs().get(i);
            int x = (int) Math.round(miscObject.getxPos());
            int y = (int) Math.round(miscObject.getyPos());
            g.drawImage(miscVisual.getImage(), x, y, null);
        }
    }
}
