package aoc2024.controller;

import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day5.SafetyManualsProtocolsFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5ControllerTest {

    @Test
    public void testGetPart1Result() {
        var controller = new Day5Controller(new InputFileDataLoaderFactory(), new SafetyManualsProtocolsFactory());

        assertThat(controller.getPart1Result()).isEqualTo(143);
    }
}