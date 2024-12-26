package aoc2024.controller;

import aoc2024.controller.input.supplier.Day2InputSupplier;
import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day2.ReportSafetyChecker;
import aoc2024.model.day2.UnusualDataFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2ControllerTest {
    private Day2Controller controller;

    @BeforeMethod
    public void setUp() {
        var supplier = new Day2InputSupplier(new InputFileDataLoaderFactory());
        controller = new Day2Controller(new UnusualDataFactory(new ReportSafetyChecker()), supplier);
    }

    @Test
    public void testGetPart1Result() {
        assertThat(controller.getPart1Result()).isEqualTo(2);
    }

    @Test
    public void testGetPart2Result() {
        assertThat(controller.getPart2Result()).isEqualTo(4);
    }
}