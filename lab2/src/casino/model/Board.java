package casino.model;


public class Board {
    private Gamer gamer[];
    private double pot;
    private int round;



    public Board(){
        newGame();
    }


    public void newGame()
    {
        gamer = new Gamer[10];
        pot = 0;
        round = 0;
    }

    public void addGamer(Gamer j)
    {
        for(int i = 0; i<gamer.length; i++)
        {
            if(gamer[i] == null)
            {
                gamer[i] = j;
                break;
            }
        }
    }

    public int getRound()
    {
        return round;
    }

    public void raise(double d)
    {
        pot += d;
    }

    public void round()
    {
        for(Gamer g : gamer)
            if(g != null) g.step();
        round++;
        System.out.println("Round: " + round);
    }

}
