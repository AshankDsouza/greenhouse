
// adds tests to test the Agents

package agents;

import Models.LightingAgent;
import Models.NutrientAgent;
import Models.WateringAgent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgentTests {

    @Test
    void testLightingAgent() {
        LightingAgent lightingAgent = new LightingAgent();
//        lightingAgent.readSensors();
        lightingAgent.run();
    }


    @Test
    void testWateringAgentSettingOfMoistureLevel() {
        // Create an instance of WateringAgent
        WateringAgent wateringAgent = new WateringAgent();

        // Set the moisture level using setMoistureLevel method
        wateringAgent.setMoistureLevel(45);

        // Check if the moisture level is correctly set
        assertEquals(45, wateringAgent.getMoistureLevel());
    }

    @Test
    void testNutrientAgentNutrientsRequired() throws InterruptedException {
        NutrientAgent nutrientAgent = new NutrientAgent();
        nutrientAgent.sensorFile="NutrientSensorTestNReq.xlsx";
        nutrientAgent.readSensors();
        nutrientAgent.run();
    }

    @Test
    void testNutrientAgentAllGood() throws InterruptedException {
        NutrientAgent nutrientAgent = new NutrientAgent();
        nutrientAgent.sensorFile="NutrientSensorTestGood.xlsx";
        nutrientAgent.readSensors();
        nutrientAgent.run();
    }

}