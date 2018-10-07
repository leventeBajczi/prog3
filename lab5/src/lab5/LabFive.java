package lab5;

//import lab5.aufgabe1.Producer;
//import lab5.aufgabe2.Producer;
import lab5.aufgabe3.Producer;
import lab5.aufgabe3.Fifo;
import lab5.aufgabe4.Consumer;

public class LabFive {

    public static void main(String[] args) {
        aufgabe3();
        aufgabe();
    }

    private static void aufgabe3() {
        Fifo fifo = new Fifo();
        for(int i = 0; i<30; i++)fifo.put("\t" + (30-i));
        for(int i = 0; i<30; i++) System.out.println(fifo.get());

    }

    private static void aufgabe()
    {
        Fifo fifo = new Fifo();
        Consumer consumer = new Consumer(fifo, "", 500);
        consumer.start();
        Producer p = new Producer("demo", fifo);
        p.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p = new Producer("demo2", fifo);
        p.start();
    }
}
