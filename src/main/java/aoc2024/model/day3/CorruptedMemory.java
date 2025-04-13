package aoc2024.model.day3;

import aoc2024.model.day3.instruction.Instruction;

import java.util.List;

public class CorruptedMemory {
    private final List<Instruction> instructions;
    private final boolean toggleActive;

    private long result;
    private boolean enabled = true;


    private CorruptedMemory(List<Instruction> instructions, boolean toggleActive) {
        this.instructions = instructions;
        this.toggleActive = toggleActive;
    }

    public static CorruptedMemory of(List<Instruction> instructions, boolean toggleActive) {
        return new CorruptedMemory(instructions, toggleActive);
    }

    public void addToResult(long value) {
        if (enabled) {
            result += value;
        }
    }

    public void enable() {
        if (toggleActive) {
            enabled = true;
        }
    }

    public void disable() {
        if (toggleActive) {
            enabled = false;
        }
    }

    public long calculateSumOfAllMultiplications() {
        instructions.forEach(instruction -> instruction.applyToMemory(this));
        return result;
    }
}
