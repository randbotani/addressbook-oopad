package se.carl.commands;

import se.carl.exceptions.*;
import se.carl.tools.*;
import se.carl.registry.*;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AddContactCommand implements Command {
    private static final Logger log = Logger.getLogger(AddContactCommand.class.getName());

    private ArrayList<String> parameters;
    private ConsolePrinter consolePrinter;
    private Registry registry;
    private final int validParameters = 3;

    public AddContactCommand(){
        log.info("Creating a command instance...");
    }

    public AddContactCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry) {
        log.info("Setting a command instance...");
        this.parameters = parameters;
        this.consolePrinter = consolePrinter;
        this.registry = registry;
    }

    @Override
    public String getName() {
        String info = "add\t";
        log.info("Getting a command name: " + info);
        return info;
    }

    @Override
    public String getDescription() {
        String info = "Adds a contact.";
        log.info("Getting a command description: " + info);
        return info;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        String info = "Contact added!";

        if (validate()) {
            registry.addContact(parameters.get(0), parameters.get(1), parameters.get(2));
            consolePrinter.print(info);
            log.info(info);

        }

    }

    private boolean validate() throws InvalidCommandParameterException {

        if (parameters.size() == validParameters) {
            log.info("Valid number of parameters.");
            return true;
        }
        else {
            log.severe("Invalid number of parameters.");
            throw new InvalidCommandParameterException();

        }
    }
}
