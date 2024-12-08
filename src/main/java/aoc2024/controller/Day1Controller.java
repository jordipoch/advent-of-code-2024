package aoc2024.controller;

import aoc2024.controller.input.annotation.Day1;
import aoc2024.model.day1.LocationDistanceCalculator;
import aoc2024.model.day1.LocationDistanceCalculatorFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day1Controller {
    private final LocationDistanceCalculator calculator;

    @Inject
    public Day1Controller(LocationDistanceCalculatorFactory locationDistanceCalculatorFactory, @Day1 Supplier<List<String>> inputData) {
        calculator = locationDistanceCalculatorFactory.create(inputData.get());
    }

    public int getPart1Result() {
        return calculator.calculateDistance();
    }
}
