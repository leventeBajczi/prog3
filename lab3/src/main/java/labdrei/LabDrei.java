package labdrei;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class LabDrei {

    public static void main(String[] args) {
        //task1(args);
        //task2(args);
        //task3(args);
    }

    private static void task3(String[] args)
    {
        boolean gin = false;
        boolean gout = false;
        String input = null;
        String output = null;
        String pattern = "";
        for (int i = 0; i < args.length; i++) {
            if ((i+1 < args.length) && args[i].equals("-i")) {
                i++;
                input = args[i];
            } else if ((i+1 < args.length) && args[i].equals("-o")) {
                i++;
                output = args[i];
            } else if ((i+1 < args.length) && args[i].equals("-p")) {
                i++;
                pattern = args[i];
            } else if ((i+1 < args.length) && args[i].equals("-gi")) {
                i++;
                gin = true;
                input = args[i];
            } else if ((i+1 < args.length) && args[i].equals("-go")) {
                i++;
                gout = true;
                output = args[i];
            }
        }
        if(args.length >= 6)
        {
            String line;
            InputStream inputStream;
            OutputStream outputStream;

            try {
                outputStream = gout? new GZIPOutputStream(new FileOutputStream(output)) : new FileOutputStream(output);
                inputStream = gin ? new GZIPInputStream(new FileInputStream(input)) : new FileInputStream(input);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                while((line = bufferedReader.readLine()) != null)
                {
                    if(line.matches(pattern))
                        bufferedWriter.write(line);
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedReader.close();
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static void task2(String[] args)
    {
        String line;
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
