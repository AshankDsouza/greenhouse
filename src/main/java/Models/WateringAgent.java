package Models;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WateringAgent {

    Runnable helloRunnable = new Runnable() {
        public void run() {
            System.out.println("Watering plants...");
        }
    };

    private float moistureLevel = 20;

    // this method sets the moisture level of the soil
    public void setMoistureLevel(float currWaterLevel) {
        // Get the moisture level of the soil
        moistureLevel = currWaterLevel;
    }

    // this method waters the plants in the greenhouse if required
    public void run() {
        // Water the plants if required
        waterPlants(moistureLevel);
    }

    // this method waters the plants in the greenhouse for the next 30 minutes
    private void waterPlants(float moistureLevel) {
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
