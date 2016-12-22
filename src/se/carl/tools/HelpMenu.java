package se.carl.tools;

import se.carl.commands.*;

import java.util.ArrayList;
import java.util.logging.Logger;


public class HelpMenu {
    private static final Logger log = Logger.getLogger(HelpMenu.class.getName());


    private ArrayList<Command> commands;
    private String menu = "";
    private AllCommands allCommands = new AllCommands();

    public HelpMenu(){
        log.info("Initializing a Help Menu ...");

        commands = allCommands.getCommands();
        build();
    }

    private String formattingHelpMenu(Command command){
        log.info("Formatting the Help Menu...");
        return command.getName() + "\t\t- " + command.getDescription();
    }


    private void build(){
        log.info("Building a Help Menu...");
        for (Command c : commands) {
            menu += formattingHelpMenu(c) + "\n";
        }
    }

    public String getMenu(){
        log.info("Getting the Help Menu...");
        return menu;
    }
}