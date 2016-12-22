package se.carl.tools;

import se.carl.commands.*;

import java.util.ArrayList;
import java.util.logging.Logger;

class AllCommands {
    private static final Logger log = Logger.getLogger(AllCommands.class.getName());


    private ArrayList<Command> commands = new ArrayList<>();

    public AllCommands(){
        log.info("Listing all commands...");
        commands.add(new AddContactCommand());
        commands.add(new DeleteContactCommand());
        commands.add(new SearchCommand());

        commands.add(new HelpCommand());
        commands.add(new ListCommand());
        commands.add(new QuitCommand());
    }

    public ArrayList<Command> getCommands(){
        log.info("Getting commands...");
        return commands;
    }
}
