package aoc2024.input;

import aoc2024.data.Environment;
import aoc2024.data.InputFileDataLoader;

public class InputFileDataLoaderForTest extends InputFileDataLoader {
    public InputFileDataLoaderForTest(int day, String fileName) {
        super(day, fileName, Environment.TEST);
    }

    public InputFileDataLoaderForTest(int day) {
        super(day, Environment.TEST);
    }
}
