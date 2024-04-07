package com.codechronicle;


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

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static WateringAgent wateringAgent = new WateringAgent();
    public static void main(String[] args) throws IOException {

        String prompt = "demo> ";
        String line = null;
        //while (!"quit".equals(line)) {
        // ask user to inpute mositure level
        // print "reading moisture level..."
        wateringAgent.readSensors();
        wateringAgent.run();


    }
}
