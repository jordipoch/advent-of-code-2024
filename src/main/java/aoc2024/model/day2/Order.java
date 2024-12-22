package aoc2024.model.day2;

import lombok.Getter;

@Getter
public enum Order {
    INCREASING(1) {
        @Override
        public boolean isOrderMet(int value1, int value2) {
            return value1 < value2;
        }
    },
    DECREASING(-1) {
        @Override
        public boolean isOrderMet(int value1, int value2) {
            return value1 > value2;
        }
    },
    EQUAL(0) {
        @Override
        public boolean isOrderMet(int value1, int value2) {
            return false;
        }
    };

    Order(int value) {
        this.value = value;
    }

    private final int value;

    public abstract boolean isOrderMet(int value1, int value2);

    public static Order of(int value1, int value2) {
        if (value1 < value2) {
            return INCREASING;
        } else if (value1 > value2) {
            return DECREASING;
        } else {
            return EQUAL;
        }
    }
}
