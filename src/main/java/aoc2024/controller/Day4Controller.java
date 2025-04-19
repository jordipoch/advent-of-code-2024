package aoc2024.controller;

import aoc2024.controller.input.InputDataLoaderFactory;
import aoc2024.model.day4.Crosswords;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Day4Controller {
private final Crosswords crosswords;

    @Inject
    public Day4Controller(InputDataLoaderFactory dataLoaderFactory) {
        var inputDataLoader = dataLoaderFactory.createFromFile(4);
        crosswords = Crosswords.create()
                .data(inputDataLoader.loadData())
                .build();
    }

    public int getPart1Result() {
        return crosswords.countNumberOfXMAS();
    }

    public int getPart2Result() {
        return crosswords.countNumberOfXShapedMAS();
    }
}
