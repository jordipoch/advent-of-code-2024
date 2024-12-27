package aoc2024.model.day3;

public record MultiplyInstruction(int value1, int value2) {
    public static MultiplyInstruction of(int value1, int value2) {
        return new MultiplyInstruction(value1, value2);
    }

    public int multiply() {
        return value1 * value2;
    }

    @Override
    public String toString() {
        return String.format("mul(%d,%d)", value1, value2);
    }
}
