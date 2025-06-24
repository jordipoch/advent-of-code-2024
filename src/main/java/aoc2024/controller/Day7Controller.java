package aoc2024.controller;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day7.EquationSetCalibrationFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day7Controller {
    private final EquationSetCalibrationFactory factory;
    private final InputDataLoader inputDataLoader;

    @Inject
    public Day7Controller(InputDataLoaderFactory dataLoaderFactory, EquationSetCalibrationFactory factory) {
        inputDataLoader = dataLoaderFactory.createFromFile(7);
        this.factory = factory;
    }

    public long getPart1Result() {
        var equationSetCalibrator = factory.create(inputDataLoader.loadData());
        return equationSetCalibrator.calculateCalibrationResult();
    }
}
