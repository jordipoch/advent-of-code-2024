package aoc2024.controller.input;

import java.util.List;

@FunctionalInterface
public interface InputDataLoader {
    List<String> loadData();
}