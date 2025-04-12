package aoc2024.model.day3.instruction;

import aoc2024.model.day3.CorruptedMemory;

public class Do implements Instruction {
    private static final Do instance = new Do();

    public static Do getInstance() {
        return instance;
    }

    @Override
    public void applyToMemory(CorruptedMemory memory) {
    }

    @Override
    public String toString() {
        return "do()";
    }
}
