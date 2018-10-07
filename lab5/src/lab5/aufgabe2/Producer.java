package lab5.aufgabe2;

public class Producer extends Thread {

    private int cnt;
    private final String msg;

    public Producer(String msg)
    {
        this.msg = msg;
        cnt = 0;
    }

    public void run() {
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