package lab5;

//import lab5.aufgabe1.Producer;
import lab5.aufgabe2.Producer;
import lab5.aufgabe3.Fifo;

public class LabFive {

    public static void main(String[] args) {
        //aufgabe12();
        aufgabe3();
    }

    private static void aufgabe3() {
        Fifo fifo = new Fifo();
        for(int i = 0; i<50; i++)fifo.put("\t" + (50-i));
        for(int i = 0; i<50; i++) System.out.println(fifo.get());

    }

    private static void aufgabe12()
    {
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
