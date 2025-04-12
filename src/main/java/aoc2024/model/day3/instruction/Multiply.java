package aoc2024.model.day3;

import java.util.Objects;

public class Multiply {
    private final int value1;
    private final int value2;

    private Multiply(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public static Multiply of(int value1, int value2) {
        return new Multiply(value1, value2);
    }

    public int apply() {
        return value1 * value2;
    }

    @Override
    public String toString() {
        return String.format("mul(%d,%d)", value1, value2);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Multiply multiply)) return false;
        return value1 == multiply.value1 && value2 == multiply.value2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2);
    }
}
