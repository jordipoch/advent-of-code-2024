package aoc2024.model.day2;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import static aoc2024.model.day2.Order.EQUAL;

@Getter
@Builder
public class Report {
    private final List<Integer> levels;

    public boolean isSafe() {
        // Pre-condition: data has at least two values

        Order levelOrder = Order.of(levels.get(0), levels.get(1));
        if (levelOrder == EQUAL) return false;

        for (int i = 0; i < levels.size() - 1; i++)
            if (!areConsecutiveLevelsSafe(levelOrder, i)) return false;

        return true;
    }

    private boolean areConsecutiveLevelsSafe(Order levelOrder, int i) {
        return levelOrder.isOrderMet(levels.get(i), levels.get(i +1)) &&
                Math.abs(levels.get(i) - levels.get(i +1)) <= 3;
    }
}
