package Models;

import Interfaces.Agent;

import static com.codechronicle.Main.log;

public class LightingAgent  implements Agent {
    public void readSensors() {
        // log a message to a file using this logger found in main :    private static Logger log = LoggerFactory.getLogger(Main.class);
        log.info("Reading light level...");




        System.out.println("Reading light level...");
    }

    public void run() {
        System.out.println("Turning on lights...");
    }
}
