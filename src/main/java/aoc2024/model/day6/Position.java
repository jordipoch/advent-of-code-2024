package aoc2024.model.day6;

import java.util.Objects;

public record Position(int x, int y) {
    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return x() == position.x() && y() == position.y();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x(), y());
    }
}
