package s0lver.katas.CmdLineArgs.version2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome, loading...");

        CmdLineArgs app = new CmdLineArgs(args);

        app.processArguments();
    }
}
