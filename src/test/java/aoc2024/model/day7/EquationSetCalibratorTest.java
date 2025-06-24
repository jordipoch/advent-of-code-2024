package aoc2024.model.day7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EquationSetCalibratorTest {

    private EquationSetCalibrationFactory factory;

    @BeforeMethod
    public void setUp() {
        factory = new EquationSetCalibrationFactory(new EquationFactory());
    }

    @Test
    public void testCalculateCalibrationResultWhenSimpleScenario() {
        var calibrator = factory.create(List.of(
                "190: 10 19",
                "83: 17 5"
        ));

        assertThat(calibrator.calculateCalibrationResult()).isEqualTo(190);
    }

    @Test
    public void testCalculateCalibrationResultWhenComplexScenario() {
        var calibrator = factory.create(List.of(
                "190: 10 19",
                "3267: 81 40 27",
                "83: 17 5",
                "156: 15 6",
                "7290: 6 8 6 15",
                "161011: 16 10 13",
                "192: 17 8 14",
                "21037: 9 7 18 13",
                "292: 11 6 16 20"
        ));

        assertThat(calibrator.calculateCalibrationResult()).isEqualTo(3749);
    }
}