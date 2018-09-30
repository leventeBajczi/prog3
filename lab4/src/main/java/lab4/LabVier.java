package lab4;

import lab4.model.Bier;

import java.util.ArrayList;
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
