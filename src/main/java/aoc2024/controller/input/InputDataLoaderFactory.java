package aoc2024.controller.input;

public interface InputDataLoaderFactory {
    InputDataLoader createFromFile(int day);
}
