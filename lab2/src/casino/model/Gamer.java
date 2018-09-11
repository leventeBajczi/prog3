package casino.model;

public class Gamer {

    protected Board board;

    public Gamer(Board board)
    {
        setBoard(board);
    }

    public void step(){}

    public void setBoard(Board a)
    {
        board = a;
    }

}
