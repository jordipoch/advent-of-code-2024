package aoc2024.model.day3;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CorruptedMemoryFactory {
    private final InstructionsExtractor extractor;

    @Inject
    public CorruptedMemoryFactory(InstructionsExtractor extractor) {
        this.extractor = extractor;
    }

    public CorruptedMemory create(List<String> memoryData) {
        return CorruptedMemory.of(memoryData, extractor);
    }
}
