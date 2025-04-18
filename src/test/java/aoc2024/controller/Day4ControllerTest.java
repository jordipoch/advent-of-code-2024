package aoc2024.controller;

import aoc2024.input.InputFileDataLoaderFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4ControllerTest {

    @Test
    public void testGetPart1Result() {
        var controller = new Day4Controller(new InputFileDataLoaderFactory());

        assertThat(controller.getPart1Result()).isEqualTo(18);
    }
}