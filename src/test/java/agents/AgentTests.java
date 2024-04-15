
// adds tests to test the Agents

package agents;

import Models.LightingAgent;
import Models.NutrientAgent;
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