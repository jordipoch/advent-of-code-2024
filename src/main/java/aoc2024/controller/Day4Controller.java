package aoc2024.controller;

import aoc2024.controller.input.annotation.Day4;
import aoc2024.model.day4.Crosswords;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day4Controller {
    private final Supplier<List<String>> inputData;

    @Inject
    public Day4Controller(@Day4 Supplier<List<String>> inputData) {
        this.inputData = inputData;
    }

    public int getPart1Result() {
        var crosswords = Crosswords.create()
                .data(inputData.get())
                .build();

        return crosswords.countNumberOfXMAS();
    }
}
