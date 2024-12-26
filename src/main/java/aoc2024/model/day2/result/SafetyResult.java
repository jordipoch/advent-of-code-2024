package aoc2024.model.day2.result;

public interface SafetyResult {
    boolean isSafe();
    int getFirstLevel();
    int getSecondLevel();

    static SafetyResult ofSafeResult() {
        return new SafeResult();
    }

    static SafetyResult ofUnsafeResult(int firstLevel, int secondLevel) {
        return new UnsafeResult(firstLevel, secondLevel);
    }
}
