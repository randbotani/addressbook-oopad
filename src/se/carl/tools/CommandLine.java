package se.carl.tools;

import java.util.ArrayList;

class CommandLine {

    private String command;
    private String[] parameters;
    private ArrayList<String> parametersArray = new ArrayList<>();

    public CommandLine(String userInput) {
        parse(userInput);
    }


    private void parse(String string) {
        parameters = string.split(" ");
        command = parameters[0];
        for (int i = 1; i < parameters.length && parameters[i] != null; i++) {
            parametersArray.add(parameters[i]);
        }
    }

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getArrayParameters() {
        return parametersArray;
    }
}