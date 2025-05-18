package aoc2024.model.day6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

public class ManufacturingLab {
    private static final Logger logger = LogManager.getLogger();

    private final Character[][] map;
    private final int xSize;
    private final int ySize;
    private Guard guard;


    ManufacturingLab(Character[][] map) {
        this.map = map;
        this.xSize = map[0].length;
        this.ySize = map.length;

        guard = Guard.builder()
                .position(calculateGuardInitialPosition())
                .direction(GuardDirection.UP)
                .build();
    }

    public int calculateNumberOfDifferentPositionsWalkedByTheGuard() {
        boolean outOfTheRoom = false;
        while (!outOfTheRoom) {
            var guardNextPos = guard.getNextPosition();
            if (isPositionInTheRoom(guardNextPos)) {
                if (getCharAtPos(guardNextPos) == '#') {
                    guard = guard.turn();
                } else {
                    markGuardVisitedPosition();
                    guard = guard.move();
                    markGuardCurrentPosition();
                }
            } else {
                markGuardVisitedPosition();
                guard = guard.move();
                outOfTheRoom = true;
            }
        }

        logger.debug("Positions walked by the guard before leaving the manufacturing lab: {}{}", System.lineSeparator(), this);

        return getNumOfDistinctVisitedPositions();
    }

    private int getNumOfDistinctVisitedPositions() {
        return (int) Arrays.stream(map)
                .flatMap(Arrays::stream)
                .filter(c -> c.equals('X'))
                .count();
    }

    private Position calculateGuardInitialPosition() {
        int guardXPos = 0;
        int guardYPos = 0;
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (getCharAtPos(Position.of(x, y)) == '^') {
                    guardXPos = x;
                    guardYPos = y;
                }
            }
        }

        return Position.of(guardXPos, guardYPos);
    }

    private void markGuardCurrentPosition() {
        setCharAtPos(guard.getPosition(), guard.getDirectionChar());
    }

    private void markGuardVisitedPosition() {
        setCharAtPos(guard.getPosition(), 'X');
    }

    private char getCharAtPos(Position p) {
        return map[p.y()][p.x()];
    }

    private void setCharAtPos(Position p, char c) {
        map[p.y()][p.x()] = c;
    }

    private boolean isPositionInTheRoom(Position position) {
        return position.x() >= 0 && position.x() < xSize
                && position.y() >= 0 && position.y() < ySize;
    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (guard.getPosition().x() == x && guard.getPosition().y() == y) {
                    strBuilder.append(guard);
                } else {
                    strBuilder.append(getCharAtPos(Position.of(x, y)));
                }
            }
            if (y < map.length - 1) {
                strBuilder.append(System.lineSeparator());
            }
        }

        return strBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ManufacturingLab that)) return false;
        return Objects.deepEquals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(map));
    }
}
