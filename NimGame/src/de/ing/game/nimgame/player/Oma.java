package de.ing.game.nimgame.player;

import java.util.Random;

public class Oma extends AbstractNimGamePlayer{

    private final Random random = new Random();
    public Oma() {
    }

    public Oma(final String name) {
        super(name);
    }

    @Override
    public Integer doMove(final Integer integer) {
        int move = random.nextInt(5) + 1;
        System.out.printf("Oma nimmt %s Steine.\n", move);
        return move;
    }
}
