package aoc2024.model.day6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ManufacturingLab {
    private static final Logger logger = LogManager.getLogger();

    private final Cell[][] map;
    private final int xSize;
    private final int ySize;
    private Guard guard;
    private final Guard initialGuardPosition;
    private Guard finalGuardPosition;
    private final Set<Position> positionsVisited = new LinkedHashSet<>();
    private boolean loopDetected;

    ManufacturingLab(Character[][] characterMap, Position guardPosition) {
        this.xSize = characterMap[0].length;
        this.ySize = characterMap.length;
        this.map = createMap(characterMap);

        guard = Guard.builder()
                .position(guardPosition)
                .direction(GuardDirection.UP)
                .build();

        initialGuardPosition = guard;
        finalGuardPosition = guard;
    }

    private Cell[][] createMap(Character[][] characterMap) {
        Cell[][] resultMap = new Cell[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                resultMap[y][x] = Cell.of(characterMap[y][x]);
            }
        }

        return resultMap;
    }

    public ManufacturingLab simulateGuardWalking() {
        while (isPositionInTheRoom(guard.getPosition()) && !loopDetected) {
            markGuardVisitedPosition();
            var guardNextPos = guard.getNextPosition();
            if (isPositionInTheRoom(guardNextPos)) {
                if (isPositionBlocked(guardNextPos)) {
                    guard = guard.turn();
                } else {
                    guard = guard.move();
                }

                loopDetected = getCellAtPos(guard.getPosition()).hasDirection(guard.getDirection());
            } else {
                guard = guard.move();
            }
        }

        return this;
    }

    public int getNumPositionsVisited() {
        return positionsVisited.size();
    }

    public boolean isLoopDetected() {
        return loopDetected;
    }

    private boolean isPositionBlocked(Position guardNextPos) {
        return getCellAtPos(guardNextPos).isBlocked();
    }

    private void markGuardVisitedPosition() {
        getCellAtPos(guard.getPosition()).markVisited(guard.getDirection());
        finalGuardPosition = guard;
        positionsVisited.add(guard.getPosition());
    }

    private int getNumOfDistinctVisitedPositions() {
        return (int) Arrays.stream(map)
                .flatMap(Arrays::stream)
                .filter(Cell::hasBeenVisited)
                .count();
    }

    private Cell getCellAtPos(Position p) {
        return map[p.y()][p.x()];
    }

    private boolean isPositionInTheRoom(Position position) {
        return position.x() >= 0 && position.x() < xSize
                && position.y() >= 0 && position.y() < ySize;
    }

    private String getPositionString(Position p) {
        if (p.equals(initialGuardPosition.getPosition())) {
            return initialGuardPosition.toString();
        } else if (p.equals(finalGuardPosition.getPosition())) {
            return finalGuardPosition.toString();
        } else {
            return String.valueOf(getCellAtPos(p).getContent());
        }
    }

    @Override
    public String toString() {
        var strBuilder = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                strBuilder.append(getPositionString(Position.of(x, y)));
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

    public List<Position> getPositionsVisited() {
        return new ArrayList<>(positionsVisited);
    }
}
