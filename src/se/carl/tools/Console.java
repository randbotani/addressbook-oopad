package se.carl.tools;

import java.util.Scanner;
import java.util.logging.Logger;

public class Console implements ConsolePrinter {
    private static final Logger log = Logger.getLogger(Console.class.getName());


    private String userInput;
    private InputHandler handler;
    private Scanner scanner = new Scanner(System.in);

    void registerInputHandler(InputHandler handler){
        log.info("Setting Register Input Handler...");
        this.handler = handler;
    }

    void run(){
        log.info("Running Scanner (Waiting and handling user's inputs): ");
        while(true) {
            userInput = scanner.nextLine();
            if(userInput!= null){
                handler.handle(new CommandLine(userInput));
            }
        }
    }

    @Override
    public void print(String string) {
        log.info("Printing: ");
        System.out.println(string);
    }
}