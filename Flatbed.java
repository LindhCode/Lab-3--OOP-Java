package org.example.lab1;

public class Flatbed extends Trailer{
    private int flatbedAngle = 0;

    public void liftFlatbed() {
        flatbedAngle += 10;
        if (flatbedAngle > 70) {
            flatbedAngle = 70;
        }
    }

    public void lowerFlatbed() {
        flatbedAngle -= 10;
        if (flatbedAngle < 0) {
            flatbedAngle = 0;
        }
    }

    public int getFlatbedAngle() {
        return flatbedAngle;
    }

}
