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

    // this method waters the plants in the greenhouse for the next 30 minutes
    public void waterPlants() {
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
