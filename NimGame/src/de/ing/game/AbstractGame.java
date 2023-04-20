package de.ing.game;

import de.ing.game.player.Player;
import de.ing.io.Writer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGame<BOARD, MOVE> implements Game{


    private final Writer writer;
    private BOARD board;
    private MOVE move;
    private List<Player<BOARD,MOVE>> players = new ArrayList<>();
    private Player<BOARD,MOVE> currentPlayer;

    public AbstractGame(final Writer writer) {
        this.writer = writer;
    }


    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(final BOARD board) {
        this.board = board;
    }

    protected MOVE getMove() {
        return move;
    }

    protected void setMove(final MOVE move) {
        this.move = move;
    }



    protected final List<Player<BOARD,MOVE>> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    protected final Player<BOARD,MOVE> getCurrentPlayer() {
        return currentPlayer;
    }

    protected void setCurrentPlayer(final Player<BOARD,MOVE> currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public final void addPlayer(Player<BOARD,MOVE>player) {
        players.add(player);
    }

    public final void removePlayer(Player<BOARD,MOVE> player) {
        players.remove(player);
    }


    @Override
    public final void play() {
        while(! isGameover()) playSingleRound();

    }

    private void playSingleRound() {

        for(var player : players) setActivePlayerAndIntitiateHisMove(player);

    }
    private void setActivePlayerAndIntitiateHisMove(final Player<BOARD,MOVE> player) {
        setCurrentPlayer(player);
        playSingleMove();
    }
    private void playSingleMove() {
        if(isGameover()) return;
        executeMoveAndRepeatUntilValid();
        terminateMove();
    }


    private void executeMoveAndRepeatUntilValid() {
        do move = getCurrentPlayer().doMove(board); while(turnIsInvalid());
    }

    private void terminateMove( ) {// Integration
        updateBoard();
        printGameOverMessageIfGameIsOver();
    }

    private boolean turnIsInvalid() {
        if(isValid()) return false;
        writer.write("Ungueltiger Zug");
        return true;
    }

    private void printGameOverMessageIfGameIsOver() {
        if(isGameover()) writer.write(getCurrentPlayer().getName() + " hat verloren");

    }

    protected void write(String message) {
        writer.write(message);
    }

    // -------------------------
    protected abstract boolean isGameover();
    protected abstract boolean isValid();

    protected abstract void updateBoard();
}
