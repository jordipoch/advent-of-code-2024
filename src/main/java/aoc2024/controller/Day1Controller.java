package aoc2024.controller;

import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day1.HistoricalLocations;
import aoc2024.model.day1.HistoricalLocationsFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day1Controller {
    private final HistoricalLocations calculator;

    @Inject
    public Day1Controller(InputDataLoaderFactory dataLoaderFactory, HistoricalLocationsFactory historicalLocationsFactory) {
        var inputDataLoader = dataLoaderFactory.createFromFile(1);
        calculator = historicalLocationsFactory.create(inputDataLoader.loadData());
    }

    public int getPart1Result() {
        return calculator.calculateDistance();
    }

    public long getPart2Result() {
        return calculator.calculateSimilarityScore();
    }
}
