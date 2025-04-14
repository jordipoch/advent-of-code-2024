package aoc2024.model.day4;

public enum Direction {
    RIGHT {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() + 1, from.y());
        }
    },
    LEFT {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() - 1, from.y());
        }
    },
    DOWN {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x(), from.y() + 1);
        }
    },
    UP {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x(), from.y() - 1);
        }
    },
    RIGHT_DOWN {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() + 1, from.y() + 1);
        }
    },
    RIGHT_UP {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() + 1, from.y() - 1);
        }
    },
    LEFT_DOWN {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() - 1, from.y() + 1);
        }
    },
    LEFT_UP {
        @Override
        public Position getNextPosition(Position from) {
            return Position.of(from.x() - 1, from.y() - 1);
        }
    };

    public abstract Position getNextPosition(Position from);
}
