package se.carl.tools;

import se.carl.commands.Command;
import se.carl.exceptions.*;
import se.carl.registry.*;

import java.util.logging.Logger;


public class CommandLineInterface implements InputHandler {
    private static final Logger log = Logger.getLogger(CommandLineInterface.class.getName());


    private Console console;
    private CommandInterpreter commandInterpreter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;

    public CommandLineInterface(Registry registry, RemoteRegistry remoteRegistry, Application application) {
        log.info("Setting Command Line Interface...");
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;

        console = new Console();
        console.registerInputHandler(this);
        commandInterpreter = new CommandInterpreter(registry, remoteRegistry, application, console);
    }

    void start(){
        log.info("Starting Console...");
        console.run();
    }


    @Override
    public void handle(CommandLine commandLine) {
        log.info("Handling a CommandLine into a Command...");
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();

        } catch (InvalidCommandException e) {
            String info = "Invalid Command!";
            log.info(info);
            System.out.println(info);
        } catch (InvalidCommandParameterException f){
            String info = "Invalid Command Parameters";
            log.info(info);
            System.out.println(info);
        }
    }
}
