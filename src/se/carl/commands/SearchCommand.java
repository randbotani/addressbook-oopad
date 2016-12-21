package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;
import se.carl.model.*;
import se.carl.registry.*;

import java.util.ArrayList;


public class SearchCommand implements Command {

    private ArrayList<String> parameters;
    private Registry registry;
    private ConsolePrinter consolePrinter;
    private RemoteRegistry remoteRegistry;
    private ArrayList<Contact> combinedContacts;
    private final int validParameters = 1;

    public SearchCommand(){}

    public SearchCommand(ArrayList<String> parameters, ConsolePrinter consolePrinter, Registry registry, RemoteRegistry remoteRegistry) {
        this.parameters = parameters;
        this.registry = registry;
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        combinedContacts = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "search";
    }

    @Override
    public String getDescription() {
        return "searches through all registers";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        if (validate()) {
            combinedContacts.addAll(registry.search(parameters.get(0)));
            combinedContacts.addAll(remoteRegistry.search(parameters.get(0)));
            combinedContacts = ContactListSorter.sort(combinedContacts);
            consolePrinter.print( ContactFormatter.format(combinedContacts));
            consolePrinter.print("Search completed!");
            if(combinedContacts.size() == 0){
                consolePrinter.print("No such contact");
            }
        } else{
            consolePrinter.print("Invalid number of parameters");
        }
    }


    private boolean validate() throws InvalidCommandParameterException {
        if (parameters.size() == validParameters) {
            return true;
        } else
            throw new InvalidCommandParameterException();
    }
}
