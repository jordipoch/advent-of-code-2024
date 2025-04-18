package aoc2024.controller;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day4.Crosswords;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day4Controller {
private final InputDataLoader inputDataLoader;

    @Inject
    public Day4Controller(InputDataLoaderFactory dataLoaderFactory) {
        inputDataLoader = dataLoaderFactory.createFromFile(4);
    }

    public int getPart1Result() {
        var crosswords = Crosswords.create()
                .data(inputDataLoader.loadData())
                .build();

        return crosswords.countNumberOfXMAS();
    }
}
