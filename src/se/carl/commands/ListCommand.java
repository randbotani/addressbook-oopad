package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.model.*;
import se.carl.registry.*;

import java.util.ArrayList;


public class ListCommand implements Command {

    private ArrayList<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter;
    private RemoteRegistry remoteRegistry;
    private ArrayList<Contact> combinedContacts;
    private final int validParameters = 0;

    public ListCommand(){}

    public ListCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        this.parameters = parameters;
        this.registry = registry;
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        combinedContacts = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "lists all contacts in all registries";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            combinedContacts.addAll(registry.getContacts());
            combinedContacts.addAll(remoteRegistry.getContacts());
            combinedContacts = ContactListSorter.sort(combinedContacts);
            consolePrinter.print(ContactFormatter.format(combinedContacts));
        }
    }


    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == validParameters) {
            return true;
        } else
            throw new InvalidCommandParameterException();
    }
}
