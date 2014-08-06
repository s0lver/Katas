package s0lver.katas.CmdLineArgs.version2;

import java.util.HashMap;
import java.util.Set;

public class CmdLineArgs {

    private String[] commandLineArguments;
    private HashMap<String, String> parsedArguments;

    public CmdLineArgs(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
        this.parsedArguments = new HashMap<>();
    }

    public void processArguments() {
        parseArguments();
        printParsedArguments();
    }

    public void parseArguments() {
        String currentParameter = null;

        for (String argument : commandLineArguments) {
            if (isArgumentName(argument)) {
                for (int i = 1; i < argument.length(); i++) {
                    currentParameter = Character.toString(argument.charAt(i));
                    if (parsedArguments.containsKey(currentParameter)) {
                        throw new RuntimeException(String.format("There is already an existing key %s", currentParameter));
                    }
                    parsedArguments.put(currentParameter, null);
                }
            } else {
                String existingValue = parsedArguments.get(currentParameter);
                if (existingValue != null) {
                    throw new RuntimeException(String.format("There is already a value %s for parameter %s", existingValue, currentParameter));
                }
                parsedArguments.put(currentParameter, argument);
            }
        }
    }

    public void printParsedArguments() {
        Set<String> keys = parsedArguments.keySet();

        for (String currentKey : keys) {
            String value = parsedArguments.get(currentKey);
            System.out.printf("[%s] \t= %s\n", currentKey, value);
        }
    }

    private boolean isArgumentName(String argument) {
        return argument.charAt(0) == '-';
    }

    public String[] getCommandLineArguments() {
        return commandLineArguments;
    }

    public HashMap<String, String> getParsedArguments() {
        return parsedArguments;
    }
}
