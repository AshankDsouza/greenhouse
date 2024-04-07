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
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        Completer completer = new ArgumentCompleter(
                new StringsCompleter("bar", "baz"),
                new StringsCompleter("foo"),
                new StringsCompleter("ree"),
                new NullCompleter());

        // https://github.com/jline/jline3/wiki/Using-line-readers
        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(completer)
                .build();

        String prompt = "demo> ";
        String line = null;
        //while (!"quit".equals(line)) {
            wateringAgent.waterPlants();
        //}
    }
}
