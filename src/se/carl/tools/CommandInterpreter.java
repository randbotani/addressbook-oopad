package se.carl.tools;

import se.carl.commands.*;
import se.carl.exceptions.InvalidCommandException;
import se.carl.registry.*;

class CommandInterpreter {

    private Registry registry;

    private RemoteRegistry remoteRegistry;
    private ConsolePrinter consolePrinter;
    private RegistryPersister registryPersister;
    private Application application;

    public CommandInterpreter(Registry registry, RemoteRegistry remoteRegistry, Application application , ConsolePrinter consolePrinter) {
        this.application = application;
        registryPersister = new RegistryPersister();
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
        this.consolePrinter = consolePrinter;
    }

    Command interpret(CommandLine commandLine) throws InvalidCommandException {

        switch (commandLine.getCommand()) {

            case ("help"): {
                return new HelpCommand(consolePrinter);
            }

            case ("add"): {
                return new AddContactCommand(commandLine.getArrayParameters(), consolePrinter, registry);
            }

            case ("delete"): {
                return new DeleteContactCommand(commandLine.getArrayParameters(), consolePrinter, registry, remoteRegistry);
            }

            case ("list"): {
                return new ListCommand(commandLine.getArrayParameters(), consolePrinter, registry, remoteRegistry);
            }

            case ("search"): {
                return new SearchCommand(commandLine.getArrayParameters(), consolePrinter, registry, remoteRegistry);
            }

            case ("quit"): {
                return new QuitCommand(commandLine.getArrayParameters(), application ,consolePrinter);
            }

            default: {
                throw new InvalidCommandException();
            }
        }
    }

}
