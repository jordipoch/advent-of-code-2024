package aoc2024.controller;

import aoc2024.controller.input.annotation.Day1;
import aoc2024.model.day1.HistoricalLocations;
import aoc2024.model.day1.HistoricalLocationsFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day1Controller {
    private final HistoricalLocations calculator;

    @Inject
    public Day1Controller(HistoricalLocationsFactory historicalLocationsFactory, @Day1 Supplier<List<String>> inputData) {
        calculator = historicalLocationsFactory.create(inputData.get());
    }

    public int getPart1Result() {
        return calculator.calculateDistance();
    }

    public long getPart2Result() {
        return calculator.calculateSimilarityScore();
    }
}
