package casino.model;

public abstract class Gamer {

    protected Board board;

    public Gamer(Board board)
    {
        setBoard(board);
    }

    public abstract void step();

    public void setBoard(Board a)
    {
        board = a;
    }

}
