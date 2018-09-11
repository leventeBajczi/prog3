package casino.model;

public abstract class Gamer {

    protected Board board;

    private static int uuid_counter = 0;

    protected int uuid;

    public Gamer(Board board)
    {
        setBoard(board);
        uuid = uuid_counter++;
    }

    public abstract void step();

    private void setBoard(Board a)
    {
        board = a;
    }

    public abstract String toString();

    public void finalize()
    {
        System.out.println(uuid + ": " + toString());
    }
}
