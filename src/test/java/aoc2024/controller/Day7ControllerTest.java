package aoc2024.controller;

import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.model.day7.EquationFactory;
import aoc2024.model.day7.EquationSetCalibrationFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day7ControllerTest {
    private Day7Controller controller;

    @BeforeMethod
    public void setUp() {
        controller = new Day7Controller(new InputFileDataLoaderFactory(), new EquationSetCalibrationFactory(new EquationFactory()));
    }

    @Test
    public void testGetPart1Result() {
        assertThat(controller.getPart1Result()).isEqualTo(3749);
    }

    @Test
    public void testGetPart2Result() {
        assertThat(controller.getPart2Result()).isEqualTo(11387);
    }
}