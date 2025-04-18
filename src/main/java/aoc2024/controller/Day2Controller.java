package aoc2024.controller;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day2.UnusualData;
import aoc2024.model.day2.UnusualDataFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day2Controller {
    private final UnusualData unusualData;
    private final InputDataLoader inputDataLoader;

    @Inject
    public Day2Controller(InputDataLoaderFactory dataLoaderFactory, UnusualDataFactory unusualDataFactory) {
        inputDataLoader = dataLoaderFactory.createFromFile(2);
        unusualData = unusualDataFactory.create(inputDataLoader.loadData());
    }

    public int getPart1Result() {
        return unusualData.getNumSafeReports();
    }

    public int getPart2Result() {
        return unusualData.getNumSafeReportsToleratingOneBadLevel();
    }
}
