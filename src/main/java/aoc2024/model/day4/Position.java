package aoc2024.model.day4;

public record Position(int x, int y) {
    public static Position of(int x, int y) {
        return new Position(x, y);
    }
}
