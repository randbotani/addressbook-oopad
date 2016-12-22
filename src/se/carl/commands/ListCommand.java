package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.model.*;
import se.carl.registry.*;

import java.util.ArrayList;
import java.util.logging.Logger;


public class ListCommand implements Command {
    private static final Logger log = Logger.getLogger(ListCommand.class.getName());


    private ArrayList<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter;
    private RemoteRegistry remoteRegistry;
    private ArrayList<Contact> combinedContacts;
    private final int validParameters = 0;

    public ListCommand(){
        log.info("Creating a command instance...");
    }

    public ListCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        log.info("Setting a command instance...");
        this.parameters = parameters;
        this.registry = registry;
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        combinedContacts = new ArrayList<>();
    }

    @Override
    public String getName() {
        String info = "list";
        log.info("Getting a command name: " + info);
        return info;
    }

    @Override
    public String getDescription() {
        String info = "Lists all contacts.";
        log.info("Getting a command description: " + info);
        return info;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            log.info("Creating an actual contact list...");
            combinedContacts.addAll(registry.getContacts());
            combinedContacts.addAll(remoteRegistry.getContacts());
            combinedContacts = ContactListSorter.sort(combinedContacts);
            consolePrinter.print(ContactFormatter.format(combinedContacts));
        }
    }


    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == validParameters) {
            log.info("Valid number of parameters.");
            return true;
        } else
            log.info("Invalid number of parameters.");
            throw new InvalidCommandParameterException();
    }
}
