
import java.util.*;

/**
 * 
 */
public class Application {


    /**
     * @param args 
     * @return
     */
    public static void main(String[] args) {
        PercentCounter pc = new PercentCounter();
        StdOutLogger stdOutLogger = new StdOutLogger();
        FileLogger fileLogger = new FileLogger("observer.txt");
        pc.register(stdOutLogger);
        pc.register(fileLogger);
        pc.run();
    }


}