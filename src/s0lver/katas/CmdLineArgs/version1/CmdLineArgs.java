package s0lver.katas.CmdLineArgs.version1;

import java.util.HashMap;
import java.util.Set;

public class CmdLineArgs {

    public static void main(String[] args) {
        CmdLineArgs app = new CmdLineArgs();

        System.out.println("Welcome to the katas");

        HashMap<String, String> parsedArgs = app.ParseParameters(args);

        System.out.println("These are the arguments");
        String strParsedArgs = app.TransformHashMapToString(parsedArgs);
        System.out.println(strParsedArgs);

    }

    public String TransformHashMapToString(HashMap<String, String> hashmap) {
        StringBuilder strBuilder = new StringBuilder();

        Set<String> keys = hashmap.keySet();
        for (String key : keys) {
            strBuilder.append(key).append("\t").append(" = ")
                    .append(hashmap.get(key));
            strBuilder.append(System.lineSeparator());
        }

        return strBuilder.toString();
    }

    public HashMap<String, String> ParseParameters(String[] cmdArguments) {
        HashMap<String, String> parsed = new HashMap<>();
        String currentParameter = null;
        for (String currentItem : cmdArguments) {
            // it is a parameter name
            if (currentItem.charAt(0) == '-') {
                for (int i = 1; i < currentItem.length(); i++) {
                    String parameterNameString = currentItem.charAt(i) + "";
                    // Add if not exists
                    if (!parsed.keySet().contains(parameterNameString)) {
                        parsed.put(parameterNameString, null);
                        currentParameter = parameterNameString;
                    }
                }

            }
            // it is a parameter value
            else {
                // Put the value in the proper parameter
                parsed.put(currentParameter, currentItem);
            }
        }

        return parsed;
    }
}
