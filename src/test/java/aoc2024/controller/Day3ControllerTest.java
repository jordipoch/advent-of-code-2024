package aoc2024.controller;

import aoc2024.controller.input.supplier.Day3InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day3.CorruptedMemoryFactory;
import aoc2024.model.day3.InstructionsExtractor;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3ControllerTest {
    private Day3Controller controller;

    @Test
    public void testGetPart1Result() {
        createController("input.txt");
        assertThat(controller.getPart1Result()).isEqualTo(161);
    }

    @Test
    public void testGetPart2Result() {
        createController("input2.txt");
        assertThat(controller.getPart2Result()).isEqualTo(48);
    }

    private void createController(String filename) {
        var supplier = new Day3InputSupplier(new InputFileDataLoaderFactory(filename));
        controller = new Day3Controller(new CorruptedMemoryFactory(new InstructionsExtractor()), supplier);
    }
}