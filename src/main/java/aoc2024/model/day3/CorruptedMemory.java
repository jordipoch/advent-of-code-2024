package aoc2024.model.day3;

import java.util.List;

public class CorruptedMemory {
    private final List<String> data;
    private final InstructionsExtractor extractor;

    private CorruptedMemory(List<String> data, InstructionsExtractor extractor) {
        this.data = data;
        this.extractor = extractor;
    }

    public static CorruptedMemory of(List<String> data, InstructionsExtractor extractor) {
        return new CorruptedMemory(data, extractor);
    }

    public long calculateSumOfAllMultiplications() {
        return data.stream()
                .flatMap(dataPart -> extractor.extractInstructions(dataPart).stream())
                .map(MultiplyInstruction::multiply)
                .mapToLong(i -> (long) i)
                .sum();
    }
}
