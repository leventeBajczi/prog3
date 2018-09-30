package lab4.model;

import java.util.Comparator;

public class Bier{
    private final String name;
    private final String type;
    private final double strength;

    public Bier(String name, String type, double strength) {
        this.name = name;
        this.type = type;
        this.strength = strength;
    }

    public void print()
    {
        System.out.println(name + " " + type + " " + strength);
    }
    public static class BierNameComparator implements Comparator<Bier>
    {

        @Override
        public int compare(Bier o1, Bier o2) {
            return o1.name.compareTo(o2.name);
        }
    }
    public static class BierTypeComparator implements Comparator<Bier>
    {

        @Override
        public int compare(Bier o1, Bier o2) {
            return o1.type.compareTo(o2.type);
        }
    }
    public static class BierStrengthComparator implements Comparator<Bier>
    {

        @Override
        public int compare(Bier o1, Bier o2) {
            return Double.compare(o1.strength, o2.strength);
        }
    }
}

