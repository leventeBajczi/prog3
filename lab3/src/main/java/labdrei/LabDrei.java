package labdrei;

import java.io.IOException;
import java.util.Scanner;

public class LabDrei {

    public static void main(String[] args) {
        //task1(args);
        task2(args);
    }

    private static void task2(String[] args)
    {
        String line = "";
        Scanner scanner;
        if(args.length >= 1)
        {
            scanner = new Scanner(System.in);
            while((line = scanner.nextLine()) != null)
            {
                if(line.matches(args[0]))
                    System.out.println(line);
            }
        }
    }

    private static void task1(String[] args)
    {
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
