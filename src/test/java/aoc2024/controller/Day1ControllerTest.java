package aoc2024.controller;

import aoc2024.controller.input.supplier.Day1InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1ControllerTest {

    @Test
    public void testGetPart1Result() {
        Supplier<List<String>> supplier = List::of;

        var controller = new Day1Controller(supplier);
        assertThat(controller.getPart1Result()).isEqualTo(0);
    }

    @Test
    public void testGetPart2Result() {
        Supplier<List<String>> supplier = List::of;

        var controller = new Day1Controller(supplier);
        assertThat(controller.getPart2Result()).isEqualTo(0);
    }


}