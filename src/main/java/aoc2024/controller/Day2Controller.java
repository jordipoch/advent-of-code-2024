package aoc2024.controller;

import aoc2024.controller.input.annotation.Day2;
import aoc2024.model.day2.UnusualData;
import aoc2024.model.day2.UnusualDataFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day2Controller {
    private final UnusualData unusualData;

    @Inject
    public Day2Controller(UnusualDataFactory unusualDataFactory, @Day2 Supplier<List<String>> inputData) {
        unusualData = unusualDataFactory.create(inputData.get());
    }

    public int getPart1Result() {
        return unusualData.getNumSafeReports();
    }

    public int getPart2Result() {
        return unusualData.getNumSafeReportsToleratingOneBadLevel();
    }
}
