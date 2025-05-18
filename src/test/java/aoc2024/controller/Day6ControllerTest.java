package aoc2024.controller;

import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day6.ManufacturingLabFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day6ControllerTest {

    @Test
    public void testGetPart1Result() {
        var controller = new Day6Controller(new InputFileDataLoaderFactory(), new ManufacturingLabFactory());

        assertThat(controller.getPart1Result()).isEqualTo(41);
    }
}