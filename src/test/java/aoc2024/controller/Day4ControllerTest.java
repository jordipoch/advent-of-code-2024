package aoc2024.controller;

import aoc2024.controller.input.supplier.Day4InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4ControllerTest {

    @Test
    public void testGetPart1Result() {
        var supplier = new Day4InputSupplier(new InputFileDataLoaderFactory());
        var controller = new Day4Controller(supplier);

        assertThat(controller.getPart1Result()).isEqualTo(18);
    }
}