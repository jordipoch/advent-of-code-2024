package aoc2024.model.day6;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
class Cell {
    private final CellType cellType;
    private final List<GuardDirection> guardDirections = new ArrayList<>();

    private Cell(CellType cellType) {
        this.cellType = cellType;
    }

    static Cell of(char content) {
        CellType cellType = CellType.getCellType(content);
        if (cellType == null) {
            throw new IllegalArgumentException(String.format("There's no cell type with the '%c' character representation", content));
        }
        return new Cell(cellType);
    }

    Character getContent() {
        return hasBeenVisited() ? getGuardDirectionsRepresentation() : cellType.getValue();
    }

    private Character getGuardDirectionsRepresentation() {
        var distinctDirectionsVisited = guardDirections.stream()
                .map(GuardDirection::getVisitedPositionChar)
                .distinct()
                .toList();

        return distinctDirectionsVisited.size() == 1 ? distinctDirectionsVisited.get(0) : '+';
    }

    boolean isBlocked() {
        return cellType == CellType.OBSTRUCTION ||
                cellType == CellType.EXTRA_OBSTRUCTION;
    }

    boolean hasBeenVisited() {
        return !guardDirections.isEmpty();
    }

    void markVisited(GuardDirection guardDirection) {
        guardDirections.add(guardDirection);
    }

    boolean hasDirection(GuardDirection direction) {
        return guardDirections.contains(direction);
    }
}
