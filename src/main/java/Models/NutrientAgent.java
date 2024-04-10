package Models;

import Interfaces.Agent;

public class NutrientAgent implements Agent {
    public void readSensors() {
        System.out.println("Reading nutrient level...");
    }

    public void run() {
        System.out.println("Adding nutrients...");
    }
}
