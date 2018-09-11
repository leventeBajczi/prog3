package casino.model.gamer;

import casino.model.Board;
import casino.model.Gamer;

public class Beginner extends Gamer {

    public Beginner(Board board)
    {
        super(board);
    }

    public void step()
    {
        System.out.println(toString() + ", Runde: " + board.getRound());
    }

    public String toString()
    {
        return getClass().getSimpleName() + uuid;
    }
}
