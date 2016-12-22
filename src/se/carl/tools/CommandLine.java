package se.carl.tools;

import java.util.ArrayList;
import java.util.logging.Logger;

class CommandLine {
    private static final Logger log = Logger.getLogger(CommandLine.class.getName());


    private String command;
    private String[] parameters;
    private ArrayList<String> parametersArray = new ArrayList<>();

    public CommandLine(String userInput) {
        log.info("Creating a Command Line...");
        parse(userInput);
    }


    private void parse(String string) {
        log.info("Parsing user's input...");
        parameters = string.split(" ");
        command = parameters[0];
        for (int i = 1; i < parameters.length && parameters[i] != null; i++) {
            parametersArray.add(parameters[i]);
        }
    }

    public String getCommand() {
        log.info("Getting a command (String).");
        return command;
    }

    public ArrayList<String> getArrayParameters() {
        log.info("Getting a array with Parameters (String).");
        return parametersArray;
    }
}