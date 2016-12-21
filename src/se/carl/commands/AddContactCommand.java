package se.carl.commands;


import se.carl.exceptions.*;
import se.carl.tools.*;
import se.carl.registry.*;

import java.util.ArrayList;

public class AddContactCommand implements Command {

    private ArrayList<String> parameters;
    private ConsolePrinter consolePrinter;
    private Registry registry;
    private final int validParameters = 3;

    public AddContactCommand(){
    }

    public AddContactCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry) {
        this.parameters = parameters;
        this.consolePrinter = consolePrinter;
        this.registry = registry;
    }

    @Override
    public String getName() {
        return "add\t";
    }

    @Override
    public String getDescription() {
        return "adds a contact";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            registry.addContact(parameters.get(0), parameters.get(1), parameters.get(2));
            consolePrinter.print("Successfully added contact.");

        }

    }

    private boolean validate() throws InvalidCommandParameterException {

        if (parameters.size() == validParameters) {
            return true;
        }
        else
            throw new InvalidCommandParameterException();
    }
}
