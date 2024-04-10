package Models;

import Interfaces.Agent;

public class LightingAgent  implements Agent {
    public void readSensors() {
        System.out.println("Reading light level...");
    }

    public void run() {
        System.out.println("Turning on lights...");
    }
}
