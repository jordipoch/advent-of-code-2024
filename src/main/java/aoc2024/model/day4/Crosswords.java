package aoc2024.model.day4;

import java.util.List;
import java.util.stream.Stream;

public class Crosswords {
    private final char[][] data;
    private final int xSize;
    private final int ySize;

    private Crosswords(char[][] data) {
        this.data = data;
        this.xSize = data[0].length;
        this.ySize = data.length;
    }

    public static Crosswords of(char[][] data) {
        return new Crosswords(data);
    }

    public int countNumberOfXMAS() {
        int numXMAS = 0;

        for (int y = 0; y < ySize; y++)
            for (int x = 0; x < data[y].length; x++)
                numXMAS += countXmasFromPosition(x, y);

        return numXMAS;
    }

    public int countNumberOfXShapedMAS() {
        int numXShapedMas = 0;

        for (int y = 0; y < ySize; y++)
            for (int x = 0; x < data[y].length; x++)
                if (isCharAtPos('A', Position.of(x, y)))
                    if (isXShapedMASAtPosition(x, y))
                        numXShapedMas++;

        return numXShapedMas;
    }

    private boolean isXShapedMASAtPosition(int x, int y) {
        return isMasFromPosition(Position.of(x - 1, y - 1), Direction.RIGHT_DOWN)
                + isMasFromPosition(Position.of(x - 1, y + 1), Direction.RIGHT_UP)
                + isMasFromPosition(Position.of(x + 1, y - 1), Direction.LEFT_DOWN)
                + isMasFromPosition(Position.of(x + 1, y + 1), Direction.LEFT_UP) == 2;
    }

    private int countXmasFromPosition(int x, int y) {
        var position = Position.of(x, y);
        if (!isCharAtPos('X', position))
            return 0;

        return Stream.of(Direction.values())
                .mapToInt(d -> isMasFromPosition(d.getNextPosition(position), d))
                .sum();
    }

    private int isMasFromPosition(Position p, Direction d) {
        String mas = "MAS";
        var nextPos = p;
        for (char c : mas.toCharArray()) {
            if (!isCharAtPos(c, nextPos))
                return 0;
            nextPos = d.getNextPosition(nextPos);
        }

        return 1;
    }

    private char getCharAtPos(Position p) {
        return data[p.y()][p.x()];
    }

    private boolean isCharAtPos(char c, Position p) {
        if (isWithinBounds(p))
            return getCharAtPos(p) == c;
        else
            return false;
    }

    private boolean isWithinBounds(Position p) {
        return p.x() >= 0 && p.x() < xSize
                && p.y() >= 0 && p.y() < ySize;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        List<String> stringData;

        public Builder data(List<String> stringData) {
            this.stringData = stringData;
            return this;
        }

        public Crosswords build() {
            return new Crosswords(toCharArray(stringData));
        }

        private char[][] toCharArray(List<String> data) {
            var converted = new char[data.size()][data.get(0).length()];

            for (int i = 0; i < data.size(); i++)
                converted[i] = data.get(i).toCharArray();

            return converted;
        }
    }
}
