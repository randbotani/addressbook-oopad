package se.carl.tools;

import se.carl.commands.*;
import se.carl.exceptions.InvalidCommandException;
import se.carl.registry.*;

import java.util.logging.Logger;

class CommandInterpreter {
    private static final Logger log = Logger.getLogger(CommandInterpreter.class.getName());

    private Registry registry;

    private RemoteRegistry remoteRegistry;
    private ConsolePrinter consolePrinter;
    private RegistryPersister registryPersister;
    private Application application;

    public CommandInterpreter(Registry registry, RemoteRegistry remoteRegistry, Application application , ConsolePrinter consolePrinter) {
        log.info("Setting Interpreter...");
        this.application = application;
        registryPersister = new RegistryPersister();
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;
        this.consolePrinter = consolePrinter;
    }

    Command interpret(CommandLine commandLine) throws InvalidCommandException {

        switch (commandLine.getCommand()) {

            case ("help"): {
                log.info("Input 'help' found!");
                return new HelpCommand(consolePrinter);
            }

            case ("add"): {
                log.info("Input 'add' found!");
                return new AddContactCommand(commandLine.getArrayParameters(), consolePrinter, registry);
            }

            case ("list"): {
                log.info("Input 'list' found!");
                return new ListCommand(commandLine.getArrayParameters(), consolePrinter, registry, remoteRegistry);
            }

            case ("search"): {
                log.info("Input 'search' found!");
                return new SearchCommand(commandLine.getArrayParameters(), consolePrinter, registry, remoteRegistry);
            }

            case ("delete"): {
                log.info("Input 'delete' found!");
                return new DeleteContactCommand(commandLine.getArrayParameters(), consolePrinter, registry, remoteRegistry);
            }

            case ("quit"): {
                log.info("Input 'quit' found!");
                return new QuitCommand(commandLine.getArrayParameters(), application ,consolePrinter);
            }

            default: {
                String info = commandLine.getCommand();
                log.info("Input '" + info + "' is undefined!");
                throw new InvalidCommandException();
            }
        }
    }

}
