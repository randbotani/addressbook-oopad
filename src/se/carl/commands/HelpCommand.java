package se.carl.commands;

import se.carl.exceptions.InvalidCommandParameterException;
import se.carl.tools.*;

public class HelpCommand implements Command {

    private ConsolePrinter consolePrinter;

    public HelpCommand(){
    }

    public HelpCommand(ConsolePrinter consolePrinter){
        this.consolePrinter = consolePrinter;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "displays a help menu";
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        HelpMenu helpMenu = new HelpMenu();
        consolePrinter.print(helpMenu.getMenu());
    }
}
