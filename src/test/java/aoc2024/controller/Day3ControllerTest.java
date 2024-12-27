package aoc2024.controller;

import aoc2024.controller.input.supplier.Day3InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day3.CorruptedMemoryFactory;
import aoc2024.model.day3.InstructionsExtractor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3ControllerTest {
    private Day3Controller controller;

    @BeforeMethod
    public void setUp() {
        var supplier = new Day3InputSupplier(new InputFileDataLoaderFactory());
        controller = new Day3Controller(new CorruptedMemoryFactory(new InstructionsExtractor()), supplier);
    }

    @Test
    public void testGetPart1Result() {
        assertThat(controller.getPart1Result()).isEqualTo(161);
    }
}