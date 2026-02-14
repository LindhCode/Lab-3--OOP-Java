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


    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);


    void moveit(CarData carObj,int x, int y) {
        carObj.point.x = x;
        carObj.point.y = y;
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

        // Synkar bilens x/y-Pos med Pointens x/y
        for(CarData carObj : cc.getCars()){
            carObj.car.setxPos(carObj.point.x);
            carObj.car.setyPos(carObj.point.y);
        }

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Updatera för alla i listan
        for (CarData carObj : cc.getCars()){
            g.drawImage(carObj.image,carObj.point.x,carObj.point.y, null);
        }
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
