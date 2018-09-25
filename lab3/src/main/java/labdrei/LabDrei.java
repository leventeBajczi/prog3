package labdrei;

import java.io.IOException;
import java.util.Scanner;

public class LabDrei {

    public static void main(String[] args) {
        MyCommandHandler commandHandler = new MyCommandHandler(args);
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            try {
                commandHandler.execute();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NotEnoughParamsException e) {
                e.printStackTrace();
            }
            commandHandler.setArgs(scanner.nextLine().split(" "));
        }

    }
}
