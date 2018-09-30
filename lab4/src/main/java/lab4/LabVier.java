package lab4;

import lab4.model.Bier;
import lab4.pqueue.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LabVier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] tokens;
        List<Bier> beers = new ArrayList<>();
        while((line = scanner.nextLine()) != null)
        {
            tokens = line.split(" ");
            switch (tokens[0])
            {
                case "add":
                    if(tokens.length < 4)
                        System.out.println("Not enough parameters!");
                    else
                        beers.add(new Bier(tokens[1], tokens[2], Double.parseDouble(tokens[3])));
                    break;
                case "list":
                    if(tokens.length > 1)
                        switch(tokens[1])
                        {
                            case "name":
                                beers.sort(new Bier.BierNameComparator());
                                break;
                            case "type":
                                beers.sort(new Bier.BierTypeComparator());
                                break;
                            case "strength":
                                beers.sort(new Bier.BierStrengthComparator());
                                break;
                        }
                    beers.forEach(Bier::print);
                    break;
                case "save":
                    if(tokens.length < 2)
                        System.out.println("Please give the name for the file.");
                    else {
                        try {
                            FileWriter fileWriter = new FileWriter(new File(tokens[1]));
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            for (Bier bier : beers) {
                                bufferedWriter.write(bier.toString() + "\n");
                            }
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            fileWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "load":
                    if(tokens.length < 2)
                        System.out.println("Please give the name for the file.");
                    else {
                        try {
                            FileReader fileReader = new FileReader(new File(tokens[1]));
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            String fileLine;
                            while((fileLine = bufferedReader.readLine()) != null)
                            {
                                tokens = fileLine.split(" ");
                                if(tokens.length < 3)
                                    System.out.println("Not enough parameters!");
                                else
                                    beers.add(new Bier(tokens[0], tokens[1], Double.parseDouble(tokens[2])));
                            }
                            bufferedReader.close();
                            fileReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case "delete":
                    if(tokens.length < 2)
                        System.out.println("Please specify what I should delete");
                    else {
                        beers.sort(new Bier.BierNameComparator());
                        beers.remove(Collections.binarySearch(beers, new Bier(tokens[1], "", 0.0), new Bier.BierNameComparator()));
                    }
                    break;
                case "test":
                    Test.main(null);
                    break;
                case "q":
                case "Q":
                case "quit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong instruction");
            }
        }
    }
}
