package aoc2024.model.day2.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UnsafeResult implements SafetyResult {
    private int firstLevel;
    private int secondLevel;

    @Override
    public boolean isSafe() {
        return false;
    }
}
