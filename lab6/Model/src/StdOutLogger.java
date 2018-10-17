
import java.util.*;

/**
 * 
 */
public class StdOutLogger implements Observer {

    /**
     * Default constructor
     */
    public StdOutLogger() {
    }

    /**
     * @param observable 
     * @return
     */
    public void report(Observable observable) {
        System.out.println(observable.toString());

    }



}