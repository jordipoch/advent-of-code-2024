package aoc2024.controller;

import aoc2024.controller.input.supplier.Day2InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day2.UnusualDataFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2ControllerTest {

    @Test
    public void testGetPart1Result() {
        var supplier = new Day2InputSupplier(new InputFileDataLoaderFactory());
        var controller = new Day2Controller(new UnusualDataFactory(), supplier);

        assertThat(controller.getPart1Result()).isEqualTo(2);
    }
}