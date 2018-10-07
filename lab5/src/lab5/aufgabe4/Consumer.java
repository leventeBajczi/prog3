package lab5.aufgabe4;

import lab5.aufgabe3.Fifo;

public class Consumer extends Thread {
    private final Fifo fifo;
    private final String str;
    private final Integer sl;
    public Consumer(Fifo fifo, String str, Integer sl){
        this.fifo = fifo;
        this.str = str;
        this.sl = sl;
    }

    public void run() {
        for(;;)
        {
            System.out.println("consumed " + str + " " + fifo.get() + " " + System.currentTimeMillis() % 100000);
            try {
                Thread.sleep(sl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
