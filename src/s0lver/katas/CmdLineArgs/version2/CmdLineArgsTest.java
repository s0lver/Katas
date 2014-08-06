package s0lver.katas.CmdLineArgs.version2;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;

public class CmdLineArgsTest extends TestCase {

    private static final String[] ARGUMENTS = new String[]{"-e", "23", "-c", "Comentario", "-al"};

    @Test
    public void testProcessArguments() throws Exception {
        CmdLineArgs parser = new CmdLineArgs(ARGUMENTS);
        assertNotNull("Attribute commandLineArguments is null", parser.getCommandLineArguments());
        assertNotNull("Attribute parsedArguments is null", parser.getParsedArguments());
    }

    @Test
    public void testParseArguments() throws Exception {
        CmdLineArgs parser = new CmdLineArgs(ARGUMENTS);

        parser.parseArguments();

        HashMap<String, String> parsedArguments = parser.getParsedArguments();

        assertEquals("Invalid value for -e", "23", parsedArguments.get("e"));
        assertEquals("Invalid value for -c", "Comentario", parsedArguments.get("c"));

        assertEquals("Invalid value for -a", null, parsedArguments.get("a"));
        assertEquals("Invalid value for -l", null, parsedArguments.get("l"));
    }

    // @Test
    public void testPrintParsedArguments() throws Exception {

    }
}