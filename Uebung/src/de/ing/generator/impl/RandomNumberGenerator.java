package de.ing.generator.impl;

import de.ing.generator.Generator;

import java.util.Random;

public class RandomNumberGenerator implements Generator {

    private final Random random = new Random();
    @Override
    public int next() {
        return random.nextInt();
    }
}
