package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.registry.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class QuitCommand implements Command {
    private static final Logger log = Logger.getLogger(QuitCommand.class.getName());


    private ArrayList<String> parameters;

    private Application application;
    private ConsolePrinter consolePrinter;
    private final int validParameters = 0;

    public QuitCommand() {
        log.info("Creating a command instance...");
    }

    public QuitCommand(ArrayList<String> parameters, Application application, ConsolePrinter consolePrinter) {
        log.info("Setting a command instance...");
        this.parameters = parameters;
        this.application = application;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public String getName() {
        String info = "quit";
        log.info("Getting a command name: " + info);
        return info;
    }

    @Override
    public String getDescription() {
        String info = "Exit.";
        log.info("Getting a command description: " + info);
        return info;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            log.info("Exiting program...");
            application.getRegistryPersister().save(application.getRegistry());
            application.quit();

        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == validParameters) {
            log.info("Valid number of parameters.");
            return true;
        } else
            log.info("invalid number of parameters.");
            throw new InvalidCommandParameterException();
    }
}
