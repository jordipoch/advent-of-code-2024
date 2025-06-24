package aoc2024.model.day7;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class EquationWithConcat extends Equation{

    @Override
    protected List<String> doRecursiveCalls(long partialResult, int currentPos, String currentSolution) {
        List<String> solutions = new ArrayList<>();

        solutions.addAll(checkEquationRecursively(partialResult + testValues.get(currentPos), currentPos + 1, currentSolution + "+" + testValues.get(currentPos)));
        solutions.addAll(checkEquationRecursively(partialResult * testValues.get(currentPos), currentPos + 1, currentSolution + "*" + testValues.get(currentPos)));
        solutions.addAll(checkEquationRecursively(concatenateValues(partialResult, testValues.get(currentPos)), currentPos + 1, currentSolution + "||" + testValues.get(currentPos)));

        return solutions;
    }

    private long concatenateValues(long value1, long value2) {
        return parseLong("" + value1 + value2);
    }
}
