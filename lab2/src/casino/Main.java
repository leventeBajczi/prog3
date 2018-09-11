package casino;

import casino.exception.GamerNotFound;
import casino.model.Board;
import casino.model.gamer.Beginner;
import casino.model.gamer.Robot;

public class Main {

    public static void main(String [] args)
    {
        Board board = new Board();
        try
        {
            board.round();
        }
        catch (GamerNotFound e)
        {
            e.printStackTrace();
        }
    }
}
