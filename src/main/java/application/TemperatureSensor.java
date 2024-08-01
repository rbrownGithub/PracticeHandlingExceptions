package application;

import java.util.Random;

public class TemperatureSensor implements Main.Sensor {
    private boolean isOn;
    private final Random random;

    public TemperatureSensor() {
        this.isOn = false;
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public int read() {
        if (!isOn) {
            throw new IllegalStateException("Sensor is off");
        }
        return random.nextInt(61) - 30; // Returns a random temperature between -30 and 30
    }
}