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

    void moveit(CarData carObj,int x, int y) {
        carObj.getPoint().x = x;
        carObj.getPoint().y = y;
    }
    void moveit(TruckData truckObj,int x, int y) {
        truckObj.getPoint().x = x;
        truckObj.getPoint().y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarController cc) throws IOException {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cc = cc;

        // Här läggs bilarna till
        // Här läggs alla bilar till, med bilobjekt, bild, point
        cc.getCars().add(new CarData(new Volvo240(Color.black, 200), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")), new Point(100,200)));
        cc.getCars().add(new CarData(new Saab95(Color.green, 200), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")), new Point(200,200)));
        cc.getMiscs().add(new MiscData(new MechanicShop<Volvo240>(10, 500, 200, "Volvo240MechanicShop"), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")), new Point(500, 200)));
        cc.getTrucks().add(new TruckData(new Scania(Color.black, 700), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")), new Point(300,200)));

        // Synkar bilens x/y-Pos med Pointens x/y
        for(CarData carObj : cc.getCars()){
            carObj.getCarObj().setxPos(carObj.getPoint().x);
            carObj.getCarObj().setyPos(carObj.getPoint().y);
        }
        // Synkar för truckarna
        for(TruckData truckObj : cc.getTrucks()){
            truckObj.getTruck().setxPos(truckObj.getPoint().x);
            truckObj.getTruck().setyPos(truckObj.getPoint().y);
        }
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
        for (CarData carObj : cc.getCars()){
            g.drawImage(carObj.getImage(),carObj.getPoint().x,carObj.getPoint().y, null);
        }
        for (TruckData truckObj : cc.getTrucks()){
            g.drawImage(truckObj.getImage(),truckObj.getPoint().x,truckObj.getPoint().y, null);
        }
        for (MiscData miscObj : cc.getMiscs()){
            g.drawImage(miscObj.getImage(),miscObj.getPoint().x,miscObj.getPoint().y, null);
        }
    }
}
