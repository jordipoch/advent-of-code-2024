package aoc2024.model.day7;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
public class Equation {
    private static final Logger logger = LogManager.getLogger();

    private final long result;
    private final List<Integer> testValues;

    public boolean canBeSolved() {
        var solutions = checkEquationRecursively(testValues.get(0), 1, String.valueOf(testValues.get(0)));

        logDebugInfo(solutions);

        return !solutions.isEmpty();
    }

    public long getResult() {
        return result;
    }

    private List<String> checkEquationRecursively(long partialResult, int currentPos, String currentSolution) {
        List<String> solutions = new ArrayList<>();
        if (currentPos < testValues.size()) {
            solutions.addAll(checkEquationRecursively(partialResult + testValues.get(currentPos), currentPos + 1, currentSolution + "+" + testValues.get(currentPos)));
            solutions.addAll(checkEquationRecursively(partialResult * testValues.get(currentPos), currentPos + 1, currentSolution + "*" + testValues.get(currentPos)));
        } else {
            if (partialResult == result) {
                solutions.add(String.format("%d=%s", result, currentSolution));
            }
        }
        return solutions;
    }

    private void logDebugInfo(List<String> solutions) {
        var sb = new StringBuilder(String.format("Evaluation result for %s%s", this, System.lineSeparator()));
        if (solutions.isEmpty()) {
            sb.append("No solutions found");
        } else {
            sb.append(String.format("%d solutions found:%s", solutions.size(), System.lineSeparator()));
            for (var solution : solutions) {
                sb.append(String.format("\t%s%s", solution, System.lineSeparator()));
            }
        }

        logger.debug(sb.toString());
    }

    @Override
    public String toString() {
        var values = testValues.stream()
                .map(String::valueOf)
                .collect((Collectors.joining(" ")));
        return result + ": " + values;
    }
}
