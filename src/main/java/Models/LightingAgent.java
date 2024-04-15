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
        System.out.println("Reading the light Intensity sensor value for lighting agent");
        float lightIntensity = Float.parseFloat(lineReader.readLine(prompt));
        System.out.println("Reading the humidity sensor value for lighting agent");
        float humidity = Float.parseFloat(lineReader.readLine(prompt));
        System.out.println("Reading the temperature sensor value for lighting agent");
        float temperature = Float.parseFloat(lineReader.readLine(prompt));
        System.out.println("Checking the shading for lighting agent");
        boolean shadingRequired = Boolean.parseBoolean(lineReader.readLine(prompt));
        setLightIntensity(lightIntensity);
        setHumidity(humidity);
        setTemperatureLevel(temperature);
        setShadingLevel(shadingRequired);
    }
    private void setLightIntensity(float lightIntensityValue) {
        // Get the moisture level of the soil
        lightIntensity = lightIntensityValue;
    }
    private void setShadingLevel(boolean shadingRequired) {
        // Get the moisture level of the soil
        shadingRequired = shadingRequired;
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

        if(ledRequirement == true && lightIntensity > 50){
            //ledRequirement=false;
            shadingRequired=true;
        }

        return shadingRequired;
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


        boolean ledRequirement= isLedRequired();
        boolean shadingRequirement = isShadingRequired(ledRequirement);
        setLedRequirement( ledRequirement);
        setShadingRequired( shadingRequirement);
        String display="Light is adequate";

         if(shadingRequired ==true && ledRequired ==true)
            display="-----Shading should been turned on for the lighting agent------";
         else if(shadingRequired ==true)
             display="---Turn ON the LED---";
        else if(shadingRequired == false && ledRequired ==false)
            display="-----Optimal Amount of light is available - No external source required for lighting agent-----";
        alert(display);
        waitForSomeTime();
    }

    @Override
    public void alert(String message) {
       System.out.println(message);
    }


    @Override
    public void waitForSomeTime() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 10000;
        while (System.currentTimeMillis() < endTime) {
            System.out.println("Reseting");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String returnSensorfile(String filename) {
        return null;
    }
}
