package lab5.aufgabe1;

public class Producer {

    private int cnt;
    private final String msg;

    public Producer(String msg)
    {
        this.msg = msg;
        cnt = 0;
    }

    public void go() throws InterruptedException {
        for(;;)
        {
            System.out.println(msg + "\t" + cnt++ + "\t" + System.currentTimeMillis() % 100000);
            Thread.sleep(1000);
        }

    }
}
