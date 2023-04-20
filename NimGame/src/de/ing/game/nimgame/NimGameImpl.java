package de.ing.game.nimgame;

import de.ing.game.AbstractGame;
import de.ing.game.Game;
import de.ing.game.player.Player;
import de.ing.io.Writer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NimGameImpl extends AbstractGame<Integer,Integer> {

    public NimGameImpl(final Writer writer) {
        super(writer);
        setBoard(23);

    }
//---------------------------------------------------------------
    protected void updateBoard() {
        setBoard(getBoard()-getMove());
    }


    protected boolean isGameover() {
        return getBoard() < 1 || getPlayers().isEmpty();
    }

    protected boolean isValid() {
        return getMove() >= 1 && getMove() <= 3;
    }


}
