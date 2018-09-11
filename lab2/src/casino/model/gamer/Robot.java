package casino.model.gamer;

import casino.model.Board;
import casino.model.Gamer;

public class Robot extends Gamer {

    public Robot(Board board)
    {
        super(board);
    }

    public void step()
    {
        System.out.println(toString() + ", Runde: " + board.getRound());
    }

    public String toString()
    {
        return getClass().getSimpleName();
    }
}
