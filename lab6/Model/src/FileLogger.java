
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 */
public class FileLogger implements Observer {

private BufferedWriter bufferedWriter;
    /**
     * @param fileName
     */
    public FileLogger(String fileName) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param observable 
     * @return
     */
    public void report(Observable observable) {
        try {
            bufferedWriter.append(observable.toString() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}