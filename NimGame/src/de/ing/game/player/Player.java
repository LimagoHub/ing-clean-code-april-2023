package de.ing.game.player;

public interface Player<BOARD , MOVE> {

    String getName();
    MOVE doMove(final BOARD board);
}
