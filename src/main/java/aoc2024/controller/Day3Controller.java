package aoc2024.controller;

import aoc2024.controller.input.annotation.Day3;
import aoc2024.model.day3.CorruptedMemory;
import aoc2024.model.day3.CorruptedMemoryFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day3Controller {
    private final CorruptedMemoryFactory corruptedMemoryFactory;
    private final Supplier<List<String>> inputData;

    @Inject
    public Day3Controller(CorruptedMemoryFactory corruptedMemoryFactory, @Day3 Supplier<List<String>> inputData) {
        this.corruptedMemoryFactory = corruptedMemoryFactory;
        this.inputData = inputData;
    }

    public long getPart1Result() {
        var corruptedMemory = corruptedMemoryFactory.create(inputData.get(), false);
        return corruptedMemory.calculateSumOfAllMultiplications();
    }

    public long getPart2Result() {
        var corruptedMemory = corruptedMemoryFactory.create(inputData.get(), true);
        return corruptedMemory.calculateSumOfAllMultiplications();
    }
}
