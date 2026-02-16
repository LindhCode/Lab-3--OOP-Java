
import java.util.Stack;

public class CarTransport extends Trailer{
    private boolean rampUp = true;
    Stack<CarFeatures> cars = new Stack<>();

    public void lowerRamp(){
        rampUp = false;
    }

    public void liftRamp(){
        rampUp = true;
    }

    public boolean getRampUp() {
        return rampUp;
    }

    public Stack<CarFeatures> getCars() {
        return cars;
    }

    public void loadCar(CarFeatures c) {
        if (!rampUp && cars.size() < 10) {
            cars.push(c);
        }
    }

    public CarFeatures unloadCar() {
        if (!cars.isEmpty()) {
            return cars.pop();
        }
        return null;
    }
}
