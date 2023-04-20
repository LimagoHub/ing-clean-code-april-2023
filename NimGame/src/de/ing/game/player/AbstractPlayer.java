package de.ing.game.player;



public abstract class AbstractPlayer<BOARD,MOVE> implements Player<BOARD,MOVE> {

    private String name = getClass().getSimpleName();

    public AbstractPlayer() {
    }

    public AbstractPlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
