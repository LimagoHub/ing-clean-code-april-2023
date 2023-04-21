package de.ing.collections.impl;

import de.ing.collections.ArrayFiller;
import de.ing.generator.Generator;
import de.ing.generator.GeneratorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelArrayFiller implements ArrayFiller {
    private final int runningThreads;
    private int[] data = new int[1];
    private final GeneratorBuilder generatorBuilder;

    private ExecutorService service;


    public ParallelArrayFiller(final GeneratorBuilder generatorBuilder, final int runningThreads) {
        this.generatorBuilder = generatorBuilder;
        this.runningThreads = runningThreads;
    }

    @Override
    public int[] fill(final int[] arrayToFill) {
        try {
            return fillImpl(arrayToFill);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private int[] fillImpl(final int[] arrayToFill) throws InterruptedException {
        this.data = arrayToFill;

        startThreadPoolForArrayFilling();


        return arrayToFill;
    }

    private void startThreadPoolForArrayFilling() throws InterruptedException {
        service = Executors.newFixedThreadPool(runningThreads);
        startAllWorkers();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startAllWorkers() {
        for (int actThread = 0; actThread < runningThreads; actThread++) {
            startSingleWorkerForSegment(actThread);
        }
    }

    private void startSingleWorkerForSegment(final int actThread) {
        final int segmentsize = data.length / runningThreads;
        final int start = actThread * segmentsize;
        final int end = start + segmentsize;
        service.execute(new FillArraySegmentWorker(start,end));
    }

    class FillArraySegmentWorker implements Runnable {

        private final int start;
        private final int ende;
        private final Generator generator = generatorBuilder.create();

        public FillArraySegmentWorker(final int start, final int ende) {
            this.start = start;
            this.ende = ende;
        }

        @Override
        public void run() {
            for(int i = start; i < ende; i ++) {
                data[i] = generator.next();
            }
        }
    }
}
