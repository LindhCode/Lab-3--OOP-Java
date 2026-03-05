package View;

import Controller.UserInputs;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowView extends JFrame {
    public static final int X = 800;
    public static final int Y = 800;
    public DrawPanel drawPanel;

    public WindowView() throws IOException {
        initComponents();
    }

    public void initComponents() {
        setTitle("Car Simulator");
        setPreferredSize(new Dimension(X, Y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    public void end() {
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
