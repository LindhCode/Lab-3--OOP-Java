package View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageHandler {
    public static final BufferedImage VOLVO240_IMAGE;
    public static final BufferedImage SAAB95_IMAGE;
    public static final BufferedImage SCANIA_IMAGE;
    public static final BufferedImage VOLVO_WORKSHOP_IMAGE;

    static {
        try {
            VOLVO240_IMAGE = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            SAAB95_IMAGE = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            SCANIA_IMAGE = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
            VOLVO_WORKSHOP_IMAGE = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

