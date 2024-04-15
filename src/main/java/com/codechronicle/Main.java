package com.codechronicle;


import Models.LightingAgent;
import Models.NutrientAgent;
import org.jline.reader.*;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import Models.WateringAgent;
import Models.NutrientAgent;
import Models.LightingAgent;
import Models.InternalConditionsAgent;
import Interfaces.Agent;


public class Main {

    public static Logger log = LoggerFactory.getLogger(Main.class);

    private static WateringAgent wateringAgent = new WateringAgent();
    private static LightingAgent lightingAgent = new LightingAgent();

    private static NutrientAgent nutrientAgent = new NutrientAgent();


    private static InternalConditionsAgent internalConditionsAgent = new InternalConditionsAgent();



    // Make a list of agents
    private static Agent[] agents = {wateringAgent, lightingAgent, nutrientAgent, internalConditionsAgent};

    public static void main(String[] args) throws IOException {

        String prompt = "demo> ";
        String line = null;
        //while (!"quit".equals(line)) {
        // ask user to inpute mositure level
        // print "reading moisture level..."
        //wateringAgent.readSensors();
        //wateringAgent.run();


        // make an infinite loop
        while (true) {
            // for each agent in the agents list
            for (Agent agent : agents) {
                // make each agent run on a separate thread


                Thread thread = new Thread(() -> {

                    // read the sensors
                    agent.readSensors();
                    // run the agent
                    agent.run();

                });
                // start the thread
                thread.start();
                // wait for the thread to finish
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    log.error("Thread interrupted", e);
                }
            }
        }




    }
}
