package aoc2024.input;

import aoc2024.controller.input.InputDataLoader;
import aoc2024.controller.input.InputDataLoaderFactory;

public class InputFileDataLoaderFactory implements InputDataLoaderFactory {
    private String filename;

    public InputFileDataLoaderFactory() {
    }

    public InputFileDataLoaderFactory(String filename) {
        this.filename = filename;
    }

    @Override
    public InputDataLoader createFromFile(int day) {
        if (filename != null)
            return new InputFileDataLoaderForTest(day, filename);
        else
            return new InputFileDataLoaderForTest(day);
    }
}
