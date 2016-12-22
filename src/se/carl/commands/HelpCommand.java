package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;

import java.util.logging.Logger;

public class HelpCommand implements Command {
    private static final Logger log = Logger.getLogger(HelpCommand.class.getName());

    private ConsolePrinter consolePrinter;

    public HelpCommand(){
        log.info("Creating a command instance...");
    }

    public HelpCommand(ConsolePrinter consolePrinter){
        log.info("Setting a printer...");
        this.consolePrinter = consolePrinter;
    }

    @Override
    public String getName() {
        String info = "help";
        log.info("Getting a command name: " + info);
        return info;
    }

    @Override
    public String getDescription() {
        String info = "Displays a help menu.";
        log.info("Getting a command description: " + info);
        return info;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        log.info("Creating a Help Menu...");
        HelpMenu helpMenu = new HelpMenu();
        consolePrinter.print(helpMenu.getMenu());
    }
}
