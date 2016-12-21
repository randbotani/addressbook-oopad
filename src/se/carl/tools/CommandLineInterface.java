package se.carl.tools;

import se.carl.commands.Command;
import se.carl.exceptions.*;
import se.carl.registry.*;



public class CommandLineInterface implements InputHandler {

    private Console console;
    private CommandInterpreter commandInterpreter;
    private Registry registry;
    private RemoteRegistry remoteRegistry;

    public CommandLineInterface(Registry registry, RemoteRegistry remoteRegistry, Application application) {
        this.registry = registry;
        this.remoteRegistry = remoteRegistry;

        console = new Console();
        console.registerInputHandler(this);
        commandInterpreter = new CommandInterpreter(registry, remoteRegistry, application, console);
    }

    void start(){
        console.run();
    }


    @Override
    public void handle(CommandLine commandLine) {
        try {
            Command command = commandInterpreter.interpret(commandLine);
            command.execute();

        } catch (InvalidCommandException e) {
            System.out.println("Invalid Command");
        } catch (InvalidCommandParameterException f){
            System.out.println("Invalid Command Parameters");
        }
    }
}
