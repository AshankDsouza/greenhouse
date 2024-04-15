package Interfaces;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public interface Agent {
    public void readSensors();
    public void run() throws InterruptedException;

    public void alert(String message);

    public void waitForSomeTime();

    public String returnSensorfile(String filename);
}
