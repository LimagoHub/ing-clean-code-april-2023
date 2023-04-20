package de.ing.game.nimgame.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private static final int MOVES[] = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doMove(final Integer stones) {
        int move = MOVES[stones%4];
        System.out.println(String.format(getName() + " nimmt %s Steine.", move));
        return move;
    }
}
