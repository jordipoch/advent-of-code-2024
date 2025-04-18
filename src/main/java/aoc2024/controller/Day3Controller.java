package aoc2024.controller;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day3.CorruptedMemoryFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day3Controller {
    private final CorruptedMemoryFactory corruptedMemoryFactory;
    private final InputDataLoader inputDataLoader;

    @Inject
    public Day3Controller(InputDataLoaderFactory dataLoaderFactory, CorruptedMemoryFactory corruptedMemoryFactory) {
        this.corruptedMemoryFactory = corruptedMemoryFactory;
        inputDataLoader = dataLoaderFactory.createFromFile(3);
    }

    public long getPart1Result() {
        var corruptedMemory = corruptedMemoryFactory.create(inputDataLoader.loadData(), false);
        return corruptedMemory.calculateSumOfAllMultiplications();
    }

    public long getPart2Result() {
        var corruptedMemory = corruptedMemoryFactory.create(inputDataLoader.loadData(), true);
        return corruptedMemory.calculateSumOfAllMultiplications();
    }
}
