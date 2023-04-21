package de.ing.generator.impl;

import de.ing.generator.Generator;
import de.ing.generator.GeneratorBuilder;

public class RandomNumberGeneratorBuilder implements GeneratorBuilder {
    @Override
    public Generator create() {
        return new RandomNumberGenerator();
    }
}
