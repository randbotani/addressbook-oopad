package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.model.*;
import se.carl.registry.*;

import java.util.ArrayList;
import java.util.logging.Logger;


public class DeleteContactCommand implements Command {
    private static final Logger log = Logger.getLogger(DeleteContactCommand.class.getName());

    private ArrayList<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter;
    private RemoteRegistry remoteRegistry;
    private ArrayList<Contact> allContacts;
    private final int validParameters = 1;

    public DeleteContactCommand(){
        log.info("Creating a command instance...");
    }

    public DeleteContactCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        log.info("Combining lists of contacts...");
        this.parameters = parameters;
        this.registry = registry;
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        allContacts = new ArrayList<>();
    }

    @Override
    public String getName() {
        String info = "delete";
        log.info("Getting a command name: " + info);
        return info;
    }

    @Override
    public String getDescription() {
        String info = "Delete a contact using a local id.";
        log.info("Getting a command description: " + info);
        return info;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        String info = "Contact deleted!";
        if (validate()) {
            for (LocalContact localContact : registry.getContacts()
                    ) {
                if(localContact.getId().equals(parameters.get(0))) {
                    registry.deleteContact(parameters.get(0));
                    consolePrinter.print(info);
                    log.info(info);
                    return;
                }
            }
            for (RemoteContact remoteContact : remoteRegistry.getContacts()
                    ) {
                if(remoteContact.getId().equals(parameters.get(0))) {
                    info = "Unable to delete remote contacts!";
                    consolePrinter.print(info);
                    log.info(info);
                }
            }
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
