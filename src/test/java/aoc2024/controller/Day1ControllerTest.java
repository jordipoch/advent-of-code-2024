package aoc2024.controller;

import aoc2024.controller.input.supplier.Day1InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day1.LocationDistanceCalculatorFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1ControllerTest {

    @Test
    public void testGetPart1Result() {
        var supplier = new Day1InputSupplier(new InputFileDataLoaderFactory());

        var controller = new Day1Controller(new LocationDistanceCalculatorFactory(), supplier);
        assertThat(controller.getPart1Result()).isEqualTo(11);
    }
}