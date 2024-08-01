package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Main.Sensor {
    private List<Main.Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Main.Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return sensors.stream().allMatch(Main.Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Main.Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Main.Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor is off or has no sensors");
        }
        int sum = sensors.stream().mapToInt(Main.Sensor::read).sum();
        int average = sum / sensors.size();
        readings.add(average);
        return average;
    }

    public List<Integer> readings() {
        return new ArrayList<>(readings);
    }
}