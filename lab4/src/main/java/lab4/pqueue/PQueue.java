package lab4.pqueue;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class PQueue<T extends Comparable> implements Iterable<T> {
    List<T> list;
    public PQueue()
    {
        list = new ArrayList<>();
    }
    public void push(T t)
    {
        list.add(0, t);
    }
    public T pop() throws EmptyQueueException
    {
        if(size() == 0)
            throw new EmptyQueueException();
        T t = list.get(0);
        list.remove(0);
        return t;
    }
    public T top() throws EmptyQueueException
    {
        if(size() == 0)
            throw new EmptyQueueException();
        return list.get(0);
    }
    public int size()
    {
        return list.size();
    }
    public void clear()
    {
        list = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

}
