package aoc2024.model.day6;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

enum CellType {
    EMPTY('.'), OBSTRUCTION('#'), EXTRA_OBSTRUCTION('O');

    CellType(Character value) {
        this.value = value;
    }

    Character getValue() {
        return value;
    }

    static CellType getCellType(Character value) {
        return valueToCellTypeMap.get(value);
    }

    private static final Map<Character, CellType> valueToCellTypeMap = Arrays.stream(values()).collect(Collectors.toMap(CellType::getValue, Function.identity()));

    final Character value;
}
