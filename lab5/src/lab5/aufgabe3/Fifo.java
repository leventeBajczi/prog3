package lab5.aufgabe3;

import sun.awt.Mutex;

import java.util.ArrayList;

public class Fifo {
    private final Mutex mutex;
    private static final int MAX_SIZE = 10;
    private final ArrayList<String> als;

    public Fifo()
    {
        mutex = new Mutex();
        als = new ArrayList<>();
    }

    public void put(String msg)
    {
        Putter putter = new Putter(msg);
        putter.start();
    }

    public String get()
    {
        while(als.size() == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mutex.lock();
        String readString = als.get(als.size()-1);
        als.remove(als.size()-1);
        mutex.unlock();
        return readString;
    }

    private class Putter extends Thread
    {
        private final String toPut;
        public Putter(String msg)
        {
            toPut = msg;
        }
        public void run() {
            while(als.size() == MAX_SIZE) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mutex.lock();
            als.add(0, toPut);
            mutex.unlock();
        }
    }

}
