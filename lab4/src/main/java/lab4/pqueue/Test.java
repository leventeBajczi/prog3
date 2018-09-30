package lab4.pqueue;

public class Test {
    public static void main(String[] args) {
        System.out.println("Creating new PQueue<String>...");
        PQueue<String> pQueue = new PQueue<>();
        try {
            System.out.println("Trying to top from an empty queue...");
            System.out.println(pQueue.top());
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
        System.out.println("Pushing \"Hello PQueue\" onto the queue...");
        pQueue.push("Hello PQueue!");
        try {
            System.out.println("Calling top: " + pQueue.top() + "; size after: " + pQueue.size());
            System.out.println("Calling pop: " + pQueue.pop() + "; size after: " + pQueue.size());
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
        System.out.println("Pushing three Strings onto the queue...");
        pQueue.push("String1");
        pQueue.push("String2");
        pQueue.push("String3");
        System.out.println("Size after: " + pQueue.size());
        System.out.println("Listing them all out via a for loop...");
        for(String s : pQueue)
            System.out.println("\t" + s);

        System.out.println("Clearing the queue...");
        pQueue.clear();
        System.out.println("Size after: " + pQueue.size());
    }
}
