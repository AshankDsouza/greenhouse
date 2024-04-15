package Models;

import Interfaces.Agent;
import Utils.TerminalUtils;
import org.jline.reader.LineReader;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InternalConditionsAgent  implements Agent {

    private static LineReader lineReader = TerminalUtils.getLineReader();;
    private static String prompt = "demo> ";

    private float carbonLevel = 10;
    private float humidityLevel = 10;



    public void readSensors() {
        System.out.println("Reading carbon dioxide levels. Please enter the carbon dioxide level: ");
        carbonLevel = Float.parseFloat(lineReader.readLine(prompt));

        System.out.println("Reading humidity levels. Please enter the humidity level: ");
        humidityLevel = Float.parseFloat(lineReader.readLine(prompt));

    }

    public void run() {
        openWindow();
    }

    public void alert(String message) {

    }

    public void waitForSomeTime() {

    }

    @Override
    public String returnSensorfile(String filename) {
        return null;
    }

    private void openWindow() {
        // if the moisture level is above and at 20% don't water the plants
        if(carbonLevel <= 10 & humidityLevel <= 10) {
            System.out.println("Conditions are normal. No need to open the windows.");
            return;
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            // Print whatever you want here
            System.out.println("Opening window...");
        }, 0, 1, TimeUnit.SECONDS);

        // Schedule a task to shutdown the scheduler after 30 seconds
        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 3, TimeUnit.SECONDS);
    }
}
