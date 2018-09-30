package lab4.model;

public class Bier {
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
}
