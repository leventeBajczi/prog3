
import java.util.*;

/**
 * 
 */
public class PercentCounter extends Observable {

    /**
     * Default constructor
     */
    public PercentCounter() {
    }

    /**
     * 
     */
    private int percent;

    /**
     * @return
     */
    public void run() {
        percent = 0;
        while(percent++<100)
        {
            if(percent%10 == 0)reportToObservers();
        }
    }

    @Override
    public String toString() {
        return percent + "%";
    }
}