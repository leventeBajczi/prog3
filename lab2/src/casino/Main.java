package casino;

import casino.model.Board;
import casino.model.gamer.Beginner;
import casino.model.gamer.Robot;

public class Main {

    public static void main(String [] args)
    {
        Board board = new Board();
        for(int i = 0; i<1;i++)
            board.addGamer(new Beginner(board));
        for(int i = 0; i<2;i++)
            board.addGamer(new Robot(board));
        for(int i = 0; i<3; i++)
            board.round();
    }
}
