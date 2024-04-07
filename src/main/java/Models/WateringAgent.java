package Models;

import java.io.BufferedReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import Interfaces.Agent;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;


import Utils.TerminalUtils;


// extends the Agent interface

public class WateringAgent implements Agent {
    Runnable helloRunnable = new Runnable() {
        public void run() {
            System.out.println("Watering plants...");
        }
    };

    private static String prompt = "demo> ";

    private static LineReader lineReader = TerminalUtils.getLineReader();;

    private float moistureLevel = 20;

    // this method sets the moisture level of the soil
    private void setMoistureLevel(float currWaterLevel) {
        // Get the moisture level of the soil
        moistureLevel = currWaterLevel;
    }
    
    // implement the readSensors method
    public void readSensors() {
        System.out.println("Reading moisture level. Please enter the moisture level: ");
        float moistureLevel = Float.parseFloat(lineReader.readLine(prompt));
        setMoistureLevel(moistureLevel);
    }

    // this method waters the plants in the greenhouse if required
    public void run() {
        // Water the plants if required
        waterPlants();
    }

    // this method waters the plants in the greenhouse for the next 30 minutes
    private void waterPlants() {
        // if the moisture level is above and at 20% don't water the plants
        if (moistureLevel >= 20) {
            System.out.println("Moisture level is at " + moistureLevel + "%. No need to water the plants.");
            return;
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            // Print whatever you want here
            System.out.println("Watering plants...");
        }, 0, 1, TimeUnit.SECONDS);

        // Schedule a task to shutdown the scheduler after 30 seconds
        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 30, TimeUnit.SECONDS);
    }
}
