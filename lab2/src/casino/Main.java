package casino;

import casino.exception.GamerNotFound;
import casino.model.Board;
import casino.model.gamer.Beginner;
import casino.model.gamer.Robot;

public class Main {

    public static void main(String [] args)
    {
        Beginner beginner = new Beginner(null);
        beginner = null;
        System.gc();
    }
}
