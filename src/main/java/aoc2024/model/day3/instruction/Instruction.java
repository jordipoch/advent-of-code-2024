package aoc2024.model.day3.instruction;

import aoc2024.model.day3.CorruptedMemory;

public interface Instruction {
    void applyToMemory(CorruptedMemory memory);
}
