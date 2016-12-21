package se.carl.tools;

import se.carl.commands.*;

import java.util.ArrayList;


public class HelpMenu {

    private ArrayList<Command> commands;
    private String menu = "";
    private AllCommands allCommands = new AllCommands();

    public HelpMenu(){
        commands = allCommands.getCommands();
        build();
    }

    private String createHelpEntry(Command command){
        return command.getName() + "\t\t- " + command.getDescription();
    }


    private void build(){
        for (Command c :
                commands) {
            menu += createHelpEntry(c) + "\n";
        }
    }

    public String getMenu(){
        return menu;
    }
}