package aoc2024.model.day2.result;

public class SafeResult implements SafetyResult {
    @Override
    public boolean isSafe() {
        return true;
    }

    @Override
    public int getFirstLevel() {
        throw new IllegalStateException("A safe report doesn't have bad levels");
    }

    @Override
    public int getSecondLevel() {
        throw new IllegalStateException("A safe report doesn't have bad levels");
    }
}
