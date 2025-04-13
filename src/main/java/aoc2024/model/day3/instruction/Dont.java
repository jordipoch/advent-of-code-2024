package aoc2024.model.day3.instruction;

import aoc2024.model.day3.CorruptedMemory;

public class Dont implements Instruction {
    private static final Dont instance = new Dont();

    public static Dont getInstance() {
        return instance;
    }

    @Override
    public void applyToMemory(CorruptedMemory memory) {
        memory.disable();
    }

    @Override
    public String toString() {
        return "don't()";
    }
}
