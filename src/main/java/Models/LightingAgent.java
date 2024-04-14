package Models;

import Interfaces.Agent;
import java.io.BufferedReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import Interfaces.Agent;
import Utils.TerminalUtils;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import static com.codechronicle.Main.log;
import Utils.TerminalUtils;

public class LightingAgent  implements Agent {
    Runnable helloRunnable = new Runnable() {
        public void run() {
            System.out.println("Checking the light Intensity...");
        }
    };

    private static String prompt = "demo> ";


    private static float lightIntensity=50;
    private static float humidity=50;
    private static float temperature=50;
    private static LineReader lineReader = TerminalUtils.getLineReader();
    private static boolean ledRequired =false;
    private static boolean shadingRequired =false;

    public void readSensors() {
        System.out.println("Reading the light Intensity sensor value");
        float lightIntensity = Float.parseFloat(lineReader.readLine(prompt));
        System.out.println("Reading the humidity sensor value");
        float humidity = Float.parseFloat(lineReader.readLine(prompt));
        System.out.println("Reading the temperature sensor value");
        float temperature = Float.parseFloat(lineReader.readLine(prompt));
        setLightIntensity(lightIntensity);
        setHumidity(humidity);
        setTemperatureLevel(temperature);
    }
    private void setLightIntensity(float lightIntensityValue) {
        // Get the moisture level of the soil
        lightIntensity = lightIntensityValue;
    }
    private void setHumidity(float humidityValue) {
        // Get the moisture level of the soil
        humidity = humidityValue;
    }
    private void setTemperatureLevel(float temperatureValue) {
        // Get the moisture level of the soil
        temperature = temperatureValue;
    }
    public boolean isLedRequired(){
        boolean ledRequirement=false;
        if(temperature< 70){
            ledRequirement=true;
        } else if (humidity> 50) {
            ledRequirement=true;
        } else if (lightIntensity> 50) {
            ledRequirement=false;
        }
        return ledRequirement;
    }
    private boolean isShadingRequired(boolean ledRequirement) {
        boolean shading =false;
        if(ledRequirement == true && lightIntensity > 50){
            ledRequirement=false;
            shading=true;
        }
        if(lightIntensity< 50)
        {
            shading=true;
        }
        if(lightIntensity< 50 && shading == true)
        {
            ledRequirement=true;
        }
        return shading;
    }
    private void setLedRequirement(boolean ledRequirement) {
        // Get the moisture level of the soil
        ledRequired = ledRequirement;
    }
    private void setShadingRequired(boolean shadingRequirement) {
        // Get the moisture level of the soil
        shadingRequired = shadingRequirement;
    }

    public void run() {
        System.out.println("Not implemented yet.");
    }

    @Override
    public void alert(String message) {
        if(ledRequired ==true)
            System.out.println("LED is ON");
        if(shadingRequired ==true)
            System.out.println("Shading has been turned on");
        if(shadingRequired == false && ledRequired ==false)
            System.out.println(" Optimal Amount of light is available - No external source required");
    }

    public void waitForSomeTime() {

    }
}
