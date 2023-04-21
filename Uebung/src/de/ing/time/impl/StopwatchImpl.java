package de.ing.time.impl;

import de.ing.time.Stopwatch;

import java.time.Duration;
import java.time.Instant;

public class StopwatchImpl implements Stopwatch {

    private Instant start;
    private Instant end;
    @Override
    public void start() {
        start = Instant.now();
    }

    @Override
    public void stop() {
        end = Instant.now();
    }

    @Override
    public long getMillis() {
        var duration = Duration.between(start, end);
        return duration.toMillis();
    }
}
