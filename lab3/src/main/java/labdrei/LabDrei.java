package labdrei;

public class LabDrei {

    public static void main(String[] args) {
        MyCommandHandler commandHandler = new MyCommandHandler(args);
        commandHandler.execute();
    }
}
