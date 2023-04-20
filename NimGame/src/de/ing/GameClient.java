package de.ing;

import de.ing.game.Game;

public class GameClient {

    private final Game game;

    public GameClient(final Game game) {
        this.game = game;
    }

    public void go() {
        game.play();
    }
}
