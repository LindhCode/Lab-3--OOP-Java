package Application;

import Controller.UserInputs;
import Model.CarModel;
import View.VisualUpdate;
import View.WindowView;

import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {
        VisualUpdate VUP = new VisualUpdate();
        VUP.VehicleUppdate();
    }
}