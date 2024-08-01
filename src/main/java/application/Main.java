package application;

import java.util.List;

public class Main {
    public interface Sensor {
        boolean isOn();    // returns true if the sensor is on
        void setOn();      // sets the sensor on
        void setOff();     // sets the sensor off
        int read();        // returns the value of the sensor if it's on
        // if the sensor is not on, throw an IllegalStateException
    }

    public static void main(String[] args) {
        // Test StandardSensor
        System.out.println("Testing StandardSensor:");
        StandardSensor ten = new StandardSensor(10);
        StandardSensor minusFive = new StandardSensor(-5);

        System.out.println(ten.read());
        System.out.println(minusFive.read());

        System.out.println(ten.isOn());
        ten.setOff();
        System.out.println(ten.isOn());

        // Test TemperatureSensor
        System.out.println("\nTesting TemperatureSensor:");
        Sensor kumpula = new TemperatureSensor();
        kumpula.setOn();
        System.out.println("temperature in Kumpula " + kumpula.read() + " degrees Celsius");

        // Test AverageSensor
        System.out.println("\nTesting AverageSensor:");
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);

        helsinkiRegion.setOn();
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");

        System.out.println("readings: " + helsinkiRegion.readings());
    }
}