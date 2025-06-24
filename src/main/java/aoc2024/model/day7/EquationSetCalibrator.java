package aoc2024.model.day7;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@EqualsAndHashCode
public class EquationSetCalibrator {
    private final List<Equation> equations;

    public long calculateCalibrationResult() {
        return equations.stream()
                .filter(Equation::canBeSolved)
                .mapToLong(Equation::getResult)
                .sum();
    }
}
