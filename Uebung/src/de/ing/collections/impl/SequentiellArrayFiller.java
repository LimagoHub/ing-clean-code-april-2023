package de.ing.collections.impl;

import de.ing.collections.ArrayFiller;
import de.ing.generator.Generator;

public class SequentiellArrayFiller implements ArrayFiller {

    private final Generator generator;

    public SequentiellArrayFiller(final Generator generator) {
        this.generator = generator;
    }

    @Override
    public int[] fill(final int[] arrayToFill) {

        for(int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = generator.next();
        }
        return arrayToFill;
    }
}
