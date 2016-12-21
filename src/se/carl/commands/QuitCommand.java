package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.registry.*;
import java.util.ArrayList;

public class QuitCommand implements Command {

    private ArrayList<String> parameters;

    private Application application;
    private ConsolePrinter consolePrinter;
    private final int validParameters = 0;

    public QuitCommand() {
    }

    public QuitCommand(ArrayList<String> parameters, Application application, ConsolePrinter consolePrinter) {

        this.parameters = parameters;
        this.application = application;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public String getName() {
        return "quit";
    }

    @Override
    public String getDescription() {
        return "exit program";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {

            application.getRegistryPersister().save(application.getRegistry());
            application.quit();

        }
    }

    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == validParameters) {
            return true;
        } else
            throw new InvalidCommandParameterException();
    }
}
