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

    void moveit(VehicleData vehObj,int x, int y) {
        vehObj.getPoint().x = x;
        vehObj.getPoint().y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cc = cc;

        // Här läggs bilarna till
        // Här läggs alla bilar till, med bilobjekt, bild, point
        cc.getVehicles().add(new VehicleData(new Volvo240(Color.black, 200), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")), new Point(100,200)));
        cc.getVehicles().add(new VehicleData(new Saab95(Color.green, 200), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")), new Point(200,200)));
        cc.getMiscs().add(new MiscData(new MechanicShop<Volvo240>(10, 500, 200, "Volvo240MechanicShop"), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point(500, 200)));
        cc.getVehicles().add(new VehicleData(new Scania(Color.black, 700), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")), new Point(300,200)));

        // Synkar fordonens x/y-Pos med Pointens x/y
        for(VehicleData vehObj : cc.getVehicles()){
            vehObj.getVehicle().setxPos(vehObj.getPoint().x);
            vehObj.getVehicle().setyPos(vehObj.getPoint().y);
        }
        // Synkar för miscs
        for (MiscData miscObj : cc.getMiscs()) {
            miscObj.getMiscObj().setxPos(miscObj.getPoint().x);
            miscObj.getMiscObj().setyPos(miscObj.getPoint().y);
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Updatera för alla i listan
        for(VehicleData vehObj : cc.getVehicles()){
            g.drawImage(vehObj.getImage(),vehObj.getPoint().x,vehObj.getPoint().y, null);
        }
        for (MiscData miscObj : cc.getMiscs()){
            g.drawImage(miscObj.getImage(),miscObj.getPoint().x,miscObj.getPoint().y, null);
        }
    }
}
