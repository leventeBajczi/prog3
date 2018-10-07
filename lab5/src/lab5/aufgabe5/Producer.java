package lab5.aufgabe5;

import lab5.aufgabe3.Fifo;

public class Producer extends Thread {

    private int cnt;
    private final String msg;
    private final Fifo fifo;
    private final Integer sl;

    public Producer(String msg, Fifo fifo, Integer sl)
    {
        this.sl = sl;
        this.fifo = fifo;
        this.msg = msg;
        cnt = 0;
    }

    public void run() {
        for(;;)
        {
            fifo.put(msg + "\t" + cnt);
            System.out.println("produced " + msg + "\t" + cnt++ + "\t" + System.currentTimeMillis() % 100000);
            try {
                Thread.sleep(sl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
