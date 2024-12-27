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
    private final CorruptedMemory corruptedMemory;

    @Inject
    public Day3Controller(CorruptedMemoryFactory corruptedMemoryFactory, @Day3 Supplier<List<String>> inputData) {
        corruptedMemory = corruptedMemoryFactory.create(inputData.get());
    }

    public long getPart1Result() {
        return corruptedMemory.calculateSumOfAllMultiplications();
    }
}
