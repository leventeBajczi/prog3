package casino;

import casino.model.Board;
import casino.model.Gamer;

public class Main {

    public static void main(String [] args)
    {
        Board board = new Board();
        for(int i = 0; i<3;i++)
            board.addGamer(new Gamer(board));
        for(int i = 0; i<3; i++)
            board.round();
    }
}
