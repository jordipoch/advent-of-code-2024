package aoc2024.model.day3;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CorruptedMemoryTest {

    @Test
    public void testCalculateSumOfAllMultiplications() {
        List<String> memoryData = List.of(
                "mul(12,24)?...mul(8,10)",
                "mul(7,10)^mul(,)  mul(2,44)"
        );

        var corruptedMemoryFactory = new CorruptedMemoryFactory(new InstructionsExtractor());
        var corruptedMemory = corruptedMemoryFactory.create(memoryData);

        long result = corruptedMemory.calculateSumOfAllMultiplications();

        assertThat(result).isEqualTo(526);
    }
}