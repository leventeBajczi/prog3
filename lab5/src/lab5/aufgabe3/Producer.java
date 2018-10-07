package lab5.aufgabe3;

public class Producer extends Thread {

    private int cnt;
    private final String msg;
    private final Fifo fifo;

    public Producer(String msg, Fifo fifo)
    {
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
