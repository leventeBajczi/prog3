package lab5;

//import lab5.aufgabe1.Producer;
import lab5.aufgabe2.Producer;

public class LabFive {

    public static void main(String[] args) {
        Producer p = new Producer("demo");
        p.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p = new Producer("demo2");
        p.start();
    }
}
