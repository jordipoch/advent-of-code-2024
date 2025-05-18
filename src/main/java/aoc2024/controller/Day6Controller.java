package aoc2024.controller;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day6.ManufacturingLabFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day6Controller {
    private final ManufacturingLabFactory manufacturingLabFactory;
    private final InputDataLoader inputDataLoader;

    @Inject
    public Day6Controller(InputDataLoaderFactory dataLoaderFactory, ManufacturingLabFactory manufacturingLabFactory) {
        inputDataLoader = dataLoaderFactory.createFromFile(6);
        this.manufacturingLabFactory = manufacturingLabFactory;
    }

    public int getPart1Result() {
        var manufacturingLab = manufacturingLabFactory.create(inputDataLoader.loadData());
        return manufacturingLab.calculateNumberOfDifferentPositionsWalkedByTheGuard();
    }
}
