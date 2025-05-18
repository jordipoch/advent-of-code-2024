package aoc2024.model.day6;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Builder
@Value
@EqualsAndHashCode
public class Guard {
    Position position;
    GuardDirection direction;

    public Position getNextPosition() {
        return direction.getNextPosition(position);
    }

    public Guard move() {
        return Guard.builder()
                .position(getNextPosition())
                .direction(direction)
                .build();
    }

    public Guard turn() {
        return Guard.builder()
                .position(position)
                .direction(direction.turnRight())
                .build();
    }

    public char getDirectionChar() {
        return direction.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(direction.getValue());
    }
}
