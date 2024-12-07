package aoc2024.input;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;

public class InputFileDataLoaderFactory implements InputDataLoaderFactory {
    @Override
    public InputDataLoader createFromFile(int day) {
        return new InputFileDataLoaderForTest(day);
    }
}
