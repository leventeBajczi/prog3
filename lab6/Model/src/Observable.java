
import java.util.*;

/**
 * 
 */
public class Observable {


    private ArrayList<Observer> alo;

    /**
     * Default constructor
     */
    public Observable() {
        alo = new ArrayList<>();
    }


    /**
     * @param observer 
     * @return
     */
    public void register(Observer observer) {
        alo.add(observer);
    }

    /**
     * @param observer 
     * @return
     */
    public void unregister(Observer observer) {
        alo.remove(observer);
    }

    /**
     * @return
     */
    public void reportToObservers() {
        alo.forEach(observer -> observer.report(this));
    }

}