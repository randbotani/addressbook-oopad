package se.carl.commands;

import se.carl.exceptions.*;

public interface Command {

    String getName();
    String getDescription();
    void execute() throws InvalidCommandParameterException;

}

