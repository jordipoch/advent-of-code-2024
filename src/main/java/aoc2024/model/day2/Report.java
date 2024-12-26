package aoc2024.model.day2;

import aoc2024.model.day2.result.SafetyResult;
import lombok.Builder;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

import static aoc2024.model.day2.Order.EQUAL;
import static aoc2024.model.day2.result.SafetyResult.ofSafeResult;
import static aoc2024.model.day2.result.SafetyResult.ofUnsafeResult;

@Getter
@Builder
public class Report {
    private final List<Integer> levels;

    private Report(List<Integer> levels) {
        this.levels = Collections.unmodifiableList(levels);
    }

    public static Report of(int... levels) {
        var levelList = Arrays.stream(levels)
                .boxed()
                .toList();

        return Report.builder()
                .levels(levelList)
                .build();
    }

    public SafetyResult checkSafety() {
        // Pre-condition: data has at least two values

        Order levelOrder = Order.of(levels.get(0), levels.get(1));
        if (levelOrder == EQUAL) return ofUnsafeResult(0, 1);

        for (int i = 0; i < levels.size() - 1; i++)
            if (areConsecutiveLevelsUnsafe(levelOrder, i)) return ofUnsafeResult(i, i+1);

        return ofSafeResult();
    }

    public Report cloneReportWithoutLevelAtIndex(int elementIndex) {
        List<Integer> levelsCopy = new ArrayList<>(levels);
        levelsCopy.remove(elementIndex);

        return Report.builder()
                .levels(levelsCopy)
                .build();
    }

    private boolean areConsecutiveLevelsUnsafe(Order levelOrder, int i) {
        return !levelOrder.isOrderMet(levels.get(i), levels.get(i + 1)) ||
                Math.abs(levels.get(i) - levels.get(i + 1)) > 3;
    }

    @Override
    public String toString() {
        return levels.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Report report)) return false;
        return Objects.equals(getLevels(), report.getLevels());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLevels());
    }
}
