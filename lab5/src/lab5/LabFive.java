package lab5;

import lab5.aufgabe1.Producer;

public class LabFive {

    public static void main(String[] args) {
        Producer p = new Producer("demo");
        try{
            p.go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
