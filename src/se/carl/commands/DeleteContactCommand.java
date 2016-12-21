package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.model.*;
import se.carl.registry.*;

import java.util.ArrayList;


public class DeleteContactCommand implements Command {

    private ArrayList<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter;
    private RemoteRegistry remoteRegistry;
    private ArrayList<Contact> combinedContacts;
    private final int validParameters = 1;

    public DeleteContactCommand(){}

    public DeleteContactCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        this.parameters = parameters;
        this.registry = registry;
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        combinedContacts = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public String getDescription() {
        return "delete a contact using id";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            for (LocalContact localContact : registry.getContacts()
                    ) {
                if(localContact.getId().equals(parameters.get(0))) {
                    registry.deleteContact(parameters.get(0));
                    consolePrinter.print("deleted local contact");
                    return;
                }
            }
            for (RemoteContact remoteContact : remoteRegistry.getContacts()
                    ) {
                if(remoteContact.getId().equals(parameters.get(0))) {
                    consolePrinter.print("Unable to delete remote contacts");
                }
            }
        }
    }


    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == validParameters) {
            return true;
        } else
            throw new InvalidCommandParameterException();
    }
}
