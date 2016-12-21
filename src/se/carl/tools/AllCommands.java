package se.carl.tools;

import se.carl.commands.*;

import java.util.ArrayList;

class AllCommands {

    private ArrayList<Command> commands = new ArrayList<>();

    public AllCommands(){
        commands.add(new AddContactCommand());
        commands.add(new DeleteContactCommand());
        commands.add(new SearchCommand());

        commands.add(new HelpCommand());
        commands.add(new ListCommand());
        commands.add(new QuitCommand());
    }

    public ArrayList<Command> getCommands(){
        return commands;
    }
}
