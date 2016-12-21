package console;

import commands.CommandLine;

import java.util.Scanner;

/**
 * Created by Luiz Oliveira on 2016-12-21.
 */
public class Console implements ConsolePrinter {

    private InputHandler inputHandler;
    private Console console;


    public void registerInputHandler(InputHandler handler){


            }

    @Override
    public void print(String output) {
        System.out.println(output);

    }
}
