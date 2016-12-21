package se.carl.tools;

import java.util.Scanner;

public class Console implements ConsolePrinter {

    private String userInput;
    private InputHandler handler;
    private Scanner scanner = new Scanner(System.in);

    void registerInputHandler(InputHandler handler){
        this.handler = handler;
    }

    void run(){

        while(true) {
            userInput = scanner.nextLine();
            if(userInput!= null){
                handler.handle(new CommandLine(userInput));
            }
        }
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }
}