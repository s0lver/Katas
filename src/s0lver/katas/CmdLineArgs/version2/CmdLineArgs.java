package s0lver.katas.CmdLineArgs.version2;

import java.util.HashMap;
import java.util.Set;

public class CmdLineArgs {
    public static void main(String[] args) {
        System.out.println("Welcome, loading...");

        CmdLineArgs app = new CmdLineArgs();

        app.processArguments(args);
    }

    public void processArguments(String[] args) {
        HashMap<String, String> parsedArguments = new HashMap<>();
        String currentParameter = null;

        for (String argument : args) {
            if (argument.charAt(0) == '-') {
                // New parameter name
                // iterate for the whole list, e.g. "-asd" should add a, s, and d
                for (int i = 1; i < argument.length(); i++) {
                    currentParameter = argument.charAt(i) + "";
                    if (parsedArguments.containsKey(currentParameter)) {
                        throw new RuntimeException(String.format("Can not add an existing key (%s)", currentParameter));
                    }
                    parsedArguments.put(currentParameter, null);
                }

            } else {
                String existingValue = parsedArguments.get(currentParameter);
                if (existingValue != null) {
                    throw new RuntimeException(String.format("There is already a value %s for parameter %s", existingValue, currentParameter));
                }
                // Set the value of the parameter
                parsedArguments.put(currentParameter, argument);
            }
        }

        printParsedParameters(parsedArguments);
    }

    public void printParsedParameters(HashMap<String, String> parsedParameters) {
        Set<String> keys = parsedParameters.keySet();

        for (String llave : keys) {
            String value = parsedParameters.get(llave);
            System.out.printf("[%s] \t= %s\n", llave, value);
        }
    }
}
