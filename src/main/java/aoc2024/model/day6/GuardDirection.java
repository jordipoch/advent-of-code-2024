package aoc2024.model.day6;

import lombok.Getter;

@Getter
public enum GuardDirection {
    UP('^', '|') {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x(), from.y() - 1);
        }
    }, RIGHT('>', '-') {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() + 1, from.y());
        }
    }, DOWN('v', '|') {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x(), from.y() + 1);
        }
    }, LEFT('<', '-') {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() - 1, from.y());
        }
    };

    GuardDirection(char currentPositionChar, char visitedPositionChar) {
        this.currentPositionChar = currentPositionChar;
        this.visitedPositionChar = visitedPositionChar;
    }

    private final char currentPositionChar;
    private final char visitedPositionChar;

    public GuardDirection turnRight() {
        return values()[(ordinal() + 1) % 4];
    }

    public abstract Position getNextPosition(Position from);
}
