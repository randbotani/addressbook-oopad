package commands;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Luiz Oliveira on 2016-12-21.
 */
public class CommandLine {

    private String command;
    private List<String> parameters;

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
}
