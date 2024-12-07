package aoc2024.controller;

import aoc2024.controller.input.annotation.Day1;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.function.Supplier;

@Singleton
public class Day1Controller {
    @Inject
    public Day1Controller(@Day1 Supplier<List<String>> inputData) {
    }

    public int getPart1Result() {
        return 0;
    }

    public int getPart2Result() {
        return 0;
    }
}
