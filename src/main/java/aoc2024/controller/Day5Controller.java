package aoc2024.controller;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day5.SafetyManualsProtocolsFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day5Controller {
    private final SafetyManualsProtocolsFactory safetyManualsProtocolsFactory;
    private final InputDataLoader inputDataLoader;

    @Inject
    public Day5Controller(InputDataLoaderFactory dataLoaderFactory, SafetyManualsProtocolsFactory safetyManualsProtocolsFactory) {
        inputDataLoader = dataLoaderFactory.createFromFile(5);
        this.safetyManualsProtocolsFactory = safetyManualsProtocolsFactory;
    }

    public int getPart1Result() {
        var safetyManualProtocols = safetyManualsProtocolsFactory.create(inputDataLoader.loadData());
        return safetyManualProtocols.getMiddlePageSumOfCorrectlyOrderedUpdates();
    }

    public int getPart2Result() {
        var safetyManualProtocols = safetyManualsProtocolsFactory.create(inputDataLoader.loadData());
        return safetyManualProtocols.getMiddlePageSumOfIncorrectlyOrderedUpdatesAfterCorrectingThem();
    }
}
