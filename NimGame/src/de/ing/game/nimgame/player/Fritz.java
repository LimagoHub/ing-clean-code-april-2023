package de.ing.game.nimgame.player;

import java.util.Scanner;

public class Fritz extends AbstractNimGamePlayer{
    private final Scanner scanner = new Scanner(System.in);
    public Fritz() {
    }

    public Fritz(final String name) {
        super(name);
    }

    @Override
    public Integer doMove(final Integer stones) {
        System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1, 2 oder 3", stones));
        return scanner.nextInt();
    }
}
