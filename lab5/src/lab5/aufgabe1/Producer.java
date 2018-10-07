package lab5.aufgabe1;

import lab5.aufgabe3.Fifo;

public class Producer {

    private int cnt;
    private final String msg;

    public Producer(String msg, Fifo fifo, Integer sl)
    {
        this.msg = msg;
        cnt = 0;
    }

    public void start(){
        for(;;)
        {
            System.out.println(msg + "\t" + cnt++ + "\t" + System.currentTimeMillis() % 100000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
