package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.model.*;
import se.carl.registry.*;

import java.util.ArrayList;
import java.util.logging.Logger;


public class SearchCommand implements Command {
    private static final Logger log = Logger.getLogger(SearchCommand.class.getName());


    private ArrayList<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter;
    private RemoteRegistry remoteRegistry;
    private ArrayList<Contact> combinedContacts;
    private final int validParameters = 1;

    public SearchCommand(){
        log.info("Creating a command instance...");
    }

    public SearchCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        log.info("Setting a command instance...");
        this.parameters = parameters;
        this.registry = registry;
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        combinedContacts = new ArrayList<>();
    }

    @Override
    public String getName() {
        String info = "search";
        log.info("Getting a command name: " + info);
        return info;
    }

    @Override
    public String getDescription() {
        String info = "Searches though all contacts.";
        log.info("Getting a command description: " + info);
        return info;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        String info = "Search completed!";
        if (validate()) {
            combinedContacts.addAll(registry.search(parameters.get(0)));
            combinedContacts.addAll(remoteRegistry.search(parameters.get(0)));
            combinedContacts = ContactListSorter.sort(combinedContacts);
            consolePrinter.print( ContactFormatter.format(combinedContacts));
            consolePrinter.print(info);
            log.info(info);
            if(combinedContacts.size() == 0){
                info = "Contact not found!";
                consolePrinter.print(info);
                log.info(info);
            }
        } else{
            info = "Searching failed!";
            consolePrinter.print(info);
            log.info(info);
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
