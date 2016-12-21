package commands;

import console.InputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Luiz Oliveira on 2016-12-21.
 */
public class CommandLine implements InputHandler {

    private String command;
    private List<String> parameters;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public CommandLine(String command, List<String> parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public static CommandLine parse(String inputData){

        String[] temp = inputData.split("\\s+");

        List <String> parameters = Arrays.asList(temp);
        parameters.remove(0);

        return new CommandLine(temp[0], parameters);

    }


    @Override
    public void input(CommandLine commandLine) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String inputData = sc.nextLine();

            //this.inputHandler = CommandLine.parse(inputData);
        }
    }
}
