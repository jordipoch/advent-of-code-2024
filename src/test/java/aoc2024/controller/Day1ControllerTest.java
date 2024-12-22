package aoc2024.controller;

import aoc2024.controller.input.supplier.Day1InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day1.HistoricalLocationsFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1ControllerTest {

    @Test
    public void testGetPart1Result() {
        var supplier = new Day1InputSupplier(new InputFileDataLoaderFactory());

        var controller = new Day1Controller(new HistoricalLocationsFactory(), supplier);
        assertThat(controller.getPart1Result()).isEqualTo(11);
    }

    @Test
    public void testGetPart2Result() {
        var supplier = new Day1InputSupplier(new InputFileDataLoaderFactory());

        var controller = new Day1Controller(new HistoricalLocationsFactory(), supplier);
        assertThat(controller.getPart2Result()).isEqualTo(31);
    }
}