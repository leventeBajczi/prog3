package lab5.aufgabe1;

public class Producer {

    private int cnt;
    private final String msg;

    public Producer(String msg)
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
